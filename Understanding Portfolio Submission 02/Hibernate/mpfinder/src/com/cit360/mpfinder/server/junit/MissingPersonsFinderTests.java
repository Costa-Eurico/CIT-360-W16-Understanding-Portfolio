package com.cit360.mpfinder.server.junit;

import static org.junit.Assert.*;

import org.json.JSONArray;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cit360.mpfinder.server.util.MPFinderProperties;
import com.cit360.mpfinder.server.dao.*;
import com.cit360.mpfinder.server.model.*;

import java.sql.Connection;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MissingPersonsFinderTests {
	static Connection conn = null;
	static Statement stmt = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//create database connection
		//database URL  
		final String DB_URL = "jdbc:mysql://" + MPFinderProperties.getProperties().getProperty("db.server")
				+ ":" + MPFinderProperties.getProperties().getProperty("db.server.port")
				+ "/" + MPFinderProperties.getProperties().getProperty("db.name");

		//Database credentials
		final String USER = MPFinderProperties.getProperties().getProperty("db.user");
		final String PASS = MPFinderProperties.getProperties().getProperty("db.password");
		
		try{
			Class.forName(MPFinderProperties.getProperties().getProperty("db.jdbc.driver"));
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Database connection open!");
		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//cleaning the house
		if(stmt != null){
			System.out.println("Closing statement.");
			stmt.close();
		}
		if(conn != null){
			System.out.println("Closing database connection.");
			conn.close();
		}
	}


	@Test
	public void CreatePersonTest() throws ParseException {
		//This test creates a new person in the database (unique name) and 
		//then retrieves the record to ensure that it was created successfully.
		
		//NOTE - For this test to function, the the expected value needs to be changed for each 
		// iteration in order to test for a unique value and its successful creation in the database.
		
		String expectedValue = "Miguel Costa";
		Person p = new Person();
		//format dates from string
	    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
		
		p.setFullName("Miguel Costa");
	    p.setAlternateNames("Kita");
	    p.setAge(47);
	    p.setAuthorEmail("ejcosta.byui@gmail.com");
	    p.setAuthorName("Eurico Costa");
	    p.setAuthorPhone("(801) 915-6813");
	    p.setDescription("5'6, brown hair, brown eyes, european complexion, last seen wearing a white blouse and blue jeans.");
		p.setDateOfBirth(format.parse("08-APR-2016"));
	    p.setEntryDate(format.parse("08-APR-2016"));
	    p.setExpiryDate(format.parse("08-OCT-2016"));
	    p.setFamilyName("Baldaia da Costa");
	    p.setGivenName("Cristina");
	    p.setHomeCity("Marco de Canavezes");
	    p.setHomeCountry("Portugal");
	    p.setHomeNeighborhood("Grilo");
	    p.setHomePostalCode("4950");
	    p.setHomeStreet("Rua Pulido Valente, 20 - 1o");
	    p.setSex("F");
	    p.setSourceName("MissingPersonFinder Application");
	    p.setSourceDate(format.parse("08-APR-2016"));
		
	    PersonDAO pdao = new PersonDAO();
	    
	    try{
	    	pdao.createPerson(p);
	    }catch(Exception e){
	    	fail("Failed with exception: " + e.getMessage());
	    }
		
		//Retrieve value from database
		try {
			stmt = conn.createStatement();

			String sql;
			sql = "select full_name from person ";			
			sql += "where full_name = '" + expectedValue + "';";

			ResultSet rs = stmt.executeQuery(sql);
			
			//Extract data from result set
			String fullName="";
			
			while(rs.next()){
				//Retrieve by column name
				fullName = rs.getString("full_name");
			}
			
			//execute test
			assertEquals(expectedValue, fullName);
			
			//STEP 6: Clean-up environment
			rs.close();
		} catch (SQLException e) {
			fail("Received error from database: " + e.getMessage());
		}	
	}
	
	@Test
	public void getPersonsTest() {
		//This test retrieves a count of records from the database
		//and then compares it to the number of records retrieved by the 
		//getMissingPersons method. The number should match.
		
		int totalDbRows = 0;
		
		//Retrieve value from database
		try {
			stmt = conn.createStatement();

			String sql;
			sql = "select count(*) as totalRecords from person;";			

			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			totalDbRows = rs.getInt("totalRecords");
			
			//Clean-up environment
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		PersonDAO personDao = new PersonDAO();
		
		try {
			List<Person> persons = personDao.getPersons();
			int totalReturnedPersons = persons.size();
			
			assertEquals(totalDbRows, totalReturnedPersons);
			
		} catch (Exception e) {
			fail("Failed with exception: " + e.getMessage());
		}
	    
	}
}
