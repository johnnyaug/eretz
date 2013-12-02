package com.eretz.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.eretz.domain.User;

public class UserDaoImpl implements UserDao {
	@Autowired
	DataSource dataSource;
	private SessionFactory sessionFactory = new Configuration().configure()
			.buildSessionFactory();

	public void insertData(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(user);
		session.getTransaction().commit();
	}

	public List<User> getUserList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<User> result = session.createQuery("from User").list();
		session.getTransaction().commit();
		session.close();
		return result;
	}

	public void deleteData(String id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.createQuery("delete from User where userId="+id).executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	public void updateData(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}

	public User getUser(String id) {
		Session session = sessionFactory.openSession();
		User result = (User) session.createQuery("from User where userId=" + id).list().get(0);
		session.close();
		return result;
	}

}
