package com.cit360.mpfinder.controller;

import org.json.JSONObject;

public abstract class Handler {
	abstract String handleIt(JSONObject data);
}