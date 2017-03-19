package com.bluemingo.bluemingo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bluemingo.bluemingo.domain.AdvVO;
import com.bluemingo.bluemingo.generic.GenericDAO;
import com.bluemingo.bluemingo.generic.GenericServiceImpl;
import com.bluemingo.bluemingo.persistence.AdvDAO;

/** Last Edit 2017-02-11 
 * AdvVO - AdvDAO - AdvService - AdvController
 * 광고 리스트 페이지에서 사용됨
 * 
 */
@Service("advService")
public class AdvServiceImpl extends GenericServiceImpl<AdvVO, Integer> implements AdvService{

	private static final Logger logger = LoggerFactory.getLogger(AdvServiceImpl.class);
	
	@Autowired
	private AdvDAO advDao;
	
	public AdvServiceImpl() {
		
	}
	@Autowired
	public AdvServiceImpl(@Qualifier("advDao") GenericDAO<AdvVO, Integer> genericDao) {
        super(genericDao);
        this.advDao = (AdvDAO) genericDao;
		
	}
	
	public void setAdvDao(AdvDAO advDao) {
		this.advDao = advDao;
	}
	
	@Override
	public void getData() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	/* �߰� ��� ��
	 * Generic���� �����ϴ� �⺻ ��� �ܿ� �ʿ��� ����� ���Ѵ�.
	 */
	//test

	
}
