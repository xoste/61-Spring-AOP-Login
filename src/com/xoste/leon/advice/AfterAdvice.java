package com.xoste.leon.advice;

import com.xoste.leon.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author Xoste
 */
public class AfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        User user = (User) objects[0];
        Logger logger = Logger.getLogger(AfterAdvice.class);
        if (o != null) {
            logger.info(user.getUsername() + "登陆成功！");
        } else {
            logger.info(user.getUsername() + "登录失败！");
        }
    }
}
