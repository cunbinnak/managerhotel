package com.manager.service;

import com.manager.dto.SearchUserDto;
import com.manager.entity.*;

import java.awt.print.Pageable;
import java.sql.SQLException;
import java.util.List;

public interface UserService {

    User findByUserName(String username) throws SQLException;

    void create(User user) throws SQLException;

    Role findRoleUser(String userId);

    List<Role> findAllRole() throws SQLException;

    void createCustomer(Customer customer) throws SQLException;

    List<User> findAllUser(SearchUserDto searchUserDto) throws SQLException;

    List<User> getListUser() throws SQLException;
}
