package com.hezho.dao;

import com.hezho.bean.Grade;
import com.hezho.bean.Student;

import java.util.List;

public interface GradDao {
    public Grade findByGrade(int id);   // 这里返回的是 Grade

    public List<Student> findAllStudent(); // 查询所有学生以及每个学生的年级信息
}
