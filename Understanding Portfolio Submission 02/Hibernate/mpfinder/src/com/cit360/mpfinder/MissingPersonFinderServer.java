package com.cit360.mpfinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cit360.mpfinder.controller.Controller;
import com.cit360.mpfinder.controller.PersonDAO;
import com.cit360.mpfinder.model.Person;
import com.cit360.mpfinder.util.HibernateUtil;
import com.cit360.mpfinder.util.MPFinderProperties;

public class MissingPersonFinderServer {

	/**
	 * @param args
	 */
	//initialize logger
	private static Logger logger = LoggerFactory.getLogger(MissingPersonFinderServer.class.getName());
	private static String errMsg;
	
	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		MissingPersonFinderServer.logger = logger;
	}

	public static SessionFactory getHibernateUtil() throws Exception{
		return HibernateUtil.getSessionFactory();
	}

	//main method: start the server.
	// To listen to the port being used, in terminal do: lsof -n -i4TCP:4499 | grep LISTEN
	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean stopServer = false;
		int portNumber = 0;
		
		//A port number is obtained from properties file "mpfinderserver.config.properties"
		//Class MPFinderProperties is the class onto which the properties file is loaded using a singleton pattern.
		try{
			portNumber = Integer.parseInt(MPFinderProperties.getProperties().getProperty("server.port"));
		}
		catch(NumberFormatException e){
			String err = "Exception: A port number was not supplied or there was a problem obtaining one. Check your configuration.";
			System.out.println(err);
			MissingPersonFinderServer.getLogger().error(err);
			System.exit(99);
		}
		
		while(!stopServer){
			try(ServerSocket serverSocket = new ServerSocket(portNumber);){
				try{
					System.out.println("The Missing Persons Finder Server is now accepting requests on port " + serverSocket.getLocalPort());
					Socket clientS = serverSocket.accept();
					System.out.println("Connected client: " + clientS.getInetAddress());
					Controller coms = new Controller(clientS);
					new Thread(coms).start();
				}
				catch(IOException e){
					throw new IOException("Unexpected error while processing client requests", e);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception: " + e.getMessage());
				MissingPersonFinderServer.getLogger().error("Exception ->" + e.getStackTrace());
				stopServer = true;
			}
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
