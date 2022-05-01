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
        <title>view teachers</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <!-- Animate.css -->
        <link rel="stylesheet" href="../css/animate.css">
        <!-- Icomoon Icon Fonts-->
        <link rel="stylesheet" href="../css/icomoon.css">
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
        </style>
        <div id="page" >
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
                                <div style="margin-right: 300px;" id="fh5co-logo"><a href="../homestudent"><i class="icon-study"></i>Educ<span>.</span></a></div>
                            </div>
                            
                            <div class="col-xs-10 text-right menu-1">
                                 <ul>
                                    <li class="active"><a style="color:  #b3afaf;" href="../homestudent">Home</a></li>
                                    <li><a  href="../profilestudent" style="color:  #b3afaf;"> profile individual</a></li>
                                    <li><a style="font-weight: bold;" href="../homestudent/teacher">teacher information</a></li>
                                    <li><a style="color:  #b3afaf;" href="../listdate">attendance</a></li>
                                    <li><a style="color:  #b3afaf;" href="../studentgrade">mark</a></li>   
                                    <c:if test="${sessionScope.studentid==null}">
                                        <li class="btn-cta"><a href="../loginstudent"><span>Login</span></a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.studentid!=null}">
                                        <li class="btn-cta"><a href="../logout"><span>Logout</span></a></li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>

                    </div>
                </div>
            </nav>
        </div>
                    <% 
                
                if(request.getAttribute("teacher")==null)
                response.sendRedirect("homestudent/teacher");
                Teacher b=(Teacher)request.getAttribute("teacher");
            %>
        <div style="height: 8px;background-color: #00ffff;margin-bottom: 30px;"></div>
        <c:if test="${none==null}">
            <form action="../homestudent/teacher" method="get" class="a">
                <select onchange="document.getElementsByClassName('a')[0].submit()" name="id">
                <option>select name teacher</option>
                <% for(int i=0;i<((ArrayList<String>)request.getAttribute("list")).size();i++){%>
                <option <%if(request.getParameter("id")!=null&&request.getParameter("id").trim().equals(((ArrayList<String>)request.getAttribute("list")).get(i).split("=")[0])){ %><%="selected"%><% }%>  value="<%= ((ArrayList<String>)request.getAttribute("list")).get(i).split("=")[0] %>"><%= ((ArrayList<String>)request.getAttribute("list")).get(i).split("=")[1] %></option>
                <% }%>
            </select>
            </form>
            <div class="container" style="margin-left: 240px;">
                <div class="bg-white shadow rounded-lg d-block d-sm-flex">
                    <div class="profile-tab-nav border-right">
                        <div class="p-4">
                            <div class="img-circle text-center mb-3">
                                <img style="width: 240px;height: 240px;" src="../image/<%= b.getImg() %>" alt="Image" class="shadow">
                            </div>
                            <h4 class="text-center"><%= b.getName() %></h4>
                        </div>
                    </div>
                        <div action="individual" method="post" class="tab-content p-4 p-md-5" id="v-pills-tabContent">
                        <div class="tab-pane fade show active" id="account" role="tabpanel" aria-labelledby="account-tab">
                            <h3 class="mb-4">Teacher Information</h3>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Full Name</label>
                                        <input type="text" name="name" readonly class="form-control" value="<%= b.getName() %>">
                                    </div>
                                </div>
                                
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input type="text" name="mail" readonly class="form-control" value="<%= b.getEmail() %>">
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
                                        <input type="text" name="date" readonly class="form-control" value="<%= new SimpleDateFormat("dd-MM-yyyy").format(b.getDob()) %>">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Code join</label>
                                        <input type="text" name="code" readonly class="form-control" value="<%= b.getCode() %>">
                                    </div>
                                </div>
                            </div>
                          
                        </div>

                    </div>
                </div>
            </div>
      </c:if>
        <c:if test="${none!=null}">
            <p>${none}</p> 
        </c:if>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>