package com.gjh.elasticsearch;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

@Document(indexName = "esblog",type = "esblog")
public class ESBlog implements Serializable {

    @Id
    private long bid;
    private String btitle;
    private String bfristImg;
    private String description;
    private String bcontent;
    private Date bupdateTime;//发布时间
    private String bpublished;
    private  Integer bviews;

    private long uid;
    private  String unickname;
    private String uheadimg;
    private String tname;


    @Override
    public String toString() {
        return "ESBlog{" +
                "bid=" + bid +
                ", btitle='" + btitle + '\'' +
                ", bfristImg='" + bfristImg + '\'' +
                ", bupdateTime=" + bupdateTime +
                ", uid=" + uid +
                ", unickname='" + unickname + '\'' +
                ", uheadimg='" + uheadimg + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }

    public Integer getBviews() {
        return bviews;
    }

    public void setBviews(Integer bviews) {
        this.bviews = bviews;
    }

    public String getBpublished() {
        return bpublished;
    }

    public void setBpublished(String bpublished) {
        this.bpublished = bpublished;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getBid() {
        return bid;
    }

    public void setBid(long bid) {
        this.bid = bid;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBfristImg() {
        return bfristImg;
    }

    public void setBfristImg(String bfristImg) {
        this.bfristImg = bfristImg;
    }

    public Date getBupdateTime() {
        return bupdateTime;
    }

    public void setBupdateTime(Date bupdateTime) {
        this.bupdateTime = bupdateTime;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUnickname() {
        return unickname;
    }

    public void setUnickname(String unickname) {
        this.unickname = unickname;
    }

    public String getUheadimg() {
        return uheadimg;
    }

    public void setUheadimg(String uheadimg) {
        this.uheadimg = uheadimg;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
