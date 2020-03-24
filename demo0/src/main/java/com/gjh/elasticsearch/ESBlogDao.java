package com.gjh.elasticsearch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


//dao 参考 https://www.cnblogs.com/guozp/archive/2018/04/02/8686904.html
public interface ESBlogDao extends ElasticsearchRepository<ESBlog,Long>{
    ESBlog findByBid(Long bid);

    Page<ESBlog> findByBpublishedAndBtitleLikeOrDescriptionLikeOrBcontentLike(String publish,String title,String des,String content,Pageable pageable);
    Page<ESBlog> findByBpublished(String published, Pageable pageable);

}
