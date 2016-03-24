package com.cit360.mpfinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cit360.mpfinder.control.PersonDAO;
import com.cit360.mpfinder.model.Note;
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
			System.out.println("------------------------------------------------------------------");
			System.out.println("create a new person");
			System.out.println("------------------------------------------------------------------");
			createPerson();
			
			//update person
			System.out.println("\n------------------------------------------------------------------");
			System.out.println("update a new person");
			System.out.println("------------------------------------------------------------------");
			updatePerson();
			
			System.out.println("\n------------------------------------------------------------------");
			System.out.println("retrieve all persons");
			System.out.println("------------------------------------------------------------------");
			//get persons from database. Because of small number of records, I'm getting all records for simplicity's sake
			List<Person> persons = getAllPersons();
			if(persons != null){
				for(Person p : persons){
					System.out.println("Person [ " + p.getPersonRecordId() + " ]: " + p.getFullName());
				}
			}
			
			//delete person
			System.out.println("\n------------------------------------------------------------------");
			System.out.println("delete a person");
			System.out.println("------------------------------------------------------------------");
			deletePerson();
			
			//get person
			System.out.println("\n------------------------------------------------------------------");
			System.out.println("get a person by id");
			System.out.println("------------------------------------------------------------------");
			Person person = getPerson();
			if(person != null){
				System.out.println("Retrieved Person: " + person.toString());
				
				Set personSet = person.getNotes();
				Iterator i = personSet.iterator();
				while(i.hasNext()){
					Note note = (Note)i.next();
					System.out.println("Note: " + note.toString());
				}
			}
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
	
	
	//retrieve a person record
	public static Person getPerson() throws Exception{
		Person person = null;
		PersonDAO pd = new PersonDAO();
		
		try{
	    	//read user input
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	System.out.print("Enter a Person Record Id from the list above to retrieve: ");
	    	int personId = Integer.parseInt(br.readLine());
	    	
	    	//retrieve record the record
	    	person = pd.getPerson(personId);
	    	System.out.println("successfully retrieved!");
	    }
		catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
	    catch(IOException ie){
	    	errMsg = "There was a problem reading your input: " + ie.getMessage();
	    	System.out.println(errMsg);
	    	logger.error(errMsg);
	    }
		catch(Exception e){
			errMsg = "There was a problem retrieving this person record [GETPERSON]: " + e.getMessage();
	    	System.out.println(errMsg);
	    	logger.error(errMsg);
		}
		return person;
	}
	
	//retrieve all persons from database
	public static List<Person> getAllPersons() throws Exception{
		PersonDAO pd = new PersonDAO();
		List<Person> persons = null;
		
		try{
			persons = pd.getPersons(); 
		}
		catch(Exception e){
			errMsg = "There was a problem fetching list of persons [GETPERSONS]: " + e.getMessage();
	    	System.out.println(errMsg);
	    	logger.error(errMsg);
		}
		return persons;
		
	}
	
	//Delete a person record
		public static void deletePerson() throws Exception {
		    PersonDAO pd = new PersonDAO();
		    
		    try{
		    	//read user input
		    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    	System.out.print("Enter a Person Record Id from the list above: ");
		    	int personId = Integer.parseInt(br.readLine());
		    	
		    	//delete the record
		    	pd.deletePerson(personId);
		    	System.out.println("successfully deleted");
		    }
			catch(NumberFormatException nfe){
	            System.err.println("Invalid Format!");
	        }
		    catch(IOException ie){
		    	errMsg = "There was a problem reading your input: " + ie.getMessage();
		    	System.out.println(errMsg);
		    	logger.error(errMsg);
		    }
		    catch(Exception e){
		    	errMsg = "There was a problem deleting this person record [DELETEPERSON]: " + e.getMessage();
		    	System.out.println(errMsg);
		    	logger.error(errMsg);
		    }
		}
}
