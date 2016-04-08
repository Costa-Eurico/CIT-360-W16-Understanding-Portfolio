package com.cit360.mpfinder.client.controller;

import org.json.JSONObject;
import com.cit360.mpfinder.client.model.Person;
import com.cit360.mpfinder.client.view.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Controller {
	private MainView mainView;
	private Person person;
	
	public Controller(MainView mainView, Person person){
		this.mainView = mainView;
		this.person = person;
		
		this.mainView.addNewPersonListener(new NewPersonListener());
	}
}

