<%-- 
    Document   : Profile
    Created on : Mar 7, 2022, 11:22:18 AM
    Author     : hoanganhPC
--%>

<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Model.Teacher"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>view attendance students</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- Animate.css -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- Icomoon Icon Fonts-->
        <link rel="stylesheet" href="css/icomoon.css">
        <!-- Bootstrap  -->
       

    </head>
    <body>
        <style>
            .menu-1{
             font-family: Lucida Console
                 Monaco;
            }
            select{
                height: 30px;
                background-color: #66ff66;
                margin-bottom: 20px;
                margin-left: 50px;
            }
            table ,td,th{
                background-color: #ffffff;
                border: 1px solid black;
            }
            th{
                color: #000000;
                background-color: #33ccff;
            }
            table{
                text-align: center;
                margin-right: 100px;
                float: right;
                width: 40%;
            }
            table p{
                text-align: center;
            }
            select:nth-of-type(2){
                margin-left: 50px;  
            }
            select:nth-of-type(1){
                margin-left: 417px;  
            }
            select:nth-of-type(3){
                margin-left: 0px;
            }

        </style>
        <div id="page"style="background-color: #ffffff;">
            <nav class="fh5co-nav" role="navigation">
                <div style="width: 100%;" class="top">
                    <div class="container">
                        <div  class="row">
                            <div class="col-xs-12 text-right">
                                <p class="site">anhh34711@gmail.com</p>
                                <p style="margin-left: 625px;" class="num">Call: +01 123 456 7890</p>
                                <ul class="fh5co-social">
                                    <li><a href="#"><i class="icon-facebook2"></i></a></li>
                                    <li><a href="#"><i class="icon-twitter2"></i></a></li>
                                    <li><a href="#"><i class="icon-dribbble2"></i></a></li>
                                    <li><a href="#"><i class="icon-github"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="margin-left: 310px;" class="top-menu">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-2">
                                <div style="margin-right: 300px;" id="fh5co-logo"><a href="homestudent"><i class="icon-study"></i>Educ<span>.</span></a></div>
                            </div>
                            
                            <div class="col-xs-10 text-right menu-1">
                                 <ul>
                                    <li class="active"><a style="color:  #b3afaf;" href="homestudent">Home</a></li>
                                    <li><a  href="profilestudent" style="color:  #b3afaf;"> profile individual</a></li>
                                    <li><a style="color:  #b3afaf;" href="homestudent/teacher">teacher information</a></li>
                                    <li><a style="font-weight: bold;" href="listdate">attendance</a></li>
                                    <li><a style="color:  #b3afaf;" href="studentgrade">mark</a></li>   
                                    <c:if test="${sessionScope.studentid==null}">
                                        <li class="btn-cta"><a href="loginstudent"><span>Login</span></a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.studentid!=null}">
                                        <li class="btn-cta"><a href="logout"><span>Logout</span></a></li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>

                    </div>
                </div>
            </nav>
        </div>
        
        <div style="height: 8px;background-color: #00ffff;margin-bottom: 30px;"></div>
        <c:if test="${er==null}">
            <jsp:include page="checkdate.jsp" />
        </c:if>
        <c:if test="${er!=null}"><p>${er}</p></c:if>
        <img style="width: 400px;height: 300px;float: left;" src="data:image/jpeg;base64,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"/>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>