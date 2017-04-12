<%-- 
    Document   : Login
    Created on : Aug 12, 2016, 10:25:03 AM
    Author     : irfan
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<spring:url var="user_Login" value="/login/fetch"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>${msg}</h1>
        <f:form action="${user_Login}" modelAttribute="cmd">
            Email:<f:input path="mail" required="true" />
            Password:<f:password path="password" required="true" />
            <f:button>Login</f:button>
        </f:form>
    </body>
</html>