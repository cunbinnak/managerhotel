package managerhotel.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import managerhotel.DAO.IloginDao;
import managerhotel.model.Users;
import managerhotel.untils.ConnectDB;

public class LoginDaoImpl implements IloginDao{

	public static ConnectDB jdbcConnect = new ConnectDB();
	
	@Override
	public Users getUser(String userName) {
		Users user = new Users();
		Connection conn =null;

		try {
			conn = jdbcConnect.openConnect();
			System.out.println("open connect");
			String sql = "select * from users where username = ?";
			PreparedStatement prepare = conn.prepareStatement(sql);
			prepare.setString(1, userName);
			ResultSet resultSet = prepare.executeQuery();
			while(resultSet.next()) {
				user.setUserName(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
