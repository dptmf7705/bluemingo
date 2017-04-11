package com.bluemingo.bluemingo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bluemingo.bluemingo.domain.Item_companyVO;
import com.bluemingo.bluemingo.domain.SearchVO;
import com.bluemingo.bluemingo.generic.GenericDAO;
import com.bluemingo.bluemingo.generic.GenericServiceImpl;
import com.bluemingo.bluemingo.persistence.Item_companyDAO;

@Service("item_companyService")
public class Item_companyServiceImpl extends GenericServiceImpl<Item_companyVO, Integer> implements Item_companyService {

private static final Logger logger = LoggerFactory.getLogger(Item_companyServiceImpl.class);
	
	@Autowired
	private Item_companyDAO item_companyDao;
	
	public Item_companyServiceImpl() {
		
	}
	@Autowired
	public Item_companyServiceImpl(@Qualifier("item_companyDao") GenericDAO<Item_companyVO, Integer> genericDao) {
        super(genericDao);
        this.item_companyDao = (Item_companyDAO) genericDao;
		
	}
	
	@Override
	public List<Item_companyVO> listAll_ref_list(SearchVO svo, String PREFIX) {
		return listAll_ref_list(svo, PREFIX);
	}
	
}