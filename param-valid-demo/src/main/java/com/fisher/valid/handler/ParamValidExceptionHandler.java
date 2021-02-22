package com.fisher.valid.handler;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
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
@Order(1)
@RestControllerAdvice
public class ParamValidExceptionHandler{

	/**
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
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public String test(ConstraintViolationException exception){
		System.out.println("进入了2");
		Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
		StringBuilder error = new StringBuilder();
		constraintViolations.forEach(e->{
			error.append("[" + e.getMessage() + "],");
		});
		return error.substring(0, error.length() - 1).toString();
	}
}
