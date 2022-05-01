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
public class Teacher {
    private String Id;
    private String Campus;
    private String email;
    private String name;
    private String img;
    private String code;
    private String pass;
    private String userlogin;
    private Date dob;
    public Teacher() {
    }

    public Teacher(String Id, String Campus, String email, String name, String img, String code, String pass, String userlogin, Date dob) {
        this.Id = Id;
        this.Campus = Campus;
        this.email = email;
        this.name = name;
        this.img = img;
        this.code = code;
        this.pass = pass;
        this.userlogin = userlogin;
        this.dob = dob;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(String userlogin) {
        this.userlogin = userlogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getCampus() {
        return Campus;
    }

    public void setCampus(String Campus) {
        this.Campus = Campus;
    }
    
}
