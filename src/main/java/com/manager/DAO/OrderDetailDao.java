package com.manager.DAO;

import com.manager.entity.OrderDetails;

import java.sql.SQLException;

public interface OrderDetailDao {

    void newOrderDetail(OrderDetails orderDetails) throws SQLException;

    void updateOrderDetail(OrderDetails orderDetails);
}
