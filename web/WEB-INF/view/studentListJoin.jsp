<%-- 
    Document   : studentListJoin
    Created on : Aug 21, 2016, 11:59:24 PM
    Author     : irfan
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resource/jquery.min.js" ></script>
         <f:url var="url_studentListJoinDelete" value="/studentListJoin/delete"/>
        <script>
            $(document).ready(function() {
                $("#btnGData").click(function() {
                    getData();
                });
            });
        </script>
        <script type="text/javascript">
            function getData() {
                $.ajax({
                    type: 'POST',
                    url: "studentListJoin/list",
                    success: function(data, textStatus, jqXHR) {
                        var grid = '';
//                         $.each(data, function(i, items1) {
//                          alert(JSON.stringify(items1));
//                         });
                        //console.log(JSON.stringify(data));
//                        alert(JSON.stringify(data));
                        $.each(data, function(i, items) {
                            grid += '<tr>';
                            grid += '<td>' + (i + 1) + '</td>';
                            grid += '<td>' + items.studentId + '</td>';
                            grid += '<td>' + items.name + '</td>';
                            grid += '<td>' + items.mobileNo + '</td>';
                            grid += '<td>' + items.rant + '</td>';
                            grid += '<td>' + items.charge + '</td>';
                            grid +='<td> <button onclick="dataDelete('+items.studentId+');">Delete</button></td>';
                            grid += '</tr>';
                        });
                        $("#gData").html(grid);
//                        alert(grid);
                        console.log(JSON.stringify(data));
                    },
                    error: function(jqXHR, textStatus, errorThrown) {

                    }
                });
            }
           function dataDelete(studentId){
                $.ajax({
                    type:'POST',
                    url:'${url_studentListJoinDelete}',
                    data:{
                      id:studentId  
                    },
                    success:function(data,textStatus, jqXHR){
                        if(data==true)
                        {
                            window.location.reload();
                        }
                        else{
                            
                        }
                    }
//                    error:function(jqXHR, textStatus, errorThrown) {
//                        $.toaster('Server Error', 'Failed', 'danger');
//                    }
//                }
                });
                
        }
        </script>
    </head>
    <body>

        <table border="1" width="50%">
            <thead>
                <tr>
                    <td>Serial No</td>
                    <td>Student Id</td>
                    <td> Name</td>
                    <td>Mobile No</td>
                    <td> Rant</td>
                    <td> charge</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody id="gData">

            </tbody>
            <%--<c:forEach items="${dtos}" var="t" varStatus="st">
                <tr>
                    <td>${st.count}</td>
                    <td>${t.studentId}</td>
                    <td> ${t.name}</td>
                    <td>${t.mobileNo}</td>
                    <td>${t.rant}</td>
                    <td> ${t.charge}</td>
                </tr>
</c:forEach>--%>
        </table>
        <button id="btnGData">Get Data</button>
       
    </body>
</html>
