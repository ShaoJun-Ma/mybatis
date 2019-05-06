package com.msj.demo04;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestDemo04 {
    @Test
    public void demo04() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            Mapper mapper = sqlSession.getMapper(Mapper.class);
            User user = mapper.selectOne(1,null);
            System.out.println(user);
        }finally {
            sqlSession.close();
        }

    }
}
