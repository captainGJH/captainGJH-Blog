package com.gjh.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private long uid;
    private String uusername;//用户名
    private  String unickname;//昵称
    private String upwd;//密码
    private String uemail;//邮箱
    private String uheadimg;//头像
    @Temporal(TemporalType.TIMESTAMP)
    private Date ucreateTime;//创建时间
    private Date uupdateTime;//修改时间

    private String uname;//实名
    private String usix;//性别
    private String ubirthday;//生日
    private String ulocation;//地区
    private String uindustry;//行业
    private String uposition;//职位
    private String usoon;//简介



    @OneToMany(mappedBy = "user")
  private List<Blog> blogs = new ArrayList<>();

    public User() {
    }

    public User(String uusername, String unickname, String upwd, String uemail, String uheadimg, Date ucreateTime, Date uupdateTime, String uname, String usix, String ubirthday, String ulocation, String uindustry, String uposition, String usoon) {
        this.uusername = uusername;
        this.unickname = unickname;
        this.upwd = upwd;
        this.uemail = uemail;
        this.uheadimg = uheadimg;
        this.ucreateTime = ucreateTime;
        this.uupdateTime = uupdateTime;
        this.uname = uname;
        this.usix = usix;
        this.ubirthday = ubirthday;
        this.ulocation = ulocation;
        this.uindustry = uindustry;
        this.uposition = uposition;
        this.usoon = usoon;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uusername='" + uusername + '\'' +
                ", unickname='" + unickname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", uemail='" + uemail + '\'' +
                ", uheadimg='" + uheadimg + '\'' +
                ", ucreateTime=" + ucreateTime +
                ", uupdateTime=" + uupdateTime +
                ", uname='" + uname + '\'' +
                ", usix='" + usix + '\'' +
                ", ubirthday='" + ubirthday + '\'' +
                ", ulocation='" + ulocation + '\'' +
                ", uindustry='" + uindustry + '\'' +
                ", uposition='" + uposition + '\'' +
                ", usoon='" + usoon + '\'' +
                '}';
    }


    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUusername() {
        return uusername;
    }

    public void setUusername(String uusername) {
        this.uusername = uusername;
    }

    public String getUnickname() {
        return unickname;
    }

    public void setUnickname(String unickname) {
        this.unickname = unickname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUheadimg() {
        return uheadimg;
    }

    public void setUheadimg(String uheadimg) {
        this.uheadimg = uheadimg;
    }

    public Date getUcreateTime() {
        return ucreateTime;
    }

    public void setUcreateTime(Date ucreateTime) {
        this.ucreateTime = ucreateTime;
    }

    public Date getUupdateTime() {
        return uupdateTime;
    }

    public void setUupdateTime(Date uupdateTime) {
        this.uupdateTime = uupdateTime;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUsix() {
        return usix;
    }

    public void setUsix(String usix) {
        this.usix = usix;
    }

    public String getUbirthday() {
        return ubirthday;
    }

    public void setUbirthday(String ubirthday) {
        this.ubirthday = ubirthday;
    }

    public String getUlocation() {
        return ulocation;
    }

    public void setUlocation(String ulocation) {
        this.ulocation = ulocation;
    }

    public String getUindustry() {
        return uindustry;
    }

    public void setUindustry(String uindustry) {
        this.uindustry = uindustry;
    }

    public String getUposition() {
        return uposition;
    }

    public void setUposition(String uposition) {
        this.uposition = uposition;
    }

    public String getUsoon() {
        return usoon;
    }

    public void setUsoon(String usoon) {
        this.usoon = usoon;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
