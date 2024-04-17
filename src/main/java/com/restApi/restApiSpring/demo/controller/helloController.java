package com.restApi.restApiSpring.demo.controller;

import com.restApi.restApiSpring.demo.Service.UserService;
import com.restApi.restApiSpring.demo.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class helloController {

    final UserService userService;

    @GetMapping("/helloWorld/string")
    public String helloWorldString() {
        return "hello";
    }

    @GetMapping("/helloWorld/json")
    @ResponseBody
    public User helloWorldJson() {
        User user = userService.findByName("이름");
        System.out.println("user = " + user);
        return user;
    }

    @GetMapping("/helloWorld/save")
    @ResponseBody
    public int save() {
        User user = User.builder()
                .userId(0L)
                .name("안녕")
                .email("abcde@gmail.com")
                .build();

        int save = userService.save(user);

        return save;
    }

    @GetMapping("/helloWorld/page")
    public String HelloWorldPage() {
        return "helloWorld";
    }

}
