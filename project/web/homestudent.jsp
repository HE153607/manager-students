<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Education At University FPT</title>
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

        <div class="fh5co-loader"></div>

        <div id="page">
            <nav class="fh5co-nav" role="navigation">
                <div class="top">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12 text-right">
                                <p class="site">www.fpt.edu.vn</p>
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
                                <div id="fh5co-logo"><a href="homestudent"><i class="icon-study"></i>Educ<span>.</span></a></div>
                            </div>
                            <div class="col-xs-10 text-right menu-1">
                                <ul>
                                    <li class="active"><a href="homestudent">Home</a></li>
                                    <li><a href="profilestudent"> profile individual</a></li>
                                    <li><a href="homestudent/teacher">teacher information</a></li>
                                    <li><a href="listdate">attendance</a></li>
                                    <li><a href="studentgrade">mark</a></li>

                                    <c:if test="${sessionScope.studentid==null}">
                                        <li class="btn-cta"><a href="login.jsp"><span>Login</span></a></li>
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

            <aside id="fh5co-hero">
                <div class="flexslider">
                    <ul class="slides">
                        <li style="background-image: url(images/img_bg_1.jpg);">
                            <div class="overlay-gradient"></div>
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-8 col-md-offset-2 text-center slider-text">
                                        <div class="slider-text-inner">
                                            <h1>The Roots of Education are Bitter, But the Fruit is Sweet</h1>
                                            <h2>FPT university for student<a href="http://freehtml5.co/" target="_blank"></a></h2>
                                            <p><a class="btn btn-primary btn-lg" href="#">Start Learning Now!</a></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li style="background-image: url(images/img_bg_2.jpg);">
                            <div class="overlay-gradient"></div>
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-8 col-md-offset-2 text-center slider-text">
                                        <div class="slider-text-inner">
                                            <h1>The Great Aim of Education is not Knowledge, But Action</h1>
                                            <h2>FPT university for student<a href="http://freehtml5.co/" target="_blank"></a></h2>
                                            <p><a class="btn btn-primary btn-lg btn-learn" href="#">Start Learning Now!</a></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li style="background-image: url(images/img_bg_3.jpg);">
                            <div class="overlay-gradient"></div>
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-8 col-md-offset-2 text-center slider-text">
                                        <div class="slider-text-inner">
                                            <h1>We Help You to Learn New Things</h1>
                                            <h2>FPT university for student<a href="http://freehtml5.co/" target="_blank"></a></h2>
                                            <p><a class="btn btn-primary btn-lg btn-learn" href="#">Start Learning Now!</a></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>		   	
                    </ul>
                </div>
            </aside>

            <div id="fh5co-counter" class="fh5co-counters" style="background-image: url(images/img_bg_4.jpg);" data-stellar-background-ratio="0.5">
                <div class="overlay"></div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <div class="row">
                                <div class="col-md-3 col-sm-6 text-center animate-box">
                                    <span class="icon"><i class="icon-world"></i></span>
                                    <span class="fh5co-counter js-counter" data-from="0" data-to="3297" data-speed="5000" data-refresh-interval="50"></span>
                                    <span class="fh5co-counter-label">Foreign Followers</span>
                                </div>
                                <div class="col-md-3 col-sm-6 text-center animate-box">
                                    <span class="icon"><i class="icon-study"></i></span>
                                    <span class="fh5co-counter js-counter" data-from="0" data-to="3700" data-speed="5000" data-refresh-interval="50"></span>
                                    <span class="fh5co-counter-label">Students Enrolled</span>
                                </div>
                                <div class="col-md-3 col-sm-6 text-center animate-box">
                                    <span class="icon"><i class="icon-bulb"></i></span>
                                    <span class="fh5co-counter js-counter" data-from="0" data-to="5034" data-speed="5000" data-refresh-interval="50"></span>
                                    <span class="fh5co-counter-label">Classes Complete</span>
                                </div>
                                <div class="col-md-3 col-sm-6 text-center animate-box">
                                    <span class="icon"><i class="icon-head"></i></span>
                                    <span class="fh5co-counter js-counter" data-from="0" data-to="1080" data-speed="5000" data-refresh-interval="50"></span>
                                    <span class="fh5co-counter-label">Certified Teachers</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="fh5co-course">
                <div class="container">
                    <div class="row animate-box">
                        <div class="col-md-6 col-md-offset-3 text-center fh5co-heading">
                            <h2>Our Course</h2>
                            <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 animate-box">
                            <div class="course">
                                <a href="#" class="course-img" style="background-image: url(images/project-1.jpg);">
                                </a>
                                <div class="desc">
                                    <h3><a href="#">Web Master</a></h3>
                                    <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                                    <span><a href="#" class="btn btn-primary btn-sm btn-course">Take A Course</a></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 animate-box">
                            <div class="course">
                                <a href="#" class="course-img" style="background-image: url(images/project-2.jpg);">
                                </a>
                                <div class="desc">
                                    <h3><a href="#">Business &amp; Accounting</a></h3>
                                    <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                                    <span><a href="#" class="btn btn-primary btn-sm btn-course">Take A Course</a></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 animate-box">
                            <div class="course">
                                <a href="#" class="course-img" style="background-image: url(images/project-3.jpg);">
                                </a>
                                <div class="desc">
                                    <h3><a href="#">Science &amp; Technology</a></h3>
                                    <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                                    <span><a href="#" class="btn btn-primary btn-sm btn-course">Take A Course</a></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 animate-box">
                            <div class="course">
                                <a href="#" class="course-img" style="background-image: url(images/project-4.jpg);">
                                </a>
                                <div class="desc">
                                    <h3><a href="#">Health &amp; Psychology</a></h3>
                                    <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                                    <span><a href="#" class="btn btn-primary btn-sm btn-course">Take A Course</a></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="fh5co-testimonial" style="background-image: url(images/school.jpg);">
                <div class="overlay"></div>
                <div class="container">
                    <div class="row animate-box">
                        <div class="col-md-6 col-md-offset-3 text-center fh5co-heading">
                            <h2><span>FPT university dynamic</span></h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <div class="row animate-box">
                                <div class="owl-carousel owl-carousel-fullwidth">
                                    <div class="item">
                                        <div class="testimony-slide active text-center">
                                            <div class="user" style="background-image: url(images/person1.jpg);"></div>
                                            <span>Mary Walker<br><small>Students</small></span>
                                            <blockquote>
                                                <p>&ldquo;Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.&rdquo;</p>
                                            </blockquote>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="testimony-slide active text-center">
                                            <div class="user" style="background-image: url(images/person2.jpg);"></div>
                                            <span>Mike Smith<br><small>Students</small></span>
                                            <blockquote>
                                                <p>&ldquo;Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.&rdquo;</p>
                                            </blockquote>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="testimony-slide active text-center">
                                            <div class="user" style="background-image: url(images/person3.jpg);"></div>
                                            <span>Rita Jones<br><small>Teacher</small></span>
                                            <blockquote>
                                                <p>&ldquo;Far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.&rdquo;</p>
                                            </blockquote>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>


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
            var d = new Date(new Date().getTime() + 1000 * 120 * 120 * 2000);

            // default example
            simplyCountdown('.simply-countdown-one', {
                year: d.getFullYear(),
                month: d.getMonth() + 1,
                day: d.getDate()
            });

            //jQuery example
            $('#simply-countdown-losange').simplyCountdown({
                year: d.getFullYear(),
                month: d.getMonth() + 1,
                day: d.getDate(),
                enableUtc: false
            });
        </script>
    </body>
</html>

