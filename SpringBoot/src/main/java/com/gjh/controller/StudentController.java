package com.gjh.controller;

import com.gjh.dao.StudentDao;
import com.gjh.dao.TeacherDao;
import com.gjh.entity.Student;
import com.gjh.entity.Teacher;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class StudentController {
    @Resource
    StudentDao studentDao;
    @Resource
    TeacherDao teacherDao;

    @PostMapping("add")
    public boolean add(Student student, Teacher teacher)
    {
        student.setTeacher(teacher);
        return studentDao.save(student)!=null;

    }
    @PostMapping("adds/{tid}")
    public boolean adds(@PathVariable int tid,Student student)
    {
        Teacher t=teacherDao.findByTid(tid);
        student.setTeacher(t);
        return studentDao.save(student)!=null;

    }
    @GetMapping("select")
    public List<Student> select()
    {
        return studentDao.findAll();
    }

    @GetMapping("select1/{tsex}")
    public List<Student> queryByTeacherTsex( @PathVariable String tsex)
    {
     return studentDao.queryByTeacherTsex(tsex);
    }
    @GetMapping("select2")
    public List<Object[]> quer( )
    {
        return studentDao.queryTnameAndCount();
    }
}
