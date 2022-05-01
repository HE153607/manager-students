package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HOANG ANH
 */
@WebServlet(urlPatterns = {"/mark"})
public class Mark extends HttpServlet {

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
            out.println("<title>Servlet Mark</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Mark at " + request.getContextPath() + "</h1>");
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
        if(request.getSession().getAttribute("id")!=null){
        ControllDao c=new ControllDao();
        List<Student> l= c.GetAllStudents((String) request.getSession().getAttribute("id"));
        if(c.checkmark((String) request.getSession().getAttribute("id")).equals("")&&l.size()>0){
           request.setAttribute("exist", "exist");  
        }
        else{ 
         request.setAttribute("list", l);
        }
        if(!mess.equals("")){
            request.setAttribute("mess", mess);
            mess="";
        }
        request.getRequestDispatcher("grade.jsp").forward(request, response);
         }else{
            response.sendRedirect("home.jsp");
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
    String mess ="";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ControllDao c=new ControllDao();
        if(request.getParameter("submit")!=null&&request.getParameter("submit").equals("save")){
          List<Student> l= c.GetAllStudents((String) request.getSession().getAttribute("id"));
          for(int i=0;i<l.size();i++){
              ArrayList<String> a=c.getsubject(l.get(i).getId(),(String) request.getSession().getAttribute("id"));
              for(int j=0;j<a.size();j++){
             if(request.getParameter(l.get(i).getId()+"-"+a.get(j).split("=")[1])!=null&&!request.getParameter(l.get(i).getId()+"-"+a.get(j).split("=")[1]).trim().equals("")){
                 try{
                     float t=Float.parseFloat(request.getParameter(l.get(i).getId()+"-"+a.get(j).split("=")[1]));
                     c.updatemark(l.get(i).getId(), (String) request.getSession().getAttribute("id"), a.get(j).split("=")[1], t);
                     mess="save successful!";
                 }catch(Exception e){
                     mess="save failed!";
                 }
             }
              }
          }
        }
        else{
       String n=request.getParameter("subject");
       List<Student> l=c.GetAllStudents((String)request.getSession().getAttribute("id"));
       for(int i=1;i<=10;i++){
          if(request.getParameter("cat"+i)!=null&&!request.getParameter("cat"+i).trim().equals("")){
              for(int j=0;j<l.size();j++){
              c.addmark(l.get(j).getId(),(String)request.getSession().getAttribute("id"), n, request.getParameter("we"+i), request.getParameter("cat"+i));
              }
          }else break;
       }
        }
       response.sendRedirect("mark");
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
