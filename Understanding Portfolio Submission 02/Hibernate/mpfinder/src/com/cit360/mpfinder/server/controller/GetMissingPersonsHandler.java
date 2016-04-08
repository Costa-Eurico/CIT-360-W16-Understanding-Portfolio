package com.cit360.mpfinder.server.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import com.cit360.mpfinder.server.dao.PersonDAO;
import com.cit360.mpfinder.server.model.Person;

public class GetMissingPersonsHandler extends Handler {

	@Override
	String handleIt(JSONObject data) {
		
		PersonDAO personDao = new PersonDAO();
		
		try {
			List<Person> persons = personDao.getPersons();
			Iterator<Person> iter = persons.iterator();
			ArrayList<Person> personsList = new ArrayList<>();
			while (iter.hasNext()) {
				Person person = (Person) iter.next();
				personsList.add(person);
			}
			JSONArray jsonPersons = new JSONArray(personsList);
			
			return jsonPersons.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
	}

}

