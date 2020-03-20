package com.gjh.dao;

import com.gjh.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDao extends JpaRepository<Student,Integer> {
    public List<Student> findBySname(String name);
    public List<Student> findBySdept(String sdept);
    public List<Student> findByTeacher_Tname(String tname);
    public List<Student> findBySdeptAndTeacher_Tsex(String sdept, String tsex);

    @Query("from Student stu where stu.teacher.tsex=?1")
    public List<Student> queryByTeacherTsex(@Param("tsex") String tsex);
    @Query("select stu.teacher.tname,count(stu.sid) from Student stu group by  stu.teacher.tname")
    public List<Object[]> queryTnameAndCount();
}
