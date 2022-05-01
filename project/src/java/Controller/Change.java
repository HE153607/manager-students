/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoanganhPC
 */
@WebServlet(name = "Change", urlPatterns = {"/change"})
public class Change extends HttpServlet {

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
            out.println("<title>Servlet Change</title>");            
            out.println("</head>");
            out.println("<body style='text-align:center;'>");
            out.println("<h1> " + request.getAttribute("er") + "</h1>");
            out.println("<a href='login.jsp'>log in</a></body>");
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
        request.setAttribute("log", "log");
        request.getRequestDispatcher("Changepass.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user =request.getParameter("user");
        String old =request.getParameter("old");
        String pass1 =request.getParameter("pass1");
        String pass2 =request.getParameter("pass2");
        if(!user.equals("")&&!old.equals("")&&!pass1.equals("")&&!pass2.equals("")&&user!=null&&old!=null&&pass1!=null&&pass2!=null){
            if(pass1.equals(pass2)){
            ControllDao c=new ControllDao();
            int t=c.changpass(user, old, pass2);
            if(t==1){
                request.setAttribute("er", "change password successful");
                processRequest(request, response);
            }else{
              request.setAttribute("er", "your password or account incorrect");
                request.getRequestDispatcher("Changepass.jsp").forward(request, response);  
            }
            }
            else {
                request.setAttribute("er", "confirm password not matched new password");
                request.getRequestDispatcher("Changepass.jsp").forward(request, response);
            }
        }else{
           request.setAttribute("er", "fill up your information");
                request.getRequestDispatcher("Changepass.jsp").forward(request, response); 
        }
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
