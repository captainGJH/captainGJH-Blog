package com.gjh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HolleController {
    @RequestMapping("hello")
    public String holle(Model model)
    {
        model.addAttribute("msg","hello");
        return "index";
    }
}
