package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired//has java file has association with another java file
	private SessionFactory sessionFactory;

	@Override
	public User createUser(User user) {
		// this refers current object
		System.out.println("Inside dao");
		Session session = this.sessionFactory.openSession();
		
	//	Transaction t=session.beginTransaction(); 
		session.save(user);
		//session.persist(user);
	//	t.commit();
		return user;
	}

	@Override
	public List<User> readUser() {
		Session session = this.sessionFactory.openSession();
		// HQl(based on java file
		String readUser = "from User";
		List<User> users = session.createQuery(readUser).list();
		return users;
	}

	@Override
	public User readUserById(int userId) {
		Session session = this.sessionFactory.openSession();
		String hql = "from User where userId=:userId";
	    List<User> users=session.createQuery(hql).setParameter("userId", userId).list();
	    return users.get(0);
	}
	
	@Override
	public User readUserByName(String userName) {
		Session session = this.sessionFactory.openSession();
		String hql = "from User where userName=:userName";
	    List<User> users=session.createQuery(hql).setParameter("userName", userName).list();
	    return users.get(0);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		/*
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		return user;*/
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql ="update User set userName=:userName,password=:password where userId=:userId";
		Query query=(Query)session.createQuery(hql);
		query.setParameter("userName",user.getUserName());
		query.setParameter("password",user.getPassword());
		query.setParameter("userId",user.getUserId());
		int r=query.executeUpdate();
		System.out.println(r);
		tx.commit();
		session.close();
		return user;
	}

	@Override
	public User deleteById(int userId) {
		Session session = this.sessionFactory.openSession();
		//session.load(User.class, new Integer(userId));
		//auto boxing
		Transaction tx=session.beginTransaction();
		User obj=session.load(User.class, userId);
		session.delete(obj);
		tx.commit();
		return obj;
	
		/*Transaction tx=session.beginTransaction();
		String hql="delete from User where userId=:userId";
		Query query=(Query) session.createQuery(hql);
		query.setParameter("userId",userId);
		int r=query.executeUpdate();
		System.out.println(r);
		tx.commit();
		session.close();
		return null;*/
	}

	@Override
	public User deleteByName(String userName) {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="delete from User where userName=:userName";
		Query query=(Query) session.createQuery(hql);
		query.setParameter("userName",userName);
		int r=query.executeUpdate();
		System.out.println(r);
		tx.commit();
		session.close();
		return null;
	}

}
