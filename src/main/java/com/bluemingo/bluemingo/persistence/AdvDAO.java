package com.bluemingo.bluemingo.persistence;

import com.bluemingo.bluemingo.generic.GenericDAO;
import com.bluemingo.bluemingo.domain.AdvVO;

/** Last Edit 2017-02-11 
 * AdvVO - AdvDAO - AdvService - AdvController
 * 광고 리스트 페이지에서 사용됨
 * 
 */
public interface AdvDAO extends GenericDAO<AdvVO,Integer>{
	
	public void getData();
	
}
