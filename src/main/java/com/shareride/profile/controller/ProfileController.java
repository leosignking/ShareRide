package com.shareride.profile.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shareride.profile.beans.UserBean;
import com.shareride.profile.service.UserService;

/**
 * @author sridhar.reddy
 * @created-on 6/16/15.
 */

@Controller
public class ProfileController {

    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
    
    private static final String profileViewName = "profile";
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/profile", method= RequestMethod.GET)
    public ModelAndView profilePage(ModelAndView model, @RequestParam("emailId") String emailId) throws IOException{
        logger.info("ProfileController.profilePage() : Redirecting to profile page");
        UserBean userValues = userService.getUserDetailsByEmail(emailId);
        model.addObject("userValues", userValues);
        model.setViewName(profileViewName);
        return model;
    }
}
