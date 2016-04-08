package com.cit360.mpfinder.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.cit360.mpfinder.client.model.Person;

import org.json.JSONObject;

import com.cit360.mpfinder.client.model.Person;

class NewPersonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// Instantiate a new Deck
		Person p = new Person();
		
		p.setFullName(mainView);
	    p.setAlternateNames(data.getString("alternateNames"));
	    p.setAge(data.getInt("age"));
	    p.setAuthorEmail(data.getString("authorEmail"));
	    p.setAuthorName(data.getString("authorName"));
	    p.setAuthorPhone(data.getString("authorPhone"));
	    p.setDescription(data.getString("description"));
		p.setDateOfBirth(format.parse(data.getString("dateOfBirth")));
	    p.setEntryDate(format.parse(data.getString("entryDate")));
	    p.setExpiryDate(format.parse(data.getString("expiryDate")));
	    p.setFamilyName(data.getString("familyName"));
	    p.setGivenName(data.getString("givenName"));
	    p.setHomeCity(data.getString("homeCity"));
	    p.setHomeCountry(data.getString("homeCountry"));
	    p.setHomeNeighborhood(data.getString("homeNeighborhood"));
	    p.setHomePostalCode(data.getString("homePostalCode"));
	    p.setHomeStreet(data.getString("homeStreet"));
	    p.setSex(data.getString("sex"));
	    p.setSourceName(data.getString("sourceName"));
	    p.setSourceDate(format.parse(data.getString("sourceDate")));
		
		

		
		p.setDeckName(homeView.getDeckName());
		JSONObject jsonObj = new JSONObject(d);
		String s = "{'request':'createDeck','data':"+jsonObj.toString()+"}";
		
		
		String hostname = "127.0.0.1";
		int port = 4499;
		
		try (
				Socket sock = new Socket(hostname, port);
				BufferedReader fromServer = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				PrintWriter toServer = new PrintWriter(sock.getOutputStream(), true);
				//PrintWriter toServer = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			) {
			
			if (fromServer.readLine().startsWith("ready")) {
				toServer.println("ready");
				toServer.println(s);
				
				if (fromServer.readLine().startsWith("TRUE")) {
					homeView.displayErrorMessage("New Deck Created");
				}
				
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
}