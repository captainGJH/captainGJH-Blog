package com.gjh.service.impl;

import com.gjh.dao.AttentionDao;
import com.gjh.entity.Attention;
import com.gjh.service.AttentionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AttentionServiceImpl implements AttentionService {

    @Resource
    private AttentionDao attentionDao;

    @Override
    public int getFans(Long bsid, String isdel) {
        return attentionDao.countByBesubscribeAndIsdel(bsid,isdel);
    }

    @Override
    public int getFollow(Long fansid,String isdel) {
        return attentionDao.countByAfansAndIsdel(fansid,isdel);
    }

    @Override
    public List<Attention> getByfid(Long fid) {
        return attentionDao.findByAfans(fid);
    }

    @Override
    public List<Attention> getBybid(Long bsid) {
        return attentionDao.findByBesubscribe(bsid);
    }
}
