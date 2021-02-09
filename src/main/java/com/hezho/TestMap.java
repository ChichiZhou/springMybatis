package com.hezho;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(reader);
        SqlSession session = build.openSession();
        Map map = new HashMap<String, Object>();
        map.put("sno", 4);
        map.put("sname","chenshuaishuai");
        session.insert("com.hezho.dao.StudentDao.insertRecordByMap", map);
        session.commit();
        session.close();
        reader.close();
    }
}
