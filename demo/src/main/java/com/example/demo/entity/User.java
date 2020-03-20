package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class  User {
    @Id
    @GeneratedValue
    private int uid;
    @NotNull(message = "用户名不能为空")
    private  String uname;
    @NotNull(message = "密码不能为空")
    private String upwd;

    @Pattern(regexp="[0-9-()（）]{7,18}", message="手机号码格式错误")
    private String phone;

    public User(@NotNull(message = "用户名不能为空") String uname, @NotNull(message = "密码不能为空") String upwd, @Pattern(regexp = "[0-9-()（）]{7,18}", message = "手机号码格式错误") String phone) {
        this.uname = uname;
        this.upwd = upwd;
        this.phone = phone;
    }

    public User() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
