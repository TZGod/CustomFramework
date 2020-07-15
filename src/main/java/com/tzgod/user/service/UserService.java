package com.tzgod.user.service;

import com.tzgod.user.beans.Users;
import com.tzgod.user.framework.Face;
import com.tzgod.user.framework.Impl;
import com.tzgod.user.service.impl.UserServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Impl(UserServiceImpl.class)
@Service
public class UserService {

    /**添加*/
    @Face
    public void insertUser(String username, String password) {
        System.out.println("");
    }


    /**查询*/
    @Face
    public List<Users> selectUser(Users users) {
        return null;
    }

}
