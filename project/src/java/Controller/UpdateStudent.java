/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Student;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author hoanganhPC
 */
@WebServlet(name = "UpdateStudent", urlPatterns = {"/update"})
@MultipartConfig
public class UpdateStudent extends HttpServlet {
protected static String update="";
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
            out.println("<title>UpdateStudent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + request.getAttribute("er") + "</h1>");
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
        if (request.getSession().getAttribute("id") != null) {
            if (request.getParameter("stt") != null) {
                try {
                    ControllDao c = new ControllDao();
                    List<Student> l = c.GetAllStudents((String) request.getSession().getAttribute("id"));
                    if (l.size() <= 0) {
                        throw new Exception();
                    }
                    int t=0;
                    for(int i=0;i<l.size();i++){
                        if(l.get(i).getId().equals(request.getParameter("stt").split("-")[0])){
                    request.setAttribute("student", l.get(i));t=1;
                        break;}
                    }
                    page=request.getParameter("stt").split("-")[1];
                    if(t==0){
                   update="Student not exist";
                   try{
                   int v=Integer.parseInt(request.getParameter("stt").split("-")[1]);
                   response.sendRedirect("list?page="+v);
                   }catch(Exception e){
                       response.sendRedirect("list");
                   }
                     
                    }
                    else
                    request.getRequestDispatcher("update.jsp").forward(request, response);
                } catch (Exception e) {
                    Logger.getLogger(UpdateStudent.class.getName()).log(Level.SEVERE, null, e);
                    update="Information incorrect!";
                    response.sendRedirect("list");
                }
            } else {
                update="Information incorrect!";
               response.sendRedirect("list");
            }
        } else {
            update="access denied!";
            response.sendRedirect("list");
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
    String page="";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String address = request.getParameter("address");
        String mail = request.getParameter("mail");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String date = request.getParameter("date");
        Part p = request.getPart("file");
        if (name != null && address != null && mail != null && gender != null && phone != null && checkDate(date)) {
            String fileName = null;
            if (p != null) {
                fileName = Paths.get(p.getSubmittedFileName()).getFileName().toString();
                
                if (fileName.contains(" ")) {
                    fileName = fileName.replace(' ', '_');
                }
                try {
                    InputStream fileContent = p.getInputStream();
                    File f = new File(getServletContext().getRealPath("image") + "\\" + fileName);
                    
                    int i;
                    if (!f.exists()) {
                        f.createNewFile();
                        FileOutputStream ff = new FileOutputStream(f);// auto create file if file not exist
                        while ((i = fileContent.read()) > -1) {
                            ff.write(i);
                        }
                        ff.close();
                        fileContent.close();
                    }
                    
                } catch (Exception e) {
              fileName=null;
                }
            }
            try {
                ControllDao c = new ControllDao();
                SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
                if(fileName==null||fileName.equals("")){
                    fileName=c.StudentbyId(id).getImg();}
                if (gender.equals("male")) {
                    c.Update(new Student(name, id, mail, phone, true, null, null, fileName, address, s.parse(date)));
                } else {
                    c.Update(new Student(name, id, mail, phone, false, null, null, fileName, address, s.parse(date)));
                }
                update="update Sucessfully";
                try{
                  int i=Integer.parseInt(page); 
                  page="";
                  response.sendRedirect("list?page="+i);
                }catch(Exception e){
                response.sendRedirect("list");
                }
            } catch (Exception ee) {
                update="update failed please check your input carefully";
                response.sendRedirect("list");
            }
        } else {
           update="update failed please check your input carefully";
            response.sendRedirect("list");
        }
    }

    private boolean checkDate(String date) {
        if (date.equals("") || date == null) {
            return false;
        }
        return Pattern.matches("^(0[1-9]|[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2]|[1-9])-([\\d]{4})$", date);
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
