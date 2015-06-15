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
    <link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <title>ShareRide</title>
</head>
<script>

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
                            <form id="login-form" action="/login" method="post" role="form" style="display: block;">
                                <div class="form-group">
                                    <input type="text" name="username" id="username" tabindex="1" class="form-control"
                                           placeholder="Username" value="">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" id="password" tabindex="2"
                                           class="form-control" placeholder="Password">
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
                                            <input type="submit" name="login-submit" id="login-submit" tabindex="4"
                                                   class="form-control btn btn-login" value="Log In">
                                        </div>
                                    </div>
                                </div>
                                <hr>
                                <div class="text-center">
                                    <a class="btn">
                                        <i class="fa fa-facebook-square fa-3x"></i>
                                    </a>
                                    <a class="btn">
                                        <i class="fa fa-google-plus-square fa-3x"></i>
                                    </a>
                                </div>
                            </form>
                        </div>
                        <div class="col-lg-10 col-lg-push-1">
                            <form id="register-form" action="/sigup" method="post" role="form" style="display: none;">
                                <div class="row">
                                    <div class="form-group">
                                        <input type="email" name="email" id="email" tabindex="1" class="form-control"
                                               placeholder="Email Address" value="">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" name="password" id="password" tabindex="2"
                                               class="form-control" placeholder="Password">
                                    </div>

                                    <%--<div class="form-group">
                                        <input type="text" name="first_name" id="first_name" class="input-lg col-lg-6" placeholder="First Name" tabindex="3">
                                        <input type="text" name="last_name" id="last_name" class="input-lg col-lg-6" placeholder="Last Name" tabindex="4">
                                    </div>--%>

                                    <div class="col-xs-10 col-sm-6 col-md-1">
                                        <div class="form-group">
                                            <input type="text" name="first_name" id="first_name"
                                                   class="form-control input-lg" placeholder="First Name" tabindex="1">
                                        </div>
                                    </div>
                                    <div class="col-xs-10 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <input type="text" name="last_name" id="last_name"
                                                   class="form-control input-lg" placeholder="Last Name" tabindex="2">
                                        </div>
                                    </div>
                                    <div class="col-xs-10">
                                        <div class="form-group">
                                            <input type="text" class="form-control " data-min="10" data-max="10"
                                                   data-wrap="true" placeholder="1234567890" tabindex="4">
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
                                    <a class="btn" href="/facebook">
                                        <i class="fa fa-facebook-square fa-3x"></i>
                                    </a>
                                    <a class="btn" href="/googleplus">
                                        <i class="fa fa-google-plus-square fa-3x"></i>
                                    </a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>