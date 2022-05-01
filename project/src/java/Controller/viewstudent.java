/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoanganhPC
 */
@WebServlet(name = "viewstudent", urlPatterns = {"/view"})
public class viewstudent extends HttpServlet {

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
            out.println("<title>viewstudent</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>can not show information of student</h1>");
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
        String stt=request.getParameter("stt");
        if(request.getSession().getAttribute("id")!=null&&stt!=null){
            try {
                ControllDao cd=new ControllDao();  
          List<Student> l=cd.GetAllStudents((String)request.getSession().getAttribute("id"));
          if(l.size()<=0){
              throw new Exception();
          }  
          Student s=null;
          for(int i=0;i<l.size();i++){
              if(l.get(i).getId().equals(stt)){
                  s=new Student(l.get(i).getName(),l.get(i).getId(), l.get(i).getEmail(),l.get(i).getPhoneNumber(),
                          l.get(i).isGender(),null, l.get(i).getCampus(), l.get(i).getImg(),l.get(i).getAddress(),l.get(i).getDob());
                  break;
              }
          }
          if(s!=null){
          request.setAttribute("stt", s);
          request.setAttribute("parent", cd.getparentbystudentid(s.getId()));
          request.setAttribute("date", cd.getdatejoin(s.getId()));
          request.getRequestDispatcher("InfoStudent.jsp").forward(request, response);
          }
          else{
                processRequest(request, response);    
          }
            } catch (Exception e) {
                processRequest(request, response);
            }
        }
        else{
          response.sendRedirect("login.jsp");}
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
