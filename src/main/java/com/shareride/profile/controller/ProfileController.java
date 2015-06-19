package com.shareride.profile.controller;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shareride.profile.beans.UserBean;

/**
 * @author sridhar.reddy
 * @created-on 6/16/15.
 */

@Controller
public class ProfileController {

    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
    
    private static final String profileViewName = "profile";

    @RequestMapping(value = "/profile", method= RequestMethod.GET)
    public ModelAndView profilePage(ModelAndView model, @ModelAttribute("userBean") UserBean userBean) throws IOException{
        logger.info("ProfileController.profilePage() : Redirecting to profile page");
        model.setViewName(profileViewName);
        return model;
    }
}
