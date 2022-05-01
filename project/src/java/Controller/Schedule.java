package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.Student;
import Model.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
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
@WebServlet(urlPatterns = {"/schedule"})
public class Schedule extends HttpServlet {

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
            out.println("<title>Servlet Schedule</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 style='color:red;'> access denied</h1>");
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
    String mess="";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       if(request.getSession().getAttribute("id")!=null){
            ControllDao c = new ControllDao();
            List<Student> l1=c.GetAllStudents((String)request.getSession().getAttribute("id"));
            Teacher t=c.TeacherbyId((String) request.getSession().getAttribute("id"));
            List<Student> l=c.getstudents(new SimpleDateFormat("yyyy-MM-dd").format(new Date()),(String)request.getSession().getAttribute("id"));
            if(l.size()<=0)
             request.setAttribute("list", l1);   
            else{
            request.setAttribute("list", l);}
            if(!mess.equals("")){
               request.setAttribute("mess", mess); 
               mess="";
            }
            request.setAttribute("info", t);
            request.getRequestDispatcher("schedule.jsp").forward(request, response);
       }
       else response.sendRedirect("login.jsp");
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
        ControllDao c = new ControllDao();
       List<Student> l=c.GetAllStudents((String)request.getSession().getAttribute("id"));
       List<Student> ll=c.getstudents(new SimpleDateFormat("yyyy-MM-dd").format(new Date()),(String)request.getSession().getAttribute("id"));
        if(request.getParameter("out")!=null){
            if(request.getSession().getAttribute("id")!=null)
                request.getSession().removeAttribute("id");
            response.sendRedirect("login.jsp");
        }
        else{
       if(ll.size()<=0){
       for(int i=0;i<l.size();i++){
       if(request.getParameter(i+"")!=null&&!request.getParameter(i+"").trim().equals("")){
           if(request.getParameter(i+"").equals("absent"))c.insertattend(false,new SimpleDateFormat("yyyy-MM-dd").format(new Date()), (String) request.getSession().getAttribute("id"), l.get(i).getId());
           if(request.getParameter(i+"").equals("present"))c.insertattend(true,new SimpleDateFormat("yyyy-MM-dd").format(new Date()), (String) request.getSession().getAttribute("id"), l.get(i).getId());
         }
       else if(request.getParameter(i+"").equals("absent"))c.insertattend(false,new SimpleDateFormat("yyyy-MM-dd").format(new Date()), (String) request.getSession().getAttribute("id"), l.get(i).getId());
        }
       mess="update successful";
       }
       else{
        for(int i=0;i<l.size();i++){
       if(request.getParameter(i+"")!=null&&!request.getParameter(i+"").trim().equals("")){
           if(request.getParameter(i+"").equals("absent"))c.updateattend(l.get(i).getId(), false, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
           if(request.getParameter(i+"").equals("present"))c.updateattend(l.get(i).getId(), true, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
         }
       else if(request.getParameter(i+"").equals("absent"))c.updateattend(l.get(i).getId(), false, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));   
        } 
        mess="update successful";
       }
       response.sendRedirect("schedule");}
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
