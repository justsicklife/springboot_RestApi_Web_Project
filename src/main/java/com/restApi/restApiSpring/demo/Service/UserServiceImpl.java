package com.restApi.restApiSpring.demo.Service;

import com.restApi.restApiSpring.demo.dto.User;
import com.restApi.restApiSpring.demo.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    final UserMapper userRepository;

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public int save(User user) {
        return userRepository.save(user);
    }
}

