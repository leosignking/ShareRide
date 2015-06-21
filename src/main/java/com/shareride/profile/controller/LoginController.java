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
	
	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
    private static final String indexViewName = "index";
    private static final String dashboardViewName = "dashboard";
  
<<<<<<< HEAD
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
=======

    @RequestMapping(value = "/", method = RequestMethod.GET)
>>>>>>> branch 'master' of https://github.com/leosignking/ShareRide.git
    public ModelAndView indexPage(ModelAndView model, @ModelAttribute("userBean") UserBean userBean) {
    	LOG.info("LoginController.indexPage() : Redirected to Login page");
        model.setViewName(indexViewName);
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
<<<<<<< HEAD
    public ModelAndView loginPage(ModelAndView model, @ModelAttribute("userBean") UserBean userBean, HttpServletRequest request) {
        logger.info("LoginController.loginPage() : Redirected to Dashboard page");
        //create session
        logger.info(" Before calling to service layer : passing userBean");
        logger.info("passing userBean with email Value: "+userBean.getEmail());
        String isValidUser = userService.isUserValid(userBean);
        logger.info(" Response came from service layer : Response is "+isValidUser);
        
        if(isValidUser.equalsIgnoreCase("validUser")){
        	request.getSession().setAttribute("emailId", userBean.getEmail());
        	model.addObject("emailIdProfile", userBean.getEmail());
        	model.setViewName(dashboardViewName);
        } else{
        	model.addObject("errorValue",isValidUser);
        	model.setViewName(indexViewName);
        }
=======
    public ModelAndView loginPage(ModelAndView model, @ModelAttribute("userBean") UserBean userBean) {
        LOG.info("LoginController.loginPage() : Redirected to Dashboard page");
        model.setViewName(dashboardViewName);
>>>>>>> branch 'master' of https://github.com/leosignking/ShareRide.git
        return model;
    }
}
