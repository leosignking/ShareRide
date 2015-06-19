package com.shareride.social.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author sridhar.reddy
 * @created-on 6/11/15.
 */

@RequestMapping(value = "/social/facebook")
@Controller
public class FacebookController {
	
	private static final Logger LOG = LoggerFactory.getLogger(FacebookController.class);
	
    private static final String FB_APP_ID = "384789898393161";
    private static final String FB_APP_SECRET = "400b9a2cdbd9b01cf6747351d9955238";
    private static final String SCOPE = "email,user_birthday,public_profile";
    private static final String REDIRECT_URI = "http://localhost:8080/ShareRide/social/facebook/callback";
    private static final String CANCEL_URI = "http://localhost:8080/ShareRide";
    private static final String DIALOG_OAUTH = "https://www.facebook.com/dialog/oauth";
    private static final String GRAPH_LINK = "https://graph.facebook.com";
	private static final String ACCESS_TOKEN = GRAPH_LINK+"/oauth/access_token";

    private static String accessToken = "";

    @RequestMapping(value = "/signin")
    public void signIn(HttpServletResponse response) {
        String fbLoginUrl = "";
        try {
            fbLoginUrl = DIALOG_OAUTH +"?client_id=" + FB_APP_ID 
            			+ "&redirect_uri=" + URLEncoder.encode(REDIRECT_URI, "UTF-8")
                    	+ "&scope="+SCOPE+"&cancel_uri="+URLEncoder.encode(CANCEL_URI, "UTF-8");

            response.sendRedirect(fbLoginUrl);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getFBGraphUrl(String code) {
        String fbGraphUrl = "";
        try {
            fbGraphUrl = ACCESS_TOKEN + "?client_id=" + FB_APP_ID
            			+ "&redirect_uri="	 + URLEncoder.encode(REDIRECT_URI, "UTF-8")
            			+ "&client_secret=" + FB_APP_SECRET + "&code=" + code;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return fbGraphUrl;
    }

    @RequestMapping(value = "/callback")
    public void getAccessToken(@RequestParam("code") String code, HttpServletResponse response ) {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("index");
        if ("".equals(accessToken)) {
            URL fbGraphURL;
            try {
                fbGraphURL = new URL(getFBGraphUrl(code));
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("Invalid code received " + e);
            }
            URLConnection fbConnection;
            StringBuffer b = null;
            try {
                fbConnection = fbGraphURL.openConnection();
                BufferedReader in;
                in = new BufferedReader(new InputStreamReader(
                        fbConnection.getInputStream()));
                String inputLine;
                b = new StringBuffer();
                while ((inputLine = in.readLine()) != null)
                    b.append(inputLine).append("\n");
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Unable to connect with Facebook "
                        + e);
            }

            accessToken = b.toString();
            if (accessToken.startsWith("{")) {
                throw new RuntimeException("ERROR: Access Token Invalid: "
                        + accessToken);
            } else {
            	URL u;
				try {
					u = new URL(GRAPH_LINK+"/me?"+accessToken);
					URLConnection connection = u.openConnection();
					
					BufferedReader in;
	                in = new BufferedReader(new InputStreamReader(
	                        connection.getInputStream()));
	                String inputLine;
	                b = new StringBuffer();
	                while ((inputLine = in.readLine()) != null)
	                    b.append(inputLine).append("\n");
	                in.close();
	                
	                response.sendRedirect("http://localhost:8080/ShareRide/profile");
	                
				} catch (Exception e) {
					e.printStackTrace();
				}
            	
            }
        }
    }
    
	@RequestMapping(value = "/callback", params = "error_reason", method = RequestMethod.GET)
	@ResponseBody
	public void error(@RequestParam("error_reason") String errorReason,
                           @RequestParam("error") String error,
                           @RequestParam("error_description") String description,
                           HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, description);
			System.out.println(errorReason);
			System.out.println(error);
			System.out.println(description);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
