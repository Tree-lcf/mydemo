package com.tree.mydemo;

import com.tree.mydemo.controller.UserController;
import com.tree.mydemo.domain.User;
import com.tree.mydemo.utils.JsonData;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MydemoApplication.class})
public class UserTest {

    @Autowired
    private UserController userController;

    @Test
    public void loginTest(){

        User user = new User();
        user.setUsername("jack1");
        user.setPwd("123");

        JsonData jsonData = userController.login(user);

        TestCase.assertEquals(0,jsonData.getCode());
    }

}
