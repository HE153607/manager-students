<%@page import="java.util.Date"%>
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
        <title>Check Attendance</title>
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
                                    <li><a  href="home.jsp">Home</a></li>
                                    <li><a  href="list">Manager Students List</a></li>
                                    <li><a href="addstudent">List student</a></li>
                                    <li><a  href="individual">Profile</a></li>
                                    <li class="active"><a  href="schedule" >Attendance</a></li>
                                    <li><a  href="mark">mark</a></li>                                    
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
        <form action="schedule" method="post" name="form-l">
           <%
               if(request.getSession().getAttribute("id")==null)
                   response.sendRedirect("login.jsp");
              ArrayList<Student> a = (ArrayList) request.getAttribute("list");
                Teacher b = (Teacher) request.getAttribute("info");
                
            %>
           <% if(request.getAttribute("delete")!=null||request.getAttribute("mess")!=null||request.getAttribute("add")!=null||request.getAttribute("update")!=null||request.getAttribute("comment")!=null){%> 
            <div class="pupup" style="width: 200px;height: 100px;background-color: #ccffcc;position: absolute;z-index: 1;
                 top: 30px;right:800px;text-align: center;padding-top: 30px;">
                <c:if test="${delete!=null}">
                    <p>${delete}</p>  
                </c:if>
                <c:if test="${comment!=null}">
                    <p>${comment}</p>  
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
            <% if(request.getAttribute("mess")!=null){ %>
                        <div class="pupup" style="width: 200px;height: 100px;background-color: #ccffcc;position: absolute;z-index: 1;
                             top: -260px;right:670px;text-align: center;">
                             <c:if test="${mess!=null}">
                                <p>${mess}</p>  
                             </c:if>
                        </div>   
                       <% }%>   
                       <c:if test="${list.size()>0}">
            <div class="out">
                <div style="display:flex;justify-content: space-between;width:100%;">
                    <h3><fmt:formatDate value="<%= new Date() %>" pattern="EEEE dd/MM/yyyy"/></h3>
                    <div style="width:240px;height:30px;display:flex;">
                    </div>
                </div>
                <c:if test="${er!=null}"><p style="font-weight: bold;text-align:center;">${er}</p></c:if>
                <c:if test="${op!=null}"><p style="font-weight: bold;text-align:center;">${op}</p></c:if>
                 <% for (int i = 0; i < a.size(); i++) { %>
                <div class="outin">
                    <div class="frame">
                        <img src="image/<%if (a.get(i).getImg() == null || a.get(i).getImg().trim().equals("")) {%><%="profile.jfif"%><%} else {%><%=a.get(i).getImg()%><% }%>"/>
                    </div>
                    <div class="in4">
                        <div>
                         <div>
                            <h4><%=a.get(i).getName()%></h4>
                            <h4><%=a.get(i).getEmail()%></h4>
                            <h4><%=a.get(i).getId()%></h4>
                        </div>   
                        </div>
                        <div style="display:flex;">
                            absent<input type="radio" <% if(!a.get(i).isAttend()){%><%= "checked"%><% }%> name="<%=i %>" value="absent"/>
                            present<input type="radio" <% if(a.get(i).isAttend()){%><%= "checked"%><% }%>  name="<%=i%>" value="present"/>
                        </div>
                    </div>
                </div> 
                <% } %>
            </div>
            <button style="margin-left:82%;background-color: #3366ff;width:100px;height:30px;color: black;" >save</button>
              </c:if>
              <c:if test="${list.size()<=0}">
                  <div class="out">
                    <p>Your class have no students</p>   
                  </div>
                 
              </c:if>
        </form>
        </form>
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
        <script>
            var pup =document.getElementsByClassName("pupup");
            if(pup!==null){
               var time = setTimeout(function (){
                   pup[0].style.display="none";
               },2500);
           }
            var form = document.getElementsByClassName("d-st");
            for (var i = 0; i < form.length; i++) {
                form[i].onclick = function (e) {
                    var n = confirm("are you sure want to delete this student?");
                    if (n === false) {
                        e.preventDefault();
                    }
                };
            }

        </script>
    </body>
</html>

