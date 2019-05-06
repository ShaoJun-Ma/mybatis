package com.msj.demo03.test;

import com.msj.demo01.User;
import com.msj.demo03.mapper.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDemo03 {
    //查询
    @Test
    public void test01() throws IOException {
        //配置文件流
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        //创建会话工厂，传入mybaits的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Mapper mapper = sqlSession.getMapper(Mapper.class);
            List<User> users = mapper.selectAll();
            System.out.println(users);
        }finally {
            //关闭资源
            sqlSession.close();
        }
    }

    //添加
    @Test
    public void test02() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Mapper mapper = sqlSession.getMapper(Mapper.class);
            User user = new User();
            user.setUsername("aa");
            user.setPassword("11");
            mapper.addOne(user);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }
    //删除
    @Test
    public void test03() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Mapper mapper = sqlSession.getMapper(Mapper.class);
            mapper.deleteOne("aa");
            sqlSession.commit();
            System.out.println("删除成功");
        }finally {
            sqlSession.close();
        }
    }
    //更新
    @Test
    public void test04() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Mapper mapper = sqlSession.getMapper(Mapper.class);
            mapper.updateOne("aaa",1);
            sqlSession.commit();
            System.out.println("更新成功");
        }finally {
            sqlSession.close();
        }
    }
}
