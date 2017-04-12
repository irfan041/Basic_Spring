<%-- 
    Document   : userList
    Created on : Aug 12, 2016, 8:41:52 PM
    Author     : irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td> Serial No </td>
                <td> Student Id </td>
                <td> Student Name</td>
                <td> Student Password</td>
                <td>Student Mail</td>
                <td>Student Mobile No</td>
                <td>Action</td>
            </tr>
            <c:forEach items="${studentList}" var="user" varStatus="st">
            <tr>
                <td> ${st.count} </td>
                <td> ${user.studentId} </td>
                <td> ${user.name}</td>
                <td> ${user.password}</td>
                <td>${user.mail}</td>
                <td>${user.mob}</td>
                <td>
                    <a href="<spring:url value="/editUser?studentId=${user.studentId}"/>">Edit</a> |
                    <a href="<spring:url value="/DeleteUser?studentId=${user.studentId}"/>">Delete</a> |
                    <a href="" >show-Password</a> |
                   </td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
