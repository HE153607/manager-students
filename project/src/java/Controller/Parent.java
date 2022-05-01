/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Parents;
import Model.Student;
import Model.Teacher;
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
 * @author hoanganhPC
 */
@WebServlet(name = "Parent", urlPatterns = {"/parent"})
public class Parent extends HttpServlet {

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
            out.println("<title>Servlet Parent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 style='color:red;'> Can't access this website in this time</h1>");
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
        if (!er.equals("")) {
            request.setAttribute("er", er);er="";
            request.getRequestDispatcher("Plogin.jsp").forward(request, response);
        }
        else if(request.getSession().getAttribute("parent")!=null){
            ControllDao c = new ControllDao();
            Student s = c.StudentbyId((String) request.getSession().getAttribute("parent"));
                request.setAttribute("student", s);
                 ArrayList<Teacher> a=c.allteacher(s.getId());
                 request.setAttribute("teacher", a);
                 if(a.size()>0){
                 String id="";
                 if(request.getParameter("tid")!=null){
                     id=request.getParameter("tid");
                 }
                 else id=a.get(0).getId();
                ArrayList<Student> attends = c.tableattend(s.getId(),id);
                if (attends.size() > 0) {
                    request.setAttribute("attend", attends);
                }
                ArrayList<Student> comments = c.getcomment(s.getId(),id);
                if (comments.size() > 0) {
                    request.setAttribute("comment", comments);
                }}
                request.getRequestDispatcher("parent.jsp").forward(request, response);
        }
        
        else request.getRequestDispatcher("parent.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String er = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (request.getParameter("id") != null && !request.getParameter("id").trim().equals("")) {
            String id = request.getParameter("id");
            String ca = request.getParameter("campus");
            ControllDao c = new ControllDao();
            Parents p = c.parentcampus(id, ca);
            boolean b = c.parentlogin(id);
            if (p != null && b) {
                request.getSession().setAttribute("parent", p.getChildid());
                Student s = c.studentbycard(id, ca);
                ArrayList<Teacher> a=c.allteacher(s.getId());
                if(a.size()>0){
                String tid ="";
                if(request.getParameter("tid")!=null){
                    tid=request.getParameter("tid");
                }
                else tid=a.get(0).getId();
                request.setAttribute("teacher", a);
                request.setAttribute("student", s);
                ArrayList<Student> attends = c.tableattend(s.getId(),tid);
                if (attends.size() > 0) {
                    request.setAttribute("attend", attends);
                }
                ArrayList<Student> comments = c.getcomment(s.getId(),tid);
                if (comments.size() > 0) {
                    request.setAttribute("comment", comments);
                }}
                response.sendRedirect("parent");
            } 
            
            else if (!b) {
                er = "id card không chính xác";
                response.sendRedirect("parent");
            } else if (p == null) {
                er = "campus không chính xác";
                response.sendRedirect("parent");
            }
        } else {
            er = "nhập id card";
            response.sendRedirect("parent");
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
