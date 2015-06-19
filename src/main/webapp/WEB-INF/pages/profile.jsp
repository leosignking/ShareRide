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
    <link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <title>ShareRide</title>
<style type="text/css">
	.form-label{
		color: #0073ab;
  		font-size: 1em;
  		font-family: 'proxima_nova_rgregular';
 		font-weight: 700;
  	
	}
	.saveButton {
  background-color: #59B2E0;
  outline: none;
  color: #fff;
  font-size: 14px;
  height: auto;
  font-weight: 700;
  text-transform: uppercase;
  border-color: #59B2E6;
}
.btn {
  display: inline-block;
  margin-bottom: 0;
  font-size: 14px;
  font-weight: 700;
  line-height: 1.42857143;
  text-align: center;
  white-space: nowrap;
  vertical-align: middle;
  -ms-touch-action: manipulation;
  touch-action: manipulation;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  background-image: none;
  border: 1px solid transparent;
  border-radius: 4px;
}
.btnForm{
	
  display: block;
  width: 100%;
  height: 35px;
  font-size: 14px;
  line-height: 1.42857143;
  background-image: none;
  border: 1px solid #ccc;
  border-radius: 4px;
  -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
  box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
  -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
  -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
  transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>

    
       <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Profile</h1>

           <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <a href="#">
              <h4>Personal Information</h4>
              </a>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <a href="#">
              <h4>Address</h4>
              </a>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <a href="#">
              <h4>Change Password</h4>
              </a>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
             <a href="#">
              <h4>Some Link</h4>
              </a>
              </div>
          </div>
          
        <h2 class="sub-header">Personal Information</h2>
          <div class="col-lg-10 col-lg-push-0">
            <table style="width: 70%;">
            <tbody>
             	 <form:form id="profile-form" action="signup" method="post" modelAttribute="userBean" role="form" style="display: none;">
             	 	 <tr style="width:100%">
	             	 	 <td style="width: 45%;">
		             	 	 <div class="form-group col-xs-13">
		             	 	 	 <form:label path="firstName" class="form-label" >First Name</form:label>
		             	 	 	  <div style="clear: both; height: 10px; width: 10px;"></div>
		                         <form:input path="firstName" name="firstName" id="firstName" tabindex="2"
		                                               class="form-control" placeholder="First Name" />
		                                        <div id="errorFirstName" style="color: red;"></div>
		                        
		                     </div>
	                     
	                     </td>
	                     <td style="width: 10%;">
	                     </td>
	                      <td style="width: 45%;">
		             	 	 <div class="form-group col-xs-13">
		             	 	 	  &nbsp;<form:label path="lastName" class="form-label" >Last Name</form:label>
		             	 	 	  <div style="clear: both; height: 10px; width: 10px;"></div>
		                         <form:input path="lastName" name="lastName" id="lastName" tabindex="2"
		                                               class="form-control" placeholder="Last Name" />
		                                        <div id="errorFirstName" style="color: red;"></div>
		                        
		                     </div>
		                     
	                     </td>
                     </tr>
                     <div style="clear: both; height: 10px; width: 10px;"></div>
                      <tr style="width: 65%;">
	             	 	 <td>
		             	 	 <div class="form-group col-xs-13">
		             	 	 	  &nbsp;<form:label path="email" class="form-label" >Email Address</form:label>
		             	 	 	  <div style="clear: both; height: 10px; width: 10px;"></div>
		                         <form:input path="email" name="email" id="email" tabindex="2"
		                                               class="form-control" placeholder="Email/User Name" />
		                         <div id="errorFirstName" style="color: red;"></div>
		                     </div>
	                     </td>
	                     <td>
	                     </td>
	                     <td>
		             	 	 <div class="form-group col-xs-13">
		             	 	 	  &nbsp;<form:label path="password" class="form-label" >Password</form:label>
		             	 	 	  <div style="clear: both; height: 10px; width: 10px;"></div>
		                         <form:password path="password" name="password" id="password" tabindex="2"
		                                               class="form-control" placeholder="password" />
		                         <div id="errorFirstName" style="color: red;"></div>
		                     </div>
	                     </td>
                     </tr>
                     <tr>
                     	<td>
                     		<div class="form-group col-xs-13">
		             	 	 	  &nbsp;<form:label path="mobileNo" class="form-label" >Phone Number</form:label>
		             	 	 	  <div style="clear: both; height: 10px; width: 10px;"></div>
		                         <form:input path="mobileNo" name="mobileNo" id="mobileNo" tabindex="2"
		                                               class="form-control" placeholder="mobileNo" />
		                         <div id="errorFirstName" style="color: red;"></div>
		                     </div>
                     	</td>
                     	<td>
	                     </td>
	                    <td></td>
                     </tr>
                      <tr>
                     	<td >
                     		<div class="form-group col-xs-13">
		             	 	 	  <input type="submit" name="register-submit" id="register-submit"
                                                   tabindex="4" align="right" class="btnForm btn saveButton"
                                                   value="Save">
		                     </div>
                     	</td>
                     	<td>
	                     </td>
	                    <td></td>
                     </tr>
                 
             	 
             	 
             	 </form:form>
            </tbody>
            </table>
          </div>
          	 
          
          
       </div>  
</body>
</html>
