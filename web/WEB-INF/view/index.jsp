<%-- 
    Document   : index
    Created on : Aug 11, 2016, 10:23:51 AM
    Author     : irfan
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <spring:url var="url_style" value="resource/style.css"/>
        <link rel="stylesheet" href="${url_style}"/>
        <style>
       
    /*<link rel="stylesheet" href="${url_style}"/>*/
     </style>   
    </head>
    <body>
        <img src="resource/banner.jpg" />
        
        <h1 class="reding">Hello</h1>
                

        <spring:url value="register/form1" var="loginUrl" />
        <spring:url value="/login/form" var="RegUrl" />
        <spring:url value="/userList" var="userList" />
        <a href="${loginUrl}">Click for Registration</a>
        <a href="${RegUrl}">Click for Login</a>
        <a href="${userList}">Click to show Student Information</a>
    </body>
</html>
