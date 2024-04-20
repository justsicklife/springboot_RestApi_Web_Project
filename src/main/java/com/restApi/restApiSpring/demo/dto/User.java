package com.restApi.restApiSpring.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "유저 dto")
public class User {

    @Schema(description = "유저 아이디")
    private Long userId;

    @Schema(description = "유저 이메일")
    private String email;

    @Schema(description = "유저 이름")
    private String name;
}
