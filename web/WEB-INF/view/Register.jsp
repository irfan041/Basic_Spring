<%-- 
    Document   : Register
    Created on : Aug 11, 2016, 10:45:53 AM
    Author     : irfan
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<spring:url var="user_Register" value="/register/save"/>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resource/jquery.min.js" ></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Registration Page</title>
        <script>
           function checkEmail(id, mail, studentId) {
                $.post('<spring:url value="/checkEmail" />', {mail: mail, studentId: studentId}, function(data) {
                    alert(data);
                    if (data != null && data != '' && data == true) {
                        alert("WARNING:\nYou cannot use this email-Id, This is already in use.");
                        $('#').val('');
                        $('#' + id).focus();
                    }
                });
            }  
            
            
        </script>
    </head>
    <body>
        <h1>${msg}</h1>
        <f:form action="${user_Register}" modelAttribute="cmd">
            Name:<f:input path="name" required="true" />
            <f:hidden path="studentId"  /><br>
            password:<f:password path="password" required="true" /><br>
            Email:<f:input path="mail" required="true" onblur="checkEmail(this.id,this.value,'${cmd.studentId}');" autocomplete="off" /><br>
            Mobile Number:<f:input path="mob" required="true" /><br>
            <f:button>Register</f:button>
    </f:form>
        </body>
</html>
