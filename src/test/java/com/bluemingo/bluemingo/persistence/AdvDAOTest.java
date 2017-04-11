package com.bluemingo.bluemingo.persistence;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.inject.Inject;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bluemingo.bluemingo.controller.AbstractTest;
import com.bluemingo.bluemingo.domain.AdvVO;
import com.bluemingo.bluemingo.domain.Item_companyVO;
import com.bluemingo.bluemingo.domain.Ref_listVO;
import com.bluemingo.bluemingo.domain.SearchVO;
import com.bluemingo.bluemingo.persistence.AdvDAO;
import com.bluemingo.bluemingo.service.AdvService;
import com.bluemingo.bluemingo.service.Item_companyService;
import com.bluemingo.bluemingo.service.Ref_listService;
import com.bluemingo.bluemingo.util.CommonUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.*;


public class AdvDAOTest extends AbstractTest{

	private SqlSessionTemplate session;

	private static final Logger logger = LoggerFactory.getLogger(AdvDAOTest.class);

    @Autowired(required = true)
    private Item_companyService item_companyService;
	
	@Autowired(required = true)
    private Ref_listService ref_listService;
	
	@Autowired(required = true)
    private AdvService advService;
	
	/*@Test
	public void getName() {
		try{
			Class cls = Class.forName("com.bluemingo.bluemingo.domain.AdvVO");
			
			Field fieldList[] = cls.getDeclaredFields();
			
			for(int i=0; i<fieldList.length; i++){
				Field fld = fieldList[i];
				System.out.println("name : "+fld.getName());
				System.out.println("decl class = " +
                        fld.getDeclaringClass());
            System.out.println("type : " + fld.getType());
            int mod = fld.getModifiers();
            System.out.println("modifiers : " +
                       Modifier.toString(mod));
            System.out.println("-----");
			}
		}catch(Throwable e){
			System.err.println(e);
		}
	}*/
	@Test
    public void testJson() throws IOException {
        JsonParsing<AdvVO> parser = new JsonParsing<AdvVO>(AdvVO.class);

        
        ArrayList<AdvVO> list = parser.getResult(testJsonData());

        for(AdvVO vo : list) {
            System.out.println(vo.getAdv_title());
        }
    }
	/*
	@Test
	public void jsonTest(){
		AdvVO vo = new AdvVO();
		JsonParsing<AdvVO> jsonParsing = new JsonParsing<AdvVO>((Class<AdvVO>) vo.getClass(), vo);
		
		ArrayList<AdvVO> avo = null;
		try {
			avo = jsonParsing.getResult(testJsonData());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("data result : "+avo.get(0).getAdv_title());

	}*/
	
	public String testJsonData(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("adv_key", 1);
		jsonObject.put("adv_image", "abcdimage");
		jsonObject.put("adv_title", "title");
		jsonObject.put("adv_ticker", "ticker");
		Calendar cal = Calendar.getInstance();
		TimeZone zone = TimeZone.getTimeZone("Asia/Seoul");
		cal.setTimeZone(zone);
		long  now_time = cal.getTimeInMillis();
		Date date = new Date(now_time);
		//jsonObject.put("adv_time", (Object)date);
		jsonObject.put("adv_message", "message");
		jsonObject.put("product_id", "p2017_01_29_1");
		jsonObject.put("product_direct_price", 1000);
		jsonObject.put("product_sale_price", 900);
		jsonObject.put("product_naver_price", 950);
		jsonObject.put("product_min", 3);
		jsonObject.put("deliver_company", 1);
		jsonObject.put("deliver_price", 2500);
		/*String json = "[{\"adv_key\":1, \"adv_image\":'A', \"adv_title\":'title1'},\n" +
                "        {\"adv_key\":2, \"adv_image\":'B', \"adv_title\":'title2'},\n" +
                "        {\"adv_key\":3, \"adv_image\":'C', \"adv_title\":'title3'},\n" +
                "        {\"adv_key\":4, \"adv_image\":'D', \"adv_title\":'title4'},\n" +
                "        {\"adv_key\":5, \"adv_image\":'E', \"adv_title\":'title5'}]";*/
		
		StringWriter out = new StringWriter();
		JSONArray jarray = new JSONArray();
		jarray.add(jsonObject);
		jarray.add(jsonObject);
		jarray.add(jsonObject);
		jarray.add(jsonObject);
		jarray.write(out);
		System.out.println(jarray);
		//jsonObject.write(out);
		return out.toString();
	}
	
