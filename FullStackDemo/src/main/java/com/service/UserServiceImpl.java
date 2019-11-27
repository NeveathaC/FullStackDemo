package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.model.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
private UserDao userDao; 
@Transactional
	@Override
	public User createUser(User user) {
	System.out.println("inside service");
		User user2=null;
		if(user.getPassword().length()>3)
		{
			System.out.println("validation sucess");
			user2=this.userDao.createUser(user);
		}
		return user2;
		
	}

	@Override
	public List<User> readUser() {
		return this.userDao.readUser();
	
	}

	@Override
	public User readUserById(int userId) {
		// TODO Auto-generated method stub
		System.out.println("i am in sevice readbyid");
		return this.userDao.readUserById(userId);
	}
	@Override
	public User readUserByName(String userName) {
		// TODO Auto-generated method stub
		System.out.println("i am in sevice readbyid");
		return this.userDao.readUserByName(userName);
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	@Transactional
	public User deleteById(int userId) {
		return userDao.deleteById(userId);
	}

	@Override
	public User deleteByName(String userName) {
		// TODO Auto-generated method stub
		return userDao.deleteByName(userName);
	}

}
