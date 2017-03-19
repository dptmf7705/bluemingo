package com.bluemingo.bluemingo.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bluemingo.bluemingo.domain.Item_companyVO;
import com.bluemingo.bluemingo.domain.SearchVO;
import com.bluemingo.bluemingo.generic.GenericDAOImpl;

@Repository("item_companyDao")
public class Item_companyDAOImpl extends GenericDAOImpl<Item_companyVO, Integer> implements Item_companyDAO {

	public Item_companyDAOImpl() {
		super(Item_companyVO.class);
	}
	
	@Override
	public List<Item_companyVO> listAll_ref_list(SearchVO svo, String PREFIX) {
		return listAll(svo, PREFIX);
	}
}
