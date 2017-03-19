package com.bluemingo.bluemingo.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bluemingo.bluemingo.controller.AbstractTest;
import com.bluemingo.bluemingo.domain.AdvVO;
import com.bluemingo.bluemingo.generic.GenericDAO;
import com.bluemingo.bluemingo.generic.GenericDAOImpl;
import com.bluemingo.bluemingo.generic.GenericService;
import com.bluemingo.bluemingo.generic.GenericServiceImpl;
import com.bluemingo.bluemingo.persistence.AdvDAO;
import com.bluemingo.bluemingo.service.AdvService;




public class TimeTest extends AbstractTest {

	/*@Inject
	private LoginService service;*/
	@Inject
	private SqlSessionTemplate session;
	
	private static final Logger logger = LoggerFactory.getLogger(AdvDAOTest.class);

	@Test
	public void test() {
		logger.info(""+session.getConnection());
		
		
		
		//logger.info(""+session.selectOne("com.bluemingo.bluemingo.domain.TimeVOMapper.getNow"));
		
		//Date date = genericService.getDateTime();
		//Logger.info(""+service.getDateTime());
	}// test()
	

}
