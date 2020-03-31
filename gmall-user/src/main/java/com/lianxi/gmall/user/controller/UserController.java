package com.lianxi.gmall.user.controller;

import com.lianxi.gmall.user.entity.UmsMember;
import com.lianxi.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    @ResponseBody
    public List<UmsMember> hello() {
        return userService.getUserlist();
    }
};
