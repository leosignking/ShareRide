package com.shareride.profile.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shareride.profile.beans.UserBean;
import com.shareride.profile.service.UserService;

/**
 * 
 * @author sandeep
 *
 */
@Controller
public class LoginController {
	
	private final Log logger = LogFactory.getLog(getClass());
	
    private static final String indexViewName = "index";
    private static final String dashboardViewName = "dashboard";
  
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView indexPage(ModelAndView model, @ModelAttribute("userBean") UserBean userBean) {
    	logger.info("LoginController.indexPage() : Redirected to Login page");
        model.setViewName(indexViewName);
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView loginPage(ModelAndView model, @ModelAttribute("userBean") UserBean userBean, HttpServletRequest request) {
        logger.info("LoginController.loginPage() : Redirected to Dashboard page");
        //validate user
        //create session
        String isValidUser = userService.isUserValid(userBean);
        
        if(isValidUser.equalsIgnoreCase("validUser")){
        	request.getSession().setAttribute("emailId", userBean.getEmail());
        	model.addObject("emailIdProfile", userBean.getEmail());
        	model.setViewName(dashboardViewName);
        } else{
        	model.addObject("errorValue",isValidUser);
        	model.setViewName(indexViewName);
        }
        return model;
    }
}