package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.UserDAO;
import com.jwt.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO UserDAO;

	@Override
	@Transactional
	public void addUser(User User) {
		UserDAO.addUser(User);
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		return UserDAO.getAllUsers();
	}

	@Override
	@Transactional
	public void deleteUser(Integer UserId) {
		UserDAO.deleteUser(UserId);
	}

	public User getUser(int usrid) {
		return UserDAO.getUser(usrid);
	}

	public User updateUser(User User) {
		// TODO Auto-generated method stub
		return UserDAO.updateUser(User);
	}

	public void setUserDAO(UserDAO UserDAO) {
		this.UserDAO = UserDAO;
	}

}
