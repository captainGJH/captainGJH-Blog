package com.gjh.controller;

import com.gjh.biz.DeptBiz;
import com.gjh.entity.Dept;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestControlle
public class HelloController {
    @Resource
    private DeptBiz deptBiz;
    @GetMapping("findall1")
    public List<Dept> findall()
    {
        System.out.println("00000");
        List<Dept> list=deptBiz.findDept();

        return list;
    }

}
