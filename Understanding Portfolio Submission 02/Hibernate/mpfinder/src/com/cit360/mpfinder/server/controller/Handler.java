package com.cit360.mpfinder.server.controller;

import org.json.JSONObject;

public abstract class Handler {
	abstract String handleIt(JSONObject data);
}