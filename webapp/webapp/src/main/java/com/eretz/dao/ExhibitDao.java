package com.eretz.dao;

import java.util.List;

import com.eretz.model.Exhibit;

public interface ExhibitDao {
	public List<Exhibit> getAllExhibits();
	public Exhibit getById(Long id);
}
