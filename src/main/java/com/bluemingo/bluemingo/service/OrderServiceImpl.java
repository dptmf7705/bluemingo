package com.bluemingo.bluemingo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bluemingo.bluemingo.domain.AdvVO;
import com.bluemingo.bluemingo.domain.OrderVO;
import com.bluemingo.bluemingo.generic.GenericDAO;
import com.bluemingo.bluemingo.generic.GenericServiceImpl;
import com.bluemingo.bluemingo.persistence.AdvDAO;
import com.bluemingo.bluemingo.persistence.OrderDAO;

/** Last Edit 2017-02-18 
 * OrderO - OrderDAO - OrderService - OrderController
 * 주문 리스트 페이지에서 사용됨
 */
@Service("orderService")
public class OrderServiceImpl extends GenericServiceImpl<OrderVO, Integer>
		implements OrderService {

	private static final Logger logger = LoggerFactory
			.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderDAO orderDao;

	public OrderServiceImpl() {

	}

	@Autowired
	public OrderServiceImpl(
			@Qualifier("orderDao") GenericDAO<OrderVO, Integer> genericDao) {
		super(genericDao);
		this.orderDao = (OrderDAO) genericDao;

	}

}
