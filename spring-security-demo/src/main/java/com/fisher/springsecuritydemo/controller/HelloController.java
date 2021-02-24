package com.fisher.springsecuritydemo.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://www.cnblogs.com/lenve/p/11242055.html
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {

        return "Hello";
    }
}
