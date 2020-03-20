package biz.impl;

import biz.RolesBiz;
import dao.RolesDao;
import dao.impl.RolesDaoImpl;
import entity.Roles;

import java.util.List;

public class RolesBizImpl implements RolesBiz {
    private RolesDao dao=new RolesDaoImpl();
    @Override
    public List<Roles> query() {
        return dao.query();
    }
}
