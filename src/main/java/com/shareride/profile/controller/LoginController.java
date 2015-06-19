package com.shareride.profile.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shareride.profile.beans.UserBean;

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
  

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView indexPage(ModelAndView model, @ModelAttribute("userBean") UserBean userBean) {
    	LOG.info("LoginController.indexPage() : Redirected to Login page");
        model.setViewName(indexViewName);
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView loginPage(ModelAndView model, @ModelAttribute("userBean") UserBean userBean) {
        LOG.info("LoginController.loginPage() : Redirected to Dashboard page");
        model.setViewName(dashboardViewName);
        return model;
    }
}