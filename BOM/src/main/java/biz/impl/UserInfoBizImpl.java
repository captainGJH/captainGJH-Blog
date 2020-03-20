package biz.impl;

import biz.UserInfoBiz;
import dao.UserInfoDao;
import dao.impl.UserInfoDaoImpl;
import entity.UserInfo;

public class UserInfoBizImpl implements UserInfoBiz {
    private UserInfoDao dao=new UserInfoDaoImpl();
    @Override
    public UserInfo login(String uname, String upwd) {
        if("".equals(uname)||"".equals(upwd))
        {
            return null;
        }
        return dao.login(uname,upwd);
    }

    @Override
    public boolean add(UserInfo user) {
        return dao.add(user);
    }
}
