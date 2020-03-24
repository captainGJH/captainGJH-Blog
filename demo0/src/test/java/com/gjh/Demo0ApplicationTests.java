package com.gjh;



import com.gjh.entity.Blog;
import com.gjh.service.BlogService;

import com.gjh.util.RedisUtils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;

@SpringBootTest
public class Demo0ApplicationTests {
@Resource
private RedisUtils redisUtils;



	@Resource
	private BlogService service;

	@Autowired
	private JavaMailSender mailSender;
//	@Autowired
//	private JestClient jestClient;






//	@Test
//	public void aaa(){
//
//		Pageable pageable=PageRequest.of(0,20);
//
//
//		Page<Blog> list=service.listBlog(pageable);
//
//		for(Blog blog:list){
//
//
//			System.out.println(blog.getBid());
//		}
//
//	}


//	@Test
//	public void contextLoads()  {
//		//给es中保存索引
//		Long l=new Long("3");
//		BlogQuery blog =new BlogQuery();
//		blog.setUid(l);
//		blog.setPublished("111");
//		blog.setTitle("唐诗三百首");
//		blog.setFlag("原创");
//		//构建一个索引
//		Index index=new Index.Builder(blog).index("captainblog").type("blog01").build();
//		try {
//			jestClient.execute(index);
//		}catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//
//
//
//	}
//	@Test
//	public void search() throws IOException {
//		String json="{\n" +
//				"    \"query\" : {\n" +
//				"        \"match\" : {\n" +
//				"            \"title\" : \"唐诗\"\n" +
//				"        }\n" +
//				"    }\n" +
//				"}";
//		ESBlogDao search=new ESBlogDao.Builder(json).addIndex("captainblog").addType("blog01").build();
//
//
//		SearchResult result=jestClient.execute(search);
//		System.out.println(result.getJsonObject());
//	}

}
