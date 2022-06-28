package com.manager.serviceImpl;

import com.manager.DAOImpl.*;
import com.manager.dto.SearchUserDto;
import com.manager.entity.*;
import com.manager.service.UserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private static final long CACHE_DURATION = 24 * 60 * 60 * 1000L;
    private static final long LAST_CACHE_TIME = 0;

    private List<Role> roles = new ArrayList<>();


    @Override
    public User findByUserName(String username) throws SQLException {
        UserDAOImpl userDAO = new UserDAOImpl();
        return userDAO.getUser(username);
    }

    @Override
    public Role findRoleUser(String userId) {
        RoleDAOImpl roleDAO = new RoleDAOImpl();
        return roleDAO.findByUserId(userId);
    }

    @Override
    public List<Role> findAllRole() throws SQLException {
        long currentTime = System.currentTimeMillis();
        if (currentTime - LAST_CACHE_TIME > CACHE_DURATION) {
            RoleDAOImpl roleDAO = new RoleDAOImpl();
            roles.addAll(roleDAO.getAllRole());
        }
        return roles;
    }

    @Override
    public void create(User user) throws SQLException {
        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.createUser(user);
    }

    @Override
    public void createCustomer(Customer customer) throws SQLException {
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        customerDAO.create(customer);
    }

    @Override
    public List<User> findAllUser(SearchUserDto searchUserDto) throws SQLException {
        Map<String, String> spec = new HashMap<>();
        if (searchUserDto != null) {
            if (searchUserDto.getUsername() != null && !searchUserDto.getUsername().isEmpty()) {
                spec.put("username", "'" + searchUserDto.getUsername() + "'");
            }
            if (searchUserDto.getRoleCode() != null && !searchUserDto.getRoleCode().isEmpty()) {
                spec.put("role_code", "'" + searchUserDto.getRoleCode() + "'");
            }
        }
        UserDAOImpl userDAO = new UserDAOImpl();
        return userDAO.getAllUser(spec);
    }

    @Override
    public List<User> getListUser() throws SQLException {
        UserDAOImpl userDAO = new UserDAOImpl();

        return userDAO.getListUser();
    }


}
