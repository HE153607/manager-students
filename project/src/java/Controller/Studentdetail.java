/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Student;
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
@WebServlet(name = "Studentdetail", urlPatterns = {"/manager/student"})
public class Studentdetail extends HttpServlet {

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
            out.println("<title>Servlet Studentdetail</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Studentdetail at " + request.getContextPath() + "</h1>");
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
    String add ="";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if(!add.equals("")){
            request.setAttribute("add", add);
            add="";
        }
        //if(request.getSession().getAttribute("admin")!=null){
        ControllDao c=new ControllDao();
        if(request.getParameter("campus")!=null){
         if(request.getParameter("campus").equals("1")) {
          request.setAttribute("list", c.studendetail("FU-Hòa Lạc"));   
         }  
         else if(request.getParameter("campus").equals("2")){
         request.setAttribute("list", c.studendetail("FU-Đà Nẵng"));    
         }
         else if(request.getParameter("campus").equals("3")){
         request.setAttribute("list", c.studendetail("FU-Hồ Chí Minh"));    
         }
         else {
         request.setAttribute("list", c.studendetail()); 
         }
        }
        else{
            request.setAttribute("list", c.studendetail());
        }
        request.getRequestDispatcher("../studentdetail.jsp").forward(request, response);
        //        }
//        else{
//            response.sendRedirect("login.jsp");
//        }
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
            String id =request.getParameter("submit");
          if(!request.getParameter("name"+id).equals("")&&!request.getParameter("mail"+id).equals("")&&!request.getParameter("date"+id).equals("")
              &&!request.getParameter("phone"+id).equals("")&&!request.getParameter("address"+id).equals("")){
            try{
            c.Update2(new Student(request.getParameter("name"+id),id ,request.getParameter("mail"+id),request.getParameter("phone"+id),false,null,null,null,request.getParameter("address"+id),new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("date"+id))));
            add="update successful!";
            }catch(Exception e){
                add="update failed!";
            }
          }
        }
        else if(request.getParameter("delete")!=null){
            c.deletestudent(request.getParameter("delete"));
            add="delete successful";
        }response.sendRedirect("../manager/student");
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
