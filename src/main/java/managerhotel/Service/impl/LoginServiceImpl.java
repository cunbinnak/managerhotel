package managerhotel.Service.impl;


import managerhotel.DAO.impl.LoginDaoImpl;
import managerhotel.Service.ILoginService;
import managerhotel.model.Users;

public class LoginServiceImpl implements ILoginService{
	

	@Override
	public Users getUser(String userName) {
		LoginDaoImpl loginDao = new LoginDaoImpl();
		Users user = new Users();
		user = loginDao.getUser(userName);
		return user;
	}

}
