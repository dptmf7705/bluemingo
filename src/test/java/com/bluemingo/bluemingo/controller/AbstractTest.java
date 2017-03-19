package com.bluemingo.bluemingo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/* 紐⑤뱺 �뀒�뒪�듃 �뙆�씪�씠 �긽�냽�븷 異붿긽�겢�옒�뒪
 * - �뼱�끂�뀒�씠�뀡 �옄�룞 異붽�
 * - Logger 
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public abstract class AbstractTest {

	protected static final Logger logger = 
			LoggerFactory.getLogger(AbstractTest.class);

}
