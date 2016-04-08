package com.cit360.mpfinder.server.controller;

import org.json.JSONObject;

public class ApplicationController {
	public String handleRequest(String request, JSONObject data) throws Exception {
		HandlerMap map = new HandlerMap();
		if (map.isValidRequest(request)) {
			Handler handler = map.getHandler(request);
			String result;
			result = handler.handleIt(data);
			return result;
		} else {
			return "invalid";
		}
	}
}
