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
    <script src="<c:url value="/resources/js/dashboard.js" />"></script>
  
    <title>ShareRide</title>
<script>
$(function(){
	$("#profile-details").hide();
});
</script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Dashboard</h1>

          <div id="profile-details"></div>
       </div>  
</body>
</html>