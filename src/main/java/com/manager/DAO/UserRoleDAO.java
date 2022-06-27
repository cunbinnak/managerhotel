package com.manager.DAO;

import com.manager.entity.UserRoleRels;

import java.sql.SQLException;

public interface UserRoleDAO {

    UserRoleRels findByUserId(String userId) throws SQLException;

    void create(UserRoleRels userRoleRels) throws SQLException;
}
