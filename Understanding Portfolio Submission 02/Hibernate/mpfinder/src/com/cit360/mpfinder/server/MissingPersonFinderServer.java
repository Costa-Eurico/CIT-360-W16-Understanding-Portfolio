package com.cit360.mpfinder.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cit360.mpfinder.server.controller.Controller;
import com.cit360.mpfinder.server.dao.PersonDAO;
import com.cit360.mpfinder.server.model.Person;
import com.cit360.mpfinder.server.util.HibernateUtil;
import com.cit360.mpfinder.server.util.MPFinderProperties;

public class MissingPersonFinderServer {

	/**
	 * @param args
	 */
	//initialize logger
	private static Logger logger = LoggerFactory.getLogger(MissingPersonFinderServer.class.getName());
	private static String errMsg;
	
	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		MissingPersonFinderServer.logger = logger;
	}

	public static SessionFactory getHibernateUtil() throws Exception{
		return HibernateUtil.getSessionFactory();
	}

	//main method: start the server.
	// To listen to the port being used, in terminal do: lsof -n -i4TCP:4499 | grep LISTEN
	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean stopServer = false;
		int portNumber = 0;
		
		//A port number is obtained from properties file "mpfinderserver.config.properties"
		//Class MPFinderProperties is the class onto which the properties file is loaded using a singleton pattern.
		try{
			portNumber = Integer.parseInt(MPFinderProperties.getProperties().getProperty("server.port"));
		}
		catch(NumberFormatException e){
			String err = "Exception: A port number was not supplied or there was a problem obtaining one. Check your configuration.";
			System.out.println(err);
			MissingPersonFinderServer.getLogger().error(err);
			System.exit(99);
		}
		
		while(!stopServer){
			try(ServerSocket serverSocket = new ServerSocket(portNumber);){
				try{
					System.out.println("The Missing Persons Finder Server is now accepting requests on port " + serverSocket.getLocalPort());
					Socket clientS = serverSocket.accept();
					System.out.println("Connected client: " + clientS.getInetAddress());
					Controller coms = new Controller(clientS);
					new Thread(coms).start();
				}
				catch(IOException e){
					throw new IOException("Unexpected error while processing client requests", e);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception: " + e.getMessage());
				MissingPersonFinderServer.getLogger().error("Exception ->" + e.getStackTrace());
				stopServer = true;
			}
		}
	}  
}
