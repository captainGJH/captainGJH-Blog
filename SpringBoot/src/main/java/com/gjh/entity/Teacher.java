package com.gjh.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * @Auther: mxt
 * @Date: 2019/11/14 15:26
 * @Description:
 */
@Entity
public class Teacher {
    @Id
    @GeneratedValue
    private int tid;
    private String tname;
    private String tsex;
    //fetch = FetchType.LAZY 懒加载需要的时候才获取
    // @JoinColumn(name = "tid")  如果不写会多一个中间表
    //@JsonIgnore忽略
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "tid")
    @JsonIgnore
    private List<Student> students;//一对多

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
