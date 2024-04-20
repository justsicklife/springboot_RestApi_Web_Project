package com.restApi.restApiSpring.demo.repository;


import com.restApi.restApiSpring.demo.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findByName(String name);

    User findByEmail(String email);

    int save(User user);

    List<User> findAll();
}
