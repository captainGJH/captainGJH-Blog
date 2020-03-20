package com.gjh.entity;

import javax.validation.constraints.Min;
import java.beans.Transient;


public class User {
    private Integer uid;
@Min(value = 18,message = "小弟弟，这里不适合你")
    private Integer age;
    private String email;

    private String phone;

    private String uage;

    private String uname;

    private String upwd;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getUage() {
        return uage;
    }

    public void setUage(String uage) {
        this.uage = uage == null ? null : uage.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd == null ? null : upwd.trim();
    }
}