package com.bluemingo.bluemingo.controller;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bluemingo.bluemingo.domain.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime2", formattedDate );
		
		return "home";
	}
	
/*	@RequestMapping(value="/**")
	public void getUser(Model model){
		logger.info("getUser called.......");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserVO user = null;
		Object principal = auth.getPrincipal();
		if(principal != null && principal instanceof UserVO){
			user = (UserVO)principal;
		}
		
		model.addAttribute("userVO", user);
	}*/
	
	
	/*@RequestMapping(value="/home", method = RequestMethod.GET)
	public void homeReturn(Locale locale, Model model){
		
		logger.info("Home Page return");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime2", formattedDate );
		
		
	}// listAllTest()
*/	
}
