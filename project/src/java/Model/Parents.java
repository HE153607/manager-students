/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hoanganhPC
 */
public class Parents {
    private String id ;
    private String idcard ;
    private String phone ;
    private String name;
    private String childid;

    public Parents(String id, String idcard, String phone, String name, String childid) {
        this.id = id;
        this.idcard = idcard;
        this.phone = phone;
        this.name = name;
        this.childid = childid;
    }

    public Parents() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChildid() {
        return childid;
    }

    public void setChildid(String childid) {
        this.childid = childid;
    }
    
}
