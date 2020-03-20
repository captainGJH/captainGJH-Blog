package com.gjh.controller;



import com.github.pagehelper.PageHelper;
import com.gjh.dao.UserMapper;
import com.gjh.entity.User;
import com.gjh.entity.UserExample;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private UserMapper userMapper;

@PostMapping("addUser")
    public boolean addUser(@Valid User user, BindingResult result)
    {
        if(result.hasErrors())
        {

            return false;

        }
        return userMapper.insert(user)!=0;
    }
@GetMapping("findAll")
    public List<User> findAll()
    {
        PageHelper.startPage(1,2);
        return userMapper.selectByExample(null);
    }
    @GetMapping("findAll/uname/{uname}")
    public User findAlluname(@PathVariable String uname)
    {
        UserExample ue=new UserExample();
        ue.createCriteria().andUnameEqualTo(uname);
        return userMapper.selectByExample(ue).get(0);
    }
    @GetMapping("findAll/uid/{uid}")
    public User findAlluid(@PathVariable int uid)
    {
        return userMapper.selectByPrimaryKey(uid);
    }
    @GetMapping("findAll2/uname/{uname}")
    public List<User> findAllu(@PathVariable String uname)
    {
        UserExample ue=new UserExample();
        ue.createCriteria().andUnameLike("%"+uname+"%");

        return userMapper.selectByExample(ue);
    }
    @GetMapping("findAll2/or/{uname}/{age}")
    public List<User> findAllor(@PathVariable String uname,@PathVariable int age)
    {
        UserExample ue=new UserExample();
        ue.createCriteria().andUnameEqualTo(uname);
        ue.or().andAgeEqualTo(age);
        return userMapper.selectByExample(ue);
    }
    @GetMapping("findAll2/get/{age}")
    public List<User> findAllgetage(@PathVariable int age)
    {
        UserExample ue=new UserExample();
        ue.createCriteria().andAgeGreaterThan(age);

        return userMapper.selectByExample(ue);
    }
}
