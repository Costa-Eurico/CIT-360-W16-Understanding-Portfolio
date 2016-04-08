package com.cit360.mpfinder.server.controller;

import java.util.HashMap;

public class HandlerMap {
	private HashMap<String, Handler> map = new HashMap<>();
	
	public HandlerMap() {
		//populate the map with messages for the server

		map.put("createMissingPerson", new CreateMissingPersonHandler());
		map.put("getMissingPersons", new GetMissingPersonsHandler());
	}

	public Handler getHandler(String request) {
		return map.get(request);
	}
	
	public boolean isValidRequest(String request) {
		return map.containsKey(request);
	}
}
