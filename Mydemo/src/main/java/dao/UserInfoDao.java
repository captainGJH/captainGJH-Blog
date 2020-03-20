package dao;

import entity.UserInfo;

public interface UserInfoDao {

    public UserInfo login(String name, String pwd);
    public boolean add(UserInfo user);
}
