package com.bluemingo.bluemingo.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

public class ApplicationContextTest extends AbstractTest{

	@Inject
	private ApplicationContext ctxt;
	
	private static final Logger logger = 
			LoggerFactory.getLogger(ApplicationContextTest.class);

	@Test
	public void test() {
		logger.info(""+ctxt);
	}// test()

}// class
