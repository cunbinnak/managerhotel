package com.manager.DAOImpl;

import com.manager.DAO.UserRoleDAO;
import com.manager.config.DatabaseSource;
import com.manager.entity.UserRoleRels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRoleDAOImpl implements UserRoleDAO {

    public static DatabaseSource jdbcConnect = new DatabaseSource();

    @Override
    public UserRoleRels findByUserId(String userId) {
        UserRoleRels userRoleRels = new UserRoleRels();
        String query = "select * from USER_ROLE_RELS where user_id = ?";
        try (Connection connection = jdbcConnect.openConnect();
             PreparedStatement prepare = connection.prepareStatement(query)){
            prepare.setString(1, userId);
            ResultSet rs = prepare.executeQuery();
            while (rs.next()){
                userRoleRels.setRoleId(rs.getString("role_id"));
                userRoleRels.setUserId(rs.getString("user_id"));
                userRoleRels.setId(rs.getString("id"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return userRoleRels;
    }

}
