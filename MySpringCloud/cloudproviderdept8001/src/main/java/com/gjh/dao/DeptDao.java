package com.gjh.dao;

import com.gjh.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {
    public boolean add(Dept dept);
    public Dept findById(int id);
    public List<Dept> findDept();
}
