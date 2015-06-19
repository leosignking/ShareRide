<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
 	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <link href="<c:url value="/resources/css/bootstraplogin.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/index.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script> 
    <title>ShareRide</title>
</head>
<script type="text/javascript">

    $(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

	
});


</script>
<body>
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
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-6">
                            <a href="#" class="active" id="login-form-link">Log In</a>
                        </div>
                        <div class="col-xs-6">
                            <a href="#" id="register-form-link">Sign Up</a>
                        </div>
                    </div>
                    <hr>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-8 col-lg-push-2">
                            <form:form id="login-form" action="login" method="POST"  modelAttribute="userBean" role="form"  style="display: block;">
                                <div class="form-group">
                                <div id="errorValueCN" style="color: red;">${errorValue}</div>
                                <form:input  path="email" name="email" id="email" tabindex="1" 
                                           placeholder="Username/Email" class="form-control" />
                                <div id="erroremail" style="color: red;"></div>
                                </div>
                                <div class="form-group">
                                <form:password path="password" name="password" id="password" tabindex="2" 
                                           placeholder="Password" class="form-control" />
                                 <div id="errorpaswd" style="color: red;"></div>
                                </div> 
                                <div class="form-group">
                                    <label for="remember">
                                        <input type="checkbox" tabindex="3" class="" name="remember" id="remember">
                                        <small>Remember Me</small>
                                    </label>
                                    <a class="pull-right forgot-password">
                                        <small>Forgot your password?</small>
                                    </a>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="button" name="login-submit" id="login-submit" tabindex="4"
                                                   class="form-control btn btn-login" value="Log In" >
                                        </div>
                                    </div>
                                </div>
                                <hr>
                                <div class="text-center">
                                    <a class="btn" href="javascript:popup_getFacebookConnection()">
                                        <i class="fa fa-facebook-square fa-3x"></i>
                                    </a>
                                    <a class="btn" href="javascript:popup_get_Google_Plus_Connection()">
                                        <i class="fa fa-google-plus-square fa-3x"></i>
                                    </a>
                                </div>
                            </form:form>
                        </div>
                        <div class="col-lg-10 col-lg-push-1">
                            <form:form id="register-form" action="signup" method="post" modelAttribute="userBean" role="form" style="display: none;">
                                <div class="row">
                                    <div class="form-group col-xs-12">
                               		 <form:input  path="email" name="email" id="emailSignup" tabindex="1" 
                                           placeholder="Username/Email" class="form-control" />
                                     <div id="errorEmails" style="color: red;"></div>
                                    </div>
                                    <div class="form-group col-xs-12">
                                     <form:password path="password" name="password" id="passwordSignup" tabindex="2"
                                               class="form-control" placeholder="Password" />
                                     <div id="errorPaswds" style="color: red;"></div>
                                    </div>

                                    <%--<div class="form-group">
                                        <input type="text" name="first_name" id="first_name" class="input-lg col-lg-6" placeholder="First Name" tabindex="3">
                                        <input type="text" name="last_name" id="last_name" class="input-lg col-lg-6" placeholder="Last Name" tabindex="4">
                                    </div>--%>

                                    <div class="col-xs-10 col-sm-6 col-md-6">
                                        <div class="form-group">
                                     	<form:input path="firstName" name="firstName" id="firstName" tabindex="2"
                                               class="form-control" placeholder="First Name" />
                                        <div id="errorFirstName" style="color: red;"></div>
                                        </div>
                                    </div>
                                    <div class="col-xs-10 col-sm-6 col-md-6">
                                        <div class="form-group">
                                     	<form:input path="lastName" name="lastName" id="lastName" tabindex="2"
                                               class="form-control" placeholder="Last Name" />
                                       	<div id="errorLastName" style="color: red;"></div>
                                        </div>
                                    </div>
                                    <div class="col-xs-6">
                                        <div class="form-group">
                                     	<form:input path="mobileNo" name="mobileNo" id="mobileNo" tabindex="2"
                                               class="form-control" placeholder="Phone Number" onblur="phoneNoValidation()"/>
                                        <div id="errorMobileNo" style="color: red;"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="submit" name="register-submit" id="register-submit"
                                                   tabindex="4" class="form-control btn btn-register"
                                                   value="Register Now">
                                        </div>
                                    </div>
                                </div>
                                <hr>
                                <div class="text-center">
                                    <a class="btn" href="javascript:popup_getFacebookConnection()">
                                        <i class="fa fa-facebook-square fa-3x"></i>
                                    </a>
                                    <a class="btn" href="javascript:popup_get_Google_Plus_Connection()">
                                        <i class="fa fa-google-plus-square fa-3x"></i>
                                    </a>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
