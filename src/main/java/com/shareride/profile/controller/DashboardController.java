package com.shareride.profile.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shareride.profile.beans.UserBean;

/**
 * @author sridhar.reddy
 * @created-on 6/16/15.
 */

@Controller
public class DashboardController {

    private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
    
    private static final String indexViewName = "index";
    private static final String dashboardViewName = "dashboard";

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboardPage(ModelAndView modelAndView, @ModelAttribute("userBean")UserBean userBean, HttpServletRequest request, HttpServletResponse response ) {
        logger.info("DashboardController.dashboardPage() : Redirecting to dashboard page");
        String emailId = (String) request.getSession().getAttribute("emailId");
        if(emailId == null || "".equals(emailId.trim())) {
        	logger.info("DashboardController.dashboardPage() : Redirecting to index page. Session Invalid or wrong access");
        	modelAndView.setViewName(indexViewName);
        } else {
        	modelAndView.setViewName(dashboardViewName);
        }
        return modelAndView;
    }
}
