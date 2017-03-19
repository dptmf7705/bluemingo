package com.bluemingo.bluemingo.persistence;

import org.springframework.stereotype.Repository;

import com.bluemingo.bluemingo.domain.AdvVO;
import com.bluemingo.bluemingo.domain.OrderVO;
import com.bluemingo.bluemingo.generic.GenericDAOImpl;

/** Last Edit 2017-02-18 
 * OrderO - OrderDAO - OrderService - OrderController
 * 주문 리스트 페이지에서 사용됨
 */
@Repository("orderDao")
public class OrderDAOImpl extends GenericDAOImpl<OrderVO, Integer> implements OrderDAO {

	public OrderDAOImpl() {
		super(OrderVO.class);
	}
	
}
