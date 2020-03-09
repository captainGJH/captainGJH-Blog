package com.gjh.util;

import com.alibaba.fastjson.JSON;
import com.gjh.entity.AttentionRedis;
import com.gjh.entity.User;
import com.gjh.service.AttentionRedisService;
import com.gjh.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;
//参考https://blog.csdn.net/qq_44717317/article/details/102846580?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
@Component
public class RedisFollowHelper {
    //（FOLLOW_USERS） 粉丝表
    private static final String FOLLOW_USERS = "USER_%s:myFans";//%s在下面是要输入用户名ID的
    //（FANS_USERS） 关注表
    private static final String FANS_USERS = "USER_%s:myFollows";


    @Resource
   private RedisUtils redisHelper;
    @Resource
    private AttentionRedisService attentionRedisService;
    @Resource
    private UserService userService;

    //userId去关注别人，判断是否已关注
    @Transactional
    public boolean isFollowed(Long fansid,Long followId) {

        String fanUsersKey = String.format(FANS_USERS, fansid);
        Object value = redisHelper.getHashKey(fanUsersKey, String.valueOf(followId));
        return value != null ;
    }
    //followId去关注别人,判断是否已关注
    @Transactional
    public boolean isFollowedByFollowId(Long followId, AttentionRedis attentionRedis) {

        String fanUsersKey = String.format(FANS_USERS, followId);
        Object value = redisHelper.getHashKey(fanUsersKey, String.valueOf(attentionRedis.getId()));
        return value != null ;
    }
    @Transactional//关注
    public void follow(Long fansid,Long followId) {
        User user=userService.getUid(fansid);
        User user1=userService.getUid(followId);
        AttentionRedis attentionRedis=attentionRedisService.addByUser(user);
        AttentionRedis attentionRedis1=attentionRedisService.addByUser(user1);

        String str= JSON.toJSONString(attentionRedis);//将AttentionRedis对象转化成JSON形式
        String str1= JSON.toJSONString(attentionRedis1);
        //我添加关注
        String fanUsersKey = String.format(FANS_USERS,fansid);
        redisHelper.put(fanUsersKey, String.valueOf(followId), str1);

        //对方新增粉丝
        String followUsersKey = String.format(FOLLOW_USERS,followId);
        redisHelper.put(followUsersKey, String.valueOf(fansid),str);
    }
    @Transactional//取消关注
    public void unFollow(Long fansid,Long followId) {
        //我取消关注
        String fanUsersKey = String.format(FANS_USERS, fansid);
        redisHelper.delete(fanUsersKey, String.valueOf(followId));
        //粉丝列表清除
        String followUsersKey = String.format(FOLLOW_USERS, followId);
        redisHelper.delete(followUsersKey, String.valueOf(fansid));
    }
    @Transactional
    public Map<Object,Object> myFollows(Long userId){//获取我的关注列表
        String fansUsersKey = String.format(FANS_USERS,userId);
        Map<Object,Object> objectMap = redisHelper.getHashEntries(fansUsersKey);

        return objectMap;
    }
    @Transactional
    public Map<Object,Object> myFans(Long userId){//获取我的粉丝列表
        String followUsersKey = String.format(FOLLOW_USERS, userId);
        Map<Object,Object> objectMap = redisHelper.getHashEntries(followUsersKey);
        return objectMap;
    }
    @Transactional
    public Long  myFollowCount(Long userId){//获取关注人数
        String fansCountKey = String.format(FANS_USERS, userId);
        Long fansCount= redisHelper.hashSize(fansCountKey);
        return  fansCount;
    }
    public Long myFansCount(Long followId){//获取粉丝人数
        String followCountKey = String.format(FOLLOW_USERS, followId);
        Long followCount= redisHelper.hashSize(followCountKey);
        return  followCount;
    }


}
