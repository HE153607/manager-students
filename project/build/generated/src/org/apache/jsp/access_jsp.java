package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class access_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <img src=\"data:image/png;base64,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\">\n");
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
