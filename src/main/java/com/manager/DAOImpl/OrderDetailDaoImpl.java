package com.manager.DAOImpl;

import com.manager.DAO.OrderDetailDao;
import com.manager.config.DatabaseSource;
import com.manager.entity.OrderDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailDaoImpl implements OrderDetailDao {

    public static DatabaseSource databaseSource = new DatabaseSource();

    @Override
    public void newOrderDetail(OrderDetails orderDetails) throws SQLException {
        String query = "INSERT INTO `managerhotel`.`orderdetails` (`id`, `created_user`, `order_id`, `ref_id`, `ref_type`, `price_ref`, `name_ref`, `unit`, `amount`, `is_deleted`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        Connection connection = databaseSource.getDatasource();
        PreparedStatement prepare = connection.prepareStatement(query);
        prepare.setString(1, orderDetails.getId());
        prepare.setString(2, "SYSTEM");
        prepare.setString(3, orderDetails.getOrderId());
        prepare.setString(4, orderDetails.getRefId());
        prepare.setDouble(5, orderDetails.getPriceRef());
        prepare.setString(6, orderDetails.getNameRef());
        prepare.setString(7, orderDetails.getUnit());
        prepare.setString(8, orderDetails.getAmount());
        prepare.setBoolean(9, false);
        try {
            prepare.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrderDetail(OrderDetails orderDetails) {

    }
}
