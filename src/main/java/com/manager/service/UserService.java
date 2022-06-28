package com.manager.service;

import com.manager.entity.Customer;
import com.manager.entity.Role;
import com.manager.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    User findByUserName(String username) throws SQLException;

    void create(User user) throws SQLException;

    Role findRoleUser(String userId);

    List<Role> findAllRole() throws SQLException;

    void createCustomer(Customer customer) throws SQLException;
}
