package com.manager.service;

import com.manager.entity.Role;
import com.manager.entity.User;
import com.manager.entity.UserRoleRels;

public interface UserService {

    User findByUserName(String username);

    Role findRoleUser(String userId);
}
