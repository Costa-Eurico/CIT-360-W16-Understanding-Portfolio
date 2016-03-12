package com.cit360.mpfinder;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cit360.mpfinder.control.PersonDAO;
import com.cit360.mpfinder.model.Person;
import com.cit360.mpfinder.util.HibernateUtil;

public class MissingPersonFinder {

	/**
	 * @param args
	 */
	//initialize logger
	private static Logger logger = LoggerFactory.getLogger(MissingPersonFinder.class.getName());
	private static String errMsg;
	
	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		MissingPersonFinder.logger = logger;
	}

	public static SessionFactory getHibernateUtil() throws Exception{
		return HibernateUtil.getSessionFactory();
	}

	public static void main(String[] args) {
		try{
			//create person
			createPerson();
			//update person
			updatePerson();
			//delete person
			deletePerson(3);
		}
		catch(Exception e){
			System.out.println("Unexpected exception: " + e.getMessage());
		}
	}  
	
	public static void createPerson() throws Exception{
		//format dates from string
	    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
	    
	    logger.debug("Starting to compose the mperson object.");
	    
	    Person mperson = new Person();  
	    //mperson.setPersonRecordId(1);
	    mperson.setFullName("Clarice Starling");
	    mperson.setAlternateNames("Clarice");
	    mperson.setAge(25);
	    mperson.setAuthorEmail("ejcosta.byui@gmail.com");
	    mperson.setAuthorName("Eurico Costa");
	    mperson.setAuthorPhone("(801) 915-6813");
	    mperson.setDescription("5'8, brown hair, slender. Was last seen with a man named Hanibal Lecter.");
	    mperson.setDateOfBirth(format.parse("15-JAN-1991"));
	    mperson.setEntryDate(format.parse("9-MAR-2016"));
	    mperson.setExpiryDate(format.parse("9-SEP-2016"));
	    mperson.setFamilyName("Starling");
	    mperson.setGivenName("Clarice");
	    mperson.setHomeCity("Hopewell");
	    mperson.setHomeCountry("United States");
	    mperson.setHomeNeighborhood("Cedar Creek");
	    mperson.setHomePostalCode("75034");
	    mperson.setHomeStreet("2345 Honeywell Dr");
	    mperson.setSex("M");
	    mperson.setSourceName("MissingPersonFinder.java");
	    mperson.setSourceDate(format.parse("9-MAR-2016"));
	    
	    logger.debug("mperson object ->" + mperson.toString());
	    
	    PersonDAO pd = new PersonDAO();
	    try{
	    	pd.createPerson(mperson);
	    	System.out.println("successfully saved");
	    	
	    	logger.debug("Successfully saved");
	    }
	    catch(Exception e){
	    	errMsg = "There was a problem saving this person record [CREATEPERSON]: " + e.getMessage();
	    	System.out.println(errMsg);
	    	logger.error(errMsg);
	    }
	}

	public static void updatePerson() throws ParseException{
		//format dates from string
	    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
	    
	    logger.debug("Starting to compose the mperson object.");
	    
	    Person mperson = new Person();  
	    mperson.setPersonRecordId(5);
	    mperson.setFullName("Clara Starling");
	    mperson.setAlternateNames("Clarice");
	    mperson.setAge(25);
	    mperson.setAuthorEmail("ejcosta.byui@gmail.com");
	    mperson.setAuthorName("Eurico Costa");
	    mperson.setAuthorPhone("(801) 915-6813");
	    mperson.setDescription("5'10, brown hair, heavy set. Was last seen with a man named Hanibal Lecter.");
	    mperson.setDateOfBirth(format.parse("15-JAN-1991"));
	    mperson.setEntryDate(format.parse("9-MAR-2016"));
	    mperson.setExpiryDate(format.parse("9-SEP-2016"));
	    mperson.setFamilyName("Starling");
	    mperson.setGivenName("Clarice");
	    mperson.setHomeCity("Alpine, UT");
	    mperson.setHomeCountry("United States");
	    mperson.setHomeNeighborhood("Cedar Creek");
	    mperson.setHomePostalCode("75034");
	    mperson.setHomeStreet("2345 Apple Tree Dr");
	    mperson.setSex("M");
	    mperson.setSourceName("MissingPersonFinder.java");
	    mperson.setSourceDate(format.parse("9-MAR-2016"));
	    
	    logger.debug("mperson object ->" + mperson.toString());
	    
	    PersonDAO pd = new PersonDAO();
	    try{
	    	pd.updatePerson(mperson);
	    	System.out.println("successfully saved");
	    	
	    	logger.debug("Successfully saved");
	    }
	    catch(Exception e){
	    	errMsg = "There was a problem saving this person record [UPDATEPERSON]: " + e.getMessage();
	    	System.out.println(errMsg);
	    	logger.error(errMsg);
	    }
	}
	
	//Delete a person record
	public static void deletePerson(int personId) throws ParseException {
	    PersonDAO pd = new PersonDAO();
	    
	    try{
	    	pd.deletePerson(personId);

	    	System.out.println("successfully deleted");
	    }
	    catch(Exception e){
	    	errMsg = "There was a problem deleting this person record [DELETEPERSON]: " + e.getMessage();
	    	System.out.println(errMsg);
	    	logger.error(errMsg);
	    }
	}
}
