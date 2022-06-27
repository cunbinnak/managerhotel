package com.manager.DAOImpl;

import com.manager.DAO.UserCustomerRelDAO;
import com.manager.config.DatabaseSource;
import com.manager.entity.UserCustomerRel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserCustomerRelDAOImpl implements UserCustomerRelDAO {

    public static DatabaseSource databaseSource = new DatabaseSource();

    @Override
    public void create(UserCustomerRel userCustomerRel) throws SQLException {
        Connection connection = databaseSource.getDatasource();
        String query = "INSERT INTO `managerhotel`.`user_customer_rels` (`id`, `created_user`, `customer_id`, `user_id`) VALUES (?, ?, ?, ?)";
        PreparedStatement prepare = connection.prepareStatement(query);
        try {
            prepare.setString(1, userCustomerRel.getId());
            prepare.setString(2, "SYSTEM");
            prepare.setString(3, userCustomerRel.getCustomerId());
            prepare.setString(4, userCustomerRel.getUserId());
            prepare.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
