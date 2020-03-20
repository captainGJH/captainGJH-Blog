package com.gjh.controller;


import com.gjh.entity.Dept;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class HelloController80 {
    private static final String path="http://localhost:8001/";
    @Resource
    RestTemplate restTemplate;
    @RequestMapping("findall2")
    public String findal2(Model model)
    {

        System.out.println("666666666666");
   //   List<Dept> list= restTemplate.getForObject(path+"findall1",List.class);
     //  model.addAttribute("list",list);
        return "index";
    }


}
