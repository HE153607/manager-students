<%-- 
    Document   : Profile
    Created on : Mar 7, 2022, 11:22:18 AM
    Author     : hoanganhPC
--%>

<%@page import="Model.Student"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Model.Teacher"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Account Settings UI Design</title>
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
                <div style="margin-left: 310px;" class="top-menu">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-2">
                                <div style="margin-right: 300px;" id="fh5co-logo"><a href="homestudent"><i class="icon-study"></i>Educ<span>.</span></a></div>
                            </div>
                            
                            <div class="col-xs-10 text-right menu-1">
                                <ul>
                                    <li class="active"><a style="color:  #b3afaf;" href="homestudent">Home</a></li>
                                    <li><a  href="profilestudent" style="font-weight: bold;"> profile individual</a></li>
                                    <li><a style="color:  #b3afaf;" href="homestudent/teacher">teacher information</a></li>
                                    <li><a style="color:  #b3afaf;" href="listdate">attendance</a></li>
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
                    <% 
                
                if(request.getAttribute("student")==null)
                response.sendRedirect("profilestudent");
                Student b=(Student)request.getAttribute("student");
            %>
        <div style="height: 8px;background-color: #00ffff;"></div>
            <div class="container">
                <div class="bg-white shadow rounded-lg d-block d-sm-flex">
                    <div class="profile-tab-nav border-right">
                        <div class="p-4">
                            <div class="img-circle text-center mb-3">
                                <img style="width: 240px;height: 240px;" src="image/<%= b.getImg() %>" alt="Image" class="shadow">
                            </div>
                            <h4 class="text-center"><%= b.getName().split("=")[0] %></h4>
                        </div>
                    </div>
                        <div class="tab-content p-4 p-md-5" id="v-pills-tabContent">
                        <div class="tab-pane fade show active" id="account" role="tabpanel" aria-labelledby="account-tab">
                            <h3 class="mb-4">Your Information</h3>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Full Name</label>
                                        <input type="text" name="name" readonly class="form-control" value="<%= b.getName().split("=")[0] %>">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>ID</label>
                                        <input type="text" readonly class="form-control" value="<%= b.getId() %>">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input type="text" readonly name="mail" class="form-control" value="<%= b.getEmail() %>">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Address</label>
                                        <input type="text" readonly name="mail" class="form-control" value="<%= b.getAddress() %>">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Phone Number</label>
                                        <input type="text" readonly name="mail" class="form-control" value="<%= b.getPhoneNumber() %>">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Campus</label>
                                        <input type="text" readonly class="form-control" value="<%= b.getCampus() %>">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Day of birth</label>
                                        <input type="text"  readonly class="form-control" value="<%= new SimpleDateFormat("dd-MM-yyyy").format(b.getDob()) %>">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>date joined</label>
                                        <input type="text"  readonly class="form-control" value="<%= new SimpleDateFormat("dd-MM-yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(b.getName().split("=")[1])) %>">
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
    
                                    <script>
                                document.getElementById("but").onclick=function (e){
                                    if(document.getElementsByName("name")[0].value.trim()===""||document.getElementsByName("date")[0].value.trim()===""
                                       ||document.getElementsByName("code")[0].value.trim()===""||document.getElementsByName("mail")[0].value.trim()===""){
                                   e.preventDefault();
                                    }
                                }
                                    </script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>