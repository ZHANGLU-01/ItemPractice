package com.springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    //    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
    @PostMapping("/userLogin")
    public String userLogin(String username, String password, Model model, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "12345".equals(password)) {
            //记录登录状态
            session.setAttribute("user", username);
            //跳转到主页
            return "redirect:/main";
        } else {
            model.addAttribute("message", "用户名或密码错误！");
            return "login";
        }
    }
}
