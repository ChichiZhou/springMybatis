package com.hezho;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hezho.bean.Student;
import com.hezho.dao.StudentDao;
import com.hezho.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestPage {
    // 测试分页
    @Test
    public void testPage(){
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        // 设置起始页数
        PageHelper.startPage(  1,2);
        // 调用查询语句
        List<Student> studentList = studentDao.getAll();
        // 进行分页
        PageInfo<Student> info = new PageInfo<Student>(studentList);

        for (Student student:info.getList()){
            System.out.println(student);
        }

        System.out.println("总条数=" + info.getTotal());
        System.out.println("当前页条数=" + info.getSize());
        System.out.println("总页数=" + info.getPages());
        System.out.println("上一页=" + info.getPrePage());
        System.out.println("下一页=" + info.getNextPage());
        System.out.println("当前页=" + info.getPageNum());
        System.out.println("显示条数=" + info.getPageSize());
        // 关闭
        SqlSessionUtil.closeSession();
    }
}
