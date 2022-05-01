package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Student;
import java.util.ArrayList;

public final class addnewstudent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>student add information</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <style>\n");
      out.write("            body,html{\n");
      out.write("                width: 98vw;\n");
      out.write("                height: 98vh;\n");
      out.write("                display: flex;\n");
      out.write("                background-color: bisque;\n");
      out.write("            }\n");
      out.write("            .a,form{\n");
      out.write("                align-items: center;\n");
      out.write("                text-align: center;\n");
      out.write("                background-color: #BFD641;\n");
      out.write("                width: 60%;\n");
      out.write("                margin: auto;\n");
      out.write("                height: 80%;\n");
      out.write("            }\n");
      out.write("            input{\n");
      out.write("                height: 30px;\n");
      out.write("                width: 220px;\n");
      out.write("            }\n");
      out.write("            select{\n");
      out.write("              height: 30px;\n");
      out.write("                width: 230px;  \n");
      out.write("            }\n");
      out.write("            button{\n");
      out.write("                width: 70px;\n");
      out.write("                border: none;\n");
      out.write("                background-color: #0066ff;\n");
      out.write("                height: 30px;\n");
      out.write("            }\n");
      out.write("            td img{\n");
      out.write("                display: none;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <form method=\"post\" action=\"newstudent\" enctype=\"multipart/form-data\">\n");
      out.write("            <div class=\"a\">\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>select campus:</td> \n");
      out.write("                        <td><select name=\"campus\">\n");
      out.write("                                <option>FU-Hòa Lạc</option>\n");
      out.write("                                <option>FU-Đà Nẵng</option>\n");
      out.write("                                <option>FU-Hồ Chí Minh</option>\n");
      out.write("                            </select> \n");
      out.write("                        </td>             \n");
      out.write("                    </tr>\n");
      out.write("                    <tr>      \n");
      out.write("                        <td>Student's name:</td><td><input type=\"text\" name=\"name\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>      \n");
      out.write("                        <td>Parent's name:</td><td><input type=\"text\" name=\"namep\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>      \n");
      out.write("                        <td>student's Gender:</td><td>\n");
      out.write("                            male<input style=\"height: 18px;width: 18px;\" checked type=\"radio\" value=\"male\" name=\"gender\"/>\n");
      out.write("                            female<input style=\"height: 18px;width: 18px;\" type=\"radio\" value=\"female\" name=\"gender\"/>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr><td>phonenumber:</td><td><input type=\"text\" name=\"phone\"/></td></tr>\n");
      out.write("                    <tr><td>parent's phonenumber:</td><td><input type=\"text\" name=\"phonep\"/></td></tr>\n");
      out.write("\n");
      out.write("                    <tr><td>Student's email:</td><td><input type=\"text\" name=\"mail\"/></td></tr>    \n");
      out.write("\n");
      out.write("                    <tr><td>Student's address:</td><td><input type=\"text\" name=\"address\"/></td></tr>   \n");
      out.write(" \n");
      out.write("                    <tr><td>Date of birth:</td><td><input type=\"text\" name=\"date\" placeholder=\"day-month-year\"/></td></tr>  \n");
      out.write("                    <tr><td>parent's ID card:</td><td><input type=\"text\" name=\"idcard\" placeholder=\"số chứng minh nhân dân bố/mẹ\"/></td></tr>  \n");
      out.write("                    <tr>\n");
      out.write("                        <td>Student's Image:</td><td><input type=\"file\" name=\"file\" id=\"file\" size=\"60\"  accept=\".jpg,.png,.jfif\" style=\"display:none;\"/>\n");
      out.write("                            <label for=\"file\" style=\"cursor: pointer;\" >Upload Student's Image(if have)</label>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>  \n");
      out.write("                    <tr>\n");
      out.write("                       <td></td> <td><img style=\"width:90px;height: 110px;\" src=\"#\" name=\"image\"/></td>\n");
      out.write("                    </tr> \n");
      out.write("                    <tr><td><button value=\"Upload\">Add</button></td><td style=\"color: red;\">");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("</td></tr> \n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("            <script>\n");
      out.write("                document.getElementsByName(\"file\")[0].onchange=function (e){\n");
      out.write("                    document.getElementsByName(\"image\")[0].style.display='block';\n");
      out.write("                   document.getElementsByName(\"image\")[0].src=URL.createObjectURL(e.target.files[0]);\n");
      out.write("                };\n");
      out.write("            </script>\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.error!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
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
}
