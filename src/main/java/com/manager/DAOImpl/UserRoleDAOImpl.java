package com.manager.DAOImpl;

import com.manager.DAO.UserRoleDAO;
import com.manager.config.DatabaseSource;
import com.manager.entity.UserRoleRels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRoleDAOImpl implements UserRoleDAO {

    public static DatabaseSource databaseSource = new DatabaseSource();

    @Override
    public UserRoleRels findByUserId(String userId) throws SQLException {
        UserRoleRels userRoleRels = new UserRoleRels();
        String query = "select * from USER_ROLE_RELS where user_id = ?";
        Connection connection = databaseSource.getDatasource();
        PreparedStatement prepare = connection.prepareStatement(query);
        try {
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

    @Override
    public void create(UserRoleRels userRoleRels) throws SQLException {
        String query = "INSERT INTO `managerhotel`.`user_role_rels` (`id`, `created_user`, `role_id`, `user_id`) VALUES (?, ?, ?, ?)";
        Connection connection = databaseSource.getDatasource();
        PreparedStatement prepare = connection.prepareStatement(query);
        try {
            prepare.setString(1, userRoleRels.getId());
            prepare.setString(2, "SYSTEM");
            prepare.setString(3, userRoleRels.getRoleId());
            prepare.setString(4, userRoleRels.getUserId());
            prepare.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
