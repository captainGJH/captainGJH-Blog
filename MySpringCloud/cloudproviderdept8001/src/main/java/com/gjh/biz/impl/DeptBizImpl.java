package com.gjh.biz.impl;

import com.gjh.biz.DeptBiz;
import com.gjh.dao.DeptDao;
import com.gjh.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptBizImpl implements DeptBiz{
   @Resource
   private DeptDao deptDao;
    public Dept findById(int id)
    {
        return deptDao.findById(id);

    };
    public List<Dept> findDept()
    {
        return deptDao.findDept();
    };
}
