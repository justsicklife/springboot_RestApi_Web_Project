package com.restApi.restApiSpring.demo.repository;


import com.restApi.restApiSpring.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    User findByName(String name);

    User findByEmail(String email);
}
