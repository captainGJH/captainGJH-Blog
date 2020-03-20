package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexAction {

    @RequestMapping("index")
    public String index()
    {
        return  "login";
    }
    @RequestMapping("useradd")
    public String useradd()
    {
        return  "adduser";
    }
}
