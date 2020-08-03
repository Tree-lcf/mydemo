package com.tree.mydemo.controller;

import com.tree.mydemo.domain.User;
import com.tree.mydemo.service.UserService;
import com.tree.mydemo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/user")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("login")
    public JsonData login(@RequestBody User user){
        System.out.println("user "+user);
        String token = userService.login(user.getUsername(), user.getPwd());
        return token!=null?JsonData.buildSuccess(token):JsonData.buildError("账户密码错误");
    }

    /**
     *
     * @return
     */
    @GetMapping("list")
    public JsonData listUser(){

        return JsonData.buildSuccess(userService.listUser());
    }
}
