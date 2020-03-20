package dao.impl;

import dao.RolesDao;
import entity.Roles;
import util.JDBCUTIL;
import util.JDBCUTIL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mxt
 * @Date: 2019/10/9 15:48
 * @Description:
 */
public class RolesDaoImpl implements RolesDao {
    private JDBCUTIL util = new JDBCUTIL();

    @Override
    public List<Roles> query() {
        List<Roles> list = new ArrayList<>();
        ResultSet rs = util.select("select * from t_role");
        try {
            while (rs.next()) {
                Roles r = new Roles(rs.getInt("roleid"), rs.getString("rolename"), rs.getString("power"));
                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.closeAll();
        }
        return list;
    }
}
