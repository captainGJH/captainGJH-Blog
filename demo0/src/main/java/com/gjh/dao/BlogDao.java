package com.gjh.dao;

import com.gjh.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BlogDao extends JpaRepository<Blog,Long>,JpaSpecificationExecutor<Blog> {
Blog findByBid(Long id);

}
