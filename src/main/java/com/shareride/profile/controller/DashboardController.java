package com.shareride.profile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author sridhar.reddy
 * @created-on 6/16/15.
 */

@Controller
public class DashboardController {

    private static final Logger LOG = LoggerFactory.getLogger(DashboardController.class);

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboardPage(ModelAndView modelAndView) {
        LOG.info("DashboardController.dashboardPage() : Redirecting to dashboard page");
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }
}
