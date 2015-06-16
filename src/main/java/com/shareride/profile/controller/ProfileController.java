package com.shareride.profile.controller;

import com.shareride.profile.model.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author sridhar.reddy
 * @created-on 6/16/15.
 */

@Controller
public class ProfileController {

    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @RequestMapping(value = "/profile")
    public ModelAndView profilePage(ModelAndView modelAndView){
        logger.info("ProfileController.profilePage() : Redirecting to profile page");
        modelAndView.setViewName("profile");
        return modelAndView;
    }
}
