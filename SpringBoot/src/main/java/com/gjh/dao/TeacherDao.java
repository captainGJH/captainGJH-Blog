package com.gjh.dao;

import com.gjh.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDao extends JpaRepository<Teacher,Integer> {
    public Teacher findByTid(int tid);
}
