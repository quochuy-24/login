package vn.iotstar.service;

import vn.iotstar.models.UserModel;

public interface IUserService {
	public UserModel login(String username,String password);
	UserModel findByUsername(String username);
	public UserModel register();
}
