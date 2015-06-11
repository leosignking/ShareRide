package com.shareride.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


 
@Controller
public class LoginController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	public static final String indexViewName ="index"; 
	public static final String signupViewName ="signup";
	
	@RequestMapping(value="/index.htm", method = RequestMethod.GET)
	public ModelAndView indexPage(ModelAndView model) throws Exception {
		
		logger.info("Index Controller is called");
		model.setViewName(indexViewName);
		return model;
	}
	
	@RequestMapping(value="/signup.htm", method = RequestMethod.GET)
	public ModelAndView signupPage(ModelAndView model) throws Exception {
		
		logger.info("Index Controller is called");
		model.setViewName(signupViewName);
		return model;
	}
	
}