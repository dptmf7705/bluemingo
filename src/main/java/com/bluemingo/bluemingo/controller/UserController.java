package com.bluemingo.bluemingo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluemingo.bluemingo.domain.UserVO;
import com.bluemingo.bluemingo.service.UserService;

@Controller
@RequestMapping("/servlet/user/*")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
    @Autowired(required = true)
    private UserService userService;
	
	/** 회원 가입 */
	@RequestMapping(value="/create")
	@ResponseBody
	public UserVO singIn(UserVO uservo){
		logger.info("android createUser called.......");
		
		return userService.insertProcedure(uservo, "user");
	}
	
}
