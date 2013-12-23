package com.eretz.services;

import java.util.List;

import com.eretz.model.Exhibit;

public interface ExhibitService {
	public List<Exhibit> getAllExhibits();

	public Exhibit getById(Long id);
}
