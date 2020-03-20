package com.gjh.controller;

import com.gjh.biz.DeptBiz;
import com.gjh.entity.Dept;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController

public class DeptController {
    @Resource
    private DeptBiz deptBiz;
    @GetMapping("findbyid/{id}")
    public Dept findbyid(@PathVariable int id)
    {
        return deptBiz.findById(id);
    }@GetMapping("findall")
    public List<Dept> findall()
    {
        return deptBiz.findDept();
    }


}
