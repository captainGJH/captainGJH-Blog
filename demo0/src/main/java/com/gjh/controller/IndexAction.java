package com.gjh.controller;

import com.gjh.entity.Blog;
import com.gjh.service.BlogService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class IndexAction {
@Resource
private BlogService blogService;

    @RequestMapping("/")
    public String ooo1(Model model, @PageableDefault(size = 4,sort = {"bviews"},direction = Sort.Direction.DESC)Pageable pageable)
    {
        model.addAttribute("indexlist",blogService.listBlog(pageable));
    //   model.addAttribute("newblog",blogService.listNewsBlog(4));

        return "index";
    }



}
