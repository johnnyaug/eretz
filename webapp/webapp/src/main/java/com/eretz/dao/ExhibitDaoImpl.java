package com.eretz.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.eretz.model.Exhibit;
import com.eretz.util.HibernateUtil;

public class ExhibitDaoImpl implements ExhibitDao {
	@Autowired
	DataSource dataSource;

	@SuppressWarnings("unchecked")
	public List<Exhibit> getAllExhibits() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Exhibit> result = session.createQuery("from Exhibit").list();
		session.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	public Exhibit getById(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Exhibit> resultList = session.createQuery(
				"from Exhibit where exhibitId=" + id).list();
		session.close();
		if (resultList == null || resultList.isEmpty()) {
			throw new RuntimeException("Couldn't find exhibit with id = " + id);
		}
		return resultList.get(0);
	}

}
