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
 * @author hoanganhPC
 */
@WebServlet(name = "NewStudent", urlPatterns = {"/newstudent"})
@MultipartConfig
public class NewStudent extends HttpServlet {
public static String mess1="";
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
            out.println("<title>Servlet NewStudent</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + request.getAttribute("message") + "</h1>");
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
        processRequest(request, response);
        
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
        String code = request.getParameter("code");
        String gender = request.getParameter("gender");
        String date = request.getParameter("date");
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        ControllDao c = new ControllDao();
        Teacher t = c.getTeacherbycode(code, campus);
        try{
        if (!idcard.equals("") && idcard.length() ==9 && !namep.equals("") && !phonep.equals("") && t != null && !name.equals("") && !phone.equals("")
                && !mail.equals("") && !address.equals("") && !code.equals("") && !date.equals("") && checkDate(date) && !idcard(c.getparents(), idcard)&&!c.checkemail(mail)) {
            String fileName = null;
            try {
                if (campus.equals(t.getCampus()) && t.getCode().equals(code)) {                    
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
                    if(c.checkattend((String) request.getSession().getAttribute("id"), new SimpleDateFormat("yyyy-MM-dd").format(new Date()))){
                    c.insertattend(false, new SimpleDateFormat("yyyy-MM-dd").format(new Date()),c.getTeacherbycode(code, campus).getId(),id);}
                    c.insertparent(new Parents(id1, idcard, phonep, namep, id));
                    c.addClass(t.getId(), id);
                    String tid=c.getTeacherbycode(code, campus).getId();
                    String idstudent=c.checkmark(tid);
                    if(!idstudent.trim().equals("")){
                        ArrayList<String> a=c.getsubject(idstudent, tid);
                        for(int i=0;i<a.size();i++){
                            c.addmark(id, tid, a.get(i).split("=")[2], a.get(i).split("=")[0],  a.get(i).split("=")[1]);
                        }
                    }
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
                    request.setAttribute("message", "student's informations added class of teacher " + t.getName());
                    mess1="add student successful!";
                }
            } catch (Exception e) {
                Logger.getLogger(NewStudent.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("message", "student's informations added class of teacher " + t.getName());
                mess1="add student failed!";
            }
            response.sendRedirect("list");
        } 
        else {
            if(idcard!=null&&idcard(c.getparents(), idcard)){
                response.sendRedirect("addinformation.jsp?error=idcard incorrect");
            }
            if(mail!=null&&!c.checkemail(mail)){
                response.sendRedirect("addinformation.jsp?error=email existed");
            }
            else {
                response.sendRedirect("addinformation.jsp?error=informations of conditions to join incorrect");
            }
        }}catch(Exception e){
           response.sendRedirect("addinformation.jsp?error=informations of conditions to join incorrect"); 
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
