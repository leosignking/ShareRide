package com.shareride.profile.controller;

import com.shareride.profile.beans.UserBean;
import com.shareride.profile.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author sridhar.reddy
 * @created-on 6/10/15.
 */

@Controller
public class SignUpController {
	
	private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);
	
	private static final String dashboardViewName = "dashboard";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView signup(@ModelAttribute("userBean") UserBean userBean) {
    	ModelAndView model = new ModelAndView();
    	model.setViewName(dashboardViewName);
        userService.createUser(userBean);
        return model;
    }
}
