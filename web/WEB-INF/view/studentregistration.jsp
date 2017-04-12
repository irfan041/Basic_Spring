<%-- 
    Document   : Register
    Created on : Aug 11, 2016, 10:45:53 AM
    Author     : irfan
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<spring:url var="user_Register" value="/StudentSave"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Registration Page</title>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resource/jquery.min.js" ></script>

        <spring:url var="url_style" value="resource/style.css"/>
        <link rel="stylesheet" href="${url_style}"/>
        <script>
            $(document).ready(function() {
//                alert('AA');
            });
            function createHobbyRow() {
                var strCount = $('#hobbyCount').val();
                //alert(strCount);
                var hobbyCount = parseInt(strCount);
                var htmlContent = "<tr><td>" + (hobbyCount + 1) + ".</td><td><input type=\"text\" name=\"hobby" + hobbyCount + "\" style=\"width:250px;\"  /></td></tr>";
                $('#tableHobbies').append(htmlContent);
                $('#hobbyCount').val(++hobbyCount);
            }
            function readUrl(input) {
                if (input.files != null && input.files[0] != null) {
                    if (input.files[0].type.split("/")[0] == 'image') {
                        var size = input.files[0].size;
                        if (size <= 102400) { // up to 100 KB : 1024 * 100 = 102400 B
                            var reader = new FileReader();
                            reader.onload = function(e) {
                                var htmlContent = "<img style='width:100%;height:100%' src='" + e.target.result + "' />";
                                $('#showImage').html(htmlContent);

                            }
                            reader.readAsDataURL(input.files[0]);
                        } else {
                            alert('WARNING:\nPlease choose image less than 100 KB.');
                        }
                    } else {
                        alert('ERROR:\nPlease select image only.');
                    }

                } else {
                    alert('ERROR:\nPlease Select valid Image.');
                }
            }
//            function Validate()
//            {
//                var image = document.getElementById("image").value;
//                if (image != '') {
//                    var checkimg = image.toLowerCase();
//                    if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)) {
//                        alert("Please enter Image File Extensions .jpg,.png,.jpeg");
//                        document.getElementById("image").focus();
//                        return false;
//                    }
//                }
//                return true;
//            }

        </script>
    </head>
    <body>
        <h1>${msg}</h1>
        <f:form action="${user_Register}" commandName="cmd" enctype="multipart/form-data">
            <input type="hidden" id="hobbyCount" name="hobbyCount" value="0" />
            <table border="1" width="50%" cellpadding="5" style="margin: auto">
                <tr>
                    <td>Name</td>
                    <td><f:input path="registerStudent.name" required="true" /></td>
                </tr>
                <tr>
                    <td>GENDER</td>
                    <td>
                        <%--
                        <c:forEach items="${genderList}" var="gender">
                             <f:radiobutton path="registerStudent.gender" value="${gender}"  />${gender}
                         </c:forEach>
                        --%>
                        <f:radiobuttons path="registerStudent.gender" items="${genderList}" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td valign="top" >Hobbies</td>
                    <td>
                        <table border="1" id="tableHobbies">

                        </table>
                        <span class="btnAddMore" onclick="createHobbyRow();">+</span>
                    </td>
                </tr>
                <tr>
                    <td>Image</td>
                    <td>
                        <div id="showImage" style="width: 112px;
                             border: 1px solid;
                             height: 117px;">

                        </div>
                        <f:input path="file" type="file" id="imgbtn" style="display: none;" onchange="readUrl(this);" />
                        <input type="button" value="Select Image" onclick="$('#imgbtn').click();" required="true"/>

                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </f:form>
    </body>
</html>
