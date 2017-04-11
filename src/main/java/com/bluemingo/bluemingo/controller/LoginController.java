package com.bluemingo.bluemingo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/servlet/login/*")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void login(){
		logger.info("web login is called.......");
	}	
	
	@RequestMapping(value="/accessDenied")
	public void accessDenied(){
		logger.info("web accessDenied is called.......");
	}

}
