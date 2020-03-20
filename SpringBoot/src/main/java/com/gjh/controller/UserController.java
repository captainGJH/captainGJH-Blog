package com.gjh.controller;

import com.gjh.dao.UserDao;
import com.gjh.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private UserDao userDao;
@PostMapping("addUser")
    public boolean addUser(User user)
    {
        return userDao.save(user)==user;
    }
@GetMapping("findAll")
    public List<User> findAll()
    {
        return userDao.findAll();
    }
    @GetMapping("findAll/uname/{uname}")
    public User findAlluname(@PathVariable String uname)
    {
        return userDao.findByUname(uname);
    }
    @GetMapping("findAll/uid/{uid}")
    public User findAlluid(@PathVariable int uid)
    {
        return userDao.findByUid(uid);
    }
    @GetMapping("findAll2/uname/{uname}")
    public List<User> findAllu(@PathVariable String uname)
    {
        return userDao.findByUnameLike("%"+uname+"%");
    }
    @GetMapping("findAll2/or/{uname}/{age}")
    public List<User> findAllor(@PathVariable String uname,@PathVariable String age)
    {
        return userDao.findByUnameOrUage(uname,age);
    }
}
