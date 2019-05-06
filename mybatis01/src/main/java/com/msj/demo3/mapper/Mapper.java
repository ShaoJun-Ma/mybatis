package com.msj.demo3.mapper;
import com.msj.demo01.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Mapper {
    //查询
    public List<User> selectAll();
    //添加
    public void addOne(User user);
    //删除
    public void deleteOne(String username);
    //更新
    //注意，多个参数的时候要加上@Param
    //给接口添加@Param注解，指明参数的对应关系，原因是给参数配置了@Param注解后
    // MyBatis就会自动将参数封装成Map类型,@Param注解值会作为Map中的key
    public void updateOne(@Param("username") String username, @Param("id") Integer id);
}
