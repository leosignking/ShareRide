<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<% String contextPath = request.getContextPath(); %>
<html>
<head>
<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">	</script>
<%-- <script type="text/javascript" src="<%=contextPath%>/js/universityhome.js"></script> --%>
<link rel="stylesheet" href="<%=contextPath%>/css/main.css">
<style>

</style>
<title>Login</title>
</head>
<body style=" background-image: url('/ShareRide/images/body_graphics.jpg'); background-repeat: no-repeat; font-size: 13px; ">
  <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Share Ride</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right">
            <div class="form-group">
              <input type="text" placeholder="Email" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>
    
    	<div style="clear: both; height: 175px; width: 20px"></div>
    
   		 <div class="basicContainer">
   		 <div style="padding-left: 100px;">
   		 	<div class="loginContainer">
   		 		<div style="clear: both; height: 25px; width: 10px;"></div>
   		 		<div style="padding-left: 75px;">
   		 			<a class="signupButton" href="signup.htm" title="create new account">Sign Up</a>
   		 	</div>
   		 	<div style="clear: both; height: 30px; width: 10px;"></div>
   		 	<div style="padding-left: 200px;">
   		 		<i class="orclass"></i>
   		 	</div>
   		 	<div style="clear: both; height: 50px; width: 5px;"></div>
   		 	<h3 style="padding-left: 150px;"> sign in using</h3>
   		 	
   		 	<div style="clear: both; height: 20px; width: 5px;"></div>
   		 	<div style="padding-left: 150px;">
   		 		<input type="image" src="/ShareRide/images/fblogin.png" id="fbLoginButton" height="35px;" width="125px;" title="login with facebook"/>
   		 	</div>
   		 	</div>
   		 </div>
	 	</div>
    
    
    
    
</body>
</html>