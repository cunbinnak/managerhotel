package com.manager.DAO;

import com.manager.entity.UserCustomerRel;

import java.sql.SQLException;

public interface UserCustomerRelDAO{

    void create(UserCustomerRel userCustomerRel) throws SQLException;
}
