<%-- 
    Document   : InfoStudent
    Created on : Feb 12, 2022, 9:12:27 PM
    Author     : hoanganhPC
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student</title>
    </head>
    <body>
        <style>
            html{
                width: 99vw;
                height: 98vh;
            }
            body{
                width: 100%;
                height: 100%;
                background-color: #ccccff;
            }
            p{
                font-size: 20px;
                margin-top: 0;
            }
            .t1{
                float: left;
                height: 100%;
                width: 50%;
            }
            .t2{
                float: right;
                height: 100%;
                width: 50%;
            }
        </style>
        <%
        if(request.getAttribute("stt")==null||request.getAttribute("parent")==null){
            response.sendRedirect("view");
        }
        %>
        <section class="t1">
            <h2>information of student</h2>
        <table>
            <c:set var="s" value="${requestScope.stt}"/>
            <tr>
                <img style="width: 250px;height: 180px;" src="image/${s.getImg()}">
            </tr>
            <tr>
                <td><p>name stuent:</p></td>
                <td><p>${s.getName()}</p></td>
            </tr>
            <tr>
                <td><p>gender:</p></td>
                <td><p><c:if test="${s.isGender()}">male</c:if><c:if test="${s.isGender()==false}">female</c:if></p></td>
            </tr> 
            <tr>
                <td><p>email:</p></td>
                <td><p>${s.getEmail()}</p></td>
            </tr> 
            <tr>
                <td><p>campus:</p></td>
                <td><p>${s.getCampus()}</p></td>
            </tr> 
            <tr>
                <td><p>mssv:</p></td>
                <td><p>${s.getId()}</p></td>
            </tr>
            <tr>
                <td><p>phone:</p></td>
                <td><p>${s.getPhoneNumber()}</p></td>
            </tr>
            <tr>
                <td><p>Birth:</p></td>
                <td><p><%=new SimpleDateFormat("dd-MM-yyyy").format(((Student)request.getAttribute("stt")).getDob())%></p></td>
            </tr>
            <tr>
                <td><p>Address: </p></td>
                <td><p>${s.getAddress()}</p></td>
            </tr>
            <tr>
                <td><p>Date join: </p></td>
                <td><p><fmt:formatDate value="${date}" pattern="dd-MM-yyyy"/></p></td>
            </tr>
        </table>
            </section>
            <section class="t2">
                <h2>information about student's parents</h2>
                <table>
                    <tr>
                        <td><p>name :</p></td>
                        <td><p>${parent.name}</p></td>
                    </tr>
                    <tr>
                        <td><p>id card :</p></td>
                        <td><p>${parent.idcard}</p></td>
                    </tr>
                    <tr>
                        <td><p>phone :</p></td>
                        <td><p>${parent.phone}</p></td>
                    </tr>
                    
                </table>
            </section>    
    </body>
</html>
