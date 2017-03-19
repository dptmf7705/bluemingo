package com.bluemingo.bluemingo.persistence;

import java.util.List;

import com.bluemingo.bluemingo.domain.Item_companyVO;
import com.bluemingo.bluemingo.domain.SearchVO;
import com.bluemingo.bluemingo.generic.GenericDAO;

public interface Item_companyDAO extends GenericDAO<Item_companyVO, Integer> {
	
	public List<Item_companyVO> listAll_ref_list(SearchVO svo, String PREFIX);
	
}
