<%-- 
    Document   : update
    Created on : Jan 27, 2022, 9:30:09 PM
    Author     : hoanganhPC
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student</title>
    </head>
    <body>
        <style>
            html{
                width: 100vw;
                height: 100vh;
                margin: 0;
                padding: 0;
            }
            body{
                margin: 0;
                padding: 0;
                width: 100%;
                height: 100%;
                background-color: #ccccff;
            }
            form{
                width: 100%;
                height: 100%;
                display: flex;
                justify-content: center;
                align-items: center;
            }
            input{
                width: 300px;height: 30px;
            }
            .ra{
                width: 18px;
                height: 18px;
            }
            .p{
                display: none;
            }
            table{background-color: #ccffff;}
        </style>
        <form action="update" method="post" enctype="multipart/form-data">
            <%
            if(request.getAttribute("student")==null){
                response.sendRedirect("update");
            }
            %>
            <table>
                <c:set var="s" value="${student}"/>
                <tr>
                    <td>campus:</td>
                    <td><input type="text" name="campus" value="${s.getCampus()}" style="background-color: #cccccc;" readonly/></td>
                </tr>
                <tr>
                    <td>mssv:</td>
                    <td><input type="text" name="id" value="${s.getId()}" style="background-color: #cccccc;" readonly/></td>
                </tr>
                <tr>
                    <td>full name:</td>
                    <td><input type="text" name="name" value="${s.getName()}"/></td>
                </tr>
                <tr>
                    <td>date of birth:</td>
                    <td><input type="text" name="date" placeholder="day-month-year"
                      value="<%=new SimpleDateFormat("dd-MM-yyyy").format(((Student)request.getAttribute("student")).getDob())%>"/></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="address" value="${s.getAddress()}"/></td>
                </tr>
                <tr>
                    <td>gender:</td>
                    <td>
                        male:<input type="radio" <c:if test="${s.isGender()}">checked</c:if> class="ra" name="gender" value="male">
                        female:<input class="ra" <c:if test="${s.isGender()==false}">checked</c:if>  type="radio" name="gender" value="female">
                    </td>
                </tr>
                <tr>
                    <td>email:</td>
                    <td><input type="email" name="mail" value="${s.getEmail()}"/></td>
                </tr>
                <tr>
                    <td>phone:</td>
                    <td><input type="text" name="phone" value="${s.getPhoneNumber()}"/></td>
                </tr>
                <tr>
                    <td>image:</td>
                    <td><label for="file" style="cursor: pointer;">Click to change your profile image</label><input  type="file" name="file" id="file" style="display:none;" accept=".jpg,.jfif,.png"/></td>
                </tr>
                <tr >
                    <td></td>
                    <td>
                        <img class="img" src="image/${s.getImg()}"
                             style="width: 150px;height: 150px;">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><button style="background-color: #3366ff;" class="but">Save</button></td>
                </tr>
                <tr>
                    <td></td>
                    <td><p style="color:red;margin-bottom: 0;" class="p"></p></td>
                </tr>
            </table>
        </form>
                <script>
                document.getElementsByName("file")[0].onchange=function (e){
                    document.getElementsByClassName("img")[0].style.display='block';
                   document.getElementsByClassName("img")[0].src=URL.createObjectURL(e.target.files[0]);
                };
                
                document.getElementsByClassName("but")[0].onclick=function (e){
                    if(document.getElementsByName("name")[0].value.trim()===""||document.getElementsByName("address")[0].value.trim()===""||
                     document.getElementsByName("date")[0].value.trim()===""||document.getElementsByName("phone")[0].value.trim()===""||
                     document.getElementsByName("mail")[0].value.trim()===""){
                         e.preventDefault();
                         document.getElementsByClassName("p")[0].style.display="block";
                         document.getElementsByClassName("p")[0].innerHTML="please fill up your information";
                     }
                };
            </script>
    </body>
</html>
