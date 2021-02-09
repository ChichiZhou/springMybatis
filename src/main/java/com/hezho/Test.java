package com.hezho;

import com.hezho.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        // 加载配置文件
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        // 得到sqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(reader);
        // 得到 session
        SqlSession session = build.openSession();
        // 操作 sql，传入的参数是sql语句的完整路径，返回值和接口中方法的返回值相同
        List<Student> studentList = session.selectList("com.hezho.dao.StudentDao.getAll");
        // 遍历
        for (Student student : studentList){
            System.out.println(student.getStudentName());
        }
        // 关闭资源


        Student student = session.selectOne("com.hezho.dao.StudentDao.getAll",1); // 在这里输入查询所需要的参数
        System.out.println(student.getStudentName());

        session.insert("com.hezho.dao.StudentDao.insertRecord", new Student("binzhu",3));
        // 做增删改的时候，要使用事务
        session.commit();

        session.close();
        reader.close();

    }
}
