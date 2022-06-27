package com.manager.DAO;

import com.manager.entity.User;

import java.util.List;

public interface UserDAO {

    public User createUser(User user);
    public User getAllUser();
    public User getUser(String username);
    public User updateUser(User user);
    public User deleteUser(List<String> ids);
}
