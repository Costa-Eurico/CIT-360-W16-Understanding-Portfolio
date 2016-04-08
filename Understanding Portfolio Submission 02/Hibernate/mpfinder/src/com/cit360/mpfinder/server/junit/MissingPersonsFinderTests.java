package com.cit360.mpfinder.server.junit;

import static org.junit.Assert.*;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cit360.mpfinder.server.util.MPFinderProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MissingPersonsFinderTests {
	static Connection conn = null;
	static Statement stmt = null;
	
	String hostname = "localhost";
	int portNumber = 4497;

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

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void CreatePersonTest() {
		//create JSONObject
		JSONObject json = new JSONObject();
		
		json.put("fullName", "Cristina Costa");
		json.put("alternateName", "Kita");
		json.put("age", 46);
		json.put("authorEmail", "ejcosta.byui@gmail.com");
		json.put("authorName", "Eurico Costa");
		json.put("authorPhone", "(801) 915-6851");
		json.put("description", "5'5, brown hair, brown eyes, white, was wearing a blue shirt and dark blue skinny jeans when she disapeared.");
		json.put("entryDate", "31-MAR-2016");
		json.put("expiryDate", "01-OCT-2016");
		json.put("familyName", "Costa");
		json.put("givenName", "Cristina");
		json.put("homeCity", "Marco de Canavezes");
		json.put("homeCountry", "Portugal");
		json.put("homeNeighborhood", "Grilo");
		json.put("postalCode", "4510");
		json.put("homeStreet", "Rua Maria Amalia Cyrne de Vasconcelos");
		json.put("gender", "F");
		json.put("sourceName", "Missing Person Finder");
		json.put("sourceDate", "31-MAR-2016");
		
		//create client
		try (
                Socket wSocket = new Socket(hostname, 4497);
                PrintWriter out = new PrintWriter(wSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(wSocket.getInputStream()));
        ) {
			//send person to server
			out.write(json.toString());

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostname + ". It seems the server is not running on port " + portNumber + ".");
            System.exit(1);
        }
		
		String expectedValue = "Cristina Costa";
		
		//Retrieve value from database
		try {
			stmt = conn.createStatement();

			String sql;
			sql = "select full_name from person ";			
			sql += "where full_name = '" + json.getString("fullName")  + "';";

			ResultSet rs = stmt.executeQuery(sql);
			
			//STEP 5: Extract data from result set
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
			e.printStackTrace();
		}
		
	}

}
