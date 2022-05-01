<%-- 
    Document   : Profile
    Created on : Mar 7, 2022, 11:22:18 AM
    Author     : hoanganhPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Model.Teacher"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Teacher Individual</title>
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
            .sub,.can{
                display: none;
                border: none;
            }
        </style>
        <div id="page">
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
                <div style="margin-left: 300px;" class="top-menu">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-2">
                                <div style="margin-right: 260px;" id="fh5co-logo"><a href="home.jsp"><i class="icon-study"></i>Educ<span>.</span></a></div>
                            </div>

                            <div class="col-xs-10 text-right menu-1">
                                <ul>
                                    <li><a style="color: #918686;" href="home.jsp">Home</a></li>
                                    <li class="active"><a style="color: #918686;" href="list">Manager Students List</a></li>
                                    <li class="active"><a href="addstudent" style="color: #918686;">List student</a></li>
                                    <li><a style="color: black;" href="individual">Profile</a></li>
                                    <li><a style="color: #918686;" href="schedule">Attendance</a></li>
                                    <li><a style="color: #918686;" href="mark">mark</a></li>     
                                        <c:if test="${sessionScope.id==null}">
                                        <li class="btn-cta"><a href="login.jsp"><span>Login</span></a></li>
                                        </c:if>
                                        <c:if test="${sessionScope.id!=null}">
                                        <li class="btn-cta"><a href="logout"><span>Logout</span></a></li>
                                        </c:if>
                                </ul>
                            </div>
                        </div>

                    </div>
                </div>
            </nav>
        </div>
        <%

            if (request.getAttribute("info") == null) {
                response.sendRedirect("individual");
            }
            Teacher b = (Teacher) request.getAttribute("info");
        %>
        <% if (request.getAttribute("delete") != null || request.getAttribute("ercode") != null || request.getAttribute("update") != null || request.getAttribute("mess") != null) {%>
            <div class="pupup" style="width: 200px;height: 100px;background-color: #ccffcc;position: absolute;z-index: 1;
                 top: 30px;right:800px;text-align: center;padding-top: 30px;">
                <c:if test="${delete!=null}">
                    <p>${delete}</p>  
                </c:if>
                <c:if test="${mess!=null}">
                    <p>${mess}</p>  
                </c:if>
                <c:if test="${ercode!=null}">
                    <p>${ercode}</p>  
                </c:if>
                <c:if test="${update!=null}">
                    <p>${update}</p>  
                </c:if>
            </div>   
            <% }%>
        <div style="height: 8px;background-color: #00ffff;"></div>
        <div class="container">
            <div class="bg-white shadow rounded-lg d-block d-sm-flex">
                <div class="profile-tab-nav border-right">
                    <form class="p-4" action="individual" method="post" enctype="multipart/form-data">
                        <div class="img-circle text-center mb-3">
                            <img style="width: 240px;height: 240px;" name="image" src="image/<%= b.getImg()%>" alt="Image" class="shadow">
                        </div>
                        <div style="display: flex;">
                            <button class="sub" value="img" name="sub" style="background-color: #00ffff;margin-left: 60px;margin-right: 20px;">Save</button>
                            <button class="can">Cancel</button>
                        <input type="file" accept=".jpg,.png,.jfif" name="file" id="file" style="display: none;">
                        <label for="file" class="la" style="margin-left: 70px;color: #ffcc66;cursor: pointer;text-decoration: underline;">change image</label>
                        </div>
                        <h4 class="text-center"><%= b.getName()%></h4>
                    </form>
                </div>
                <form action="individual" method="post" class="tab-content p-4 p-md-5" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="account" role="tabpanel" aria-labelledby="account-tab">
                        <h3 class="mb-4">Account Information</h3>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Full Name</label>
                                    <input type="text" name="name" class="form-control" value="<%= b.getName()%>">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>ID</label>
                                    <input type="text" readonly="" class="form-control" value="<%= b.getId()%>">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="text" name="mail" class="form-control" value="<%= b.getEmail()%>">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Campus</label>
                                    <input type="text" readonly class="form-control" value="<%= b.getCampus()%>">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Day of birth</label>
                                    <input type="text" name="date" class="form-control" value="<%= new SimpleDateFormat("dd-MM-yyyy").format(b.getDob())%>">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Code join</label>
                                    <input type="text" name="code" class="form-control" value="<%= b.getCode()%>">
                                </div>
                            </div>
                        </div>
                        <div>
                            <button id="but" value="update" name="update" class="btn btn-primary">Update</button>
                        </div>
                    </div>

                </form>
            </div>
        </div>

        <script>
            document.getElementsByName("file")[0].onchange=function (e){
                document.getElementsByClassName("sub")[0].style.display="block";
                document.getElementsByClassName("can")[0].style.display="block";
                document.getElementsByClassName("la")[0].style.display="none";
                   document.getElementsByName("image")[0].src=URL.createObjectURL(e.target.files[0]);
                };
                if(document.getElementsByClassName("can")[0]!==null){
                    document.getElementsByClassName("can")[0].onclick=function (e){
                        e.preventDefault();
                      location.reload();
                    };
                }
            var pup = document.getElementsByClassName("pupup");
            if (pup !== null) {
                var time = setTimeout(function () {
                    pup[0].style.display = "none";
                }, 2500);
            }
            document.getElementById("but").onclick = function (e) {
                if (document.getElementsByName("name")[0].value.trim() === "" || document.getElementsByName("date")[0].value.trim() === ""
                        || document.getElementsByName("code")[0].value.trim() === "" || document.getElementsByName("mail")[0].value.trim() === "") {
                    e.preventDefault();
                }
            }
        </script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>