/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HOANG ANH
 */
@WebServlet(name = "Studentgrade", urlPatterns = {"/studentgrade"})
public class Studentgrade extends HttpServlet {

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
            out.println("<title>Servlet Studentgrade</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Studentgrade at " + request.getContextPath() + "</h1>");
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
        if(request.getSession().getAttribute("studentid")!=null){
            ControllDao c=new ControllDao();
           ArrayList<String> a= c.getsub((String) request.getSession().getAttribute("studentid"));
           if(a.size()>0){
               request.setAttribute("subject", a);
               String sub="";
               try {
                   int t=Integer.parseInt(request.getParameter("stt"));
                   for(int i=0;i<a.size();i++){
                       if(i==t){
                           sub=a.get(i);
                       break;}
                   }
               } catch (Exception e) {
               }
               if(sub.equals("")){
               request.setAttribute("list",c.getmarks(a.get(0).split("=")[0], (String) request.getSession().getAttribute("studentid")));
               request.setAttribute("stt", a.get(0));}
               else {
                   request.setAttribute("stt", sub);
                   request.setAttribute("list",c.getmarks(sub.split("=")[0], (String) request.getSession().getAttribute("studentid")));
               }
           }
           request.getRequestDispatcher("studentgrade.jsp").forward(request, response);
        }
        else response.sendRedirect("loginstudent.jsp");
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
        processRequest(request, response);
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
