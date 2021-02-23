package com.fisher.valid.handler;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @Description
 * @Author fisher
 * @Date 2021-02-22 16:19
 */
@RestControllerAdvice
public class ParamValidExceptionHandler {

    /**
     * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
     * 此方法无法格式化get请求里面 封装的VO参数 ，替代方法为BindException
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String paramValidFailed(MethodArgumentNotValidException exception) {
        System.out.println("进入了1");
        BindingResult bindingResult = exception.getBindingResult();
        StringBuilder error = new StringBuilder();
        bindingResult.getAllErrors().forEach(e -> {
            error.append("[" + e.getDefaultMessage() + "],");
        });
        return error.substring(0, error.length() - 1).toString();
    }

    /**
     * 单个参数校验时的异常拦截
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public String test(ConstraintViolationException exception) {
        System.out.println("进入了2");
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        StringBuilder error = new StringBuilder();
        constraintViolations.forEach(e -> {
            error.append("[" + e.getMessage() + "],");
        });
        return error.substring(0, error.length() - 1).toString();
    }

    /**
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(BindException.class)
    public String bindExceptionHandle(BindException exception) {
        System.out.println("进入了3");
        BindingResult bindingResult = exception.getBindingResult();
        StringBuilder error = new StringBuilder();
        bindingResult.getAllErrors().forEach(e -> {
            error.append("[" + e.getDefaultMessage() + "],");
        });
        return error.substring(0, error.length() - 1).toString();
    }
}
