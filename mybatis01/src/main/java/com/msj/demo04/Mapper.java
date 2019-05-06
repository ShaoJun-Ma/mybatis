package com.msj.demo04;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Mapper {
    public List<User> selectOne(@Param("id") Integer id, @Param("username") String username);
}
