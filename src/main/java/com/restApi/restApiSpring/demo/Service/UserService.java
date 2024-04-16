package com.restApi.restApiSpring.demo.Service;

import com.restApi.restApiSpring.demo.entity.User;
import com.restApi.restApiSpring.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

}
