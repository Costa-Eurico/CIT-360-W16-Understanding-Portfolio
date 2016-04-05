package com.cit360.mpfinder.controller;

import java.util.HashMap;

public class HandlerMap {
	private HashMap<String, Handler> map = new HashMap<>();
	
	public HandlerMap() {
		
		//to create new functionality add a new entry with the desired request name
		//and the name of the new handler class. Then make sure the new handler
		//extends the Handler class. Then identify what data you need from the client
		//and what to return to the client, if anything. Then do everything in between.
		//This would normally include some kind of database access.
		
		//populate the map with messages for the server

		map.put("createrMissingPerson", new CreateMissingPersonHandler());
		//map.put("editMissingPerson", new EditMissingPersonHandler());
		//map.put("findMissingPersons", new FindMissingPersonsHandler());
		//map.put("getMissingPersons", new getMissingPersonsHandler());
		//map.put("createNote", new CreateNoteHandler());
		//map.put("editNote", new EditNoteHandler());
		//map.put("getNotes", new getNotesHandler());
	}

	public Handler getHandler(String request) {
		return map.get(request);
	}
	
	public boolean isValidRequest(String request) {
		return map.containsKey(request);
	}
}
