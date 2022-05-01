/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Student;
import Model.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hoanganhPC
 */
@WebServlet(name = "ListStudent", urlPatterns = {"/list"})
public class ListStudent extends HttpServlet {

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
            out.println("<title>Servlet ListStudent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListStudent at " + request.getContextPath() + "</h1>");
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
    String text="";
    boolean delete=false;
    String comment ="";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getSession().getAttribute("id")!=null){
            ControllDao c = new ControllDao();
            Teacher t=c.TeacherbyId((String) request.getSession().getAttribute("id"));
            List<Student> l=c.GetAllStudents((String)request.getSession().getAttribute("id"));
            if(l.size()>0){
            int page=1;
            int totalpage=1;
            if(l.size()<=3){
               totalpage=1; 
            }
            else{
             int demain =l.size()%4;
                totalpage=l.size()/4;
                if(demain>0)
                    totalpage+=1;   
            }
            try{
            if(request.getParameter("page")!=null){
               page=Integer.parseInt(request.getParameter("page"));  
            }
            }catch(Exception e){
                page=0;
            }
            if(!text.trim().equals("")){
               ArrayList<Integer> li=new ArrayList<>();
               int tpage=0;
                    for(int i=0;i<l.size();i++){
                        if(l.get(i).getName().toLowerCase().contains(text.trim().toLowerCase())){
                            if(!li.contains((i+1)%4==0?(i/4):((i/4)+1))){
                            li.add((i+1)%4==0?((i+1)/4):(((i+1)/4)+1));
                            }
                        }
                    }   
                    if(li.size()>0){
                       page=Collections.min(li);  
                    }
                    request.setAttribute("search", li);
                    request.setAttribute("text", text);
                    text="";
            }
            if(page>0&&page<=totalpage){
           List<Student> st=c.getlistpage(page,(ArrayList<Student>) l);
           request.setAttribute("list", st);
           request.setAttribute("info", t);
           if(delete){
               request.setAttribute("delete", "delete successfully");
               delete=false;
           }
           if(!NewStudent.mess1.equals("")){
               request.setAttribute("mess1", NewStudent.mess1);
               NewStudent.mess1="";
           }
           else if(!comment.equals("")){
               request.setAttribute("comment", comment);
              comment="";
           }
           else if(!UpdateStudent.update.equals("")){
               request.setAttribute("update", UpdateStudent.update);
               UpdateStudent.update="";
           }
            request.setAttribute("size", l.size());
           request.setAttribute("page", page);
           request.setAttribute("total", totalpage);    
        }
            else{
              request.setAttribute("list", new ArrayList());
              request.setAttribute("info", t);
              request.setAttribute("op", "oop! Found not anything");
              request.setAttribute("page", 1);
              request.setAttribute("total", totalpage);
            }
            }
            else{// list is null
            request.setAttribute("list", new ArrayList());
           request.setAttribute("info", t);
           if(delete){
               request.setAttribute("delete", "delete successfully");
               delete=false;
           }
             request.setAttribute("page", 1);
              request.setAttribute("total", 1);
              request.setAttribute("er", "add your students to class"); 
            }
            request.getRequestDispatcher("list.jsp").forward(request, response);
        }//session working
        else{//session not working
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        text="";
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        String campus = request.getParameter("campus");
        ControllDao c = new ControllDao();
        if(request.getParameter("search")!=null){
            text=request.getParameter("text");
            response.sendRedirect("list");
        }
       else if(request.getParameter("out")!=null){
            if(request.getSession().getAttribute("id")!=null)
                request.getSession().removeAttribute("id");
            response.sendRedirect("login.jsp");
        }
       else if(request.getParameter("comment")!=null){
            if(!request.getParameter("content"+request.getParameter("comment")).trim().equals("")&&request.getSession().getAttribute("id")!=null){
                c.sendcomment(request.getParameter("content"+request.getParameter("comment")), (String)request.getSession().getAttribute("id"),request.getParameter("comment"), new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
             comment="commited to student parents";}
           else if(request.getParameter("content"+request.getParameter("comment")).trim().equals("")){
                comment="comment invalid!";
            }
            response.sendRedirect("list");
       }
        else{
        if(request.getParameter("name")!=null){
            if(request.getSession().getAttribute("id")!=null){
                try{
                String id=(String)request.getSession().getAttribute("id");
            c.delete(request.getParameter("name").split("-")[0], id);
            int t=c.GetAllStudents(id).size();
            int v=Integer.parseInt(request.getParameter("name").split("-")[1]);
            int t1=t/3;
            if(t%3!=0) t1+=1;
            if(v>t1)
               v=t1;
            delete=true;
            response.sendRedirect("list?page="+v);}
            catch(Exception e){
            response.sendRedirect("list");    
            }}
            else response.sendRedirect("list");
        }
        else{
         if(name!=null&&pass!=null) {
             request.getSession().removeAttribute("studentid");
        request.getSession().removeAttribute("id");
        request.getSession().removeAttribute("admin");
             if(c.checkadmin(name, pass)){
                 request.getSession().setAttribute("admin", name);
                 response.sendRedirect("homeadmin");
             }
             else{
                 if (pass.contains("-") ||name.contains("<") ||pass.contains("or") || !c.login(name, pass, campus)) {
                request.setAttribute("er", "Thông tin đăng nhập không chính xác");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                HttpSession h = request.getSession();
                String id = c.getId(name);
                h.setAttribute("id", id);
               response.sendRedirect("home.jsp");
            }}
        }
         else{
             request.setAttribute("er", "Thông tin đăng nhập không chính xác");
          request.getRequestDispatcher("login.jsp").forward(request, response); 
         }  
    }}
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
