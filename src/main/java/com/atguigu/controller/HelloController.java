package com.atguigu.controller;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {


//    @RequestMapping({"/", "index.html"})
//    public String index() {
//        return "index";
//    }


    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>Hello Thymeleaf!!!</h1>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "success";
    }
}
