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

    public List<Student> findInList(List<Integer> studentList);

    public List<Student> findInArray(int[] studentArray);

    public List<Student> findInMap(Map studentMap);

    public List<Student> findByAmbigulous(Map map);

    public Student findByStudent(Student student);

    public List<Student> findInRange(Map map);

    public List<Student> findInRange2(Map map);
}
