package com.gjh.service;

import com.gjh.entity.AttentionRedis;
import com.gjh.entity.User;

import java.util.List;

public interface AttentionRedisService {

    AttentionRedis addByUser(User user);//将user对象中相应的属性赋值给AttentionRedis

    Boolean isFollowed(Long fansid,Long followId);//判断是否已关注

    void follow(Long fansid,Long followId);//关注

    void unFollow(Long fansid,Long followId);//取关

    List<AttentionRedis> getFans(Long fansid);//遍历粉丝列表

    List<AttentionRedis> getFollows(Long followid);//遍历关注列表

    Long  myFollowCount(Long userId);//获取关注人数

    Long myFansCount(Long followId);//获取粉丝人数


}
