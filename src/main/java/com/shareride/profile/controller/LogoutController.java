/**
 * 
 */
package com.shareride.profile.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shareride.profile.beans.UserBean;

/**
 * @author sridhar.reddy
 *
 */

@Controller
public class LogoutController {
	
	private static final Logger LOG = LoggerFactory.getLogger(LogoutController.class);
	
	private static final String indexPageView = "index";

	@RequestMapping(value = "/logout")
	public ModelAndView logout(ModelAndView modeAndView, @ModelAttribute("userBean") UserBean userBean, HttpSession session) {
		String emailId = (String) session.getAttribute("emailId");
		session.removeAttribute("emailId");
		LOG.info("User: "+emailId+" is logged out at "+new Date());
		modeAndView.setViewName(indexPageView);
		return modeAndView;
	}
}
