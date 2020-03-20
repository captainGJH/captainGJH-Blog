package controller;

import biz.RolesBiz;
import biz.UserInfoBiz;
import biz.impl.RolesBizImpl;
import biz.impl.UserInfoBizImpl;
import entity.Roles;
import entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserInfoAction {

private UserInfoBiz userbiz=new UserInfoBizImpl();

    private RolesBiz rb=new RolesBizImpl();
    @RequestMapping("useradd")
    public String useradd(Model model)
    {

        List<Roles> list=rb.query();
        model.addAttribute("li",list);
        return  "adduser";
    }




@RequestMapping("add")
    public String add( UserInfo user,Model model)
    {
        if(userbiz.add(user))
        {
            model.addAttribute("msg","添加成功");
        }else
            {
                model.addAttribute("msg","添加失败");
            }

            return "adduser";

    }

@RequestMapping("login")
    public String login(String uname ,String upwd,Model model )
{
    UserInfo user=userbiz.login(uname,upwd);
if(user!=null)
{
model.addAttribute("msg","登录成功:"+user.getU_name());

return "welcome";
}else
    {
        model.addAttribute("msg","登录失败");

        return "login";
    }

}
}
