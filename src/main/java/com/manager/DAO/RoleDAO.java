package com.manager.DAO;

import com.manager.entity.Role;
import com.manager.entity.User;

import java.util.List;

public interface RoleDAO {
    List<Role> getAllRole();
    Role findByUserId(String userId);
}
