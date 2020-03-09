package com.gjh.entity;

import java.io.Serializable;

public class AttentionRedis implements Serializable {
private Long id;
private String nikeName;
private String headImg;

    public AttentionRedis() {
    }

    @Override
    public String toString() {
        return "AttentionRedis{" +
                "id=" + id +
                ", nikeName='" + nikeName + '\'' +
                ", headImg='" + headImg + '\'' +
                '}';
    }

    public AttentionRedis(Long id, String nikeName, String headImg) {
        this.id = id;
        this.nikeName = nikeName;
        this.headImg = headImg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
