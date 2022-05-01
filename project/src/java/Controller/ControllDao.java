/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Parents;
import Model.Student;
import Model.Teacher;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoanganhPC
 */
public class ControllDao extends Dao {
    public String datejoin(String id){
        String sql ="select djoin from datejoin where id=?";
        try {
            PreparedStatement p=connection.prepareStatement(sql);
            p.setString(1, id);
            ResultSet r=p.executeQuery();
            if(r.next())return r.getDate("djoin")+"";
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Student> getdate(String id,String tid){
        ArrayList<Student> a=new ArrayList<>();
        String sql="select * from attend where sid=? and tid=?";
        
        try {
            PreparedStatement p=connection.prepareStatement(sql);
            p.setString(1, id);
            p.setString(2, tid);
            ResultSet r=p.executeQuery();
            while(r.next())
                a.add(new Student(r.getBoolean("attend"), r.getDate("dtime")));
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
      return a;
    }
    public void updateaccount(String user ,String pass,String id){
        String sql="update account set username=?,pass=? where id=?";
        try {
            PreparedStatement p=connection.prepareStatement(sql);
            p.setString(1, user);
            p.setString(2, pass);
            p.setString(3, id);
            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateimgteacher(String file,String id){
        String sql="update teacher set img=? where id=?";
        try {
            PreparedStatement p=connection.prepareStatement(sql);
            p.setString(1, file);
            p.setString(2, id);
            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Teacher> allteacher(String sid){
        ArrayList<Teacher> a=new ArrayList<>();
        String sql="select t.* from class c join teacher t on t.id=c.id where studentid=?";
        try {
            PreparedStatement p=connection.prepareStatement(sql);
            p.setString(1, sid);
            ResultSet r=p.executeQuery();
            while(r.next()) a.add(new Teacher(r.getString("id"), null, null, r.getString("name"), null, null, null, null, null));
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }return a;
    }
    public void deletestudent(String id){
        String sql ="delete datejoin where id=?\n" +
" delete attend where [sid]=?\n" +
" delete mark where [sid]=?\n" +
" delete parent where studentid=?\n" +
" delete class where studentid=?\n" +
" delete comment where studentid=?\n" +
" delete Student where studentid=?\n" +
" delete account where id=?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement p=connection.prepareStatement(sql);
            p.setString(1, id);
            p.setString(2, id);
            p.setString(3, id);
            p.setString(4, id);
            p.setString(5, id);
            p.setString(6, id);
            p.setString(7, id);
            p.setString(8, id);
            p.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  public ArrayList<Student> studendetail(String campus){
      ArrayList<Student> a=new ArrayList<>();
      String sql="select * from Student where campus=?";
      try {
          PreparedStatement p=connection.prepareStatement(sql);
          p.setNString(1, campus);
          ResultSet r=p.executeQuery();
          while(r.next()) a.add(new Student(r.getString("name"), r.getString("studentid"), r.getString("email"), r.getString("phonenumber"),r.getBoolean("gender"), null,  r.getString("campus"), r.getString("img"), r.getString("address"), r.getDate("dob")));
      } catch (SQLException ex) {
          Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
      }
      return a;
  }
  public ArrayList<Student> studendetail(){
      ArrayList<Student> a=new ArrayList<>();
      String sql="select * from Student";
      try {
          PreparedStatement p=connection.prepareStatement(sql);
          ResultSet r=p.executeQuery();
          while(r.next()) a.add(new Student(r.getString("name"), r.getString("studentid"), r.getString("email"), r.getString("phonenumber"),r.getBoolean("gender"), null,  r.getString("campus"), r.getString("img"), r.getString("address"), r.getDate("dob")));
      } catch (SQLException ex) {
          Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
      }
      return a;
  }
    public void deleteteacher(String id){
        String sql ="delete class where id=? \n" +
" delete attend where tid=?\n" +
" delete mark where tid=?\n" +
" delete comment where tid=?\n" +
" delete teacher where id=?\n" +
" delete account where id=?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement p=connection.prepareStatement(sql);
            p.setString(1, id);
            p.setString(2, id);
            p.setString(3, id);
            p.setString(4, id);
            p.setString(5, id);
            p.setString(6, id);
            p.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateteacher(String id,String name ,String code,String date ,String email){
     String sql="update teacher set name=?,email=?,code=?,dob=? where id=?";
        try {
            PreparedStatement p=connection.prepareStatement(sql);
            p.setString(1, name);
            p.setString(2, email);
            p.setString(3, code);
            p.setDate(4, Date.valueOf(date));
            p.setString(5, id);
            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    public ArrayList<Teacher> getteacherbycampus(String campus){
        ArrayList<Teacher> a=new ArrayList<>();
        String sql ="select t.*,a.username,a.pass from teacher t join account a on a.id=t.id where t.campus=?";
        try {
            PreparedStatement p=connection.prepareStatement(sql);
            p.setNString(1, campus);
            ResultSet r=p.executeQuery();
            while(r.next()) a.add(new Teacher(r.getString("id"), null, r.getString("email"), r.getString("name"), r.getString("img"), r.getString("code"), r.getString("pass"), r.getString("username"), r.getDate("dob")));
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }return a;
    }
    public ArrayList<Teacher> getteacher(){
        ArrayList<Teacher> a=new ArrayList<>();
        String sql ="select t.*,a.username,a.pass from teacher t join account a on a.id=t.id";
        try {
            PreparedStatement p=connection.prepareStatement(sql);
            ResultSet r=p.executeQuery();
            while(r.next()) a.add(new Teacher(r.getString("id"), null, r.getString("email"), r.getString("name"), r.getString("img"), r.getString("code"), r.getString("pass"), r.getString("username"), r.getDate("dob")));
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }return a;
    }
    public ArrayList<String> getmarks(String sub,String sid){
        String sql="select * from mark where [sid]=? and [subject]=?";
        ArrayList<String> a=new ArrayList<>();
        try {
            PreparedStatement p=connection.prepareStatement(sql);
            p.setString(1, sid);
            p.setString(2, sub);
            ResultSet r=p.executeQuery();
            while(r.next()) a.add(r.getInt("mark_weight")+"="+r.getString("catgrade")+"="+(r.getFloat("mark")==-1?" ":r.getFloat("mark"))+"="+r.getString("tid"));
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }return a;
    }
    public ArrayList<String> getsub(String sid){
        String sql ="select distinct [subject],t.name from mark m join teacher t on t.id=m.tid where m.[sid]=?";
        ArrayList<String> a=new ArrayList<>();
        try {
            PreparedStatement p=connection.prepareStatement(sql);
            p.setString(1, sid);
            ResultSet r=p.executeQuery();
            while(r.next()) a.add(r.getString("subject")+"="+r.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }return a;
    }
    public ArrayList<String> getteacherids(String sid){
        ArrayList<String> a=new ArrayList<>();
        String sql="select c.id,t.name from class c join teacher t on t.id=c.id where c.studentid=?";
        try {
            PreparedStatement p=connection.prepareStatement(sql);
            p.setString(1, sid);
            ResultSet r=p.executeQuery();
            while(r.next()) a.add(r.getString("id")+"="+r.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    public void updatemark(String sid ,String tid ,String cat,float mark){
        String s ="update mark set mark=? where catgrade=? and [sid]=? and tid=?";
        try {
            PreparedStatement p=connection.prepareStatement(s);
            p.setFloat(1,mark);
            p.setString(2, cat);
            p.setString(3, sid);
            p.setString(4, tid);
            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public ArrayList<String> getsubject(String sid,String tid){
        ArrayList<String> a=new ArrayList<>();
     String s="select * from mark where tid=? and [sid]=?";
        try {
            PreparedStatement p = connection.prepareStatement(s);
            p.setString(1, tid);
            p.setString(2, sid);
            ResultSet r=p.executeQuery();
            while(r.next()) a.add(r.getInt("mark_weight")+"="+r.getString("catgrade")+"="+r.getString("subject")+"="+(r.getFloat("mark")==-1?" ":r.getFloat("mark"))+"");
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }return a;   
    }
    public String checkmark(String tid){
        String s="select top 1 *  from mark where tid=?";
        try {
            PreparedStatement p = connection.prepareStatement(s);
            p.setString(1, tid);
            ResultSet r=p.executeQuery();
            if(r.next()) return r.getString("sid");
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }return "";
    }
public void addmark(String sid ,String tid ,String sub,String weight,String cat){
    String sql ="insert into mark (mark_weight,catgrade,[sid],tid,subject,mark) values(?,?,?,?,?,?)";
    try {
        PreparedStatement p = connection.prepareStatement(sql);
        p.setInt(1, Integer.parseInt(weight));
        p.setString(2, cat);
        p.setString(3, sid);
        p.setString(4, tid);
        p.setString(5, sub);
        p.setFloat(6, -1);
        p.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    public ArrayList<Student> getallstudent(String campus) {
        ArrayList<Student> a = new ArrayList<>();
        String s = "select * from Student where campus=?";
        try {
            PreparedStatement p = connection.prepareStatement(s);
            p.setString(1, campus);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                a.add(new Student(r.getString("name"), r.getString("studentid"), r.getString("email"), r.getString("phonenumber"),
                        r.getBoolean("gender"), null, r.getString("campus"), r.getString("img"), r.getString("address"), r.getDate("dob")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public Teacher getteacherbystudent(String id) {
        String s = "select t.* from teacher t join class c on c.id=t.id join Student s on s.studentid=c.studentid where s.studentid=?";
        try {
            PreparedStatement p = connection.prepareStatement(s);
            p.setString(1, id);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return new Teacher(r.getString("id"), r.getString("campus"), r.getString("email"), r.getString("name"), r.getString("img"), r.getString("code"), null, null, r.getDate("dob"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Teacher getteacherbyid(String id) {
        String s = "select t.* from teacher t  where t.id=?";
        try {
            PreparedStatement p = connection.prepareStatement(s);
            p.setString(1, id);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return new Teacher(r.getString("id"), r.getString("campus"), r.getString("email"), r.getString("name"), r.getString("img"), r.getString("code"), null, null, r.getDate("dob"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean checkemail(String e) {
        if (e == null) {
            return false;
        }
        String s = "select * from Student where email=?";
        try {
            PreparedStatement pp = connection.prepareStatement(s);
            pp.setString(1, e);
            ResultSet r = pp.executeQuery();
            if (r.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void addstudentacount(String u, String p, String id) {
        String s = "insert into account(username,pass,id,roleid) values(?,?,?,3)";
        try {
            PreparedStatement pp = connection.prepareStatement(s);
            pp.setString(1, u);
            pp.setString(2, p);
            pp.setString(3, id);
            pp.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addstudentacountp(String u, String p, String id) {
        String s = "insert into account(username,pass,id,roleid) values(?,?,?,4)";
        try {
            PreparedStatement pp = connection.prepareStatement(s);
            pp.setString(1, u);
            pp.setString(2, p);
            pp.setString(3, id);
            pp.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Student getstudentbyids(String id) {
        String s = "select s.*,d.djoin from Student s join datejoin d on d.id=s.studentid where studentid=?";
        try {
            PreparedStatement p = connection.prepareStatement(s);
            p.setString(1, id);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return new Student(r.getString("name") + "=" + r.getDate("djoin"), r.getString("studentid"), r.getString("email"), r.getString("phonenumber"), r.getBoolean("gender"), null, r.getString("campus"), r.getString("img"), r.getString("address"), r.getDate("dob"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String loginstudent(String e, String p, String c) {
        String s = "select s.studentid from account a join Student s on s.email=a.username where username=? and pass=? and s.campus=?";
        try {
            PreparedStatement pp = connection.prepareStatement(s);
            pp.setString(1, e);
            pp.setString(2, p);
            pp.setString(3, c);
            ResultSet r = pp.executeQuery();
            if (r.next()) {
                return r.getString("studentid");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean checkadmin(String n, String p) {
        String s = "select * from account where username=? and pass=? and roleid=1";
        try {
            PreparedStatement pp = connection.prepareStatement(s);
            pp.setString(1, n);
            pp.setString(2, p);
            ResultSet r = pp.executeQuery();
            if (r.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void sendcomment(String content, String tid, String sid, String date) {
        String sql = "insert into comment(content,dtime,tid,studentid) values(?,?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, content);
            p.setDate(2, Date.valueOf(date));
            p.setString(3, tid);
            p.setString(4, sid);
            p.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public boolean parentlogin(String card) {
        try {
            PreparedStatement p = connection.prepareStatement("select p.* from parent p \n"
                    + " where p.idcard=? ");
            p.setString(1, card);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public ArrayList<Student> getcomment(String id,String tid) {
        ArrayList<Student> a = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement("select * from comment c where c.studentid=? and tid=?");
            p.setString(1, id);
            p.setString(2, tid);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                a.add(new Student(r.getString("content"), r.getString("tid"), r.getString("studentid"), r.getDate("dtime")));
            }

        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return a;
    }

    public ArrayList<Student> tableattend(String id,String tid) {
        ArrayList<Student> a = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement("select attend,dtime from attend where [sid]=? and tid=?");
            p.setString(1, id);
            p.setString(2, tid);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                a.add(new Student(r.getBoolean("attend"), r.getDate("dtime")));
            }

        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return a;
    }
    public ArrayList<Student> tableattends(String id,String tid) {
        ArrayList<Student> a = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement("select attend,dtime from attend where [sid]=? and tid=?");
            p.setString(1, id);
            p.setString(2, tid);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                a.add(new Student(r.getBoolean("attend"), r.getDate("dtime")));
            }

        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return a;
    }

    public Parents parentcampus(String card, String campus) {
        try {
            PreparedStatement p = connection.prepareStatement("select p.* from parent p join Student s on s.studentid=p.studentid\n"
                    + " where p.idcard=? and s.campus=?");
            p.setString(1, card);
            p.setString(2, campus);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return new Parents(r.getString("pid"), r.getString("idcard"), r.getString("phone"), r.getString("name"), r.getString("studentid"));
            }
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public void join(String n, String id) {
        try {
            PreparedStatement p = connection.prepareStatement("insert into datejoin(djoin,id) values(?,?)");
            p.setDate(1, Date.valueOf(n));
            p.setString(2, id);
            p.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void insertparent(Parents parent) {
        String sql = "insert into parent(name,phone,pid,studentid,idcard) values(?,?,?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, parent.getName());
            p.setString(2, parent.getPhone());
            p.setString(3, parent.getId());
            p.setString(4, parent.getChildid());
            p.setString(5, parent.getIdcard());
            p.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ArrayList<Parents> getparents() {
        ArrayList<Parents> l = new ArrayList<>();
        String sql = "select * from parent";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                l.add(new Parents(r.getString("pid"), r.getString("idcard"), r.getString("phone"), r.getString("name"), r.getString("studentid")));
            }
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return l;
    }

    public ArrayList<Student> getstudents(String date, String idteacher) {
        ArrayList<Student> l = new ArrayList<>();
        try {
            String sql = "select s.*,d.attend from(select c.*,a.attend from class c join attend a on c.studentid=a.[sid] \n" +
"                    where c.id=? and a.tid=? and a.dtime=?) as d\n" +
"                    join Student s on s.studentid=d.studentid";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, idteacher);
            p.setString(2, idteacher);
            p.setDate(3, Date.valueOf(date));
            ResultSet r = p.executeQuery();
            while (r.next()) {
                l.add(new Student(r.getString("name"), r.getString("studentid"), r.getString("email"), r.getString("phonenumber"),
                        r.getBoolean("gender"), null, r.getString("campus"), r.getString("img"), r.getString("address"), r.getDate("dob"), r.getBoolean("attend")));
            }
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return l;
    }

    public void insertattend(boolean state, String date, String t, String s) {
        String sql = "insert into attend(attend,dtime,[sid],tid) values(?,?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setBoolean(1, state);
            p.setDate(2, Date.valueOf(date));
            p.setString(3, s);
            p.setString(4, t);
            p.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public boolean checkattend(String s, String date) {
        String sql = "select * from attend a where a.tid=? and a.dtime=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, s);
            p.setDate(2, Date.valueOf(date));
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void updateattend(String id, boolean state, String date) {
        String sql = "update attend set attend=? where [sid]=? and dtime=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setBoolean(1, state);
            p.setString(2, id);
            p.setDate(3, Date.valueOf(date));
            p.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Parents getparentbystudentid(String id) {
        Parents p = null;
        try {
            PreparedStatement pp = connection.prepareStatement("select p.* from parent p join Student s on p.studentid=s.studentid where s.studentid=?");
            pp.setString(1, id);
            ResultSet r = pp.executeQuery();
            if (r.next()) {
                p = new Parents(null, r.getString("idcard"), r.getString("phone"), r.getString("name"), null);
            }
        } catch (Exception e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return p;
    }

    public Date getdatejoin(String idstudent) {
        String sql = "select djoin from datejoin where id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, idstudent);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return r.getDate("djoin");
            }
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public Student studentbycard(String card, String campus) {

        String sql = "select s.* from Student s join parent p on p.studentid=s.studentid where p.idcard=? and campus=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, card);
            p.setNString(2, campus);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return new Student(r.getString("name"), r.getString("studentid"), null, null,
                        r.getBoolean("gender"), null, null, r.getString("img"), null, null);
            }
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public boolean getcode(String code) {
        String sql = "select code from teacher where code=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, code);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public ControllDao() {
    }

    ArrayList<Student> getlistpage(int page, ArrayList<Student> ar) {
        ArrayList<Student> a = new ArrayList<>();
        for (int i = 0; i < ar.size(); i++) {
            if (i >= ((page - 1) * 4) && i < (page * 4)) {
                a.add(ar.get(i));
            }
        }
        return a;
    }

    int changpass(String user, String pass, String newpass) {
        String sql = "update account set pass=? where username=? and pass=?";
        int t = 2;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, newpass);
            p.setString(2, user);
            p.setString(3, pass);
            t = p.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return t;
    }

    void updatecode(String idteacher, Teacher t) {
        String sql = "update teacher set code=?,email=?,name=?,dob=? where id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, t.getCode());
            p.setString(2, t.getEmail());
            p.setString(3, t.getName());
            p.setDate(4, Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(t.getDob())));
            p.setString(5, idteacher);
            p.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    boolean checkclass(String id, String idteacher) {
        String s = "select * from class c where c.studentid=? and c.id!=?";
        try {
            PreparedStatement p = connection.prepareStatement(s);
            p.setString(1, id);
            p.setString(2, idteacher);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    void delete(String id, String idteacher) {
        String sql = null;
        if (checkclass(id, idteacher)) {
            sql = "delete mark where [sid]=? and tid=? delete class where id=? and studentid=? "//co nhiu class
                    + "delete comment where studentid=? and tid=? \n"
                    + " delete attend where [sid]=? and tid=?";
        } else {
            sql = "delete mark where [sid]=? and tid=? delete class where id=? and studentid=? "
                    + "delete parent where studentid=? delete comment where studentid=?"
                    + " delete datejoin where id=? "
                    + "delete attend where [sid]=? delete Student where studentid=? delete account where id=?";
        }
        try {
            connection.setAutoCommit(false);
            PreparedStatement p = connection.prepareStatement(sql);
            if (checkclass(id, idteacher)) {
                p.setString(1, id);
                p.setString(2, idteacher);
                p.setString(3, idteacher);
                p.setString(4, id);
                p.setString(5, id);
                p.setString(6, idteacher);
                p.setString(7, id);
                p.setString(8, idteacher);
            } else {
                p.setString(1, id);
                p.setString(2, idteacher);
                p.setString(3, idteacher);
                p.setString(4, id);
                p.setString(5, id);
                p.setString(6, id);
                p.setString(7, id);
                p.setString(8, id);
                p.setString(9, id);
                p.setString(10, id);
            }

            p.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ArrayList<Student> allstudents() {
        String sql = "select * from Student";
        ArrayList<Student> a = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                a.add(new Student(r.getString("name"), r.getString("studentid"), r.getString("email"), r.getString("phonenumber"),
                        r.getBoolean("gender"), null, r.getString("campus"), r.getString("img"), r.getString("address"), r.getDate("dob")));
            }
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return a;
    }

    public List<Student> GetAllStudents(String idteacher) {
        List<Student> l = new ArrayList<>();
        try {
            String sql = "select s.* from Student s \n"
                    + "join class c on s.studentid=c.studentid where c.id=?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, idteacher);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                l.add(new Student(r.getString("name"), r.getString("studentid"), r.getString("email"), r.getString("phonenumber"),
                        r.getBoolean("gender"), null, r.getString("campus"), r.getString("img"), r.getString("address"), r.getDate("dob")));
            }
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return l;
    }

    public void Update(Student s) throws SQLException {
        String sql = "update Student set name=?,phonenumber=?,[address]=?,gender=?,dob=?,img=? \n"
                + ",email=? where studentid=?";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setString(1, s.getName());
        p.setString(2, s.getPhoneNumber());
        p.setString(3, s.getAddress());
        p.setBoolean(4, s.isGender());
        p.setDate(5, Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(s.getDob())));
        p.setString(6, s.getImg());
        p.setString(7, s.getEmail());
        p.setString(8, s.getId());
        p.executeUpdate();
    }
    public void Update2(Student s) throws SQLException {
        String sql = "update Student set name=?,phonenumber=?,[address]=?,dob=? \n"
                + ",email=? where studentid=?";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setString(1, s.getName());
        p.setString(2, s.getPhoneNumber());
        p.setString(3, s.getAddress());
        p.setDate(4, Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(s.getDob())));
        p.setString(5, s.getEmail());
        p.setString(6, s.getId());
        p.executeUpdate();
    }

    public void NewStudent(Student s) {
        try {
            String sql = "insert into Student(studentid,name,gender,campus,email,phonenumber,[address],img,dob) "
                    + "values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, s.getId());
            p.setString(2, s.getName());
            p.setBoolean(3, s.isGender());
            p.setString(4, s.getCampus());
            p.setString(5, s.getEmail());
            p.setString(6, s.getPhoneNumber());
            p.setString(7, s.getAddress());
            p.setString(8, s.getImg());
            p.setDate(9, Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(s.getDob())));
            p.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    Teacher forgot(String user, String date, String id) {
        String sql = "select a.pass,t.email from account a join teacher t on a.id=? where a.username=? and t.dob=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);
            p.setString(2, user);
            p.setString(3, date);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return new Teacher(null, null, r.getString("email"), null, null, null, r.getString("pass"), null, null);
            }
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    boolean login(String name, String pass, String campus) {
        String sql = "select a.username,a.pass from account a join teacher t \n"
                + " on a.id=t.id where t.campus=? and \n"
                + "a.username=? and a.pass=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, campus);
            p.setString(2, name);
            p.setString(3, pass);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public boolean checklogin(String name) {
        String sql1 = "select * from account where username=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql1);
            p.setString(1, name);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public void addaccount(String name, String pass, String id) {
        String sql = "insert into account(username,pass,id,roleid) values(?,?,?,2)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, name);
            p.setString(2, pass);
            p.setString(3, id);
            p.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ArrayList<Teacher> listTeacher() {
        String sql1 = "select * from teacher";
        ArrayList<Teacher> al = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql1);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                al.add(new Teacher(r.getString("id"), r.getString("campus"), r.getString("email"), r.getString("name"),
                        r.getString("img"), r.getString("code"), null, null, r.getDate("dob")));
            }
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return al;
    }

    public Teacher TeacherbyId(String id) {
        String sql1 = "select * from teacher where id=?";
        Teacher t = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql1);
            p.setString(1, id);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                t = new Teacher(r.getString("id"), r.getString("campus"), r.getString("email"), r.getString("name"),
                        r.getString("img"), r.getString("code"), null, null, r.getDate("dob"));
            }
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return t;
    }

    public Student StudentbyId(String id) {
        String sql1 = "select * from Student where studentid=?";
        Student t = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql1);
            p.setString(1, id);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                t = new Student(r.getString("name"), r.getString("studentid"), r.getString("email"), r.getString("phonenumber"),
                        r.getBoolean("gender"), null, r.getString("campus"), r.getString("img"), r.getString("address"), r.getDate("dob"));
            }
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return t;
    }

    public void addTeacher(Teacher t) {
        String sql = "insert into teacher(id,campus,email,name,img,code,dob) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, t.getId());
            p.setString(2, t.getCampus());
            p.setString(3, t.getEmail());
            p.setString(4, t.getName());
            p.setString(5, t.getImg());
            p.setString(5, t.getImg());
            p.setString(6, t.getCode());
            p.setDate(7, Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(t.getDob())));
            p.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String getId(String user) {
        String n = null;
        try {
            String sql = "select id from account where username=?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, user);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                n = r.getString("id");
            }
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }

    public Teacher getTeacherbycode(String code, String campus) {
        String sql = "select * from teacher where code=? and campus=?";
        Teacher t = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, code);
            p.setString(2, campus);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                t = new Teacher(r.getString("id"), r.getString("campus"), r.getString("email"),
                        r.getString("name"), r.getString("img"), r.getString("code"), null, null, r.getDate("dob"));
            }
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return t;
    }

    public void addClass(String teacher, String student) {
        String sql = "insert into class(id,studentid) values(?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, teacher);
            p.setString(2, student);
            p.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ControllDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
