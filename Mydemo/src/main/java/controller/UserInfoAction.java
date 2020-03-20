package controller;

import biz.CodesBiz;
import biz.RolesBiz;
import biz.UserInfoBiz;
import biz.impl.CodesBizImpl;
import biz.impl.RolesBizImpl;
import biz.impl.UserInfoBizImpl;
import entity.Codes;
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
    private CodesBiz cb=new CodesBizImpl();
    @RequestMapping("u")
    public String useradd(Model model)
    {

        List<Codes> zhiwu=cb.queryByType("职务");
        List<Codes> bumen=cb.queryByType("部门");
        List<Codes> xueli=cb.queryByType("学历");
        List<Roles> list=rb.query();
        model.addAttribute("list",list);
        model.addAttribute("zhiwu",zhiwu);
        model.addAttribute("bumen",bumen);
        model.addAttribute("xueli",xueli);


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

            return useradd(model);

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
