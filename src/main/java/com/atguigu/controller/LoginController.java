package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession httpSession) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            httpSession.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }
        map.put("msg", "用户名或密码错误");
        return "login";
    }
}
