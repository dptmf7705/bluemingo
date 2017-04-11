package com.bluemingo.bluemingo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bluemingo.bluemingo.domain.AdvVO;
import com.bluemingo.bluemingo.domain.Item_companyVO;
import com.bluemingo.bluemingo.domain.Ref_listVO;
import com.bluemingo.bluemingo.generic.GenericDAO;
import com.bluemingo.bluemingo.generic.GenericServiceImpl;
import com.bluemingo.bluemingo.persistence.AdvDAO;
import com.bluemingo.bluemingo.persistence.Ref_listDAO;

/** Last Edit 2017-02-12
 * RefListVO - RefListDAO - RefListService - RefListController
 * product-item
 * item-option
 * reservation-deliver
 */

@Service("ref_listService")
public class Ref_listServiceImpl extends GenericServiceImpl<Ref_listVO, Integer> implements Ref_listService {

	private static final Logger logger = LoggerFactory.getLogger(Ref_listServiceImpl.class);
	
	@Autowired
	private Ref_listDAO ref_listDao;
	
	public Ref_listServiceImpl() {
		
	}
	@Autowired
	public Ref_listServiceImpl(@Qualifier("ref_listDao") GenericDAO<Ref_listVO, Integer> genericDao) {
        super(genericDao);
        this.ref_listDao = (Ref_listDAO) genericDao;
		
	}
	
	public void createOption(List<Ref_listVO> option_list) {
		//1. option_name이 다를때 옵션개수 카운팅
		//2. 
	}
	
	@Override
	public List<Item_companyVO> setOptionList(List<Ref_listVO> refList, List<Item_companyVO> icList) {
		List<Ref_listVO> id_list = new ArrayList<Ref_listVO>();
		Ref_listVO temp = null;
		String ref_id = null;
		
		int t = 0;
		if(refList == null){
			return icList;
		}
		while (t < refList.size()) {
			if ((ref_id = refList.get(t).getRef_id()) == null) {
				t++;
			}else if(t == refList.size()){
				return icList;
			}else{
				break;
			}
		}
		
		int size = refList.size();
		int icList_index = 0;
		
		for(int i=0; i<size; i++){
			temp = refList.get(i);
			if(i < size-1){ 
				if(ref_id.equals(temp.getRef_id())){
					id_list.add(temp);
				} else {
					icList.get(icList_index).setOption_list(id_list);
					icList.get(icList_index).setTable_num(icList_index+1);
					icList_index++;
					
					id_list = new ArrayList<Ref_listVO>();
					
					id_list.add(temp);
					ref_id = temp.getRef_id();
				}
			} else { // last
				if(ref_id.equals(temp.getRef_id())){
					id_list.add(temp);
				} else {
					icList.get(icList_index).setOption_list(id_list);
					icList.get(icList_index).setTable_num(icList_index+1);
					icList_index++;
					
					id_list = new ArrayList<Ref_listVO>();
					
					id_list.add(temp);
					ref_id = temp.getRef_id();
				}
				icList.get(icList_index).setOption_list(id_list);
				icList.get(icList_index).setTable_num(icList_index+1);
			}
		}
		return icList;
	}

}
