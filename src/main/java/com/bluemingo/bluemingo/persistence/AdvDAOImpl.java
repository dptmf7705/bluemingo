package com.bluemingo.bluemingo.persistence;

import org.springframework.stereotype.Repository;

import com.bluemingo.bluemingo.generic.GenericDAOImpl;
import com.bluemingo.bluemingo.domain.AdvVO;

/** Last Edit 2017-02-11 
 * AdvVO - AdvDAO - AdvService - AdvController
 * 광고 리스트 페이지에서 사용됨
 * 
 */
@Repository("advDao")
public class AdvDAOImpl extends GenericDAOImpl<AdvVO, Integer> implements AdvDAO {

	public AdvDAOImpl() {
		super(AdvVO.class);
	}

	@Override
	public void getData() {
		// TODO Auto-generated method stub
		
	}
	
	
}
