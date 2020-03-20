package com.gjh.config;


import com.gjh.entity.User;
import com.gjh.service.UserService;
import com.gjh.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserService userService;
    @Autowired
    private MyUserDetailService myUserDetailService;

@Bean
protected PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}



    @Override//请求授权的规则
    protected void configure(HttpSecurity http) throws Exception {


        //首页所有人可以访问
        //这边的ADMIN需要与MyUserDetailService中的ROLE_ADMIN，ROLE_后面的名字一样
        // 否则会报403的错误permitAll()全部
        http
                .authorizeRequests()
                .antMatchers("/bsave").hasAnyAuthority("PRODUCT_USER")
                .antMatchers("/persiontext").hasAnyAuthority("PRODUCT_USER")
                .antMatchers("/editor").hasAnyAuthority("PRODUCT_USER")
                .antMatchers("/comments").hasAnyAuthority("PRODUCT_USER")
                .antMatchers("/bsave").hasAnyAuthority("PRODUCT_USER")
                .antMatchers("/redit/{uid}").hasAnyAuthority("PRODUCT_USER")
                .antMatchers("/blogs/delect").hasAnyAuthority("PRODUCT_USER")
                .antMatchers("/Addfollow").hasAnyAuthority("PRODUCT_USER")
//                .antMatchers("/**")禁用全部
//                .fullyAuthenticated()
                .and()
                .formLogin().loginPage("/login").successHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                HttpSession session=request.getSession();
                RequestCache requestCache = new HttpSessionRequestCache();
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                User  user=userService.reEmail(userDetails.getUsername());
                session.setAttribute("user",user);
                response.setContentType("application/json;charset=utf-8");

                String url = null;
                SavedRequest savedRequest = requestCache.getRequest(request,response);
                if(savedRequest != null){
                    url = savedRequest.getRedirectUrl();
                   response.sendRedirect(url);
                }  if(url == null){
                    response.sendRedirect("/");
                }


            }
        })
                .and()
                .csrf().disable();//跨站请求伪造直接关闭

//                .antMatchers("/blogdetails/{bid}").hasRole("ADMIN")
//                .antMatchers("/persiontext").hasAnyAuthority("PRODUCT_ADD")
//                .antMatchers("/editor").hasAnyAuthority("PRODUCT_UPDATE");

   //返回了权限默认的登录页面
//  http.formLogin();
        //登录成功处理


    }

    //认证


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//
//
//    }





}
