package com.gjh.dao;

import com.gjh.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogDao extends JpaRepository<Blog,Long>,JpaSpecificationExecutor<Blog> {
    @Query("select b from Blog b where b.bpublished = '1'")//最新推荐
    List<Blog> findNew(Pageable pageable);

    Blog findByBid(Long id);

    //全局搜索  ？1的意思是第一个参数
//    @Query("select b from Blog b where b.btitle like ?1 or b.bcontent like ?1 or b.description like ?1")
//    Page<Blog> getQuery(String query,Pageable pageable);



}
