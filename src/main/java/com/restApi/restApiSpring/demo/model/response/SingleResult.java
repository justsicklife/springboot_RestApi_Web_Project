package com.restApi.restApiSpring.demo.model.response;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SingleResult<T> extends CommonResult {
    private T data;
}
