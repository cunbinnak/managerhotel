package com.manager.ctrl;

import com.manager.dto.SearchUserDto;
import com.manager.entity.Customer;
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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet({"/admin/search/user", "/admin/create/user" })
public class AdminCtrl extends HttpServlet {
    private static final String PATH_JSP = "/views/admin/";
    private static final String PATH = "/admin/";

    public static long serialVersionUID = -8899517213540670829L;

    public AdminCtrl() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        HttpSession session = req.getSession();
        UserServiceImpl userService = new UserServiceImpl();
        try {
            if (url.equalsIgnoreCase(PATH + "search/user")) {
                searchUserGet(req, resp, userService, session);
            }
            if (url.equalsIgnoreCase(PATH + "create/user")) {
                req.getRequestDispatcher(PATH_JSP + "createUser.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String url = req.getServletPath();
        try {
            if (url.equalsIgnoreCase(PATH + "search/user")) {
                searchUserPost(req, resp, session);
            }
            if (url.equalsIgnoreCase(PATH + "create/user")) {
                createUserAdminPos(req, resp, session);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchUserGet(HttpServletRequest req, HttpServletResponse resp, UserServiceImpl userService, HttpSession session ) throws ServletException, IOException, SQLException {
        SearchUserDto searchUserDto = new SearchUserDto();
        if (session.getAttribute("usernameSearchUser") != null) {
            searchUserDto.setUsername(String.valueOf(session.getAttribute("usernameSearchUser")));
        }
        if (session.getAttribute("roleCodeSearchUser") != null) {
            searchUserDto.setRoleCode(String.valueOf(session.getAttribute("roleCodeSearchUser")));
        }
        req.setAttribute("users", userService.findAllUser(searchUserDto));
        session.removeAttribute("usernameSearchUser");
        session.removeAttribute("roleCodeSearchUser");
        req.getRequestDispatcher(PATH_JSP + "listUser.jsp").forward(req, resp);

    }

    private void searchUserPost(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
        session.setAttribute("usernameSearchUser", req.getParameter("usernameSearchUser"));
        session.setAttribute("roleCodeSearchUser", req.getParameter("roleCodeSearchUser"));
        resp.sendRedirect(session.getAttribute("pathTomcat") +"/admin/search/user");
    }

    private void createUserAdminPos(HttpServletRequest request, HttpServletResponse response , HttpSession session){
        UserServiceImpl userService = new UserServiceImpl();
        List<Role> roles = new ArrayList<>();
        User user = null;
        Customer customer = new Customer();
        try {
            roles.addAll(userService.findAllRole());
            //user
            String userId = String.valueOf(UUID.randomUUID());
            String username = request.getParameter("username");
            String password = "123";
            // customer
            String customerId = String.valueOf(UUID.randomUUID());
            String name = request.getParameter("name");
            Date birthDay = null;
            if(request.getParameter("birthDay") != null && !request.getParameter("birthDay").isEmpty()){
                birthDay = new SimpleDateFormat("dd-mm-yyyy").parse(request.getParameter("birthDay"));
            }
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String type = "1";
            // user customer
            // user role
            String roleCode = request.getParameter("roleCode");
            String roleId = "";
            for (Role role : roles) {
                if (role.getRoleCode().equalsIgnoreCase(roleCode)) {
                    roleId = role.getId();
                }
            }
            // check user có tồn tại hay không
            user = userService.findByUserName(username);
            if (user != null && user.getUsername() != null) {
                request.setAttribute("message", "Tài khoản đã tồn tại");
                request.getRequestDispatcher("/views/authen/register.jsp").forward(request, response);
            }

            //create customer
            customer.setName(name);
            customer.setBirthDay(birthDay);
            customer.setAddress(address);
            customer.setEmail(email);
            customer.setId(customerId);
            customer.setPhone(phone);
            customer.setType(type);
            userService.createCustomer(customer);
            //create user
            User user1 = new User();
            user1.setId(userId);
            user1.setUsername(username);
            user1.setPassword(password);
            user1.setCustomerId(customerId);
            user1.setRoleCode(roleCode);
            user1.setRoleId(roleId);
            user1.setIsDeleted(false);
            userService.create(user1);
            response.sendRedirect(session.getAttribute("pathTomcat") +"/admin/search/user");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
