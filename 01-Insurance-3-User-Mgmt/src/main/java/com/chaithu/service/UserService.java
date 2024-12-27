package com.chaithu.service;

import java.util.List;

import com.chaithu.bindings.ActiveAccount;
import com.chaithu.bindings.Login;
import com.chaithu.bindings.User;

public interface UserService {

	public Boolean saveUser(User user);

	public Boolean activeUserAcc(ActiveAccount actiavateAcc);

	public Boolean statusChange(Integer id, String status);

	public String login(Login login);

	public User getUserById(Integer id);

	public Boolean deleteUser(Integer id);

	public List<User> getAllUser();

	public String forgetPassword(String email);

}
