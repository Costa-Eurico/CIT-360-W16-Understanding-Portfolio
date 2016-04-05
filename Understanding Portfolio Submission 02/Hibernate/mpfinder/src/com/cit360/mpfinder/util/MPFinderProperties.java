package com.cit360.mpfinder.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public final class MPFinderProperties {
	private static Properties props;

	private MPFinderProperties(){	
	}
	
	public static Properties getProperties() throws IOException{
		if(props == null){
			synchronized(MPFinderProperties.class){
				try{
					InputStream input = null;
			    	
			    	try {
			    		String filename = "mpfinderserver.config.properties";
			    		input = MPFinderProperties.class.getClassLoader().getResourceAsStream(filename);
			    		props = new Properties();
			    		props.load(input);
			    	} 
			    	catch (IOException ex) {
			    		ex.printStackTrace();
			        } 
			    	finally{
			        	if(input!=null){
							input.close();
			        	}
			        }
				}
				catch(IOException e){
					throw new IOException("Unable to read properties file for MissingPersonsFinderServer application.", e);
				}
			}
		}
		return props;
	}
}