package com.gjh.controller;




import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class Action1 {







@RequestMapping("1")
    public String ooo2()
    {
//redirect:show
        return "homepage";
    }



    @RequestMapping("blog")

    public String ooo5()
    {
//redirect:show
        return "blog";
    }


}
