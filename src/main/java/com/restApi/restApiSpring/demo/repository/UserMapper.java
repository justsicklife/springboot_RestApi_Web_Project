package com.restApi.restApiSpring.demo.repository;


import com.restApi.restApiSpring.demo.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    Optional<User> findById(Long userId);

    List<User> findByName(String name);

    User findByEmail(String email);

    int save(User user);

    List<User> findAll();

    int updateById(User user);

    int deleteById(Long userId);
}
