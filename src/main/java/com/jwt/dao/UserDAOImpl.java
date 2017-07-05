package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(User User) {
		sessionFactory.getCurrentSession().saveOrUpdate(User);

	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {

		return sessionFactory.getCurrentSession().createQuery("from User")
				.list();
	}

	@Override
	public void deleteUser(Integer UserId) {
		User User = (User) sessionFactory.getCurrentSession().load(
				User.class, UserId);
		if (null != User) {
			this.sessionFactory.getCurrentSession().delete(User);
		}

	}

	public User getUser(int userid) {
		return (User) sessionFactory.getCurrentSession().get(
				User.class, userid);
	}

	@Override
	public User updateUser(User User) {
		sessionFactory.getCurrentSession().update(User);
		return User;
	}

}