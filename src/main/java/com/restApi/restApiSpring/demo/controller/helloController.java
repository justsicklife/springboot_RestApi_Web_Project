package com.restApi.restApiSpring.demo.controller;

import com.restApi.restApiSpring.demo.Service.UserService;
import com.restApi.restApiSpring.demo.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {

    @Autowired
    UserService userService;

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

    @GetMapping("/helloWorld/page")
    public String HelloWorldPage() {
        return "helloWorld";
    }

}