	/*
	@Test
	public void setValue(){
		*//**
		 * dataVO 클래스의 변수들을 설정할때마다 모든 겟셋 메소드를 일일이 조작하는건 귀찮다.
		 * VO클래스의 겟셋 메소드는 해당 변수명과 연관성이 존재한다.
		 * 클래스에 정의된 메소드의 이름을 알아오는 방법이 존재한다.
		 * getDeclaredMethod()를 이용하면 된다.
		 * 이는 Method methlist[]에 모두 담을 수 있다.
		 * Method.invoke로 실행할 수 있다.
		 * 이들을 이용하면 VO를 Object로 받아와서 메소드명을 string.substring으로 set이 있는것만 실행
		 * JSON파싱의 경우 위에서 실행,해당 변수명으로 파싱 후 넘기면 된다 이때 오브젝트로 받아오는데 이 또한 변수타입 겟하여 설정
		 *//*
		Ref_listVO vo = new Ref_listVO();
		Ref_listVO refVO = new Ref_listVO();
		refVO.setRef_list_key(1);
		refVO.setRef_id("ref_id");
		refVO.setItem_id("item_id");
		refVO.setOption_name("opt_name");
		refVO.setOption_price(100);
		refVO.setOption_value("opt_value");
		
		String method_name = null;
		Field fld = null;
		try{
			Class cls = Class.forName("com.bluemingo.bluemingo.domain.Ref_listVO");
			
			Object obj = null;
			Method methList[] = cls.getDeclaredMethods();
			Field fieldList[] = cls.getDeclaredFields();
			for(int i=0;i<methList.length;i++){
				method_name = methList[i].getName();
				if(method_name.contains("set")){
					fld = valueSearch(fieldList, method_name);
					
					obj = fld.getName();
					System.out.println("type : "+fld.getType());
					if(fld.getType() == Integer.class){
						obj = (Integer)fld.get(obj);
					}
					
					methList[i].invoke(vo, obj);
					System.out.println("method : "+method_name+" value : "+fld.getName());
				}
			}
			
		}catch(Throwable e){
			System.err.println(e);
		}
		
		System.out.println("data : "+vo.getRef_list_key());
		System.out.println("data : "+vo.getRef_id());
		System.out.println("data : "+vo.getItem_id());
		System.out.println("data : "+vo.getOption_name());
		System.out.println("data : "+vo.getOption_value());
		System.out.println("data : "+vo.getOption_price());
		System.out.println("data : "+vo.getCount());
		
	}
	
	public Field valueSearch(Field[] fieldList, String method_name){
		String value = method_name.substring(3).toLowerCase();
		for(int i=0; i<fieldList.length; i++){
			if(fieldList[i].getName().equals(value)){
				return  fieldList[i];
			}
		}
		return null;
	}*/
	
	/*@Test
	public void test() {
		logger.info(""+session.getConnection());
		
		//logger.info(""+session.selectOne("com.bluemingo.bluemingo.domain.TimeVOMapper.getNow"));
		
		
	}// test()
*/	
	/*
	@Test
	public void sqlTest3() {
		ProductVO vo = new ProductVO();
		vo.setProduct_min(3);
		vo.setDeliver_company(1);
		vo.setDeliver_price(3000);
		vo.setProduct_num(7);
		
		Calendar cal = Calendar.getInstance();
		TimeZone zone = TimeZone.getTimeZone("Asia/Seoul");
		cal.setTimeZone(zone);
		long  now_time = cal.getTimeInMillis();
		Date date = new Date(now_time);
        String str_nowTime = (new SimpleDateFormat("yyyy_MM_dd").format(date));
        
		String id = "p"+str_nowTime+"_"+vo.getProduct_num();
		
		vo.setProduct_id(id);
		vo.setProduct_period(date);
		
		List<ProductVO> list = new ArrayList<ProductVO>();
		list.add(vo);
		list.add(vo);
		
		pservice.multiCreate(list);
		//int key = pservice.create(vo);
				
		List<ProductVO> list = pservice.procedure(vo);
		//logger.info("procedure:insert_product : "+list.get(0));
		
		System.out.println("key : "+list.get(0).getProduct_key());
	}
	*/
	/*@Test
	public void Time(){
		testTime(service.listAll());
	}
	
	public void testTime(List<AndroidVO> vo){
		Calendar cal = Calendar.getInstance();
		TimeZone zone = TimeZone.getTimeZone("Asia/Seoul");
		cal.setTimeZone(zone);
		
		System.out.println(cal.get(Calendar.YEAR)+"�뀈"+cal.get(Calendar.MONTH)+"�썡"+cal.get(Calendar.DAY_OF_MONTH)+"�씪");
		
		cal = new GregorianCalendar().getInstance();
		System.out.println(cal.get(Calendar.YEAR)+"�뀈"+(cal.get(Calendar.MONTH)+1)+"�썡"+cal.get(Calendar.DAY_OF_MONTH)+"�씪");
		
		cal = new GregorianCalendar(zone).getInstance();
		System.out.println(cal.get(Calendar.YEAR)+"�뀈"+cal.get(Calendar.MONTH)+"�썡"+cal.get(Calendar.DAY_OF_MONTH)+"�씪");
		
		long  now_time = cal.getTimeInMillis();
		System.out.println("long now_time : "+now_time);
		
		 
		Long time = vo.get(0).getPeriod();
        System.out.println("long period.time : "+time);
        
        Date date = new Date(time-now_time);
        String str_resTime = (new SimpleDateFormat("HH:mm:ss").format(date));
        date = new Date(now_time);
        String str_nowTime = (new SimpleDateFormat("yyyy-MM-dd").format(date));
        date = new Date(time);
        String str_getTime = (new SimpleDateFormat("yyyy-MM-dd").format(date));
        
        System.out.println("time-now �궓���떆媛�"+str_resTime);
        System.out.println("now day"+str_nowTime);
        System.out.println("get day"+str_getTime);
        System.out.println("get day.time"+date.getTime());
        
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss",Locale.KOREA);
        
        System.out.println("�쁽�옱�떆媛�"+format.format(cal.getTime()));
        
        Long res = time-now_time;
        String timer = "00:00:00";
        if(res > 0){
        	int hours = (int)(res/(1000*60*60));
        	System.out.println("hours : "+hours);
        	int minutes = (int)(res%(1000*60*60))/(1000*60);
        	System.out.println("minutes : "+minutes);
        	int seconds = (int)((res%(1000*60*60))%(1000*60)/1000);
        	System.out.println("seconds : "+seconds);
        	if(hours>23){
        		timer = String.format("%2d�씪 %02d:%02d:%02d",hours/24,hours-(hours/24)*24,minutes,seconds);
        	}else{
        		timer = String.format("%02d:%02d:%02d",hours,minutes,seconds);
        	}
        }
        System.out.println("�궓���떆媛�"+timer);
        
	}
	*/
	
	
	/*@Test
	public void searchTest() {
		SearchVO svo = new SearchVO();
		svo.setSearch_key("源��긽�궗");
		svo.setSearch_table("c.company_name");
		logger.info(""+service.search(svo));
	}*/
	
