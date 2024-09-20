package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	List<UserModel>findall();
	UserModel findById(int id);
	UserModel findByUsername(String username);
	UserModel insert(UserModel a);
	
}
