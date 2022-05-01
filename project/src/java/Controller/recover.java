/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoanganhPC
 */
@WebServlet(name = "recover", urlPatterns = {"/redeem"})
public class recover extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet recover</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet recover at " + request.getAttribute("er") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doget");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("user");
        String id=request.getParameter("id");
        String date=request.getParameter("date");
        if(name!=null&&id!=null&&date!=null&&!name.trim().equals("")&&!date.trim().equals("")&&!id.trim().equals("")){
            ControllDao c=new ControllDao();
            Teacher t=null;
            try{
                if(!checkDate(date))
                    throw new Exception();
                t=c.forgot(name, new SimpleDateFormat("yyy-MM-dd").format(new SimpleDateFormat("dd-MM-yyy").parse(date)), id);
            }catch(Exception ee){
                t=null;
                request.setAttribute("er","Format date invalided!");
                request.getRequestDispatcher("redeem.jsp").forward(request, response);
            }
            if(t!=null){
                try{
                    String mail=t.getEmail();
                    String pass=t.getPass();
                    Properties p=new Properties();
                    p.put("mail.smtp.host", "smtp.gmail.com");
                    p.put("mail.smtp.port", "587");
                    p.put("mail.smtp.auth", "true");
                    p.put("mail.smtp.starttls.enable", "true");
                    Session s=Session.getInstance(p);
                    MimeMessage m=new MimeMessage(s);
                    m.setFrom(new InternetAddress("anhh34711@gmail.com","app Manager Students"));
                    m.setRecipients(Message.RecipientType.TO, mail);
                    m.setSubject("recover password");
                    m.setContent("<h1>Your Password: "+pass+"</h1>"
                    + "<a style=\"text-align:center;background-color:green;text-decoration: none;"
                            + "color:black;border-radius:5px;height: 50px;width: 100px;font-size: 25px;\""
                            + " href=\"http://localhost:8080/project/login.jsp\">log in</a>","text/html");
                    Transport.send(m,"anhh34711@gmail.com","anh12345");
                    request.setAttribute("er", "Password sent to "+mail);
                    processRequest(request, response);
                }catch(Exception e){
                    request.setAttribute("er", "sent failed, something wrong happened!");
                    processRequest(request, response);
                }
            }else{
                request.setAttribute("er","Informations can't verified your account");
                request.getRequestDispatcher("redeem.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("er","fill up your information");
            request.getRequestDispatcher("redeem.jsp").forward(request, response);
        }
    }
private boolean checkDate(String date){
        if(date.equals("")||date==null) return false;
      return  Pattern.matches("^(0[1-9]|[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2]|[1-9])-([\\d]{4})$", date);
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
