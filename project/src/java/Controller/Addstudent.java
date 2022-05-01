package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(urlPatterns = {"/addstudent"})
public class Addstudent extends HttpServlet {

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
            out.println("<title>Servlet Addstudent</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Addstudent at " + request.getContextPath() + "</h1>");
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
            List<Student> a= c.GetAllStudents((String) request.getSession().getAttribute("id"));
            ArrayList<Student> b= c.getallstudent(c.getteacherbyid((String) request.getSession().getAttribute("id")).getCampus());
            if(b.size()<=0){
                request.setAttribute("list", new ArrayList());
            }
            else if(a.size()<=0){
               request.setAttribute("list", b); 
            }
            else if(a.size()>0&&b.size()>0){
                int t=0;
               ArrayList<Student> d=new ArrayList<>();
               for(int i=0;i<b.size();i++){
                for(int j=0;j<a.size();j++){
                  if(a.get(j).getId().equals(b.get(i).getId())) {
                      t=1;
                      break;}
               }   if(t==0) {d.add(b.get(i));}t=0;
               }
               request.setAttribute("list", d); 
            }
            request.getRequestDispatcher("addstudent.jsp").forward(request, response);
        }else response.sendRedirect("home.jsp");
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
        ControllDao c=new ControllDao();
       if(c.checkattend((String) request.getSession().getAttribute("id"), new SimpleDateFormat("yyyy-MM-dd").format(new Date()))){
        c.insertattend(false,  new SimpleDateFormat("yyyy-MM-dd").format(new Date()), (String) request.getSession().getAttribute("id"),request.getParameter("id"));}
        c.addClass((String) request.getSession().getAttribute("id"),request.getParameter("id"));
        String idstudent=c.checkmark((String) request.getSession().getAttribute("id"));
                    if(!idstudent.trim().equals("")){
                        ArrayList<String> a=c.getsubject(idstudent, (String) request.getSession().getAttribute("id"));
                        for(int i=0;i<a.size();i++){
                            c.addmark(request.getParameter("id"), (String) request.getSession().getAttribute("id"), a.get(i).split("=")[2], a.get(i).split("=")[0],  a.get(i).split("=")[1]);
                        }
                    }
        response.sendRedirect("addstudent");
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
