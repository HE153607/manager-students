<%@page import="java.util.List"%>
<%@page import="Controller.ControllDao"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.TreeMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Teacher"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Grade Student</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Free HTML5 Website Template by freehtml5.co" />
        <meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
        <meta name="author" content="freehtml5.co" />

        <!-- 
        //////////////////////////////////////////////////////

        FREE HTML5 TEMPLATE 
        DESIGNED & DEVELOPED by FreeHTML5.co
                
        Website: 		http://freehtml5.co/
        Email: 			info@freehtml5.co
        Twitter: 		http://twitter.com/fh5co
        Facebook: 		https://www.facebook.com/fh5co

        //////////////////////////////////////////////////////
        -->

        <!-- Facebook and Twitter integration -->
        <meta property="og:title" content=""/>
        <meta property="og:image" content=""/>
        <meta property="og:url" content=""/>
        <meta property="og:site_name" content=""/>
        <meta property="og:description" content=""/>
        <meta name="twitter:title" content="" />
        <meta name="twitter:image" content="" />
        <meta name="twitter:url" content="" />
        <meta name="twitter:card" content="" />

        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400" rel="stylesheet">

        <!-- Animate.css -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- Icomoon Icon Fonts-->
        <link rel="stylesheet" href="css/icomoon.css">
        <!-- Bootstrap  -->
        <link rel="stylesheet" href="css/bootstrap.css">

        <!-- Magnific Popup -->
        <link rel="stylesheet" href="css/magnific-popup.css">

        <!-- Owl Carousel  -->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">

        <!-- Flexslider  -->
        <link rel="stylesheet" href="css/flexslider.css">

        <!-- Pricing -->
        <link rel="stylesheet" href="css/pricing.css">

        <!-- Theme style  -->
        <link rel="stylesheet" href="css/style.css">

        <!-- Modernizr JS -->
        <script src="js/modernizr-2.6.2.min.js"></script>
        <!-- FOR IE9 below -->
        <!--[if lt IE 9]>
        <script src="js/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <style>
            .out{
                margin-left: 9vw;
                width: 80vw;


            }
            .outin{
                background-color: #f7f7f7;
                width: 100%;
                height: 125px;
                display: flex;
                justify-content: space-between;
                border-radius: 7px;
                margin-bottom: 10px;
                border: 1px solid black;
            }
            .frame{
                width: 20%;
                height: 185px;
            }
            .frame img{
                border-radius: 7px;
                width: 70%;
                height: 125px;
            }
            .in4 a{
                text-decoration: none;
                background-color: #bad1fa;
                border-radius: 4px;
                padding: 10px 7px;
                color: black;vertical-align: middle;
            }
            .in4 button{
                margin-left: 10px;
                margin-right: 10px;
                background-color: #bad1fa;
                border-radius: 4px;
                padding: 11px 7px;  
                color: black;
                border: none;
                cursor: pointer;
            }
            .in4{
                align-items: center;
                width: 70%;
                display: flex;
                justify-content: space-between;
                padding-right: 60px;
            }
            .na{
                margin-top: 15px;
            }
            .na a{
                background-color: #cccccc;
                padding: 5px 15px 5px 15px;
                text-decoration: none;
                font-size: 20px;
                font-weight: bold;
                margin-right: 10px;
            }
            .adds input,.add2 input{
                    width: 105px;
                    height:35px;
                    margin-top:7px;
                    margin-right: 10px;
                    color: #000000;
                }
                table ,td,th{
                    border: 1px solid black;
                }
                table{
                    margin-left: 200px;
                }
                td{
                    text-align: center;
                }
                td input{text-align: center;
                    border: none;
                }
        </style>
        <div id="page">
            <nav class="fh5co-nav" role="navigation">
                <div class="top">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12 text-right">
                                <p class="site">anhh34711@gmail.com</p>
                                <p class="num">Call: +01 123 456 7890</p>
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
                <div class="top-menu">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-2">
                                <div id="fh5co-logo"><a href="home.jsp"><i class="icon-study"></i>Educ<span>.</span></a></div>
                            </div>
                            <div class="col-xs-10 text-right menu-1">
                                <ul>
                                    <li><a href="home.jsp">Home</a></li>
                                    <li><a href="list">Manager Students List</a></li>
                                    <li ><a href="addstudent" style="color: #a7a2a2;">List student</a></li>
                                    <li><a href="individual">Profile</a></li>
                                    <li><a href="schedule">Attendance</a></li>
                                    <li class="active"><a href="mark">mark</a></li>                                    
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
        <div style="height: 8px;border-radius: 5px;background-color: #00ffff;margin-bottom: 20px;"></div>
        <form action="mark" method="post" name="form-l">
            
            <% if (request.getAttribute("delete") != null || request.getAttribute("add") != null || request.getAttribute("update") != null || request.getAttribute("mess") != null) {%>
            <div class="pupup" style="width: 200px;height: 100px;background-color: #ccffcc;position: absolute;z-index: 1;
                 top: 30px;right:800px;text-align: center;padding-top: 30px;">
                <c:if test="${delete!=null}">
                    <p>${delete}</p>  
                </c:if>
                <c:if test="${mess!=null}">
                    <p>${mess}</p>  
                </c:if>
                <c:if test="${add!=null}">
                    <p>${add}</p>  
                </c:if>
                <c:if test="${update!=null}">
                    <p>${update}</p>  
                </c:if>
            </div>   
            <% }%>   
            <c:if test="${exist!=null}">
                <div class="out">
                    <div class="sj" style="display:flex;width:100%;">
                        <div style="border-radius: 3px;display:block;padding-top:5px;width:50%;height:30px;margin-top:7px;margin-bottom: 20px;">
                            Enter subject:<input name="subject" type="text" placeholder="enter subject"/>
                        </div>

                    </div>
                    <div class="adds" style="display:flex;width:100%;">

                        <div style="background-color:aquamarine ;border-radius: 3px;display:block;padding-top:5px;padding-bottom: 30px;
                             text-align:center;width:140px;height:30px;margin-top:7px;font-weight: bold;" class="add">new grade category</div>
                    </div>
                    <div class="add2" style="display:flex;width:100%;">
                        <div style="background-color:aquamarine ;border-radius: 3px;display:block;padding-top:5px;
                             text-align:center;width:140px;height:35px;margin-top:7px;font-weight: bold;" class="add1">create weight</div>
                    </div>
                    <button style="background-color: #3366ff;border-radius: 3px;display:block;padding-top:3px;
                            text-align:center;width:140px;height:30px;margin-top:7px;border:none; color: black;" class="save">save</button>
                    <p style="color:red;" class="run"></p>
                </div>  
            </c:if>
            <c:if test="${exist==null}">
                <c:if test="${list.size()>0}">
                <%Controller.ControllDao c = new ControllDao();
                    String id = (String) request.getSession().getAttribute("id");
                    List<Student> l = (List<Student>) request.getAttribute("list");
                    ArrayList<String> a1 = c.getsubject(l.get(0).getId(), id);
                %>
   
                <h2 style="margin-left: 200px;">Subject : <%= a1.get(0).split("=")[2]%></h2>
                <table>
                    <tr>
                        <th><p style="display: flex;color: green;align-items: center;justify-content: center;margin: 0;">Category Grade</p></th>
                        <% for(int i=0;i<a1.size();i++){ %>
                        <th><Strong style="padding-left:10px;padding-right:10px;"><%= a1.get(i).split("=")[1]%></Strong></th>
                        <% }%>
                        <th><Strong style="padding-left:10px;padding-right:10px;">total</Strong></th>
                    </tr>
                    <tr>
                        <td><p style="color: green;margin: 0;font-weight: bold;">Grade Weight</p></td>
                        <% for(int i=0;i<a1.size();i++){ %>
                        <td><%= a1.get(i).split("=")[0]%>%</td>
                        <% }%>
                        <td></td>
                    </tr>
                    <%int t1=0;float t2=0;for (int i = 0; i < l.size(); i++) {
                            ArrayList<String> a = c.getsubject(l.get(i).getId(), id); %>
                    <tr>
                        <td><h4 style="margin: 0;margin-top: 5px;"><%= l.get(i).getName() %></h4><h4 style="margin: 0;margin-bottom: 5px;"><%= l.get(i).getId() %></h4></td>
                        <%for (int j = 0; j < a.size(); j++) {  %>
                        <% if(a.get(j).split("=")[3].trim().equals("")){%>
                        <% t1=1; }%>
                        <% if(!a.get(j).split("=")[3].trim().equals("")){%>
                        <% t2+=Float.parseFloat(a.get(j).split("=")[3])*Integer.parseInt(a.get(j).split("=")[0])/100; }%>
                        <td><input type="text" name="<%= l.get(i).getId() %>-<%= a.get(j).split("=")[1]%>" value="<%= a.get(j).split("=")[3]%>"></td>
                        <% }%>
                        <td><%if(t1==0){%><%=(double)Math.round(t2*100)/100%><% }%></td>
                    </tr>
                    <% t1=0;t2=0; }%>
                </table>
                <button style="margin-left: 200px;margin-top: 30px;padding-left: 15px;padding-right: 15px;background-color: #3366ff;color: black;" name="submit" value="save">save</button>
              </c:if>
                    <c:if test="${list.size()<=0}"><p style="margin-left: 680px;">Your class is empty!</p></c:if>
            </c:if>
        </form>
        <script>
            var pup = document.getElementsByClassName("pupup");
            if (pup !== null) {
                var time = setTimeout(function () {
                    pup[0].style.display = "none";
                }, 2500);
            }
            var cou = 1, cou1 = 1;
            document.getElementsByClassName("add")[0].onclick = function () {
                if (cou <= 10) {
                    var input = document.createElement("input");
                    input.placeholder = "grade category";
                    input.name = "cat" + cou;
                    document.getElementsByClassName("adds")[0].appendChild(input);
                }
                if (cou > 10) {
                    document.getElementsByClassName("run")[0].innerHTML = "you just add limit 10 column!";
                }
                cou++;
            };
            document.getElementsByClassName("add1")[0].onclick = function () {
                if (cou1 <= 10) {
                    var input = document.createElement("input");
                    input.type = "number";
                    input.placeholder = "weight grade";
                    input.name = "we" + cou1;
                    document.getElementsByClassName("add2")[0].appendChild(input);
                }
                if (cou1 > 10) {
                    document.getElementsByClassName("run")[0].innerHTML = "you just add limit 10 column!";
                }
                cou1++;
            };
            document.getElementsByClassName("save")[0].onclick = function (e) {
                if (document.getElementsByName("subject")[0].value.trim() === "") {
                    e.preventDefault();
                    document.getElementsByClassName("run")[0].innerHTML = "subject empty!";
                } else if (cou !== cou1) {
                    e.preventDefault();
                    document.getElementsByClassName("run")[0].innerHTML = "category not match grade weight!";
                } else if (cou < 2 || cou1 < 2) {
                    e.preventDefault();
                    document.getElementsByClassName("run")[0].innerHTML = "add grade category and grade weight!";
                } else if (cou === cou1 && cou >= 2 && cou1 >= 2) {
                    for (let h = 1; h < cou1; h++) {
                        if (document.getElementsByName("we" + h)[0].value.trim() === "") {
                            e.preventDefault();
                            document.getElementsByClassName("run")[0].innerHTML = "grade weight can not empty!";
                            break;
                        }
                    }
                    for (let h = 1; h < cou; h++) {
                        if (document.getElementsByName("cat" + h)[0].value.trim() === "") {
                            e.preventDefault();
                            document.getElementsByClassName("run")[0].innerHTML = "category can not empty!";
                            break;
                        }
                    }
                }
            };
            let u = 0;
            document.getElementById("set").onclick = function () {
                if (u === 1) {
                    document.getElementsByName("set")[0].style.display = "block";
                    u = 0;
                } else {
                    document.getElementsByName("set")[0].style.display = "none";
                    u = 1;
                }
            };
            document.getElementsByName("logout")[0].onclick = function () {
                var input1 = document.createElement("input");
                input1.type = "text";
                input1.value = "logout";
                input1.name = "out";
                input1.style.visibility = 'hidden';
                document.getElementsByName("logout")[0].appendChild(input1);
                document.getElementsByName("form-l")[0].submit();
            };
        </script>
        <!-- jQuery -->
        <script src="js/jquery.min.js"></script>
        <!-- jQuery Easing -->
        <script src="js/jquery.easing.1.3.js"></script>
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Waypoints -->
        <script src="js/jquery.waypoints.min.js"></script>
        <!-- Stellar Parallax -->
        <script src="js/jquery.stellar.min.js"></script>
        <!-- Carousel -->
        <script src="js/owl.carousel.min.js"></script>
        <!-- Flexslider -->
        <script src="js/jquery.flexslider-min.js"></script>
        <!-- countTo -->
        <script src="js/jquery.countTo.js"></script>
        <!-- Magnific Popup -->
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/magnific-popup-options.js"></script>
        <!-- Count Down -->
        <script src="js/simplyCountdown.js"></script>
        <!-- Main -->
        <script src="js/main.js"></script>
    </body>
</html>

