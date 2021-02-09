package com.hezho;

import com.hezho.bean.Student;
import com.hezho.dao.StudentDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class TestGetMapper {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(reader);
        SqlSession session = build.openSession();
        // 使用 getMapper 就可以避免使用 sql 的全路径
        StudentDao studentDao = session.getMapper(StudentDao.class);
        List<Student> studentList = studentDao.getAll();
        for (Student student:studentList){
            System.out.println(student.getStudentName());
        }
    }
}
