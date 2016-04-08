package com.cit360.mpfinder.client;

import com.cit360.mpfinder.client.controller.Controller;
import com.cit360.mpfinder.client.model.Person;
import com.cit360.mpfinder.client.view.MainView;

public class MissingPersonFinderClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainView mainView = new MainView();
		Person person = new Person();
		
		Controller controller = new Controller(mainView, person);
		mainView.setVisible(true);
	}
}
