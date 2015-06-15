package com.shareride.profile.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

    private static final String indexViewName = "index";
    private static final String signupViewName = "signup";
    private final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView indexPage(ModelAndView model) {

        logger.info("Index Controller is called");
        model.setViewName(indexViewName);
        return model;
    }

    @RequestMapping(value = "/signup.htm", method = RequestMethod.GET)
    public ModelAndView signupPage(ModelAndView model) {

        logger.info("Index Controller is called");
        model.setViewName(signupViewName);
        return model;
    }

}