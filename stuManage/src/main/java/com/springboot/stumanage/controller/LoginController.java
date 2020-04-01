package com.springboot.stumanage.controller;

import com.springboot.stumanage.entity.User;
import com.springboot.stumanage.Dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login")
    public String index() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user) {
        String username = user.getUsername();
        List<User> userList = userRepository.findByusername(username);
        if (userList.size() != 0) {
            User user1 = userList.get(0);
            switch (user1.getTab()) {
                case 0:
                    if (user1.getPassword().equals(user.getPassword())) {
                        return "root";
                    } else {
                        break;
                    }
                case 1:
                    if (user1.getPassword().equals(user.getPassword())) {
                        return "teacher";
                    } else {
                        break;
                    }
                case 2:
                    if (user1.getPassword().equals(user.getPassword())) {
                        return "student";
                    } else {
                        break;
                    }
                default:
                    break;
            }
        }
        return "login";
    }
}
