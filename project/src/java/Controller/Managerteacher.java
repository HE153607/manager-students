/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HOANG ANH
 */
@WebServlet(name = "Managerteacher", urlPatterns = {"/manager/teacher"})
public class Managerteacher extends HttpServlet {

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
            out.println("<title>Servlet Managerteacher</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Managerteacher at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if(request.getSession().getAttribute("admin")!=null){
        ControllDao c=new ControllDao();
        if(!mess.equals("")){
            request.setAttribute("add", mess);
            mess="";
        }
        if(request.getParameter("campus")!=null){
         if(request.getParameter("campus").equals("1")) {
          request.setAttribute("list", c.getteacherbycampus("FU-Hòa Lạc"));   
         }  
         else if(request.getParameter("campus").equals("2")){
         request.setAttribute("list", c.getteacherbycampus("FU-Đà Nẵng"));    
         }
         else if(request.getParameter("campus").equals("3")){
         request.setAttribute("list", c.getteacherbycampus("FU-Hồ Chí Minh"));    
         }
         else {
         request.setAttribute("list", c.getteacher());     
         }
        }
        else{
            request.setAttribute("list", c.getteacher());
        }
        request.getRequestDispatcher("/managerteacher.jsp").forward(request, response);
        }
        else{
            response.sendRedirect("login.jsp");
        }
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ControllDao c=new ControllDao();
       if(request.getParameter("submit")!=null){
           String id=request.getParameter("submit");
           if(request.getParameter("name"+id)!=null&&!request.getParameter("name"+id).trim().equals("")&&request.getParameter("date"+id)!=null
           &&!request.getParameter("date"+id).trim().equals("")&&request.getParameter("code"+id)!=null&&!request.getParameter("code"+id).trim().equals("")&&request.getParameter("mail"+id)!=null
           &&!request.getParameter("mail"+id).trim().equals("")&&!request.getParameter("user"+id).trim().equals("")&&!request.getParameter("pass"+id).trim().equals("")){
           try{
           c.updateteacher(id,request.getParameter("name"+id), request.getParameter("code"+id),new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("date"+id))), request.getParameter("mail"+id));
           c.updateaccount(request.getParameter("user"+id), request.getParameter("pass"+id),id);
           mess="update successful!";
           }catch(Exception e){
               mess="update failed!";
               response.sendRedirect("../manager/teacher");
           }
           }
           else{
            mess="update failed! pls,fill up informations";   
           }
       }
       else if(request.getParameter("delete")!=null){
         c.deleteteacher(request.getParameter("delete").trim());
         mess="delete successful!";
       }
       response.sendRedirect("../manager/teacher");
    }
String mess="";
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
