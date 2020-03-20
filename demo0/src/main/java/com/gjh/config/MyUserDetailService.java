package com.gjh.config;

import com.gjh.service.UserService;
import com.gjh.util.MD5;
import com.gjh.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
/**
 * 重写了UserDetailsService中的方法来达到将默认页面的用户名变为输入username的模式
 * 和将密码修改为设置的模式 不过不能使用明文的密码 所以我们还需要定义一个的加密类
 * 也就是前面做的SecurityConfig类了
 * **/
public class MyUserDetailService implements UserDetailsService {

    @Resource
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.gjh.entity.User user=userService.reEmail(username);

        if(user==null){
            throw new UsernameNotFoundException("用户不存在");
        }

        Collection<GrantedAuthority> collection=authorities();
        return new User(username,user.getUpwd(), collection);//多个角色


    //   单个角色权限可以这么写 return new User(username, pwd, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));

    }
    private Collection<GrantedAuthority> authorities(){
        List<GrantedAuthority> list=new ArrayList<>();
        list.add(new SimpleGrantedAuthority("PRODUCT_ADMIN"));
        list.add(new SimpleGrantedAuthority("PRODUCT_USER"));
        return list;
    }
}
