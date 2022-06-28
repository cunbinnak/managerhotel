package com.manager.DAO;

import com.manager.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserDAO {

     void createUser(User user) throws SQLException;
     List<User> getAllUser(Map<String, String> spec) throws SQLException;
     User getUser(String username) throws SQLException;
     User updateUser(User user);
     User deleteUser(List<String> ids);
    public  List<User> getListUser() throws SQLException;
}