	/*@Test
	public void sqlTest() {
		SearchVO svo = new SearchVO();
		svo.setCompany_name("company_name");
		svo.setSearch_key("留덉깶");
		logger.info(""+service.search(svo));
	}*/
	
	/*@Test
	public void sqlTest1() {
		SearchVO svo = new SearchVO();
		svo.setUser_name("user_name");
		svo.setSearch_key("源�吏��뿰");
		logger.info(""+uservice.search(svo));
	}*/
	
	/*@Test
	public void sqlTest2() {
		SearchVO svo = new SearchVO();
		svo.setAdv_key("adv_key");
		svo.setSearch_key(1);
		
		List<AdvertiseVO> list = aservice.search(svo);
		for(int i=0; i<list.size(); i++){
			list.get(i).setNow_count();
		}
		logger.info(""+list);
	}
	
	@Test
	public void sqlTest3() {
		List<AdvertiseVO> list = aservice.listAll();
		for(int i=0; i<list.size(); i++){
			list.get(i).setNow_count();
		}
		logger.info(""+list);
	}*/
	
	
	/*@Test
	public void createTest() {
		AdvVO vo = new AdvVO();
		vo.setAdv_title("@adv_title_1");
		vo.setAdv_message("@adv_message_1");
		vo.setAdv_ticker("@adv_ticker_1");
		vo.setAdv_resource("@adv_resource_1");
		//vo.setAdv_time();
		vo.setProduct_product_key(1);
		ItemVO vo = new ItemVO();
		vo.setItem_name("test_name");
		vo.setItem_price(25000);
		vo.setItem_detail("test_detail");
		vo.setItem_image("test_image");	
		
		dao.create(vo);
	}*/
	/*
	@Test
	public void listAllTest(){
		logger.info(""+service.listAll());
		//logger.info(""+dao.listAll());
	}
	*/
	
	/*@Test
	public void readTest() {
		logger.info("adv_time"+service.read(7).getItem_name());
		//logger.info(""+service.read(1));
	}// readTest()
*/	
	/*
	@Test
	public void updateTest() {
		
		BoardVO bVO = new BoardVO();
		bVO.setBno(1);
		bVO.setTitle("占쎈땾占쎌젟占쎈쭆 疫뀐옙");
		bVO.setContent("占쎈땾占쎌젟占쎈쭆 占쎄땀占쎌뒠");
		bVO.setWriter("user00");
		
	}// readTest()
	
	
	@Test
	public void deleteTest() {
		
		dao.delete(728);
	}// readTest()
	*/
	

}
