<%--
  Created by IntelliJ IDEA.
  User: reddy
  Date: 6/10/15
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/dashboard.css" />" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
   <%--  <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script> --%>
  
    <title>ShareRide</title>
<script>
$(function(){
	$("#profile-details").hide();
});
</script>

</head>
<body>
<%
	String emailId = (String) request.getSession().getAttribute("emailId");
	System.out.println(emailId);
%>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Share Ride</a>
        </div>
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#">
                        <i class="fa fa-bell-o"> Notifications</i>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-comment"> Messages</i>
                    </a>
                </li>
                <li>
                    <a href="profile?emailId=<c:out value="${emailIdProfile}"/>">
                    	<%
                    		if (emailId != null && !emailId.isEmpty()) {
						%>
                        <i class="fa fa-user">${emailIdProfile}</i>
                        
						<%
						} else  { 
						%>
                        <i class="fa fa-user">Profile</i>
                        <%
						}
						%>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-sign-out"> Logout</i>
                    </a>
                </li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" placeholder="Search..." class="form-control">
            </form>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li ><a href="#">Dashboard</a></li>
                <li><a href="#">Reports</a></li>
                <li><a href="#">Search</a></li>
            </ul>
            <!-- <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            	<h1 class="page-header">Dashboard</h1>
            </div> -->
       </div>
   
    </div>
    
</div>

</body>
</html>