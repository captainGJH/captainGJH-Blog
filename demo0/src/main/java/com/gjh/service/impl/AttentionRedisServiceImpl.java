package com.gjh.service.impl;

import com.alibaba.fastjson.JSON;
import com.gjh.entity.AttentionRedis;
import com.gjh.entity.User;
import com.gjh.service.AttentionRedisService;
import com.gjh.service.UserService;
import com.gjh.util.RedisFollowHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AttentionRedisServiceImpl implements AttentionRedisService {
    @Resource
    private RedisFollowHelper redisFollowHelper;

    @Transactional
    @Override
    public AttentionRedis addByUser(User user) {
        AttentionRedis attentionRedis=new AttentionRedis();
        attentionRedis.setId(user.getUid());
        attentionRedis.setNikeName(user.getUnickname());
        attentionRedis.setHeadImg(user.getUheadimg());
        return attentionRedis;
    }
    @Transactional
    @Override//将map转为List<AttentionRedis> 获取粉丝列表
    public List<AttentionRedis> getFans(Long fansid) {
        Map<Object,Object> map=redisFollowHelper.myFans(fansid);
        List<AttentionRedis> list=new ArrayList<>();
        AttentionRedis object=null;
        for (Object key : map.keySet()) {
            String get=(String)map.get(key);
            object = JSON.parseObject(get,AttentionRedis.class);
            list.add(object);
        }
        return list;
    }
    @Transactional
    @Override//获取关注列表
    public List<AttentionRedis> getFollows(Long followid) {
        Map<Object,Object> map=redisFollowHelper.myFollows(followid);
        List<AttentionRedis> list=new ArrayList<>();
        AttentionRedis object=null;
        for (Object key : map.keySet()) {
            String get=(String)map.get(key);
            object = JSON.parseObject(get,AttentionRedis.class);
            list.add(object);
        }
        return list;
    }
    @Transactional
    @Override//判断是否关注
    public Boolean isFollowed(Long fansid, Long followId) {

        return redisFollowHelper.isFollowed(fansid,followId);
    }
    @Transactional
    @Override//添加关注
    public void follow(Long fansid, Long followId) {
        redisFollowHelper.follow(fansid,followId);
    }
    @Transactional
    @Override//取消关注
    public void unFollow(Long fansid, Long followId) {
          redisFollowHelper.unFollow(fansid,followId);
    }
    @Transactional
    @Override//关注的人数
    public Long myFollowCount(Long userId) {
        return redisFollowHelper.myFollowCount(userId);
    }
    @Transactional
    @Override//粉丝人数
    public Long myFansCount(Long followId) {
        return redisFollowHelper.myFansCount(followId);
    }
}
