package com.gjh.controller;

import com.github.pagehelper.PageHelper;
import com.gjh.dao.NewsDao;
import com.gjh.entity.News;
import com.sun.xml.internal.ws.api.ServiceSharedFeatureMarker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.beans.Transient;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class Action1 {
    @Resource
    NewsDao newsDao;
    @RequestMapping("out")
    public String out(HttpSession session)
    {
        session.removeAttribute("user");
      return "redirect:show";
    }
    @RequestMapping("newsAdd")
    public String newsAdd()
    {

        return "addBook";
    }
    @RequestMapping("addnews")
    public String addnews(News news,Model model)
    {

        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String time=df.format(date);
        news.setTime(time);
        newsDao.save(news);
        model.addAttribute("msg",1);
        return "addBook";
    }


    @RequestMapping("show")
    public String show(Model model)
    {
        List<News> list1=newsDao.findByOx(1);
        List<News> list2=newsDao.findByOx(2);
        List<News> list3=newsDao.findByOx(3);
        List<News> listAll=newsDao.findAll();
        model.addAttribute("list1",list1);
        model.addAttribute("list2",list2);
        model.addAttribute("list3",list3);
        model.addAttribute("listAll",listAll);
        return "index";
    }
@RequestMapping("ooo")
    public String ooo()
{
    return "success";
}
@RequestMapping("aaa")
    public String aaa()
{
    return "index";
}

}
