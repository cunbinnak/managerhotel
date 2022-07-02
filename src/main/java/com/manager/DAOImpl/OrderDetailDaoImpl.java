package com.manager.DAOImpl;

import com.manager.DAO.OrderDetailDao;
import com.manager.config.DatabaseSource;
import com.manager.dto.BusinessReport;
import com.manager.dto.BusinessReportRequest;
import com.manager.entity.OrderDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDetailDaoImpl implements OrderDetailDao {

    public static DatabaseSource databaseSource = new DatabaseSource();

    @Override
    public void newOrderDetail(List<OrderDetails> orderDetails) throws SQLException {
        String query = "INSERT INTO `managerhotel`.`orderdetails` (`id`, `created_user`, `order_id`, `ref_id`, `ref_type`, `price_ref`, `name_ref`, `unit`, `amount`, `is_deleted`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        Connection connection = databaseSource.getDatasource();
        PreparedStatement prepare = connection.prepareStatement(query);
        for (OrderDetails details : orderDetails) {
            prepare.setString(1, details.getId());
            prepare.setString(2, "SYSTEM");
            prepare.setString(3, details.getOrderId());
            prepare.setString(4, details.getRefId());
            prepare.setDouble(5, details.getPriceRef());
            prepare.setString(6, details.getNameRef());
            prepare.setString(7, details.getUnit());
            prepare.setString(8, details.getAmount());
            prepare.setBoolean(9, false);
            prepare.addBatch();
        }
        try {
            prepare.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrderDetail(Map<String, String> spec, String id) {
        String query = "UPDATE `managerhotel`.`order`";
        List<String> predicates = new ArrayList<>();
        try {
            if (!spec.isEmpty()) {
                query = query + "SET";
                for (Map.Entry<String, String> entry : spec.entrySet()) {
                    predicates.add(" " + entry.getKey() + "=" + entry.getValue());
                }
                String predicate = String.join(" , ", predicates);
                query = query + predicate + "where id = " + "'" + id + "'";
            } else {
                return;
            }
            Connection connection = databaseSource.getDatasource();
            PreparedStatement prepare = connection.prepareStatement(query);
            prepare.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderDetailById(String id) throws SQLException {
        String query = "delete from orderdetails where id = ?";
        List<OrderDetails> orderDetails = new ArrayList<>();
        Connection connection = databaseSource.getDatasource();
        PreparedStatement prepare = connection.prepareStatement(query);
        try {
            prepare.setString(1, id);
            prepare.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderDetails> getOrderDetailByOrderId(String orderId) throws SQLException {
        String query = "select * from orderdetails where order_id = ?";
        List<OrderDetails> orderDetails = new ArrayList<>();
        Connection connection = databaseSource.getDatasource();
        PreparedStatement prepare = connection.prepareStatement(query);
        try {
            prepare.setString(1, orderId);
            ResultSet rs = prepare.executeQuery();

            while (rs.next()) {
                OrderDetails orderDetail = new OrderDetails();
                orderDetail.setId(rs.getString("id"));
                orderDetail.setOrderId(rs.getString("order_id"));
                orderDetail.setAmount(rs.getString("amount"));
                orderDetail.setNameRef(rs.getString("name_ref"));
                orderDetail.setPriceRef(rs.getDouble("price_ref"));
                orderDetail.setRefType(rs.getString("ref_type"));
                orderDetail.setUnit(rs.getString("unit"));
                orderDetails.add(orderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }

    @Override
    public OrderDetails getOrderDetailById(String id) throws SQLException {
        String query = "select * from orderdetails where id = ?";
        OrderDetails orderDetail = new OrderDetails();
        Connection connection = databaseSource.getDatasource();
        PreparedStatement prepare = connection.prepareStatement(query);
        try {
            prepare.setString(1, id);
            ResultSet rs = prepare.executeQuery();

            while (rs.next()) {
                orderDetail.setId(rs.getString("id"));
                orderDetail.setOrderId(rs.getString("order_id"));
                orderDetail.setAmount(rs.getString("amount"));
                orderDetail.setNameRef(rs.getString("name_ref"));
                orderDetail.setPriceRef(rs.getDouble("price_ref"));
                orderDetail.setRefType(rs.getString("ref_type"));
                orderDetail.setUnit(rs.getString("unit"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetail;
    }

    @Override
    public List<BusinessReport> getBusinessReport(BusinessReportRequest req) throws SQLException {
        List<BusinessReport> res = new ArrayList<>();
        if (req.getYear() != null && req.getMonth() != null) {
            String query = "SELECT sum(d.price_ref * d.amount) as total, b.checkout_month, b.checkout_year FROM billdetails d join bill b on d.bill_id = b.id  where b.checkout_month  = ? and b.checkout_year = ? group by checkout_month, checkout_year order by checkout_month desc, checkout_year desc";
            Connection connection = databaseSource.getDatasource();
            PreparedStatement prepare = connection.prepareStatement(query);
            try {
                prepare.setString(1, req.getMonth());
                prepare.setString(2, req.getYear());
                ResultSet rs = prepare.executeQuery();

                while (rs.next()) {
                    BusinessReport br = new BusinessReport();
                    br.setTotal(rs.getLong("total"));
                    br.setCreatedMonth(rs.getString("checkout_month"));
                    br.setCreatedYear(rs.getString("checkout_year"));

                    res.add(br);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (req.getYear() != null && !req.getYear().isEmpty() && req.getMonth() == null) {
            String query = "SELECT sum(d.price_ref * d.amount) as total, b.checkout_month, b.checkout_year FROM billdetails d join bill b on d.bill_id = b.id  where b.checkout_year = ? group by checkout_month, checkout_year order by checkout_month desc, checkout_year desc";
            Connection connection = databaseSource.getDatasource();
            PreparedStatement prepare = connection.prepareStatement(query);
            try {
                prepare.setString(1, req.getYear());
                ResultSet rs = prepare.executeQuery();

                while (rs.next()) {
                    BusinessReport br = new BusinessReport();
                    br.setTotal(rs.getLong("total"));
                    br.setCreatedMonth(rs.getString("checkout_month"));
                    br.setCreatedYear(rs.getString("checkout_year"));

                    res.add(br);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            String query = "SELECT sum(d.price_ref * d.amount) as total, b.checkout_month, b.checkout_year FROM billdetails d join bill b on d.bill_id = b.id group by checkout_month, checkout_year order by checkout_month desc, checkout_year desc";
            Connection connection = databaseSource.getDatasource();
            PreparedStatement prepare = connection.prepareStatement(query);
            try {
                ResultSet rs = prepare.executeQuery();

                while (rs.next()) {
                    BusinessReport br = new BusinessReport();
                    br.setTotal(rs.getLong("total"));
                    br.setCreatedMonth(rs.getString("checkout_month"));
                    br.setCreatedYear(rs.getString("checkout_year"));

                    res.add(br);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
