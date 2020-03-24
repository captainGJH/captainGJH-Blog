package com.gjh.service.impl;


import com.gjh.NotFoundException;
import com.gjh.dao.BlogDao;
import com.gjh.elasticsearch.ESBlog;
import com.gjh.elasticsearch.ESBlogDao;
import com.gjh.entity.Blog;
import com.gjh.entity.BlogType;
import com.gjh.service.BlogService;
import com.gjh.util.MarkdownUtils;
import com.gjh.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{


    @Resource
    private BlogDao blogDao;
    @Resource
    private ESBlogDao esBlogDao;

    @Override
    public Blog getBlog(Long id) {

        return blogDao.findByBid(id);
    }

    @Override
    public Blog getMDBlog(Long id) {
     Blog b=blogDao.findByBid(id);
     ESBlog esBlog=esBlogDao.findByBid(id);
        b.setBviews(b.getBviews()+1);
        esBlog.setBviews(b.getBviews()+1);
   if(b==null){
     throw new NotFoundException("博客不存在");
        }
        Blog blog=new Blog();
        BeanUtils.copyProperties(b,blog);//将b的内容copy给blog
        String content=blog.getBcontent();
        blogDao.save(blog);//将view的值修改
        esBlogDao.save(esBlog);//将es中的view的值修改
        blog.setBcontent(MarkdownUtils.markdownToHtmlExtensions(content));
        return blog;
    }

    @Override
    public List<Blog> listNewsBlog(Integer size) {
        Sort order=Sort.by(Sort.Direction.DESC, "bupdateTime");
        PageRequest request = PageRequest.of(0,size,order);

        return blogDao.findNew(request);
    }

//    @Override
//    public Page<Blog> listBlog(Pageable pageable) {
//        return blogDao.findAll(new Specification<Blog>() {
//            @Nullable
//            @Override
//            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
//                List<Predicate> predicateList=new ArrayList<>();
//                predicateList.add(cb.equal(root.get("bpublished"),"1"));
//                cq.where(predicateList.toArray(new Predicate[predicateList.size()]));
//                return null;
//            }
//        },pageable);
//    }
@Override
public Page<Blog> listBlog(Pageable pageable) {
  return blogDao.findAll(pageable);
}

    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blogQuery) {


        return blogDao.findAll(new Specification<Blog>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicateList=new ArrayList<>();
                if(blogQuery.getUid()!=null){
                    predicateList.add(cb.equal(root.get("user").get("uid"),blogQuery.getUid()));

                    if ("all".equals(blogQuery.getPublished())){
                        predicateList.add(cb.notEqual(root.get("bpublished"),"0"));
                    }
                    if (!"".equals(blogQuery.getPublished()) && blogQuery.getPublished()!=null && !"all".equals(blogQuery.getPublished()) ){
                        predicateList.add(cb.equal(root.get("bpublished"),blogQuery.getPublished()));

                    }

                    if(!"".equals(blogQuery.getTitle()) && blogQuery.getTitle()!=null) {
                        predicateList.add(cb.like(root.<String>get("btitle"), "%" + blogQuery.getTitle() + "%"));
                    }
                if(!"".equals(blogQuery.getFlag()) && blogQuery.getFlag()!=null) {
                    predicateList.add(cb.equal(root.<String>get("bflag"),blogQuery.getFlag()));

                }
                    if(blogQuery.getTypeid()!= null)
                    {
                        predicateList.add(cb .equal(root.<BlogType>get("blogType").get("tid"),blogQuery.getTypeid()));

                    }
                    cq.where(predicateList.toArray(new Predicate[predicateList.size()]));//转化成数组


                }
                return null;
            }
        },pageable);
    }
    @Transactional
    @Override
    public Blog saveBlog(Blog blog) {
        if(blog.getBid()==0){
            blog.setBupdateTime(new Date());
            blog.setBcreateTime(new Date());
            blog.setBviews(0);
        }else
            {
                blog.setBupdateTime(new Date());
            }

        return blogDao.save(blog);
    }
    @Transactional
    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog b=blogDao.findByBid(id);
        if(b == null)
        {
            throw new NotFoundException("该博客不存在");

        }
        BeanUtils.copyProperties(b,blog);//将blog里面的属性值赋值给b
        return blogDao.save(b);
    }
@Transactional
    @Override
    public void removeBlog(Long id) {
        blogDao.deleteById(id);
    }


//    @Override
//    public Page<Blog> listBlog(String query, Pageable pageable) {
//        return blogDao.getQuery(query,pageable);
//    }
}
