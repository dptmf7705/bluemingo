package com.bluemingo.bluemingo.service;

import com.bluemingo.bluemingo.domain.AdvVO;
import com.bluemingo.bluemingo.generic.GenericService;

/** Last Edit 2017-02-11 
 * AdvVO - AdvDAO - AdvService - AdvController
 * 광고 리스트 페이지에서 사용됨
 * 
 */
public interface AdvService extends GenericService<AdvVO, Integer>{

	public void getData();
	
}
