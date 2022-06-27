package com.manager.DAO;

import com.manager.entity.UserRoleRels;

public interface UserRoleDAO {

    UserRoleRels findByUserId(String userId);
}
