package com.eretz.restapi;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eretz.model.Exhibit;
import com.eretz.services.ExhibitService;

@Controller
@RequestMapping("/exhibit")
public class ExhibitRestResource {
	@Autowired
	private ExhibitService exhibitService;

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody
	List<Exhibit> getAllExhibits(HttpSession session) {
		return exhibitService.getAllExhibits();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", headers = "Accept=*/*")
	public @ResponseBody
	Exhibit getExhibit(@PathVariable("id") Long id) {
		return exhibitService.getById(id);

	}
}
