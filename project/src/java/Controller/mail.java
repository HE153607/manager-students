package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.Student;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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
@WebServlet(urlPatterns = {"/mail"})
@MultipartConfig
public class mail extends HttpServlet {

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
            out.println("<title>Servlet mail</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + request.getAttribute("mailto") + "</h1>");
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
            response.sendRedirect("sendmail.jsp");
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
        request.setCharacterEncoding("UTF-8");
        String mail=request.getParameter("mail");
        String pass=request.getParameter("pass");
        String subject=request.getParameter("subject");
        String content=request.getParameter("content");
          if(mail!=null&&pass!=null&&subject!=null&&content!=null){
        Properties pr = new Properties();
        pr.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        pr.put("mail.smtp.port", "587"); //TLS Port
        pr.put("mail.smtp.auth", "true"); //enable authentication
        pr.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        Session s = Session.getInstance(pr);    
        try {
            ControllDao c=new ControllDao();
            List<Student> l=c.GetAllStudents((String)request.getSession().getAttribute("id"));
            if(l.size()>=1){
            Address[] a = new Address[l.size()];
            for(int i=0;i<l.size();i++){
             a[i]=new InternetAddress(l.get(i).getEmail());
            }
            MimeMessage m = new MimeMessage(s);
            m.setFrom(new InternetAddress(mail, "Teacher"));
            MimeBodyPart b = new MimeBodyPart();
            MimeBodyPart mp = new MimeBodyPart();
            Multipart m1 = new MimeMultipart();
            Part pp=request.getPart("file");
            if(pp!=null){
            File f = new File(getServletContext().getRealPath("file")+"\\"+pp.getSubmittedFileName());
            if(!f.exists()){
                f.createNewFile();
            
            InputStream i=pp.getInputStream();
            FileOutputStream ff=new FileOutputStream(f);
            int t;
            while((t=i.read())>-1){
                ff.write(t);
            }
            ff.close();i.close();}
            b.attachFile(f);
            b.setFileName(pp.getSubmittedFileName());
            m1.addBodyPart(b);
            }
            m.setRecipients(Message.RecipientType.TO, a);//or m.addRecipients(Message.RecipientType.TO, a);  
            mp.setText(content,"UTF-8");
            m1.addBodyPart(mp);
            m.setSubject(subject,"UTF-8");           
            m.setContent(m1);
            Transport.send(m, mail, pass);
            if(pp!=null){
            File f = new File(getServletContext().getRealPath("file")+"\\"+pp.getSubmittedFileName());
            if(f.exists())
                f.delete();
            }
            }
            request.setAttribute("mailto", "mail sent to your students successful");
            processRequest(request, response);
        } catch ( Exception e) {
            Logger.getLogger(mail.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("mailto", "mail sent failed!");
            processRequest(request, response);
        }
            
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
