package vn.iotstar.service.implement;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.implement.UserDaoImp;
import vn.iotstar.models.UserModel;
import vn.iotstar.service.IUserService;

public class UserServiceImp implements IUserService{
	IUserDao user = new UserDaoImp();
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel findByUsername(String username) {
		// TODO Auto-generated method stub
		return user.findByUsername(username);
	}

	@Override
	public UserModel register() {
		// TODO Auto-generated method stub
		return null;
	}

}
