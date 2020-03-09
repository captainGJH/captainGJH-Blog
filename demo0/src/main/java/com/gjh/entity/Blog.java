package com.gjh.entity;




import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Blog {

    @Id
    @GeneratedValue//(generator = "bid")
  //  @GenericGenerator(name="bid",strategy = "uuid")
    private long bid;
    private String btitle;//标题
    @Basic(fetch = FetchType.LAZY)//懒加载
    @Lob//大数据类型
    private String bcontent;//内容
    private String bfristImg;//首图
    private String bflag;//标记 转载 原创 翻译
    private Integer bviews;//浏览次数
    private boolean bdofristImg;//打赏是否开启
    private boolean bdopay;//打赏是否开启
    private boolean bshareStarement;//转载声明是否开启
    private boolean bcommentabled;//评论是否开启
    private String bpublished;//0删除1发布2未发布
    private String description;//博客概述

    @Transient//不会入库
    private String tagIds;

    @Temporal(TemporalType.TIMESTAMP)
    private Date bcreateTime;//发布时间

    @Temporal(TemporalType.TIMESTAMP)
    private Date bupdateTime;//更新时间

    @ManyToOne
    private BlogType blogType;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<BlogTag> tags=new ArrayList<>();
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments=new ArrayList<>();

    public void init(){
        this.tagIds = tagsAll(this.getTags());
    }

    private String tagsAll(List<BlogTag> tags){
        if(!tags.isEmpty()){
            StringBuffer ids=new StringBuffer();
            Boolean flag=false;
            for(BlogTag tag : tags){
                if(flag){
                    ids.append(",");
                }else {
                    flag=true;
                }
                ids.append(tag.getTgid());
            }
            return ids.toString();
        }else
            {
                return tagIds;
            }
    }

    @Override
    public String toString() {
        return "Blog{" +
                "bid=" + bid +
                ", btitle='" + btitle + '\'' +
                ", bcontent='" + bcontent + '\'' +
                ", bfristImg='" + bfristImg + '\'' +
                ", bflag='" + bflag + '\'' +
                ", bviews=" + bviews +
                ", bdofristImg=" + bdofristImg +
                ", bdopay=" + bdopay +
                ", bshareStarement=" + bshareStarement +
                ", bcommentabled=" + bcommentabled +
                ", bpublished='" + bpublished + '\'' +
                ", description='" + description + '\'' +
                ", tagIds='" + tagIds + '\'' +
                ", bcreateTime=" + bcreateTime +
                ", bupdateTime=" + bupdateTime +
                ", blogType=" + blogType +
                ", tags=" + tags +
                ", user=" + user +
                ", comments=" + comments +
                '}';
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

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public String getBfristImg() {
        return bfristImg;
    }

    public void setBfristImg(String bfristImg) {
        this.bfristImg = bfristImg;
    }

    public String getBflag() {
        return bflag;
    }

    public void setBflag(String bflag) {
        this.bflag = bflag;
    }

    public Integer getBviews() {
        return bviews;
    }

    public void setBviews(Integer bviews) {
        this.bviews = bviews;
    }

    public boolean isBdofristImg() {
        return bdofristImg;
    }

    public void setBdofristImg(boolean bdofristImg) {
        this.bdofristImg = bdofristImg;
    }

    public boolean isBdopay() {
        return bdopay;
    }

    public void setBdopay(boolean bdopay) {
        this.bdopay = bdopay;
    }

    public boolean isBshareStarement() {
        return bshareStarement;
    }

    public void setBshareStarement(boolean bshareStarement) {
        this.bshareStarement = bshareStarement;
    }

    public boolean isBcommentabled() {
        return bcommentabled;
    }

    public void setBcommentabled(boolean bcommentabled) {
        this.bcommentabled = bcommentabled;
    }

    public String getBpublished() {
        return bpublished;
    }

    public void setBpublished(String bpublished) {
        this.bpublished = bpublished;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public Date getBcreateTime() {
        return bcreateTime;
    }

    public void setBcreateTime(Date bcreateTime) {
        this.bcreateTime = bcreateTime;
    }

    public Date getBupdateTime() {
        return bupdateTime;
    }

    public void setBupdateTime(Date bupdateTime) {
        this.bupdateTime = bupdateTime;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }

    public List<BlogTag> getTags() {
        return tags;
    }

    public void setTags(List<BlogTag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
