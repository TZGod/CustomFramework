package com.tzgod.user.service.impl;

import com.tzgod.user.UserApplication;
import com.tzgod.user.beans.Users;
import com.tzgod.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class UserServiceImplTest {

            @Resource
            private UserService userService;
            @Resource
            private UserServiceImpl userServiceimpl;
            @Test
            public void insertUser() {
                userService.insertUser("sansan",null);
            }

//            @Test
//            public void selectUser() {
//                System.out.println(userServiceImpl.selectUser(new Users(null,"zhangsan",null)));
//            }
            @Test
            public void selectUser() {
                List<Users> zhangsan = userService.selectUser(new Users(null, "zhangsan", "123456"));
            }

}