package com.hezho;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

public class TestStatics {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(reader);
        SqlSession session = build.openSession();
        Map<String, Object> map = session.selectOne("com.hezho.dao.StudentDao.findStatics");
        for(Map.Entry entry : map.entrySet()){
            System.out.println(entry);
        }
        session.close();
        reader.close();
    }
}
