package com.imoosen.test.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/20.
 */
@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)

    @ResponseBody
    public Map<String,Object> isError(){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("errorCode","500");
        result.put("errorMsg","系统错误");
        return result;
    }
}
