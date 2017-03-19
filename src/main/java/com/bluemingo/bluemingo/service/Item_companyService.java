package com.bluemingo.bluemingo.service;

import java.util.List;

import com.bluemingo.bluemingo.domain.Item_companyVO;
import com.bluemingo.bluemingo.domain.SearchVO;
import com.bluemingo.bluemingo.generic.GenericService;

public interface Item_companyService extends GenericService<Item_companyVO, Integer> {
	
	public List<Item_companyVO> listAll_ref_list(SearchVO svo, String PREFIX);
	
}
