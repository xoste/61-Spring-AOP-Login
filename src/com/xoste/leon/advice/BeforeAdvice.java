package com.xoste.leon.advice;

import com.xoste.leon.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author Xoste
 */
public class BeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        User user = (User) objects[0];
        Logger logger = Logger.getLogger(BeforeAdvice.class);
        logger.info(user.getUsername() + "在" + new Date().toString() + "进行登录");
    }
}

