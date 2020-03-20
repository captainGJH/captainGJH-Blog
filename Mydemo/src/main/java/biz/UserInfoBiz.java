package biz;

import entity.UserInfo;

public interface UserInfoBiz {
    public UserInfo login(String name, String pwd);
    public boolean add(UserInfo user);
}
