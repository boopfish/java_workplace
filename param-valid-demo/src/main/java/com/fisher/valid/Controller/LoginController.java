package com.fisher.valid.Controller;

import com.fisher.valid.vo.UserVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	 * 进入不了异常拦截器？
	 * 发现问题:参数只能添加到请求体里面进行校验才能进入异常拦截器
	 * 如果在地址栏上进行拼接  虽然能进行参数校验 但是进入不了异常拦截器
	 * @param userVO
	 * @return
	 */
	@GetMapping("/login")
	public String login(@RequestParam(required = true) UserVO userVO) {
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
