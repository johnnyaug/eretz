package com.eretz.dao;

import java.util.List;

import org.hibernate.Session;

import com.eretz.model.File;
import com.eretz.util.HibernateUtil;

public class FilePathDaoImpl implements FilePathDao {

	@SuppressWarnings("unchecked")
	@Override
	public String getRelativePath(Long fileId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		HibernateUtil.getSessionFactory().withOptions().tenantIdentifier("bla").openSession();
		
		List<File> resultList = session.createQuery(
				"from File where fileId=" + fileId).list();
		session.close();
		if (resultList == null || resultList.isEmpty()) {
			throw new RuntimeException("Couldn't find file with id = " + fileId);
		}
		return resultList.get(0).getRelativePath();
	}

}
