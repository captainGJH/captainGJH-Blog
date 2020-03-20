package com.gjh.controller;

import com.gjh.entity.Dept;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("oooo")
public class DeptController80 {
    private static final String path="http://localhost:8001/";

    @Resource
    RestTemplate restTemplate;

    @GetMapping("consumer/findbyid/{id}")
    public Dept findbyid(@PathVariable int id)
    {
        return restTemplate.getForObject(path+"findbyid/"+id,Dept.class);
    }
    @GetMapping("consumer/findall")
    public List<Dept> findall()
    {
        return restTemplate.getForObject(path+"findall",List.class);
    }
}
