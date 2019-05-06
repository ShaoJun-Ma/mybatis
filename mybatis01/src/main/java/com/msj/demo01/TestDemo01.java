package com.msj.demo01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDemo01 {
    @Test
    public void demo01() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            Mapper mapper = sqlSession.getMapper(Mapper.class);
            List<User> users = mapper.selectAll();
            System.out.println(users);
        }finally {
            sqlSession.close();
        }

    }
}
