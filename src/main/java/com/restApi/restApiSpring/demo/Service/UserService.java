package com.restApi.restApiSpring.demo.Service;

import com.restApi.restApiSpring.demo.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public Optional<User> findById(Long userId);

    public List<User> findByName(String name);

    public User findByEmail(String email);

    public int save(User user);

    public List<User> findAll();

    int updateById(User user);

    int deleteById(Long userId);

}