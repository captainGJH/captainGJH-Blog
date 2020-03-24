package com.gjh.service;

import com.gjh.elasticsearch.ESBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ESBlogService {

    Page<ESBlog> getESquery(String query, Pageable pageable);//查询页面
    Page<ESBlog> getESIndex( Pageable pageable);//首页的展示
}
