package com.gjh.controller;

import com.gjh.entity.Comment;
import com.gjh.entity.User;
import com.gjh.service.BlogService;
import com.gjh.service.CommentService;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class CommentAction {
@Resource
private CommentService commentService;
@Resource
private BlogService blogService;


@GetMapping("/comments/{blogId}")//评论的局部刷新
public String comments(@PathVariable Long blogId, Model model){
    model.addAttribute("comments",commentService.listCommentByBid(blogId));

    return "blog :: commentList";
}

    @RequestMapping("/comments")//评论
    @Transactional
    public String mycomment(Comment comment, HttpSession session){
    User user=(User) session.getAttribute("user");
        Long blogId=blogId= comment.getBlog().getBid();
        if (user==null) {
            return "redirect:/blogdetails/" + blogId;
        }
            comment.setBlog(blogService.getBlog(blogId));
            comment.setUid(user.getUid());
            comment.setHeadimg(user.getUheadimg());
            comment.setNickname(user.getUnickname());
            commentService.addComment(comment);

        return "redirect:/comments/" + blogId;
    }

}
