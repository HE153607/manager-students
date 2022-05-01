/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Parents;
import Model.Student;
import Model.Teacher;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * @author HOANG ANH
 */
@WebServlet(name = "Adminaddstudent", urlPatterns = {"/admin/addstudent"})
@MultipartConfig
public class Adminaddstudent extends HttpServlet {

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
            out.println("<title>Servlet Adminaddstudent</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Adminaddstudent at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("../addnewstudent.jsp").forward(request, response);
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
        Part filePart = request.getPart("file");        
        String name = request.getParameter("name");
        String namep = request.getParameter("namep");
        String campus = request.getParameter("campus");
        String phone = request.getParameter("phone");
        String idcard = request.getParameter("idcard");
        String phonep = request.getParameter("phonep");
        String mail = request.getParameter("mail");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String date = request.getParameter("date");
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        ControllDao c = new ControllDao();
        try{
        if (!idcard.equals("") && idcard.length() ==9 && !namep.equals("") && !phonep.equals("") && !name.equals("") && !phone.equals("")
                && !mail.equals("") && !address.equals("") && !date.equals("") && checkDate(date) && !idcard(c.getparents(), idcard)&&!c.checkemail(mail)) {
            String fileName = null;
            try {                   
                    fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();                    
                    
                    if (fileName.contains(" ")) {
                        fileName = fileName.replace(' ', '_');
                    }
                    String id = randomid(c.allstudents());
                    String id1 = randomid2(c.getparents());
                    if (gender.equals("male")) {
                        c.addaccount(mail, phone, id);
                        c.addstudentacountp(idcard, phonep, id1);
                        c.NewStudent(new Student(name, id, mail, phone, true, null, campus, fileName.trim().equals("") ? "profile.jfif" : fileName, address, s.parse(date)));
                    } else {
                        c.addaccount(mail, phone, id);
                        c.addstudentacountp(idcard, phonep, id1);
                        c.NewStudent(new Student(name, id, mail, phone, false, null, campus, fileName.trim().equals("") ? "profile.jfif" : fileName, address, s.parse(date)));
                    }
                    c.join(new SimpleDateFormat("yyyy-MM-dd").format(new  Date()), id);
                    c.insertparent(new Parents(id1, idcard, phonep, namep, id));
                    if (!fileName.trim().equals("")) {
                        InputStream fileContent = filePart.getInputStream();
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
                    }
                
            } catch (Exception e) {
                Logger.getLogger(NewStudent.class.getName()).log(Level.SEVERE, null, e);
            }
            response.sendRedirect("../manager/student");
        } 
        else {
            if(idcard!=null&&idcard(c.getparents(), idcard)){
                request.setAttribute("error", "idcard invalid!");
               request.getRequestDispatcher("../addnewstudent.jsp").forward(request, response);
            }
            else if(mail!=null&&c.checkemail(mail)){
                request.setAttribute("error", "email invalid!");
                request.getRequestDispatcher("../addnewstudent.jsp").forward(request, response);
            }
            else {
                request.setAttribute("error", "information invalid!");
                request.getRequestDispatcher("../addnewstudent.jsp").forward(request, response);
            }
        }}catch(Exception e){
            request.setAttribute("error", "information invalid!");
           request.getRequestDispatcher("../addnewstudent.jsp").forward(request, response);
        }
    }
    
private boolean checkDate(String date) {
        if (date == null || date.equals("")) {
            return false;
        }
        return Pattern.matches("^(0[1-9]|[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2]|[1-9])-([\\d]{4})$", date);
    }

    public String randomid(ArrayList<Student> a) {
        int i = 1;
        StringBuilder b = new StringBuilder("HE");
        if (a.size() <= 0) {
            return "HE00001";
        }
        while (true) {
            if (a.get(i - 1).getId().equalsIgnoreCase(b.append(String.format("%05d", i)).toString())) {
                if (i == a.size()) {
                    return "HE" + String.format("%05d", (i + 1));
                }
                i++;
                b.replace(0, b.length(), "HE");
            } else {
                return b.toString();
            }
        }
    }

    boolean idcard(ArrayList<Parents> a, String id) {
        if (a.size() <= 0) {
            return false;
        } 
        else
        return a.stream().anyMatch((p) -> (p.getIdcard().equals(id)));
    }

    public String randomid2(ArrayList<Parents> a) {
        int i = 1;
        StringBuilder b = new StringBuilder("PE");
        if (a.size() <= 0) {
            return "PE00001";
        }
        while (true) {
            if (a.get(i - 1).getId().equalsIgnoreCase(b.append(String.format("%05d", i)).toString())) {
                if (i == a.size()) {
                    return "PE" + String.format("%05d", (i + 1));
                }
                i++;
                b.replace(0, b.length(), "PE");
            } else {
                return b.toString();
            }
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
