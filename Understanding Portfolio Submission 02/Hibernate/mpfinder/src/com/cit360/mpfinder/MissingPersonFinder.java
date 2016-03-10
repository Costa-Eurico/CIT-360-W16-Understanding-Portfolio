package com.cit360.mpfinder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cit360.mpfinder.model.Person;
import com.cit360.mpfinder.util.HibernateUtil;

public class MissingPersonFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ParseException {  
	      
		//Initialize HibernateUtil
		HibernateUtil.getInstance();
		
	    //creating configuration object  
	    Configuration cfg = new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	      
	    //creating session factory object  
	    SessionFactory factory = cfg.buildSessionFactory();
		//SessionFactory factory = HibernateUtil.getSessionFactory();
	      
	    //creating session object  
	    Session session = factory.openSession();
	      
	    //creating transaction object  
	    Transaction t = session.beginTransaction();  
	          
	    //format dates from string
	    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
	    
	    Person mperson = new Person();  
	    mperson.setFullName("Norman Foley");
	    mperson.setAlternateNames("Norm");
	    mperson.setAge(64);
	    mperson.setAuthorEmail("ejcosta.byui@gmail.com");
	    mperson.setAuthorName("Eurico Costa");
	    mperson.setAuthorPhone("(801) 915-6813");
	    mperson.setDescription("6'2, silver hair, slender. Was last seen wearing a red and white checkered short, blue jeans, tan hiking boots.");
	    mperson.setDateOfBirth(format.parse("15-JAN-1951"));
	    mperson.setEntryDate(format.parse("9-MAR-2016"));
	    mperson.setExpiryDate(format.parse("9-SEP-2016"));
	    mperson.setFamilyName("Foley");
	    mperson.setGivenName("Norman");
	    mperson.setHomeCity("Hopewell");
	    mperson.setHomeCountry("United States");
	    mperson.setHomeNeighborhood("Cedar Creek");
	    mperson.setHomePostalCode("75034");
	    mperson.setHomeStreet("2345 Honeywell Dr");
	    mperson.setSex("M");
	    mperson.setSourceName("MissingPersonFinder.java");
	    mperson.setSourceDate(format.parse("9-MAR-2016"));
	      
	    session.saveOrUpdate(mperson);//persisting the object  
	      
	    t.commit();//transaction is committed  
	    session.close();  
	      
	    System.out.println("successfully saved");
	}  

}
