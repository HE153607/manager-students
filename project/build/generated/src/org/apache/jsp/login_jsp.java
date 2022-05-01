package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Login</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                height: 97vh;\n");
      out.write("                width: 98vw;\n");
      out.write("                background-image:linear-gradient(\n");
      out.write("140deg, #EADEDB 0%, #BC70A4 50%, #BFD641 75%);\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("                align-items: center;\n");
      out.write("            }\n");
      out.write("            .frame{\n");
      out.write("                border-radius: 10px;\n");
      out.write("                background-color: #ffffff;\n");
      out.write("                width: 100%;\n");
      out.write("                height: 100%;\n");
      out.write("                display: flex;\n");
      out.write("                flex-direction: column;\n");
      out.write("            }\n");
      out.write("            form{\n");
      out.write("                width: 40%;\n");
      out.write("                height: 55%;  \n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h2{\n");
      out.write("                width: 130px;\n");
      out.write("                margin-left: 20px;\n");
      out.write("            }\n");
      out.write("            table{\n");
      out.write("                margin-top: 45px;\n");
      out.write("            }\n");
      out.write("            tr td:nth-of-type(1){\n");
      out.write("                width: 20%;\n");
      out.write("            } \n");
      out.write("            input{\n");
      out.write("                width: 90%;\n");
      out.write("                height: 30px;\n");
      out.write("            }\n");
      out.write("            td{\n");
      out.write("                padding-top: 15px;\n");
      out.write("            }\n");
      out.write("            button{\n");
      out.write("                text-decoration: none;\n");
      out.write("                color: black;\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("                align-items: center;\n");
      out.write("                height: 30px;\n");
      out.write("                width: 80px;\n");
      out.write("                background-color: rgb(66, 66, 247);\n");
      out.write("            }\n");
      out.write("            button:hover{\n");
      out.write("                background-color: rgb(157, 157, 197);\n");
      out.write("            }\n");
      out.write("            button:nth-of-type(1){\n");
      out.write("                margin-right: 100px;\n");
      out.write("            }\n");
      out.write("            p{\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("                align-items: center;\n");
      out.write("            }\n");
      out.write("            #id{\n");
      out.write("                display: none;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form method=\"post\" onsubmit=\"return false\">\n");
      out.write("            <div class=\"frame\" >\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><p style=\"margin-left: 20px;\">CamPus FPT:</p></td>\n");
      out.write("                        <td><select name=\"campus\">\n");
      out.write("                                        <option>FU-Hòa Lạc</option>\n");
      out.write("                                        <option>FU-Đà Nẵng</option>\n");
      out.write("                                        <option>FU-Hồ Chí Minh</option>\n");
      out.write("                            </select></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr><td></td><td><strong>Teacher,manager FPT</strong></td></tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><h2 style=\"margin-top: 0px;\">User name:</h2></td>\n");
      out.write("                        <td><input name=\"user\" id=\"user\" type=\"text\"/></td>\n");
      out.write("                    </tr>  \n");
      out.write("                    <tr>\n");
      out.write("                        <td><h2>Password:</h2></td>\n");
      out.write("                        <td><input id=\"pass\" name=\"pass\" type=\"password\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("                <p id=\"a\" style=\"margin: 0;color: red;\">");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("</p>\n");
      out.write("                <nav style=\"display: flex;width: 250px;padding-top: 20px;margin-left: 26%;\">\n");
      out.write("                    <button>LOGIN</button>\n");
      out.write("                    <button>REGISTER</button>\n");
      out.write("                    \n");
      out.write("                </nav >\n");
      out.write("                <nav style=\"display: flex;width: 450px;padding-top: 20px;margin-left: 26%;\">\n");
      out.write("                <a href=\"redeem.jsp\">Forgot password</a>\n");
      out.write("                <a href=\"parent\" style=\"margin-left: 60px;\">Parent login</a>\n");
      out.write("                <a href=\"homestudent\" style=\"margin-left: 30px;\">Student login</a></nav>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("        <script>\n");
      out.write("                var a = document.getElementById(\"user\");\n");
      out.write("                var b = document.getElementById(\"pass\");\n");
      out.write("                var c=document.getElementById(\"a\");\n");
      out.write("                document.getElementsByTagName(\"button\")[0].onclick = function () {\n");
      out.write("                    if(a.value.trim() === \"\" || b.value.trim() === \"\"){\n");
      out.write("                    c.style.display=\"flex\";\n");
      out.write("                   c.innerHTML=\"thông tin đăng nhập không chính xác\";\n");
      out.write("               }\n");
      out.write("                    if (a.value.trim() !== \"\" && b.value.trim() !== \"\") {\n");
      out.write("                        document.getElementsByTagName(\"form\")[0].action = \"list\";\n");
      out.write("                        document.getElementsByTagName(\"form\")[0].onsubmit = \"return true\";\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("                document.getElementsByTagName(\"button\")[1].onclick = function () {\n");
      out.write("                    if(a.value.trim() === \"\" || b.value.trim() === \"\"){\n");
      out.write("                       c.style.display=\"flex\";\n");
      out.write("                       c.innerHTML=\"thông tin không hợp lệ\";\n");
      out.write("                   }\n");
      out.write("                    if (a.value.trim() !== \"\" && b.value.trim() !== \"\") {\n");
      out.write("                        document.getElementsByTagName(\"form\")[0].action = \"register\";\n");
      out.write("                        document.getElementsByTagName(\"form\")[0].onsubmit = \"return true\";\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("            </script>\n");
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
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.er!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.er}", java.lang.String.class, (PageContext)_jspx_page_context, null));
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
