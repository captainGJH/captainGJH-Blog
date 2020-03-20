package com.gjh.biz;

import com.gjh.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface DeptBiz {

    public Dept findById(int id);
    public List<Dept> findDept();
}
