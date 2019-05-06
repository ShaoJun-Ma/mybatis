package com.msj.demo04;

import org.apache.ibatis.annotations.Param;

public interface Mapper {
    public User selectOne(@Param("id") Integer id, @Param("username") String username);
}
