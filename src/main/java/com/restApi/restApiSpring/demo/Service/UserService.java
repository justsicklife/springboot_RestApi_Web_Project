package com.restApi.restApiSpring.demo.Service;

import com.restApi.restApiSpring.demo.dto.User;
import com.restApi.restApiSpring.demo.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserService {

    public User findByName(String name);

    public User findByEmail(String email);

    public int save(User user);
}