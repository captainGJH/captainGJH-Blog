package com.gjh.vo;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


public class BlogQuery {

    private Long uid;
    private String title;

    private Long typeid;
    private String flag;


    private String published;

    public BlogQuery() {
    }

    @Override
    public String toString() {
        return "BlogQuery{" +
                "title='" + title + '\'' +
                ", typeid=" + typeid +
                ", flag='" + flag + '\'' +
                ", uid=" + uid +
                ", published='" + published + '\'' +
                '}';
    }



    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
