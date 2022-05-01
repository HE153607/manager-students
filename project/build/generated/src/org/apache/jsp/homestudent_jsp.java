package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homestudent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <title>Education At University FPT</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta name=\"description\" content=\"Free HTML5 Website Template by freehtml5.co\" />\n");
      out.write("        <meta name=\"keywords\" content=\"free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive\" />\n");
      out.write("        <meta name=\"author\" content=\"freehtml5.co\" />\n");
      out.write("\n");
      out.write("        <!-- \n");
      out.write("        //////////////////////////////////////////////////////\n");
      out.write("\n");
      out.write("        FREE HTML5 TEMPLATE \n");
      out.write("        DESIGNED & DEVELOPED by FreeHTML5.co\n");
      out.write("                \n");
      out.write("        Website: \t\thttp://freehtml5.co/\n");
      out.write("        Email: \t\t\tinfo@freehtml5.co\n");
      out.write("        Twitter: \t\thttp://twitter.com/fh5co\n");
      out.write("        Facebook: \t\thttps://www.facebook.com/fh5co\n");
      out.write("\n");
      out.write("        //////////////////////////////////////////////////////\n");
      out.write("        -->\n");
      out.write("\n");
      out.write("        <!-- Facebook and Twitter integration -->\n");
      out.write("        <meta property=\"og:title\" content=\"\"/>\n");
      out.write("        <meta property=\"og:image\" content=\"\"/>\n");
      out.write("        <meta property=\"og:url\" content=\"\"/>\n");
      out.write("        <meta property=\"og:site_name\" content=\"\"/>\n");
      out.write("        <meta property=\"og:description\" content=\"\"/>\n");
      out.write("        <meta name=\"twitter:title\" content=\"\" />\n");
      out.write("        <meta name=\"twitter:image\" content=\"\" />\n");
      out.write("        <meta name=\"twitter:url\" content=\"\" />\n");
      out.write("        <meta name=\"twitter:card\" content=\"\" />\n");
      out.write("\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Roboto+Slab:300,400\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Animate.css -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/animate.css\">\n");
      out.write("        <!-- Icomoon Icon Fonts-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/icomoon.css\">\n");
      out.write("        <!-- Bootstrap  -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("\n");
      out.write("        <!-- Magnific Popup -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\n");
      out.write("\n");
      out.write("        <!-- Owl Carousel  -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/owl.theme.default.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Flexslider  -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/flexslider.css\">\n");
      out.write("\n");
      out.write("        <!-- Pricing -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/pricing.css\">\n");
      out.write("\n");
      out.write("        <!-- Theme style  -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("        <!-- Modernizr JS -->\n");
      out.write("        <script src=\"js/modernizr-2.6.2.min.js\"></script>\n");
      out.write("        <!-- FOR IE9 below -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("        <script src=\"js/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"fh5co-loader\"></div>\n");
      out.write("\n");
      out.write("        <div id=\"page\">\n");
      out.write("            <nav class=\"fh5co-nav\" role=\"navigation\">\n");
      out.write("                <div class=\"top\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-xs-12 text-right\">\n");
      out.write("                                <p class=\"site\">www.fpt.edu.vn</p>\n");
      out.write("                                <p class=\"num\">Call: +01 123 456 7890</p>\n");
      out.write("                                <ul class=\"fh5co-social\">\n");
      out.write("                                    <li><a href=\"#\"><i class=\"icon-facebook2\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"icon-twitter2\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"icon-dribbble2\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"icon-github\"></i></a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"top-menu\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-xs-2\">\n");
      out.write("                                <div id=\"fh5co-logo\"><a href=\"homestudent\"><i class=\"icon-study\"></i>Educ<span>.</span></a></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-xs-10 text-right menu-1\">\n");
      out.write("                                <ul>\n");
      out.write("                                    <li class=\"active\"><a href=\"homestudent\">Home</a></li>\n");
      out.write("                                    <li><a href=\"profilestudent\"> profile individual</a></li>\n");
      out.write("                                    <li><a href=\"homestudent/teacher\">teacher information</a></li>\n");
      out.write("                                    <li><a href=\"listdate\">attendance</a></li>\n");
      out.write("                                    <li><a href=\"studentgrade\">mark</a></li>\n");
      out.write("\n");
      out.write("                                    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("\n");
      out.write("            <aside id=\"fh5co-hero\">\n");
      out.write("                <div class=\"flexslider\">\n");
      out.write("                    <ul class=\"slides\">\n");
      out.write("                        <li style=\"background-image: url(images/img_bg_1.jpg);\">\n");
      out.write("                            <div class=\"overlay-gradient\"></div>\n");
      out.write("                            <div class=\"container\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-8 col-md-offset-2 text-center slider-text\">\n");
      out.write("                                        <div class=\"slider-text-inner\">\n");
      out.write("                                            <h1>The Roots of Education are Bitter, But the Fruit is Sweet</h1>\n");
      out.write("                                            <h2>FPT university for student<a href=\"http://freehtml5.co/\" target=\"_blank\"></a></h2>\n");
      out.write("                                            <p><a class=\"btn btn-primary btn-lg\" href=\"#\">Start Learning Now!</a></p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </li>\n");
      out.write("                        <li style=\"background-image: url(images/img_bg_2.jpg);\">\n");
      out.write("                            <div class=\"overlay-gradient\"></div>\n");
      out.write("                            <div class=\"container\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-8 col-md-offset-2 text-center slider-text\">\n");
      out.write("                                        <div class=\"slider-text-inner\">\n");
      out.write("                                            <h1>The Great Aim of Education is not Knowledge, But Action</h1>\n");
      out.write("                                            <h2>FPT university for student<a href=\"http://freehtml5.co/\" target=\"_blank\"></a></h2>\n");
      out.write("                                            <p><a class=\"btn btn-primary btn-lg btn-learn\" href=\"#\">Start Learning Now!</a></p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </li>\n");
      out.write("                        <li style=\"background-image: url(images/img_bg_3.jpg);\">\n");
      out.write("                            <div class=\"overlay-gradient\"></div>\n");
      out.write("                            <div class=\"container\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-8 col-md-offset-2 text-center slider-text\">\n");
      out.write("                                        <div class=\"slider-text-inner\">\n");
      out.write("                                            <h1>We Help You to Learn New Things</h1>\n");
      out.write("                                            <h2>FPT university for student<a href=\"http://freehtml5.co/\" target=\"_blank\"></a></h2>\n");
      out.write("                                            <p><a class=\"btn btn-primary btn-lg btn-learn\" href=\"#\">Start Learning Now!</a></p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </li>\t\t   \t\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </aside>\n");
      out.write("\n");
      out.write("            <div id=\"fh5co-counter\" class=\"fh5co-counters\" style=\"background-image: url(images/img_bg_4.jpg);\" data-stellar-background-ratio=\"0.5\">\n");
      out.write("                <div class=\"overlay\"></div>\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-10 col-md-offset-1\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-md-3 col-sm-6 text-center animate-box\">\n");
      out.write("                                    <span class=\"icon\"><i class=\"icon-world\"></i></span>\n");
      out.write("                                    <span class=\"fh5co-counter js-counter\" data-from=\"0\" data-to=\"3297\" data-speed=\"5000\" data-refresh-interval=\"50\"></span>\n");
      out.write("                                    <span class=\"fh5co-counter-label\">Foreign Followers</span>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-3 col-sm-6 text-center animate-box\">\n");
      out.write("                                    <span class=\"icon\"><i class=\"icon-study\"></i></span>\n");
      out.write("                                    <span class=\"fh5co-counter js-counter\" data-from=\"0\" data-to=\"3700\" data-speed=\"5000\" data-refresh-interval=\"50\"></span>\n");
      out.write("                                    <span class=\"fh5co-counter-label\">Students Enrolled</span>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-3 col-sm-6 text-center animate-box\">\n");
      out.write("                                    <span class=\"icon\"><i class=\"icon-bulb\"></i></span>\n");
      out.write("                                    <span class=\"fh5co-counter js-counter\" data-from=\"0\" data-to=\"5034\" data-speed=\"5000\" data-refresh-interval=\"50\"></span>\n");
      out.write("                                    <span class=\"fh5co-counter-label\">Classes Complete</span>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-3 col-sm-6 text-center animate-box\">\n");
      out.write("                                    <span class=\"icon\"><i class=\"icon-head\"></i></span>\n");
      out.write("                                    <span class=\"fh5co-counter js-counter\" data-from=\"0\" data-to=\"1080\" data-speed=\"5000\" data-refresh-interval=\"50\"></span>\n");
      out.write("                                    <span class=\"fh5co-counter-label\">Certified Teachers</span>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"fh5co-course\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row animate-box\">\n");
      out.write("                        <div class=\"col-md-6 col-md-offset-3 text-center fh5co-heading\">\n");
      out.write("                            <h2>Our Course</h2>\n");
      out.write("                            <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-6 animate-box\">\n");
      out.write("                            <div class=\"course\">\n");
      out.write("                                <a href=\"#\" class=\"course-img\" style=\"background-image: url(images/project-1.jpg);\">\n");
      out.write("                                </a>\n");
      out.write("                                <div class=\"desc\">\n");
      out.write("                                    <h3><a href=\"#\">Web Master</a></h3>\n");
      out.write("                                    <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>\n");
      out.write("                                    <span><a href=\"#\" class=\"btn btn-primary btn-sm btn-course\">Take A Course</a></span>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-6 animate-box\">\n");
      out.write("                            <div class=\"course\">\n");
      out.write("                                <a href=\"#\" class=\"course-img\" style=\"background-image: url(images/project-2.jpg);\">\n");
      out.write("                                </a>\n");
      out.write("                                <div class=\"desc\">\n");
      out.write("                                    <h3><a href=\"#\">Business &amp; Accounting</a></h3>\n");
      out.write("                                    <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>\n");
      out.write("                                    <span><a href=\"#\" class=\"btn btn-primary btn-sm btn-course\">Take A Course</a></span>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-6 animate-box\">\n");
      out.write("                            <div class=\"course\">\n");
      out.write("                                <a href=\"#\" class=\"course-img\" style=\"background-image: url(images/project-3.jpg);\">\n");
      out.write("                                </a>\n");
      out.write("                                <div class=\"desc\">\n");
      out.write("                                    <h3><a href=\"#\">Science &amp; Technology</a></h3>\n");
      out.write("                                    <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>\n");
      out.write("                                    <span><a href=\"#\" class=\"btn btn-primary btn-sm btn-course\">Take A Course</a></span>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-6 animate-box\">\n");
      out.write("                            <div class=\"course\">\n");
      out.write("                                <a href=\"#\" class=\"course-img\" style=\"background-image: url(images/project-4.jpg);\">\n");
      out.write("                                </a>\n");
      out.write("                                <div class=\"desc\">\n");
      out.write("                                    <h3><a href=\"#\">Health &amp; Psychology</a></h3>\n");
      out.write("                                    <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>\n");
      out.write("                                    <span><a href=\"#\" class=\"btn btn-primary btn-sm btn-course\">Take A Course</a></span>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"fh5co-testimonial\" style=\"background-image: url(images/school.jpg);\">\n");
      out.write("                <div class=\"overlay\"></div>\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row animate-box\">\n");
      out.write("                        <div class=\"col-md-6 col-md-offset-3 text-center fh5co-heading\">\n");
      out.write("                            <h2><span>FPT university dynamic</span></h2>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-10 col-md-offset-1\">\n");
      out.write("                            <div class=\"row animate-box\">\n");
      out.write("                                <div class=\"owl-carousel owl-carousel-fullwidth\">\n");
      out.write("                                    <div class=\"item\">\n");
      out.write("                                        <div class=\"testimony-slide active text-center\">\n");
      out.write("                                            <div class=\"user\" style=\"background-image: url(images/person1.jpg);\"></div>\n");
      out.write("                                            <span>Mary Walker<br><small>Students</small></span>\n");
      out.write("                                            <blockquote>\n");
      out.write("                                                <p>&ldquo;Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.&rdquo;</p>\n");
      out.write("                                            </blockquote>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"item\">\n");
      out.write("                                        <div class=\"testimony-slide active text-center\">\n");
      out.write("                                            <div class=\"user\" style=\"background-image: url(images/person2.jpg);\"></div>\n");
      out.write("                                            <span>Mike Smith<br><small>Students</small></span>\n");
      out.write("                                            <blockquote>\n");
      out.write("                                                <p>&ldquo;Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.&rdquo;</p>\n");
      out.write("                                            </blockquote>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"item\">\n");
      out.write("                                        <div class=\"testimony-slide active text-center\">\n");
      out.write("                                            <div class=\"user\" style=\"background-image: url(images/person3.jpg);\"></div>\n");
      out.write("                                            <span>Rita Jones<br><small>Teacher</small></span>\n");
      out.write("                                            <blockquote>\n");
      out.write("                                                <p>&ldquo;Far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.&rdquo;</p>\n");
      out.write("                                            </blockquote>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- jQuery -->\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <!-- jQuery Easing -->\n");
      out.write("        <script src=\"js/jquery.easing.1.3.js\"></script>\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <!-- Waypoints -->\n");
      out.write("        <script src=\"js/jquery.waypoints.min.js\"></script>\n");
      out.write("        <!-- Stellar Parallax -->\n");
      out.write("        <script src=\"js/jquery.stellar.min.js\"></script>\n");
      out.write("        <!-- Carousel -->\n");
      out.write("        <script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("        <!-- Flexslider -->\n");
      out.write("        <script src=\"js/jquery.flexslider-min.js\"></script>\n");
      out.write("        <!-- countTo -->\n");
      out.write("        <script src=\"js/jquery.countTo.js\"></script>\n");
      out.write("        <!-- Magnific Popup -->\n");
      out.write("        <script src=\"js/jquery.magnific-popup.min.js\"></script>\n");
      out.write("        <script src=\"js/magnific-popup-options.js\"></script>\n");
      out.write("        <!-- Count Down -->\n");
      out.write("        <script src=\"js/simplyCountdown.js\"></script>\n");
      out.write("        <!-- Main -->\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            var d = new Date(new Date().getTime() + 1000 * 120 * 120 * 2000);\n");
      out.write("\n");
      out.write("            // default example\n");
      out.write("            simplyCountdown('.simply-countdown-one', {\n");
      out.write("                year: d.getFullYear(),\n");
      out.write("                month: d.getMonth() + 1,\n");
      out.write("                day: d.getDate()\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            //jQuery example\n");
      out.write("            $('#simply-countdown-losange').simplyCountdown({\n");
      out.write("                year: d.getFullYear(),\n");
      out.write("                month: d.getMonth() + 1,\n");
      out.write("                day: d.getDate(),\n");
      out.write("                enableUtc: false\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.studentid==null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <li class=\"btn-cta\"><a href=\"login.jsp\"><span>Login</span></a></li>\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.studentid!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <li class=\"btn-cta\"><a href=\"logout\"><span>Logout</span></a></li>\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}
