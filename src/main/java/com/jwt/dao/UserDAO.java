package com.jwt.dao;

import java.util.List;
import com.jwt.model.User;

public interface UserDAO {

	public void addUser(User User);

	public List<User> getAllUsers();

	public void deleteUser(Integer UserId);

	public User updateUser(User User);

	public User getUser(int Userid);
}
