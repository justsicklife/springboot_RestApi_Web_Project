package com.restApi.restApiSpring.demo.controller;

import com.restApi.restApiSpring.demo.Service.ResponseService;
import com.restApi.restApiSpring.demo.Service.UserService;
import com.restApi.restApiSpring.demo.dto.User;
import com.restApi.restApiSpring.demo.model.response.CommonResult;
import com.restApi.restApiSpring.demo.model.response.ListResult;
import com.restApi.restApiSpring.demo.model.response.SingleResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name= "예제 APi", description = "Swagger 테스트용 API")
@RestController
@RequiredArgsConstructor
public class UserController {

    final UserService userService;
    final ResponseService responseService;

    @Operation(summary = "회원 단검 검색", description = "userId로 회원을 조회합니다.")
    @GetMapping("/user/{userId}")
    public SingleResult<User> findUserByKey(@Parameter(name = "userId",required = true) @PathVariable Long userId) {
        return responseService.getSingleResult(userService.findById(userId).orElse(null));
    }

    @Operation(summary = "회원 검색 (이름)" , description = "이름으로 회원을 검색합니다.")
    @GetMapping("/users/{name}")
    public ListResult<User> findUserByName(@Parameter(name = "name",required = true) @PathVariable String name) {
        return responseService.getListResult(userService.findByName(name));
    }

//    @Operation(summary = "회원 검색 (이메일)",description = "이메일로 회원 검색합니다.")
//    @GetMapping("/users/{email}")
//    public User findUserByEmail(@Parameter(name = "email",required = true) @PathVariable String email) {
//        return userService.findByEmail(email);
//    }

    @Operation(summary = "모든 회원 조회", description = "모든 회원 목록을 조회합니다.")
    @GetMapping("/users")
    public ListResult<User> findAllUser() {
        return responseService.getListResult(userService.findAll());
    }

    @Operation(summary = "회원 저장" ,description = "이름 과 이메일을 받아 저장합니다.")
    @PostMapping("/user")
    public SingleResult<Integer> save(@Parameter(name = "email",required = true)
                        @RequestParam String email,
                    @Parameter(name = "name", required = true)
                        @RequestParam String name) {

        User user = User.builder()
                .email(email)
                .name(name)
                .build();

        return  responseService.getSingleResult(userService.save(user));
    }
    
    @Operation(summary = "회원 수정", description = "회원 정보를 수정합니다.")
    @PutMapping("/user")
    public CommonResult modify(
            @Parameter(name = "userId",required = true) @RequestParam Long userId,
            @Parameter(name = "email",required = true) @RequestParam String email,
            @Parameter(name = "name",required = true) @RequestParam String name
            ) {
        User user = User.builder()
                .userId(userId)
                .email(email)
                .name(name)
                .build();

        return responseService.getOperatorResult(userService.updateById(user));
    }

    @Operation(summary = "회원 삭제",description = "회원 정보를 수정합니다.")
    @DeleteMapping("/user/{userId}")
    public CommonResult delete(@Parameter(name = "userId",required = true)
                               @PathVariable Long userId) {

        userService.deleteById(userId);
        return responseService.getSuccessResult();

    }


}
