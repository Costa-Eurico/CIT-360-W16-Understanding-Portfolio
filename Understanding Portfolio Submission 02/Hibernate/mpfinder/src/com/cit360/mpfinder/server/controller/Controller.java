package com.cit360.mpfinder.server.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.JSONObject;

public class Controller implements Runnable {

	private Socket connection;
	
	public Controller(Socket connection) {
		this.connection = connection;
	}
	
	public void run() {
		try (
			PrintWriter toClient = new PrintWriter(connection.getOutputStream(), true);
			BufferedReader fromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		) {		            
			//send that server is ready
			toClient.println("ready");
			String status = fromClient.readLine();
			//look for ready from the client
			if (status.startsWith("ready")) {
				System.out.println("Client Ready");
				//look for a JSON string from client
				String jsonStr = fromClient.readLine();
				//convert JSON string into JSONObject
				JSONObject jsonObj = new JSONObject(jsonStr);
				String request = jsonObj.getString("request");
				JSONObject data = jsonObj.getJSONObject("data");
				
				//handle the request
				ApplicationController appController = new ApplicationController();
				String result = appController.handleRequest(request, data);
				if (result == "invalid") System.out.println(result);
				//send result to client
				toClient.println(result);
				System.out.println("Client from " + connection.getInetAddress() + " disconnected");
			} else {
				System.out.println("Client not ready");
			}
			
		} catch (Exception e) {
			System.out.println("\n**ERROR** There was a problem communicating with a client.");
				System.out.println(e.getMessage());
				e.printStackTrace();
		    }
		}

}
