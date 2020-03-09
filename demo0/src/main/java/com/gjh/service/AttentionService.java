package com.gjh.service;

import com.gjh.entity.Attention;

import java.util.List;

public interface AttentionService {

    int getFans(Long bsid,String isdel);//获取粉丝的人数
    int getFollow(Long fansid,String isdel);//自己关注的人数
    List<Attention> getByfid(Long fid);//获取粉丝
    List<Attention> getBybid(Long bsid);//自己的关注

}
