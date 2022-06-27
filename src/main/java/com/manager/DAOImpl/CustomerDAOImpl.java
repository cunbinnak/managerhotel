package com.manager.DAOImpl;

import com.manager.DAO.CustomerDAO;
import com.manager.config.DatabaseSource;
import com.manager.entity.Customer;

import java.sql.*;

public class CustomerDAOImpl implements CustomerDAO {

    public static DatabaseSource databaseSource = new DatabaseSource();

    @Override
    public void create(Customer customer) throws SQLException {
        String query = "INSERT INTO `managerhotel`.`customer` (`id`, `created_user`, `name`, `birth_day`, `address`, `email`, `phone_number`, `type`, `is_deleted`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection =  databaseSource.getDatasource();
        CallableStatement prepare = connection.prepareCall(query);
        try{
            prepare.setString(1, customer.getId());
            prepare.setString(2, "SYSTEM");
            prepare.setString(3, customer.getName());
            prepare.setDate(4, new Date(customer.getBirthDay().getTime()));
            prepare.setString(5, customer.getAddress());
            prepare.setString(6, customer.getEmail());
            prepare.setString(7, customer.getPhone());
            prepare.setString(8, customer.getType());
            prepare.setBoolean(9, false);
            prepare.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
