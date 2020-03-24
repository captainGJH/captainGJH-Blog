package com.gjh.service.impl;

import com.gjh.elasticsearch.ESBlog;
import com.gjh.elasticsearch.ESBlogDao;
import com.gjh.service.ESBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ESBlogServiceImpl implements ESBlogService {
@Resource
private ESBlogDao esBlogDao;

    @Override
    public Page<ESBlog> getESquery(String query, Pageable pageable) {

        return esBlogDao.findByBpublishedAndBtitleLikeOrDescriptionLikeOrBcontentLike("1",query,query,query,pageable);
    }

    @Override
    public Page<ESBlog> getESIndex( Pageable pageable) {
        return esBlogDao.findByBpublished("1",pageable);
    }
}
