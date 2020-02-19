package com.gjh.service.impl;

import com.gjh.dao.BlogTypeDao;
import com.gjh.entity.BlogType;
import com.gjh.service.BlogTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BlogTypeServiceImpl implements BlogTypeService {
    @Resource
    private BlogTypeDao blogTypeDao;

    @Override
    public List<BlogType> listType() {
        return blogTypeDao.findAll();
    }
}
