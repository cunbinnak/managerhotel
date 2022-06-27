package com.manager.DAO;

import com.manager.entity.Customer;

import java.sql.SQLException;

public interface CustomerDAO {
    void create(Customer customer) throws SQLException;
}
