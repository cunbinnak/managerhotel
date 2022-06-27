package com.manager.DAOImpl;

import com.manager.DAO.UserDAO;
import com.manager.config.DatabaseSource;
import com.manager.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class UserDAOImpl implements UserDAO {

    public static DatabaseSource jdbcConnect = new DatabaseSource();

    @Override
    public User createUser(User user) {
        User newUser = new User();

        String query = "INSERT INTO user (`id`, `created_user`, `username`, `password`) VALUES (?, ?, ?, ?);";
        try (Connection connection = jdbcConnect.openConnect();
             PreparedStatement prepare = connection.prepareStatement(query)){
            prepare.setString(1, String.valueOf(UUID.randomUUID()));
            prepare.setString(2, "SYSTEM");
            prepare.setString(3, user.getUsername());
            prepare.setString(4, user.getPassword());

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getAllUser() {
        return null;
    }

    @Override
    public User getUser(String username) {
        User userDto = new User();
        String query = "select * from user where username = ?";
        try (Connection connection = jdbcConnect.openConnect();
             PreparedStatement prepare = connection.prepareStatement(query)){
            prepare.setString(1, username);
            ResultSet rs = prepare.executeQuery();
            while (rs.next()){
                userDto.setUsername(rs.getString("username"));
                userDto.setPassword(rs.getString("password"));
                userDto.setId(rs.getString("id"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return userDto;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(List<String> ids) {
        return null;
    }
}
