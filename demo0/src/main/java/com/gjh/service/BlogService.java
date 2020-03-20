package com.gjh.service;

import com.gjh.entity.Blog;
import com.gjh.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {


    Blog getBlog(Long id);

    Blog getMDBlog(Long id);//对详情页内容进行markdown的转换

    Page<Blog> listBlog(Pageable pageable,BlogQuery blogQuery);//条件分页显示

    Page<Blog> listBlog(Pageable pageable);//首页分页显示

    Page<Blog> listBlog(String query,Pageable pageable);//全局搜索

    List<Blog> listNewsBlog(Integer size);//最新推荐;

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    void removeBlog(Long id);
}
