package com.msj.demo02;

import org.apache.ibatis.annotations.Select;

public interface Mapper {
    @Select("select * from users where id = #{id}")
    public User selectOne(Integer id);
}
