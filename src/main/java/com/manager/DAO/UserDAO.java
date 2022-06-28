package com.manager.DAO;

import com.manager.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    public void createUser(User user) throws SQLException;

    public User getAllUser();

    public User getUser(String username) throws SQLException;

    public User updateUser(User user);

    public User deleteUser(List<String> ids);
}
