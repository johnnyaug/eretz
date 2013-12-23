package com.eretz.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eretz.dao.ExhibitDao;
import com.eretz.model.Exhibit;

public class ExhibitServiceImpl implements ExhibitService {
	@Autowired
	private ExhibitDao exhibitDao;

	public List<Exhibit> getAllExhibits() {
		return exhibitDao.getAllExhibits();
	}

	public Exhibit getById(Long id) {
		return exhibitDao.getById(id);
	}

}
