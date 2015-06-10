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

/**
 * @author sridhar.reddy
 * @created-on 6/10/15.
 */

@Controller
public class SignUp {

    private static final Logger logger = LoggerFactory.getLogger(SignUp.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("userBean") UserBean userBean){
        userService.createUser(userBean);
        return "";
    }
}
