package com.restApi.restApiSpring.demo.Service;

import com.restApi.restApiSpring.demo.dto.User;
import com.restApi.restApiSpring.demo.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    final UserMapper userMapper;

    @Override
    public Optional<User> findById(Long userId) {
        return userMapper.findById(userId);
    }

    @Override
    public List<User> findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    @Override
    public int save(User user) {
        return userMapper.save(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public int updateById(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int deleteById(Long userId) {
        return userMapper.deleteById(userId);
    }
}

