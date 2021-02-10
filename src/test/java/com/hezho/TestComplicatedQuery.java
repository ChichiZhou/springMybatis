package com.hezho;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hezho.bean.Grade;
import com.hezho.bean.Student;
import com.hezho.bean.Wife;
import com.hezho.dao.GradDao;
import com.hezho.dao.StudentDao;
import com.hezho.dao.WifeDao;
import com.hezho.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class TestComplicatedQuery {
    @Test
    public void testComplicatedList(){
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        // 匿名 ArrayList
        List<Student> findInList = studentDao.findInList(new ArrayList<Integer>(Arrays.asList(1,2,3)));
        // 输出
        for (Student student : findInList){
            System.out.println(student.getStudentName());
        }

        // 关闭
        SqlSessionUtil.closeSession();
    }

    @Test
    public void testComplicatedArray(){
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        List<Student> findInList = studentDao.findInArray(new int[]{1,2,3});
        for (Student student : findInList){
            System.out.println(student.getStudentName());
        }

        // 关闭
        SqlSessionUtil.closeSession();
    }

    @Test
    public void testComplicatedMap(){
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        int[] array = new int[]{1,2,3};
        Map<String, Object> map = new HashMap<>();
        map.put("ids", array);
        List<Student> findInList = studentDao.findInMap(map);
        for (Student student : findInList){
            System.out.println(student.getStudentName());
        }

        // 关闭
        SqlSessionUtil.closeSession();
    }

    @Test
    public void testAmbigulous(){
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Map map = new HashMap();
        map.put("stuname", "hez");
        List<Student> findInList = studentDao.findByAmbigulous(map);

        for (Student student : findInList){
            System.out.println(student.getStudentName());
        }
        // 关闭
        SqlSessionUtil.closeSession();
    }

    @Test
    public void testFindByStudent(){
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Student targetStudent = new Student(0,"hez",1);
        Student resultStudent = studentDao.findByStudent(targetStudent);

        System.out.println(resultStudent.getStudentName());
        // 关闭
        SqlSessionUtil.closeSession();
    }

    @Test
    public void testBetween(){
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("begin", 1);
        map.put("end", 5);

        List<Student> studentList = studentDao.findInRange(map);
        for (Student student : studentList){
            System.out.println(student.getStudentName());
        }

        List<Student> studentList2 = studentDao.findInRange2(map);
        for (Student student : studentList2){
            System.out.println(student.getStudentName());
        }

        // 关闭
        SqlSessionUtil.closeSession();
    }

    @Test
    public void testGrade(){
        SqlSession session = SqlSessionUtil.getSession();
        GradDao gradDao = session.getMapper(GradDao.class);

        Grade resultGade = gradDao.findByGrade(3);

        for (Student student :resultGade.getStudentList()){
            System.out.println(student);
        }

        // 关闭
        SqlSessionUtil.closeSession();
    }

    @Test
    public void testFindAllStudent(){
        SqlSession session = SqlSessionUtil.getSession();
        GradDao gradDao = session.getMapper(GradDao.class);

        List<Student> studentList = gradDao.findAllStudent();

        for (Student student :studentList){
            System.out.println(student);
        }

        // 关闭
        SqlSessionUtil.closeSession();
    }

    @Test
    public void testWife(){
        SqlSession session = SqlSessionUtil.getSession();
        WifeDao wifeDao = session.getMapper(WifeDao.class);

        Wife resultWife = wifeDao.findByHusbandId(1);

        System.out.println(resultWife.getWifeName());

        SqlSessionUtil.closeSession();
    }
}
