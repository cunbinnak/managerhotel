package com.manager.ctrl;

import com.manager.entity.*;
import com.manager.serviceImpl.UserServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet()
public class RegisterCtrl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/authen/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserServiceImpl userService = new UserServiceImpl();
        List<Role> roles = new ArrayList<>();
        User user = null;
        Customer customer = new Customer();
        UserRoleRels userRoleRels = new UserRoleRels();
        UserCustomerRel userCustomerRel = new UserCustomerRel();
        try {
            roles.addAll(userService.findAllRole());
            //user
            String userId = String.valueOf(UUID.randomUUID());
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            // customer
            String customerId = String.valueOf(UUID.randomUUID());
            String name = request.getParameter("name");
            Date birthDay = null;
            try {
                birthDay = new SimpleDateFormat("dd-mm-yyyy").parse(request.getParameter("birthDay"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String type = "1";
            // user customer
            String userCusId = String.valueOf(UUID.randomUUID());
            // user role
            String roleId = "";
            for (Role role : roles) {
                if (role.getRoleCode().equalsIgnoreCase("USER")) {
                    roleId = role.getId();
                }
            }
            // check user có tồn tại hay không
            user = userService.findByUserName(username);
            if (user != null || user.getUsername() != null) {
                request.setAttribute("message", "Tài khoản đã tồn tại");
                request.getRequestDispatcher("/views/authen/register.jsp").forward(request, response);
            }
            //create user
            User user1 = new User();
            user1.setId(userId);
            user1.setUsername(username);
            user1.setPassword(password);
            userService.create(user1);
            //create customer
            customer.setName(name);
            customer.setBirthDay(birthDay);
            customer.setAddress(address);
            customer.setEmail(email);
            customer.setId(customerId);
            customer.setPhone(phone);
            customer.setType(type);
            userService.createCustomer(customer);
            // create user customer
            userCustomerRel.setId(userCusId);
            userCustomerRel.setCustomerId(customerId);
            userCustomerRel.setUserId(userId);
            userService.createUserCustomer(userCustomerRel);
            // create user role
            userRoleRels.setId(String.valueOf(UUID.randomUUID()));
            userRoleRels.setUserId(userId);
            userRoleRels.setRoleId(roleId);
            userService.createUserRole(userRoleRels);
            request.setAttribute("message", "Đăng ký thành công, vui lòng đăng nhập lại");
            response.sendRedirect("/manager_hotel_war/authen/login");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
