package com.fisher.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author fisher
 * @Date 2021-02-24 16:14
 */
@RestController
@RequestMapping("/api")
public class HelloController {

	@GetMapping("hello1")
	public String hello1() {
		return "hello1";
	}

	@GetMapping("hello2")
	public String hello2() {
		return "hello2";
	}
}
