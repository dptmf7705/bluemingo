package com.bluemingo.bluemingo.persistence;

import org.springframework.stereotype.Repository;

import com.bluemingo.bluemingo.domain.AdvVO;
import com.bluemingo.bluemingo.domain.SellerVO;
import com.bluemingo.bluemingo.generic.GenericDAOImpl;

/** Last Edit 2017-02-16
 * SellerVO - SellerDAO - SellerService - SellerController
 * 판매자 리스트 페이지에서 사용됨
 * 
 */
@Repository("sellerDao")
public class SellerDAOImpl extends GenericDAOImpl<SellerVO, Integer> implements SellerDAO {

	public SellerDAOImpl() {
		super(SellerVO.class);
	}
}
