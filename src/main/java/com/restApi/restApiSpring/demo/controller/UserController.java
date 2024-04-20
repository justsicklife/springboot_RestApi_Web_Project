package com.restApi.restApiSpring.demo.controller;

import com.restApi.restApiSpring.demo.Service.UserService;
import com.restApi.restApiSpring.demo.dto.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name= "예제 APi", description = "Swagger 테스트용 API")
@RestController
@RequiredArgsConstructor
public class UserController {

    final UserService userService;

    @Operation(summary = "모든 회원 조회", description = "모든 회원 목록을 조회합니다.")
    @GetMapping("/users")
    public List<User> findAllUser() {
        return userService.findAll();
    }

    @Operation(summary = "회원 저장" ,description = "이름 과 이메일을 받아 저장합니다.")
    @PostMapping("/user")
    public int save(@Parameter(name = "email",required = true)
                        @RequestParam String email,
                    @Parameter(name = "name", required = true)
                        @RequestParam String name) {

        User user = User.builder()
                .email(email)
                .name(name)
                .build();

        return userService.save(user);
    }

    @Operation(summary = "회원 검색 (이름)" , description = "이름으로 회원을 검색합니다.")
    @GetMapping("/users/name/{name}")
    public List<User> findUserByName(@Parameter(name = "name",required = true) @PathVariable String name) {
        return userService.findByName(name);
    }

    @Operation(summary = "회원 검색 (이메일)",description = "이메일로 회원 검색합니다.")
    @GetMapping("/users/email/{email}")
    public User findUserByEmail(@Parameter(name = "email",required = true) @PathVariable String email) {
        return userService.findByEmail(email);
    }

}
