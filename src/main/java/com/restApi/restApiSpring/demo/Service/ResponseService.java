package com.restApi.restApiSpring.demo.Service;

import com.restApi.restApiSpring.demo.model.response.CommonResult;
import com.restApi.restApiSpring.demo.model.response.ListResult;
import com.restApi.restApiSpring.demo.model.response.SingleResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    // 단일건 결과 처리 메세드
    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }

    // 복수건 결과 처리 메서드
    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<>();
        result.setList(list);
        setSuccessResult(result);
        return result;
    }

    // 성공 결과만 처리
    public CommonResult getSuccessResult() {
        CommonResult result = new CommonResult();
        setSuccessResult(result);
        return result;
    }

    // 실패 결과만 처리
    public CommonResult getFailResult() {
        CommonResult result = new CommonResult();
        setFailResult(result);
        return result;
    }

    public CommonResult getOperatorResult(int number) {
        CommonResult result = new CommonResult();
        if(number > 0)
            setSuccessResult(result);
        else
            setFailResult(result);
        return result;
    }

    // API 요청 성공 시 응답 모델을 성공 데이터로 세팅
    private void setSuccessResult(CommonResult result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }

    // API 요청 실패 시 응답 모델을 실패 데이터로 세팅
    private void setFailResult(CommonResult result) {
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
    }


}
