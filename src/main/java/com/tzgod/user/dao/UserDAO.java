package com.tzgod.user.dao;

import com.tzgod.user.beans.Users;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface UserDAO extends Mapper<Users>, MySqlMapper<Users> {

}
