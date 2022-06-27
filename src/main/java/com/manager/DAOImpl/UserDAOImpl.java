package com.manager.DAOImpl;

import com.manager.DAO.UserDAO;
import com.manager.config.DatabaseSource;
import com.manager.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public class UserDAOImpl implements UserDAO {

    public static DatabaseSource databaseSource = new DatabaseSource();

    @Override
    public void createUser(User user) throws SQLException {
        String query = "INSERT INTO `managerhotel`.`user` (`id`, `created_user`, `username`, `password`, `role_code`, `customer_id`, `is_deleted`, `role_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        Connection connection = databaseSource.getDatasource();
        PreparedStatement prepare = connection.prepareStatement(query);
        try {
            prepare.setString(1, user.getId());
            prepare.setString(2, "SYSTEM");
            prepare.setString(3, user.getUsername());
            prepare.setString(4, user.getPassword());
            prepare.setString(5, user.getRoleCode());
            prepare.setString(6, user.getCustomerId());
            prepare.setBoolean(7, false);
            prepare.setString(8, user.getRoleId());
            prepare.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getAllUser() {
        return null;
    }

    @Override
    public User getUser(String username) throws SQLException {
        User userDto = new User();
        String query = "select * from user where username = ?";
        Connection connection =  databaseSource.getDatasource();
        PreparedStatement prepare = connection.prepareStatement(query);
        try {
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
