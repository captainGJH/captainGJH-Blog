package com.gjh.service;

import com.gjh.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(Comment comment);

    List<Comment> listCommentByBid(Long bid);
}
