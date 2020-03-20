package com.gjh.controller;

import com.gjh.entity.Blog;
import com.gjh.service.BlogService;
import com.gjh.service.BlogTypeService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.validation.constraints.PastOrPresent;

@Controller
public class IndexAction {
@Resource
private BlogService blogService;
@Resource
private BlogTypeService blogTypeService;

    @RequestMapping("/")
    public String ooo1(Model model, @PageableDefault(size = 4,sort = {"bviews"},direction = Sort.Direction.DESC)Pageable pageable)throws Exception
    {
        model.addAttribute("blogtype",blogTypeService.listType());
        model.addAttribute("indexlist",blogService.listBlog(pageable));
       model.addAttribute("newblog",blogService.listNewsBlog(4));
        return "index";
    }
    @GetMapping("/forbiddenError")//权限控制跳转403
    public String forbidden()throws Exception{
        return "error/403";
    }

@RequestMapping("/login")//登录界面
    public String login()throws Exception{
        return "login";
}
    @GetMapping("register")//注册界面
    public String register()throws Exception{
        return "register";
    }


    @RequestMapping("/search")
    public String search(String query,@PageableDefault(size = 8,sort = {"bupdateTime"},direction = Sort.Direction.DESC)Pageable pageable,Model model) throws Exception{



        model.addAttribute("searchlist",blogService.listBlog("%"+query+"%",pageable));
        model.addAttribute("query",query);
        return "search";
    }
}
