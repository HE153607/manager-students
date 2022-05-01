/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author hoanganhPC
 */
public class Student {
    private String Name;
    private String Id;
    private String Email;
    private String PhoneNumber;
    private boolean Gender;
    private String TeacherId;
    private String campus;
    private String img;
    private String Address;
    private Date dob;
    private boolean attend=false; 
    private String comment ;
    public Student() {
    }
    public Student(boolean attend ,Date date) {
        this.attend=attend;
        dob=date;
    }
 public Student(String comment ,String teacherid,String id,Date d) {
     this.comment=comment;
     TeacherId=teacherid;
     Id=id;
     dob=d;
    }
    public Student(String Name, String Id, String Email, String PhoneNumber, boolean Gender, String TeacherId, String campus, String img, String Address, Date dob) {
        this.Name = Name;
        this.Id = Id;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Gender = Gender;
        this.TeacherId = TeacherId;
        this.campus = campus;
        this.img = img;
        this.Address = Address;
        this.dob = dob;
    }

    public Student(String Name, String Id, String Email, String PhoneNumber, boolean Gender, String TeacherId, String campus, String img, String Address, Date dob, boolean attend) {
        this.Name = Name;
        this.Id = Id;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Gender = Gender;
        this.TeacherId = TeacherId;
        this.campus = campus;
        this.img = img;
        this.Address = Address;
        this.dob = dob;
        this.attend = attend;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getImg() {
        return img;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public void setImg(String img) {
        this.img = img;
    }

  
    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public String getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(String TeacherId) {
        this.TeacherId = TeacherId;
    }

    public boolean isAttend() {
        return attend;
    }

    public void setAttend(boolean attend) {
        this.attend = attend;
    }
    
}
