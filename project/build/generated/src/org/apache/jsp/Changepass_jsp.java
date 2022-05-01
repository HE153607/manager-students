package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Changepass_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Change Password</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <style>\n");
      out.write("            html,body{\n");
      out.write("                height: 100vh;\n");
      out.write("                width: 100vw;\n");
      out.write("                overflow: hidden;\n");
      out.write("            }\n");
      out.write("            form{\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("                align-items: center;\n");
      out.write("                width: 100%;\n");
      out.write("                height: 100%;\n");
      out.write("                background-image: linear-gradient(to bottom left,yellow,green);\n");
      out.write("            }\n");
      out.write("            table{\n");
      out.write("                background-color: #ffffcc;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            input{\n");
      out.write("                height: 30px;\n");
      out.write("                width: 250px;\n");
      out.write("                margin-top: 20px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("            }\n");
      out.write("            </style>\n");
      out.write("            ");

            if(request.getAttribute("log")==null)
            response.sendRedirect("change");
            
      out.write("\n");
      out.write("            <form action=\"change\" method=\"post\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>username:</td>\n");
      out.write("                    <td><input name=\"user\" type=\"text\" placeholder=\"username\"/></td>\n");
      out.write("                </tr>\n");
      out.write("             <tr>\n");
      out.write("                    <td>old password:</td>\n");
      out.write("                    <td><input name=\"old\" type=\"password\" placeholder=\"old password\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>new password:</td>\n");
      out.write("                    <td><input name=\"pass1\" type=\"password\" placeholder=\"new password\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>confirm password:</td>\n");
      out.write("                    <td><input name=\"pass2\" type=\"password\" placeholder=\"confirm password\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td><button>save</button></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td style=\"color: red;\"><c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${er!=null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${er}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</c:if></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
}
