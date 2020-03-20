package dao.impl;

import dao.UserInfoDao;
import entity.UserInfo;
import util.JDBCUTIL;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

/**
 * @Auther: mxt
 * @Date: 2019/10/9 14:18
 * @Description:
 */
public class UserInfoDaoImpl implements UserInfoDao {
    private JDBCUTIL util = new JDBCUTIL();

    @Override
    public UserInfo login(String name, String pwd) {
        UserInfo user = null;
        String sql = "select * from t_user where u_name=? and u_pwd=?";
        ResultSet rs = util.select(sql, name, pwd);
        try {
            if (rs.next()) {
                user = new UserInfo();
                user.setDeptid(rs.getInt("deptid"));
                user.setDutyid(rs.getInt("dutyid"));
                user.setEnduid(rs.getInt("enduid"));
                Date date = rs.getDate("joindate");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (date != null) {
                    user.setJoindate(format.format(date));
                }
                user.setRoleid(rs.getInt("roleid"));
                user.setU_id(rs.getInt("u_id"));
                user.setU_name(rs.getString("u_name"));
                user.setU_pwd(rs.getString("u_pwd"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.closeAll();
        }
        return user;
    }

    @Override
    public boolean add(UserInfo user) {
        return util.add("insert into t_user(u_name,u_pwd,roleid,dutyid,deptid,joindate,enduid) values(?,?,?,?,?,STR_TO_DATE(?,'%Y-%m-%d'),?)",
                user.getU_name(),user.getU_pwd(),user.getRoleid(),user.getDutyid(),user.getDeptid(),user.getJoindate(),user.getEnduid());

    }
}
