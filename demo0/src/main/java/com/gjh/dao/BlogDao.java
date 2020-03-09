package com.gjh.dao;

import com.gjh.entity.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogDao extends JpaRepository<Blog,Long>,JpaSpecificationExecutor<Blog> {
    Blog findByBid(Long id);

    @Query("select b from Blog b where b.bpublished = '1'")//最新推荐
      List<Blog> findNew(Pageable pageable);

}
