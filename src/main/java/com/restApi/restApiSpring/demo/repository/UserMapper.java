package com.restApi.restApiSpring.demo.repository;


import com.restApi.restApiSpring.demo.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserMapper {

    User findByName(String name);

    User findByEmail(String email);

    int save(User user);
}
