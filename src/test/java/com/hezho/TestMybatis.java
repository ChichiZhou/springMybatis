package com.hezho;


import com.hezho.bean.Student;
import com.hezho.dao.StudentDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {
    Reader reader;

    {
        try {
            reader = Resources.getResourceAsReader("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 得到sqlSessionFactoryBuilder
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory build = builder.build(reader);
    // 得到 session
    SqlSession session = build.openSession();
    // 操作 sql，传入的参数是sql语句的完整路径，返回值和接口中方法的返回值相同

    @Test
    public void testMybatis(){
        List<Student> studentList = session.selectList("com.hezho.dao.StudentDao.getAll");
        // 遍历
        for (Student student : studentList){
            System.out.println(student.getStudentName());
        }
        // 关闭资源

        Student student = session.selectOne("com.hezho.dao.StudentDao.findById",1); // 在这里输入查询所需要的参数
        System.out.println(student.getStudentName());

        session.insert("com.hezho.dao.StudentDao.insertRecord", new Student(4,"chenshuaishuai"));
        // 做增删改的时候，要使用事务
        session.commit();

        session.close();
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetMapper(){
        StudentDao studentDao = session.getMapper(StudentDao.class);
        List<Student> studentList = studentDao.getAll();
        for (Student student:studentList){
            System.out.println(student.getStudentName());
        }
        session.close();
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMap(){
        Map map = new HashMap<String, Object>();
        map.put("sno", 5);
        map.put("sname","binbinzhu");
        session.insert("com.hezho.dao.StudentDao.insertRecordByMap", map);
        session.commit();
        session.close();
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStatics(){
        Map<String, Object> map = session.selectOne("com.hezho.dao.StudentDao.findStatics");
        for(Map.Entry entry : map.entrySet()){
            System.out.println(entry);
        }
        session.close();
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
