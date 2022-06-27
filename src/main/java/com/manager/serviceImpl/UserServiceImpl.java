package com.manager.serviceImpl;

import com.manager.DAOImpl.RoleDAOImpl;
import com.manager.DAOImpl.UserDAOImpl;
import com.manager.DAOImpl.UserRoleDAOImpl;
import com.manager.entity.Role;
import com.manager.entity.User;
import com.manager.entity.UserRoleRels;
import com.manager.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

//    long currentTime = System.currentTimeMillis();
//    private static final long CACHE_DURATION = 24 * 60 * 60 * 1000L;
//    private static final long LAST_CACHE_TIME = 0;
//      if(currentTime - LAST_CACHE_TIME > CACHE_DURATION) {
//        roles.addAll(roleDAO.getAllRole());
//    }

    private List<Role> roles = new ArrayList<>();

    @Override
    public User findByUserName(String username) {
        UserDAOImpl userDAO = new UserDAOImpl();
        return userDAO.getUser(username);
    }

    @Override
    public Role findRoleUser(String userId) {
        RoleDAOImpl roleDAO = new RoleDAOImpl();
        return roleDAO.findByUserId(userId);
    }
}
