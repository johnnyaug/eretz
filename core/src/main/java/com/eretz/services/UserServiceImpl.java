package com.eretz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eretz.dao.UserDao;
import com.eretz.domain.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public void insertData(User user) {
		userDao.insertData(user);
	}

	public List<User> getUserList() {
		return userDao.getUserList();
	}

	public void deleteData(String id) {
		userDao.deleteData(id);
	}

	public User getUser(String id) {
		return userDao.getUser(id);
	}

	public void updateData(User user) {
		userDao.updateData(user);
	}
}
