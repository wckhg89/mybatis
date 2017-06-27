package com.guppy.mybatis.controller;

import com.guppy.mybatis.repository.entity.User;
import com.guppy.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by kanghonggu on 2017. 6. 27..
 */

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index (Model model) {

        User user = userService.findOne(1L);

        model.addAttribute("user", user);

        return "index";
    }

}
