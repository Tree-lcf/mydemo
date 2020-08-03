package com.tree.mydemo.service;

import com.tree.mydemo.domain.User;

import java.util.List;

public interface UserService {

    String login(String username,String pwd);

    List<User> listUser();
}
