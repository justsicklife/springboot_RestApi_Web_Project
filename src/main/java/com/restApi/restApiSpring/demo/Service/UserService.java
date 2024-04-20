package com.restApi.restApiSpring.demo.Service;

import com.restApi.restApiSpring.demo.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public List<User> findByName(String name);

    public User findByEmail(String email);

    public int save(User user);

    public List<User> findAll();
}