package com.bluemingo.bluemingo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bluemingo.bluemingo.domain.AdvVO;
import com.bluemingo.bluemingo.domain.SellerVO;
import com.bluemingo.bluemingo.generic.GenericDAO;
import com.bluemingo.bluemingo.generic.GenericServiceImpl;
import com.bluemingo.bluemingo.persistence.AdvDAO;
import com.bluemingo.bluemingo.persistence.SellerDAO;

/** Last Edit 2017-02-16
 * SellerVO - SellerDAO - SellerService - SellerController
 * 판매자 리스트 페이지에서 사용됨
 * 
 */
@Service("sellerService")
public class SellerServiceImpl extends GenericServiceImpl<SellerVO, Integer> implements SellerService {

private static final Logger logger = LoggerFactory.getLogger(SellerServiceImpl.class);
	
	@Autowired
	private SellerDAO sellerDao;
	
	public SellerServiceImpl() {
		
	}
	@Autowired
	public SellerServiceImpl(@Qualifier("sellerDao") GenericDAO<SellerVO, Integer> genericDao) {
        super(genericDao);
        this.sellerDao = (SellerDAO) genericDao;
		
	}
	
}
