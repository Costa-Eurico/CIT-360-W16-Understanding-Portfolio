package com.cit360.mpfinder.client.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.*;

import org.json.JSONArray;

import com.cit360.mpfinder.client.model.Person;
import com.cit360.mpfinder.client.util.MPFinderProperties;

public class MainView extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//test arrayList
	private ArrayList<String> testList = new ArrayList<>();
	private String[] testArray;
	private String[] boxArray;
	
	// Declare component variables
	private JLabel appTitleLabel = new JLabel("Flashcard App");
	private JLabel deckNameLabel = new JLabel("New Deck Name: ");
	private JTextField deckNameText = new JTextField(20);
	private JButton newDeckButton = new JButton("Create New Deck");
	private JLabel deckSelectLabel = new JLabel("Select Existing Deck: ");
	private JComboBox deckSelectComboBox = new JComboBox();
	private DefaultComboBoxModel boxModel;
	private JLabel statusBarLabel = new JLabel("Status: ");
	
	public MainView(){
		int portNumber = 0;
		String hostName = "";
		
		//get data from mpfinder.client.properties
		//A port number is obtained from properties file "mpfinderclient.properties"
		//Class MPFinderProperties is the class onto which the properties file is loaded using a singleton pattern.
		try{
			portNumber = Integer.parseInt(MPFinderProperties.getProperties().getProperty("server.port"));
			hostName = MPFinderProperties.getProperties().getProperty("server.name");
		}
		catch(NumberFormatException | IOException e){
			String err = "Exception: A port number was not supplied or there was a problem obtaining one. Check your configuration.";
			System.out.println(err);
			System.exit(99);
		}
		
		String hostname = hostName;
		int port = portNumber;
		String s = "[{'request':'getMissingPersons','data':{}}]";

		try (
				Socket sock = new Socket(hostname, port);
				BufferedReader fromServer = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				PrintWriter toServer = new PrintWriter(sock.getOutputStream(), true);
			) {
			
			if (fromServer.readLine().startsWith("ready")) {
				toServer.println("ready");
				toServer.println(s);
				
				JSONArray jsonArray = new JSONArray(fromServer.readLine());
				Iterator iter = jsonArray.iterator();
				testArray = new String[jsonArray.length()];
				int counter = 0;
				while (iter.hasNext()) {
					testArray[counter] = (String) iter.next();
					
					counter++;
				}
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		
		// set combo box data
		boxModel = new DefaultComboBoxModel(testArray);
		deckSelectComboBox.setModel(boxModel);
		
		JPanel homePanel = new JPanel(new BorderLayout());
		JPanel newDeckPanel = new JPanel(new BorderLayout());
		JPanel selectDeckPanel = new JPanel(new BorderLayout());
		JPanel contentPanel = new JPanel(new BorderLayout());
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 500);
		
		newDeckPanel.add(deckNameLabel, BorderLayout.LINE_START);
		newDeckPanel.add(deckNameText, BorderLayout.CENTER);
		newDeckPanel.add(newDeckButton, BorderLayout.LINE_END);
		newDeckPanel.setBorder(new EmptyBorder(10,10,10,10));
		
		selectDeckPanel.add(deckSelectLabel, BorderLayout.LINE_START);
		selectDeckPanel.add(deckSelectComboBox, BorderLayout.CENTER);
		selectDeckPanel.setBorder(new EmptyBorder(10,10,10,10));
		
		contentPanel.add(newDeckPanel, BorderLayout.PAGE_START);
		contentPanel.add(selectDeckPanel, BorderLayout.PAGE_END);
		contentPanel.setBorder(new EmptyBorder(10,10,10,10));
		
		homePanel.add(appTitleLabel, BorderLayout.PAGE_START);
		homePanel.add(contentPanel, BorderLayout.CENTER);
		homePanel.add(statusBarLabel, BorderLayout.PAGE_END);
		homePanel.setBorder(new EmptyBorder(10,10,10,10));
		
		this.add(homePanel);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public String getDeckName(){
		return deckNameText.getText();
	}
	
	public void setBoxModel(ArrayList<String> decks){
		boxArray = decks.toArray(new String[testList.size()]);
		
		// set combo box data
		boxModel = new DefaultComboBoxModel(boxArray);
		deckSelectComboBox.setModel(boxModel);
	}
	
	public void addNewPersonListener(ActionListener listenForNewPerson) {
		newDeckButton.addActionListener(listenForNewPerson);
	}
	
	public void addSelectPersonListener(ActionListener listenForSelectPerson) {
		
	}
	
	public void displayErrorMessage(String errorMessage){
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
