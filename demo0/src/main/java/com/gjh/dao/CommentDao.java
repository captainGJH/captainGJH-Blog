package com.gjh.dao;

import com.gjh.entity.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,Long>{
 List<Comment> findByBlogBidAndParentCommentNull(Long bid, Sort sort);
 Comment findByCid(Long cid);
}
