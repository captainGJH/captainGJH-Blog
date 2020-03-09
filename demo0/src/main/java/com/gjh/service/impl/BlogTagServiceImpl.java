package com.gjh.service.impl;

import com.gjh.dao.BlogTagDao;
import com.gjh.entity.BlogTag;

import com.gjh.service.BlogTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogTagServiceImpl implements BlogTagService{
    @Resource
    private BlogTagDao blogTagDao;

    @Override
    public List<BlogTag> listTag() {
        return blogTagDao.findAll();
    }

    @Override
    public List<BlogTag> listTag(String ids) {
        return blogTagDao.findAllById(tagsList(ids));
    }

    private List<Long> tagsList(String ids)
    {
        List<Long> list=new ArrayList<>();
        if(!"".equals(ids) && ids!=null)
        {
            String[] idsall=ids.split(",");
            for (int i=0;i<idsall.length;i++)
            {
                list.add(new Long(idsall[i]));
            }
        }
        return list;
    }

}
