/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Teacher;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoanganhPC
 */
@WebServlet(name = "Individual", urlPatterns = {"/individual"})
@MultipartConfig
public class Individual extends HttpServlet {

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
            out.println("<title>Servlet Individual</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Individual at " + request.getContextPath() + "</h1>");
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
          ControllDao c = new ControllDao();
          if(!code.equals("")){
              request.setAttribute("ercode", code);
              code="";
          }
          request.setAttribute("info", c.TeacherbyId((String) request.getSession().getAttribute("id")));
          request.getRequestDispatcher("individual.jsp").forward(request, response);
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
    protected static String code="";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
            if(request.getSession().getAttribute("id")!=null){ 
                ControllDao c=new ControllDao();
               boolean t= c.getcode(request.getParameter("join"));
               if(request.getParameter("update")!=null){
                   if(!t){
                   try{
            c.updatecode((String)request.getSession().getAttribute("id"),new Teacher(null,null,request.getParameter("mail"), request.getParameter("name")
                    ,null, request.getParameter("code"), null, null,new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("date")) ));
                   code="update successful!"; }
                   catch(Exception e){
                      code="format input cant not update!"; 
                   }
                   }
                   else{
                    code="code have been existed";   
                   }}
               else if(request.getParameter("sub")!=null&&request.getParameter("sub").equals("img")){
                   if(request.getPart("file")!=null&&!request.getPart("file").getSubmittedFileName().trim().equals("")){
                       String fileName =request.getPart("file").getSubmittedFileName();
                       InputStream fileContent = request.getPart("file").getInputStream();
                        File f = new File(getServletContext().getRealPath("image") + "\\" + fileName);
                        int i;
                        if (!f.exists()) {
                            f.createNewFile();                            
                            FileOutputStream ff = new FileOutputStream(f);
                            while ((i = fileContent.read()) > -1) {
                                ff.write(i);
                            }
                            ff.close();
                            fileContent.close();
                        }
                        c.updateimgteacher(fileName, (String) request.getSession().getAttribute("id"));
                        code="update image successful!";
                   }
               }
               else{
               code="update failed!";    
               }
               response.sendRedirect("individual");
            }
            else{
                response.sendRedirect("login.jsp");
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
