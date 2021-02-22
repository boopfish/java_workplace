package com.fisher.valid.controller;

import com.fisher.valid.vo.UserVO;
import org.apache.catalina.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * @Description https://www.cnblogs.com/mr-yang-localhost/p/7812038.html#_label3
 * @Author fisher
 * @Date 2021-02-22 16:06
 */
@RestController
@Validated
public class LoginController {

	/**
	 * 可以进入异常拦截器
	 * @param userVO
	 * @return
	 */
	@PostMapping("/register")
	public String register(@RequestBody @Validated(UserVO.Register.class) UserVO userVO) {
		return "注册成功";
	}

	/**
	 * https://www.cnblogs.com/panchanggui/p/11758242.html
	 * 进入不了异常拦截器？
	 * 发现问题:参数只能添加到请求体里面进行校验才能进入异常拦截器
	 * 如果在地址栏上进行拼接  虽然能进行参数校验 但是进入不了异常拦截器
	 * 解决 ：校验失败时会报错BindException 对BindException拦截就行了 BindException是MethodArgumentNotValidException的父类
	 * @param userVO
	 * @return
	 */
	@GetMapping("/login")
	public String login(@Validated(UserVO.Login.class) UserVO userVO) {
		return "登录成功";
	}

	/**
	 *
	 * @param username
	 * @return
	 */
	@GetMapping("/test")
	public String test( @NotBlank(message = "用户名不合法")String username){
		return "success";
	}
}
