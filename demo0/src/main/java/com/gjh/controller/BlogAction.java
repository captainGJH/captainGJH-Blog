package com.gjh.controller;

import com.gjh.dao.BlogDao;
import com.gjh.entity.Blog;
import com.gjh.entity.Comment;
import com.gjh.entity.User;
import com.gjh.service.*;
import com.gjh.vo.BlogQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class BlogAction {
    @Resource
    private BlogService blogService;
    @Resource
    private BlogTypeService blogTypeService;
    @Resource
    private AttentionService attentionService;

    @Resource
    private UserService userService;
    @Resource
    private BlogTagService blogTagService;

    @Resource
    private AttentionRedisService attentionRedisService;

    @PostMapping("/bsave")//保存博客
    public String save(Blog blog ,Model model)throws Exception {
        if(blog.getBflag()==""||blog.getBflag()==null){
            blog.setBflag("原创");
        }

        blog.setTags(blogTagService.listTag(blog.getTagIds()));

        blogService.saveBlog(blog);

        return "redirect:/blogget";

    }
    @RequestMapping("/editor")//写博客
    public String editor(Model model)throws Exception {
        setTypeAndTag(model);
        model.addAttribute("blog",new Blog());

        return "blog-text";
    }
    @RequestMapping("/redit/{uid}")//博客编辑
    public String redit(Model model,@PathVariable long uid)throws Exception {
        setTypeAndTag(model);
        Blog blog=blogService.getBlog(uid);
        blog.init();
        model.addAttribute("blog",blog);
        return "blog-text";
    }
    private void setTypeAndTag(Model model)throws Exception{//初始化类型和标签
        model.addAttribute("typeall",blogTypeService.listType());
        model.addAttribute("tagall",blogTagService.listTag());
    }
    @RequestMapping("/blogs/delect")//博客删除
    @ResponseBody
    public String delectBlog(long bid, RedirectAttributes attributes)throws Exception {

        Blog blog=blogService.getBlog(bid);
        blog.setBpublished("0");
        blogService.updateBlog(bid,blog);

      attributes.addFlashAttribute("message","删除成功");
        return "1";
    }

    @GetMapping("/blogdetails/{bid}")//博客详情
    @Transactional
    public String blogdetails(@PathVariable("bid")Long bid,Model model,HttpSession session)throws Exception{
        Blog blog=blogService.getMDBlog(bid);//调用方法会自动添加观看次数（bviews+1）
        if (session.getAttribute("user")!=null){
            User u=(User)session.getAttribute("user");
            Long lid=u.getUid();
            model.addAttribute("lid",lid);//用来前端页面判断是否显示关注按钮使用
            boolean isfollow=attentionRedisService.isFollowed(u.getUid(),blog.getUser().getUid());
            // model.addAttribute("isfollow",isfollow);
            session.setAttribute("isfollow",isfollow);
        }

             model.addAttribute("blog",blog);

        return "blog";
    }

    @RequestMapping("/blogget")//个人博客列表
    @Transactional
    public String blogget(Model model, @PageableDefault(size = 5,sort = {"bupdateTime"},direction = Sort.Direction.DESC)Pageable pageable, BlogQuery blog, HttpSession session)throws Exception
    {
        blog.setPublished("all");//除了删除的全部博客
        System.out.println(blog);
       User u=(User)session.getAttribute("user");
        blog.setUid(u.getUid());
        model.addAttribute("blogList",blogService.listBlog(pageable,blog));
        model.addAttribute("blogs",blog);
        model.addAttribute("listtype",blogTypeService.listType());
        return "myblogs";
    }
    @RequestMapping("/persiontext")//个人中心
    public String persiontext(HttpSession session,Model model)throws Exception{
        User u=(User)session.getAttribute("user");
//        int myFans=attentionService.getFans(u.getUid(),"1"); mysql中的关注粉丝表(备用)
//        int myFollow=attentionService.getFollow(u.getUid(),"1");
        Long myFans=attentionRedisService.myFansCount(u.getUid());
        Long myFollow=attentionRedisService.myFollowCount(u.getUid());
        model.addAttribute("myFans",myFans);
        model.addAttribute("myFollow",myFollow);
        return "homepage";
    }
    @RequestMapping("youindex/{uid}")//主页
    @Transactional
    public String youindex(Model model, @PageableDefault(size = 5,sort = {"bupdateTime"},direction = Sort.Direction.DESC)Pageable pageable, BlogQuery blog,@PathVariable long uid,HttpSession session)throws Exception
    {
        zhuye(session,model,uid);
        blog.setPublished("1");//发布的博客
        blog.setUid(uid);

        model.addAttribute("yblogList",blogService.listBlog(pageable,blog));
        return "your-index";
    }
    @RequestMapping("follow/{uid}")//他的关注
    @Transactional
    public String follow(Model model ,@PathVariable long uid,HttpSession session)throws Exception
    {
      zhuye(session,model,uid);

        model.addAttribute("myfollows", attentionRedisService.getFollows(uid));

        return "your-index-follow";
    }
    @RequestMapping("fans/{uid}")//他的fans
    @Transactional
    public String fans(Model model ,@PathVariable long uid,HttpSession session)throws Exception
    {
        zhuye(session,model,uid);

        model.addAttribute("myfans", attentionRedisService.getFans(uid));

        return "your-index-fans";
    }


    //主页和他的关注页 的共享
    private void zhuye(HttpSession session,Model model,Long uid)throws Exception{

        if (session.getAttribute("user")!=null){
            User u=(User)session.getAttribute("user");
            Long lid=u.getUid();
            model.addAttribute("lid",lid);//用来前端页面判断是否显示关注按钮使用
            boolean isfollow=attentionRedisService.isFollowed(u.getUid(),uid);
            // model.addAttribute("isfollow",isfollow);
            session.setAttribute("isfollow",isfollow);
        }
        User user=userService.getUid(uid);
//        int myFans=attentionService.getFans(uid,"1");//查询粉丝人数
//        int myFollow=attentionService.getFollow(uid,"1");//查询关注人数
        Long myFans=attentionRedisService.myFansCount(uid);//查询粉丝人数
        Long myFollow=attentionRedisService.myFollowCount(uid);//查询关注人数
        model.addAttribute("myuser",user);
        model.addAttribute("myFans",myFans);
        model.addAttribute("myFollow",myFollow);

    }
    @RequestMapping("/Addfollow")//添加/取消关注
    @ResponseBody
    @Transactional
    public String Addfollow(Long followId,HttpSession session)throws Exception{
        User user=(User)session.getAttribute("user");
        if(user==null)
        {
            return "0";
        }
        boolean isfollow=attentionRedisService.isFollowed(user.getUid(),followId);
        if (isfollow==true) {

            attentionRedisService.unFollow(user.getUid(),followId);
            session.setAttribute("isfollow",false);
            return "2";
        }
        attentionRedisService.follow(user.getUid(),followId);
        session.setAttribute("isfollow",true);
        return "1";
    }





}
