package com.gjh.entity;

import javax.persistence.*;

/**
 * @Auther: mxt
 * @Date: 2019/11/14 15:26
 * @Description:
 */
@Entity
public class Student {
    @Id
    @GeneratedValue
    private int sid;
    private String sname;
    private int sage;
    private String sdept;
    //cascade = CascadeType.ALL级联 一起添加删除
    //fetch = FetchType.EAGER 因为参数很少直接获取
    //@JoinColumn(name = "tid")  关联的Teacher的主键字段
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "tid")
    private Teacher teacher;//多对一

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSdept() {
        return sdept;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
