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
                <td> Student Gender</td>
                <td>Student DOB</td>
                <td>Student Hobbies </td>
                <td>Student Image</td>
                <td>Action</td>
            </tr>
            <c:forEach items="${dtos}" var="dto" varStatus="st">
                <tr>
                    <td> ${st.count} </td>
                    <td> ${dto.registerStudent.studentId} </td>
                    <td> ${dto.registerStudent.name} </td>
                    <td> ${dto.registerStudent.gender} </td>

                    <td> ${dto.registerStudent.DOB} </td>
                    <td>
                        <c:forEach items="${dto.hobbies}" var="h">
                            ${h.hobby}<br>
                        </c:forEach>
                    </td>
                    <td><img src="${img_path}${dto.registerStudent.image}" style="width:30%; height: 20%;"></td>
                    <td> 
                        <a href="#">Edit</a>
                        <a href="#">Update</a>
                        <a href="#">Delete</a>


                    </td>





                </tr>
            </c:forEach>
        </table>
    </body>
</html>