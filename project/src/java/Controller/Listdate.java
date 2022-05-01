/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HOANG ANH
 */
@WebServlet(name = "Listdate", urlPatterns = {"/listdate"})
public class Listdate extends HttpServlet {

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
            out.println("<title>Servlet Listdate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Listdate at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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
        if(request.getSession().getAttribute("studentid")!=null){
        ControllDao cd = new ControllDao();
        ArrayList<String> aa = cd.getteacherids((String) request.getSession().getAttribute("studentid"));
            if (aa.size() > 0) {
                String id = "";
                if (request.getParameter("id") != null) {
                    for (int i = 0; i < aa.size(); i++) {
                        if (aa.get(i).split("=")[0].equals(request.getParameter("id"))) {
                            id = aa.get(i).split("=")[0];
                            break;
                        }
                    }
                }
                request.setAttribute("listteacher", aa);

                if (!id.equals("")) {
                    request.setAttribute("id", id);
                } else {
                    request.setAttribute("id", aa.get(0).split("=")[0]);
                }
            } else {
                request.setAttribute("er", "you are not in any classes!");
            }
        String date1 = cd.datejoin((String) request.getSession().getAttribute("studentid"));
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
        Locale l = new Locale("vi");
        SimpleDateFormat s2 = new SimpleDateFormat("EEEE", l);
        String date = new Date().getDate() + "-" + (new Date().getMonth() + 1) + "-" + (new Date().getYear() + 1900);
        try {
            if (new Date().getYear() == s1.parse(date1).getYear()) {
                date = s1.parse(date1).getDate() + "-" + (s1.parse(date1).getMonth() + 1) + "-" + (new Date().getYear() + 1900);
                request.setAttribute("year", (new Date().getYear() + 1900));
            }
            if (request.getParameter("year") != null && !request.getParameter("year").trim().equals("")) {
                if (request.getParameter("year").equals((s1.parse(date1).getYear() + 1900) + "")) {
                    date = s1.parse(date1).getDate() + "-" + (s1.parse(date1).getMonth() + 1) + "-" + request.getParameter("year");
                } else {
                    date = "1-1-" + request.getParameter("year");
                }
                request.setAttribute("year", request.getParameter("year"));
            }
            Date d = s.parse(date);
            String year = (d.getYear()+1900) + "";
            String n = s2.format(d);
            if (d.getDate() == 1 && (d.getMonth() + 1) == 1) {
                switch (n) {
                    case "Thứ bảy":
                        d.setDate(d.getDate() + 2);
                        break;
                    case "Thứ sáu":
                        d.setDate(d.getDate() + 3);
                        break;
                    case "Thứ năm":
                        d.setDate(d.getDate() + 4);
                        break;
                    case "Thứ tư":
                        d.setDate(d.getDate() + 5);
                        break;
                    case "Thứ ba":
                        d.setDate(d.getDate() + 6);
                        break;
                    case "Chủ nhật":
                        d.setDate(d.getDate() + 1);
                        break;
                }
            } else {
                switch (n) {
                    case "Thứ bảy":
                        d.setDate(d.getDate() - 5);
                        break;
                    case "Thứ sáu":
                        d.setDate(d.getDate() - 4);
                        break;
                    case "Thứ năm":
                        d.setDate(d.getDate() - 3);
                        break;
                    case "Thứ tư":
                        d.setDate(d.getDate() - 2);
                        break;
                    case "Thứ ba":
                        d.setDate(d.getDate() - 1);
                        break;
                    case "Chủ nhật":
                        d.setDate(d.getDate() + 1);
                        break;
                }
            }
            String n1 = s.format(s.parse((d.getDate()) + "-" + (d.getMonth() + 1) + "-" + (d.getYear() + 1900)));
            String n2;
            ArrayList<String> a = new ArrayList<>();
            int count = 1;
            while (true) {
                d = s.parse(n1);
                n2 = s.format(s.parse((d.getDate() + 6) + "-" + (d.getMonth() + 1) + "-" + (d.getYear() + 1900)));
                if (s.parse(n1).after(s.parse("31" + "-" + "12" + "-" + (Integer.parseInt(year))))) {
                    break;
                }
                if(request.getParameter("time")!=null&& request.getParameter("iden")==null){
                    if(request.getParameter("time").equals(count+""))
                        request.setAttribute("stt", count);
                }
                else  if (new Date().getYear() == s1.parse(date1).getYear()||(request.getParameter("year")!=null&&request.getParameter("year").equals((new Date().getYear()+1900)+""))) {
                  if((d.before(new Date())&&s.parse(n2).after(new Date()))||(d.getDate()==new Date().getDate()&&d.getYear()==new Date().getYear()&&d.getMonth()==new Date().getMonth())
                          ||(s.parse(n2).getDate()==new Date().getDate()&&s.parse(n2).getYear()==new Date().getYear()&&s.parse(n2).getMonth()==new Date().getMonth())){
                    request.setAttribute("stt", count);
                  }
                }
                else {
                   request.setAttribute("stt", 1); 
                }   
                a.add(n1.split("-")[0] + "-" + n1.split("-")[1] + " to " + n2.split("-")[0] + "-" + n2.split("-")[1]);
                n1 = s.format(s.parse((d.getDate() + 7) + "-" + (d.getMonth() + 1) + "-" + (d.getYear() + 1900)));
                count++;
            }
            request.setAttribute("list", a);
            if(request.getParameter("iden")!=null&&!(request.getParameter("year")!=null&&request.getParameter("year").equals((new Date().getYear()+1900)+""))){
             request.setAttribute("stt", 1); }
            ArrayList<String> a1 = new ArrayList<>((ArrayList<String>) request.getAttribute("list"));
            Date date3=s.parse(a1.get(((int) request.getAttribute("stt"))-1).split("to")[0].trim()+"-"+year);
            a1.clear();
            for(int i=1;i<=7;i++){
                a1.add((date3.getDate())+"-"+(date3.getMonth()+1)+"-"+(date3.getYear()+1900));
                date3=s.parse((date3.getDate()+1)+"-"+(date3.getMonth()+1)+"-"+(date3.getYear()+1900));
            }
            request.setAttribute("attend", cd.getdate((String) request.getSession().getAttribute("studentid"), (String) request.getAttribute("id")));
            request.setAttribute("sche", a1);
        } catch (Exception e) {
           Logger.getLogger(Listdate.class.getName()).log(Level.SEVERE, null, e);
        }
        //request.setAttribute("studentid", "HE00001");
        request.getRequestDispatcher("attendance.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("loginstudent.jsp");
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
