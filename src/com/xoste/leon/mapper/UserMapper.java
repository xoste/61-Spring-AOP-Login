package com.xoste.leon.mapper;

import com.xoste.leon.pojo.User;

/**
 * @author Xoste
 */
public interface UserMapper {
    /**
     * 通过用户名密码查询用户
     * @param user User
     * @return User
     */
    User selectUserByUsernamePassword(User user);
}
