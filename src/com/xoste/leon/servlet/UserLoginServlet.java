package com.xoste.leon.servlet;

import com.xoste.leon.pojo.User;
import com.xoste.leon.service.UserService;
import com.xoste.leon.service.impl.UserServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Xoste
 */
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    public void init() throws ServletException {
        WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = applicationContext.getBean("userService", UserServiceImpl.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        User userLogin = userService.userLogin(user);
        if (userLogin != null) {
            req.setAttribute("userLogin", userLogin);
            resp.sendRedirect("jsp/success.jsp");
        } else {
            req.setAttribute("error", "用户名或密码错误！");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
