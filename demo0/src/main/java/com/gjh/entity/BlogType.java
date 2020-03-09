package com.gjh.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BlogType {

    @Id
    @GeneratedValue
    private long tid;
    private String tname;

    @OneToMany(mappedBy = "blogType",fetch = FetchType.EAGER)
    private List<Blog> blogs=new ArrayList<>();

    @Override
    public String toString() {
        return "BlogType{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", blogs=" + blogs +
                '}';
    }

    public BlogType() {
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
