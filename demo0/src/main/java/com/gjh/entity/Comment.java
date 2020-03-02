package com.gjh.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private long cid;
    private String ccontent;

    @Temporal(TemporalType.TIMESTAMP)
    private Date cTime;//回复时间
    @ManyToOne
    private Blog blog;
    @ManyToOne
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments=new ArrayList<>();




    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", ccontent='" + ccontent + '\'' +
                ", cTime=" + cTime +
                ", blog=" + blog +
                ", parentComment=" + parentComment +
                ", replyComments=" + replyComments +
                '}';
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public List<Comment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }
}
