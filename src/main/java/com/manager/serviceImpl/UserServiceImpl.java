package com.manager.serviceImpl;

import com.manager.DAOImpl.*;
import com.manager.dto.SearchUserDto;
import com.manager.entity.*;
import com.manager.service.UserService;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public void updateUser(User user) throws SQLException {
        Map<String, String> spec = new HashMap<>();
        if (user != null) {
            if (user.getRoleCode() != null && !user.getRoleCode().isEmpty()) {
                spec.put("role_code", "'" + user.getRoleCode() + "'");
            }
            if (user.getRoleId() != null && !user.getRoleId().isEmpty()) {
                spec.put("role_id", "'" + user.getRoleId() + "'");
            }
        }
        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.updateUser(spec, user.getId());
    }

    @Override
    public void createCustomer(Customer customer) throws SQLException {
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        customerDAO.create(customer);
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException, ParseException {
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        Map<String, String> spec = new HashMap<>();
        if (customer != null) {
            if (customer.getBirthDay() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String date=sdf.format(customer.getBirthDay() );
                spec.put("birth_day", "'" +  date + "'");
            }
            if (customer.getName() != null && !customer.getName().isEmpty()) {
                spec.put("name", "'" + customer.getName() + "'");
            }
            if (customer.getAddress() != null && !customer.getAddress().isEmpty()) {
                spec.put("address", "'" + customer.getAddress() + "'");
            }
            if (customer.getPhone() != null && !customer.getPhone().isEmpty()) {
                spec.put("phone_number", "'" + customer.getPhone() + "'");
            }
            if (customer.getEmail() != null && !customer.getEmail().isEmpty()) {
                spec.put("email", "'" + customer.getEmail() + "'");
            }
        } else {
            return;
        }
        customerDAO.updateById(spec, customer.getId());
    }

    @Override
    public List<User> findAllUser(SearchUserDto searchUserDto) throws SQLException {
        Map<String, String> spec = new HashMap<>();
        if (searchUserDto != null) {
            if (searchUserDto.getUsername() != null && !searchUserDto.getUsername().isEmpty()) {
                spec.put("username", "'%" + searchUserDto.getUsername() + "%'");
            }
            if (searchUserDto.getRoleCode() != null && !searchUserDto.getRoleCode().isEmpty()) {
                spec.put("role_code", "'%" + searchUserDto.getRoleCode() + "%'");
            }
        }
        UserDAOImpl userDAO = new UserDAOImpl();
        return userDAO.getAllUser(spec);
    }

    @Override
    public Customer findCustomerById(String id) throws SQLException {
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        return customerDAO.findById(id);
    }

    @Override
    public List<User> getListUser() throws SQLException {
        UserDAOImpl userDAO = new UserDAOImpl();

        return userDAO.getListUser();
    }

}
