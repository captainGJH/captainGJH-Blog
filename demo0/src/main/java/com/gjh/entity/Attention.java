package com.gjh.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
//粉丝关注表 参考https://blog.csdn.net/weixin_41423450/article/details/97375256
public class Attention {
    @Id
    @GeneratedValue
    private long aid;
    private long besubscribe;//被关注id
    private  String beNickname;//被关注昵称
    private String beHeadimg;//被关注头像
    private long afans;//粉丝id
    private  String fNickname;//粉丝昵称
    private String fHeadimg;//粉丝头像
    private String isdel;//1关注 0取消关注
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;//更新时间




    public Attention() {
    }

    @Override
    public String toString() {
        return "Attention{" +
                "aid=" + aid +
                ", besubscribe=" + besubscribe +
                ", afans=" + afans +
                ", isdel='" + isdel + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getBeNickname() {
        return beNickname;
    }

    public void setBeNickname(String beNickname) {
        this.beNickname = beNickname;
    }

    public String getBeHeadimg() {
        return beHeadimg;
    }

    public void setBeHeadimg(String beHeadimg) {
        this.beHeadimg = beHeadimg;
    }

    public String getfNickname() {
        return fNickname;
    }

    public void setfNickname(String fNickname) {
        this.fNickname = fNickname;
    }

    public String getfHeadimg() {
        return fHeadimg;
    }

    public void setfHeadimg(String fHeadimg) {
        this.fHeadimg = fHeadimg;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public long getBesubscribe() {
        return besubscribe;
    }

    public void setBesubscribe(long besubscribe) {
        this.besubscribe = besubscribe;
    }

    public long getAfans() {
        return afans;
    }

    public void setAfans(long afans) {
        this.afans = afans;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel;
    }
}
