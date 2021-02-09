package com.hezho.dao;

import com.hezho.bean.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    // 增删改查的方法
    public List<Student> getAll();
    // Find by id
    public Student findById(int id);
    // 插入
    public int insertRecord(Student student);

    public int insertRecordByMap(Map map);

    public Map<String, Object> findStatics();
}
