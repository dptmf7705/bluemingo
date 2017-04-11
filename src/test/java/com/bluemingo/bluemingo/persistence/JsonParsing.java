package com.bluemingo.bluemingo.persistence;


import java.io.IOException;
import java.util.ArrayList;
import java.lang.reflect.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * Created by sst on 2017-03-06.
 * Object로 들어온 값을 설정된 익명의VO에 맞춰서 자동으로 파싱함
 */
public class JsonParsing<E> {

    private String TAG = "JsonParsing";
    protected Class<E> voType;
    private ArrayList<E> lists;

    public JsonParsing(Class<E> voType){
        this.voType = voType;

    }

    public E get(){
        try{
            return voType.newInstance();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<E> getResult(String result) throws JSONException, IOException {
        lists = new ArrayList<E>();
        E rvo = null;
        JSONObject jsonObj = null;
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(result);

        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObj = jsonArray.getJSONObject(i);
            System.out.println("jsonObj.get : "+jsonObj.get("adv_title"));
            lists.add(doParsing(jsonObj));

        }
        return lists;
    }

    private E doParsing(JSONObject jsonObject) throws JSONException, IOException{
        String method_name = null;
        Field fld = null;
        E mvo = get();

        try{
            Class cls = Class.forName(voType.getName());
            System.out.println("Class.forName(voType.getName() : "+Class.forName(voType.getName()));

            Method methList[] = cls.getDeclaredMethods();
            Field fieldList[] = cls.getDeclaredFields();
            String fldName = null;
            mvo = get();
            for(int i=0;i<methList.length;i++){
                method_name = methList[i].getName();
                if(method_name.contains("set")){
                    fld = valueSearch(fieldList, method_name);
                    if(fld != null) {
                        fldName = fld.getName();

                        System.out.println("method : " + method_name + "/ value : " + jsonObject.get(fldName));
                        System.out.println("type : " + fld.getType() + "/ name : " + fldName);

                        if (jsonObject.get(fld.getName()) != null) {
                            if (fld.getType() == Integer.class) {
                                methList[i].invoke(mvo, Integer.parseInt(jsonObject.get(fldName).toString()));
                            } else if (fld.getType() == String.class) {
                                methList[i].invoke(mvo, jsonObject.get(fldName).toString());
                            } else if (fld.getType() == Long.class) {
                                methList[i].invoke(mvo, Long.valueOf(jsonObject.get(fldName).toString()));
                            } else {
                                methList[i].invoke(mvo, jsonObject.get(fldName).toString());
                            }
                        }
                    }
                }
            }

        }catch(Throwable e){
            System.err.println(e);
        }
        return mvo;
    }


    private Field valueSearch(Field[] fieldList, String method_name){
        String value = method_name.substring(3).toLowerCase();
        for(int i=0; i<fieldList.length; i++){
            if(fieldList[i].getName().equals(value)){
                return  fieldList[i];
            }
        }
        return null;
    }

}