package com.gjh.controller;

import com.gjh.elasticsearch.ESBlog;
import com.gjh.elasticsearch.ESBlogDao;
import com.gjh.entity.Blog;
import com.gjh.service.BlogService;
import com.gjh.service.BlogTypeService;
import com.gjh.service.ESBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexAction {
@Resource
private BlogService blogService;
@Resource
private BlogTypeService blogTypeService;
@Resource
private ESBlogService esBlogService;
    @Resource
    private ESBlogDao esBlogDao;

    @RequestMapping("/")//首页
    public String ooo1(Model model, @PageableDefault(size = 4,sort = {"bviews"},direction = Sort.Direction.DESC)Pageable pageable)throws Exception
    {
        model.addAttribute("blogtype",blogTypeService.listType());
//        model.addAttribute("indexlist",blogService.listBlog(pageable));
        model.addAttribute("indexlist",esBlogService.getESIndex(pageable));
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


    @RequestMapping("/search")//使用了ES全局搜索
    public String search(String query,@PageableDefault(size = 8,sort = {"bupdateTime"},direction = Sort.Direction.DESC)Pageable pageable,Model model) throws Exception{


        model.addAttribute("searchlist",esBlogService.getESquery(query,pageable));
      //  model.addAttribute("searchlist",blogService.listBlog("%"+query+"%",pageable)); //这个是mysql的查询
        model.addAttribute("query",query);
        return "search";
    }

    @RequestMapping("/essearch")//测试
    @ResponseBody
    public String essearch(String query, Pageable pageable) throws Exception{
        Pageable pageable1= PageRequest.of(0,20);

ESBlog esBlog=new ESBlog();
        Page<Blog> list=blogService.listBlog(pageable1);

        for(Blog blog:list){
            System.out.println(blog.getBid());
            esBlog.setTname(blog.getBlogType().getTname());
            esBlog.setUnickname(blog.getUser().getUnickname());
            esBlog.setUid(blog.getUser().getUid());
            esBlog.setBtitle(blog.getBtitle());
            esBlog.setBid(blog.getBid());
            esBlog.setBcontent(blog.getBcontent());
            esBlog.setBfristImg(blog.getBfristImg());
            esBlog.setBupdateTime(blog.getBupdateTime());
            esBlog.setDescription(blog.getDescription());
            esBlog.setUheadimg(blog.getUser().getUheadimg());
            esBlog.setBpublished(blog.getBpublished());
            esBlog.setBviews(blog.getBviews());
            esBlogDao.index(esBlog);

        }


     //   Page<ESBlog> page= ESBlogService.getESquery(query,pageable);

       // return page.getContent();
        return "";
    }



}
