package com.gjh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BlogTag {
    @Id
    @GeneratedValue
    private long tgid;
    private String tgname;

    public BlogTag() {
    }

    @ManyToMany(mappedBy = "tags")
    private List<Blog> tags=new ArrayList<>();


    @Override
    public String toString() {
        return "BlogTag{" +
                "tgid=" + tgid +
                ", tgname='" + tgname + '\'' +
                ", tags=" + tags +
                '}';
    }

    public long getTgid() {
        return tgid;
    }

    public void setTgid(long tgid) {
        this.tgid = tgid;
    }

    public String getTgname() {
        return tgname;
    }

    public void setTgname(String tgname) {
        this.tgname = tgname;
    }

    public List<Blog> getTags() {
        return tags;
    }

    public void setTags(List<Blog> tags) {
        this.tags = tags;
    }
}
