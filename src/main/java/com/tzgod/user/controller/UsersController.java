package com.tzgod.user.controller;

import com.tzgod.user.beans.Users;
import com.tzgod.user.service.UserService;
import com.tzgod.user.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/User")
public  class UsersController {
    @Resource
    private UserService userService;

    /**注册
    * */
    @RequestMapping(value="/register",method = RequestMethod.POST)
    private ResultVO insertUser(@RequestBody Users users){
        try {
            userService.insertUser(users.getUsername(),users.getPassword());
            return new ResultVO(0,"注册成功");
        } catch (Exception e) {
            return new ResultVO(1,"fail");
        }
    }

    /**登录
    * */
    @RequestMapping(value="/login",method = RequestMethod.GET)
    private ResultVO selectUser(Users users){
        try {
            if (users.getPassword().equals(null)||
                    users.getPassword().equals("")||
                    users.getUsername().equals(null)||
                    users.getUsername().equals("")){
                throw new Exception("请重新添加");
            }
            userService.selectUser(users);
            return new ResultVO(0,"登录成功");
        } catch (Exception e) {
            return new ResultVO(1,"data") ;
        }
    }

    /**
     * 查询
    * */
    @RequestMapping(value="/list",method = RequestMethod.POST)
    @ResponseBody
    private ResultVO<Users> User(@RequestBody Users users){
        System.out.println(users);
        try {
            List<Users> users1 = userService.selectUser(users);
            System.out.println(users1);
            return new ResultVO(0,"success",users1);
        } catch (Exception e) {
            return new ResultVO(1,"fail") ;
        }
    }


}
