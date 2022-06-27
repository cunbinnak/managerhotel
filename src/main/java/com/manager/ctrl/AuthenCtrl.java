package com.manager.ctrl;

import com.manager.entity.Role;
import com.manager.entity.User;
import com.manager.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

@WebServlet(urlPatterns = "/authen/login")
public class AuthenCtrl extends HttpServlet {

    public AuthenCtrl(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/authen/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username =  req.getParameter("username");
        String password =  req.getParameter("password");
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.findByUserName(username);
        Role role = new Role();
        Integer flag = 0;
        if(user != null){
            role =  userService.findRoleUser(user.getId());
            flag = 1;
        }
        if(flag != 0 && user.getPassword().equals(password) && role != null){
            session.setAttribute("role", role.getRoleCode().toUpperCase(Locale.ROOT));
            session.setAttribute("username", username);
            if(role.getRoleCode().equalsIgnoreCase("admin")){
                resp.sendRedirect("/manager_hotel_war/admin");
            }
            if(role.getRoleCode().equalsIgnoreCase("staff")){
                resp.sendRedirect("/manager_hotel_war/staff");
            }
            if(role.getRoleCode().equalsIgnoreCase("user")){
                resp.sendRedirect("/manager_hotel_war/user");
            }
        } else {
            req.setAttribute("message", "Tài khoản mật khẩu không chính xác");
            req.getRequestDispatcher("/views/authen/login.jsp").forward(req, resp);
        }
    }
}
