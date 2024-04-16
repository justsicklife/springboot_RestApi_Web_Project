package com.restApi.restApiSpring.demo.entity;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long userId;

    private String email;

    private String name;
}
