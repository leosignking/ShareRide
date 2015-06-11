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
<title>Sign Up</title>
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
          <a style="padding-left: 400px;" class="navbar-brands" href="#" >Share Ride</a>
        </div>
      </div>
    </nav> 
    
    <div style="clear: both; height: 200px; width: 20px;"></div>
    <div class="basicContainer">
    	<div class="signup-text"> Sign Up to Ride</div>
    	<div id="signup-div">
    	</div>
    </div>
    
</body>
</html>