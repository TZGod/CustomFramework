package com.tzgod.user.service.impl;

import com.tzgod.user.beans.Users;
import com.tzgod.user.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl {
    @Resource
    private UserDAO userDAO;


    public void insertUser(String username, String password) {
        System.out.println(username+"=====UserServiceImpl====="+password);
//        userDAO.insert(new Users(null,username,password));
    }

    public List<Users> selectUser (Users users) {
        System.out.println("users"+users);
        Example example = new Example(Users.class);
        if (!(users.getUsername() == null|| users.getUsername().equals(""))){
            example.and(example.createCriteria().andEqualTo("username",users.getUsername()));
        }
        if (!(users.getPassword() == null|| users.getPassword().equals(""))){
            example.and(example.createCriteria().andEqualTo("password",users.getPassword()));
        }
        List<Users> users1 = userDAO.selectByExample(example);
        System.out.println("selectUser");

        return users1;
    }
}
