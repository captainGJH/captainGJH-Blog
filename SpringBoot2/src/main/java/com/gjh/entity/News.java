package com.gjh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.sql.Clob;
import java.sql.Timestamp;

@Entity
public class News {
    @Id
    @GeneratedValue
    private int new_id;
    private String title;
    private String time;
    private String imgurl;
    private String newbodys;
    private int ox;

    public int getOx() {
        return ox;
    }

    public void setOx(int ox) {
        this.ox = ox;
    }

    public int getNew_id() {
        return new_id;
    }

    public void setNew_id(int new_id) {
        this.new_id = new_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getNewbodys() {
        return newbodys;
    }

    public void setNewbodys(String newbodys) {
        this.newbodys = newbodys;
    }
}
