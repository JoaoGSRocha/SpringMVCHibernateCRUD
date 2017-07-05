package com.jwt.service;

import java.util.List;

import com.jwt.model.User;

public interface UserService {
	
	public void addUser(User User);

	public List<User> getAllUsers();

	public void deleteUser(Integer UserId);

	public User getUser(int Userid);

	public User updateUser(User User);
}
