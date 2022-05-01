package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.Teacher;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author hoanganhPC
 */
@WebServlet(urlPatterns = {"/add"})
@MultipartConfig
public class Addacount extends HttpServlet {

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
            out.println("<title>Servlet Addacount</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Addacount at " + request.getContextPath() + "</h1>");
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
        response.sendRedirect("login.jsp");
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
        String n = request.getParameter("name");
        String e = request.getParameter("email");
        String code = request.getParameter("code");
        HttpSession h = request.getSession();
        String user = (String) h.getAttribute("user");
        String pass = (String) h.getAttribute("pass");
        String campus = (String) h.getAttribute("campus");
        String date =request.getParameter("date");
        SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
        ControllDao c = new ControllDao();
        String fileName = null;
        if (user == null || pass == null || campus == null) {
            h.removeAttribute("user");
            h.removeAttribute("pass");
            h.removeAttribute("campus");
            request.setAttribute("er", "account existed try with anothers account");
            response.sendRedirect("login.jsp");
        } else {
            try {
                Part p = request.getPart("file");
                fileName = Paths.get(p.getSubmittedFileName()).getFileName().toString();
                File ff = new File(getServletContext().getRealPath("image") + "\\" + fileName);
                if (!ff.exists()) {
                    int i;
                    ff.createNewFile();
                    FileOutputStream fo = new FileOutputStream(ff);
                    InputStream f = p.getInputStream();
                    while ((i = f.read()) > -1) {
                        fo.write(i);
                    }
                }
            } catch (Exception nul) {
                Logger.getLogger(Addacount.class.getName()).log(Level.SEVERE, null, nul);
            }
            try{
              if(code != null && c.getcode(code)) {
                  request.setAttribute("error", "the code existed!");
                  request.getRequestDispatcher("Createinfo.jsp").forward(request, response);
              } 
              else if ((code != null && e != null && n != null) && !(code.trim().equals("") && e.trim().equals("") && n.trim().equals(""))&&checkDate(date)) {
                String id = randomid(c.listTeacher());
                c.addaccount(user, pass, id);
                if (fileName != null) {
                    if (fileName.contains(" ")) {
                        fileName = fileName.replace(' ', '_');
                    }
                    c.addTeacher(new Teacher(id, campus, e, n, fileName, code, null, null,s.parse(date)));
                } else {
                    c.addTeacher(new Teacher(id, campus, e, n, null, code, null, null,s.parse(date)));
                }
                h.removeAttribute("user");
                h.removeAttribute("pass");
                h.removeAttribute("campus");
                h.setAttribute("id", id);
                response.sendRedirect("list");
            } else {
                if(!checkDate(date)){
                request.setAttribute("error", "date not in format");  
                }else{
                request.setAttribute("error", "please fill up your information");
                }
                request.getRequestDispatcher("Createinfo.jsp").forward(request, response);
            }}catch(Exception ex){
             Logger.getLogger(Addacount.class.getName()).log(Level.SEVERE, null,ex);   
            }
        }
    }
    private boolean checkDate(String date){
        if(date.equals("")||date==null) return false;
      return  Pattern.matches("^(0[1-9]|[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2]|[1-9])-([\\d]{4})$", date);
    }
    private String randomid(ArrayList<Teacher> a) {
        int i = 1;
        StringBuilder b = new StringBuilder("SE");
        if (a.size() <= 0) {
            return "SE00001";
        }
        while (true) {
            if (a.get(i - 1).getId().equalsIgnoreCase(b.append(String.format("%05d", i)).toString())) {
                if (i == a.size()) {
                    return "SE" + String.format("%05d", (i + 1));
                }
                i++;
                b.replace(0, b.length(), "SE");
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
