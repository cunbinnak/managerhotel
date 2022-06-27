package com.manager.serviceImpl;

import com.manager.DAOImpl.*;
import com.manager.entity.*;
import com.manager.service.UserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        if(currentTime - LAST_CACHE_TIME > CACHE_DURATION) {
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


}
