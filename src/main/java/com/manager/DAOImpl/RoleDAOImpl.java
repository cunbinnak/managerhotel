package com.manager.DAOImpl;

import com.manager.DAO.RoleDAO;
import com.manager.config.DatabaseSource;
import com.manager.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAOImpl implements RoleDAO {

    public static DatabaseSource jdbcConnect = new DatabaseSource();

    @Override
    public List<Role> getAllRole() {
        List<Role> roles = new ArrayList<>();
        String query = "select * from role ";
        try (Connection connection = jdbcConnect.openConnect();
             PreparedStatement prepare = connection.prepareStatement(query)){
            ResultSet rs = prepare.executeQuery();
            while (rs.next()){
                Role role = new Role();
                role.setId(rs.getString("id"));
                role.setRoleCode(rs.getString("role_code"));
                role.setRoleName(rs.getString("role_name"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public Role findByUserId(String userId) {
        String query = "select * from role where id in (select role_id from USER_ROLE_RELS where user_id = ?)";
        Role role = new Role();
        try (Connection connection = jdbcConnect.openConnect();
             PreparedStatement prepare = connection.prepareStatement(query)){
            prepare.setString(1, userId);
            ResultSet rs = prepare.executeQuery();
            while (rs.next()){
                role.setId(rs.getString("id"));
                role.setRoleCode(rs.getString("role_code"));
                role.setRoleName(rs.getString("role_name"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

}
