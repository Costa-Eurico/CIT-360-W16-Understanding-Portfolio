package com.cit360.mpfinder.server.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.JSONException;
import org.json.JSONObject;

import com.cit360.mpfinder.server.MissingPersonFinderServer;
import com.cit360.mpfinder.server.dao.PersonDAO;
import com.cit360.mpfinder.server.model.Person;

public class CreateMissingPersonHandler extends Handler{

	@Override
	String handleIt(JSONObject data) {
		//format dates from string
	    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");

	    MissingPersonFinderServer.getLogger().debug("Starting to compose the mperson object.");
	    Person mperson = new Person(); 
	    
	    try {
	    	//Several exceptions can occur here, when accessing the Json object, or when 
	    	//converting the date fields.     
		    mperson.setFullName(data.getString("fullName"));
		    mperson.setAlternateNames(data.getString("alternateNames"));
		    mperson.setAge(data.getInt("age"));
		    mperson.setAuthorEmail(data.getString("authorEmail"));
		    mperson.setAuthorName(data.getString("authorName"));
		    mperson.setAuthorPhone(data.getString("authorPhone"));
		    mperson.setDescription(data.getString("description"));
			mperson.setDateOfBirth(format.parse(data.getString("dateOfBirth")));
		    mperson.setEntryDate(format.parse(data.getString("entryDate")));
		    mperson.setExpiryDate(format.parse(data.getString("expiryDate")));
		    mperson.setFamilyName(data.getString("familyName"));
		    mperson.setGivenName(data.getString("givenName"));
		    mperson.setHomeCity(data.getString("homeCity"));
		    mperson.setHomeCountry(data.getString("homeCountry"));
		    mperson.setHomeNeighborhood(data.getString("homeNeighborhood"));
		    mperson.setHomePostalCode(data.getString("homePostalCode"));
		    mperson.setHomeStreet(data.getString("homeStreet"));
		    mperson.setSex(data.getString("sex"));
		    mperson.setSourceName(data.getString("sourceName"));
		    mperson.setSourceDate(format.parse(data.getString("sourceDate")));
	    } catch (JSONException | ParseException e1) {
			// TODO Auto-generated catch block
	    	MissingPersonFinderServer.getLogger().error("Exception ->" + e1.getStackTrace());
	    	throw new JSONException(e1);
		}
	    
	    //debug
	    MissingPersonFinderServer.getLogger().debug("mperson object ->" + mperson.toString());
		
		//use deck to persist in database
		PersonDAO personDao = new PersonDAO();
		try {
			personDao.createPerson(mperson);
			return "TRUE";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			MissingPersonFinderServer.getLogger().error("Exception ->" + e.getStackTrace());
			return e.getMessage();
		}
	}
}
