package com.tree.mydemo.mapper;

import com.tree.mydemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserMapper {

    private static Map<String, User> userMap = new HashMap<>();

    static {
        userMap.put("jack1", new User(1,"jack1","123"));
        userMap.put("jack2", new User(2,"jack2","123"));
        userMap.put("jack3", new User(3,"jack3","123"));

    }

    public User login(String username, String pwd){

        User user = userMap.get(username);

        if (user != null){
            if (user.getPwd().equals(pwd)){
                return user;
            }
            return null;
        }
        return null;
    }

    public List<User> listUser(){
        Collection<User> users = userMap.values();
        List<User> userList = new ArrayList<>();
        userList.addAll(users);
        return userList;
    }
}
