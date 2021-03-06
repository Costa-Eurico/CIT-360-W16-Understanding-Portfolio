//HTTPURLConnection Example

import java.net.*;
import java.io.*;
import java.util.*;
import org.json.JSONObject;

public class HttpUrlConnectionDemo {

	public static void main(String[] args) throws Exception{
		URL ur = new URL("http://api.wunderground.com/api/22b4347c464f868e/conditions/q/Utah/Alpine.json");
		
		try{
			HttpURLConnection httpCon = (HttpURLConnection) ur.openConnection();
			
			//display request method
			System.out.println("Request method is -> " + httpCon.getRequestMethod());
			
			//display response code
			System.out.println("Response code is -> " + httpCon.getResponseCode());
			
			//display response message
			System.out.println("Response message is -> " + httpCon.getResponseMessage());
			
			//************************
			// Collection example using Map and Set
			//get list of header fields and a set of the header keys
			System.out.println("\nCollection Example using Map/Set:");
			Map<String, List<String>> headerMap = httpCon.getHeaderFields();
			Set<String> headerField = headerMap.keySet();
			TreeMap<String, List<String>> headerVarTreeM = new TreeMap<String, List<String>>();
			
			System.out.println("Header details: ");
			//display all header keys and values
			for(String key : headerField) {
				System.out.println("Key: " + key + " Value: " + headerMap.get(key));
				// load treeMap
				if(key != null){
					headerVarTreeM.put(key, headerMap.get(key));
				}
			}
			
			//************************
			// Collections example using TreeMap
			System.out.println("\nCollection Example using TreeMap:");
	        //add key-value pair to TreeMap
	        System.out.println(headerVarTreeM);
			
	        //display the contents using an iterator
	        /* Display content using Iterator*/
	        Set set = headerVarTreeM.entrySet();
	        Iterator iterator = set.iterator();
	        while(iterator.hasNext()) {
	           Map.Entry mentry = (Map.Entry)iterator.next();
	           System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
	           System.out.println(mentry.getValue());
	        }
			
			//read stream
			InputStream in = httpCon.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			StringBuilder result = new StringBuilder();
			String line;
			while((line = reader.readLine()) != null) {
			    result.append(line);
			}
			
			//Process output json object
			JSONObject json = new JSONObject(result.toString());
			JSONObject currObs = (JSONObject) json.get("current_observation");

            String theOutput = "Weather\t\t\t: " + currObs.get("weather")
                    + "\nTemperature\t\t: " + currObs.get("temperature_string")
                    + "\nWindchill\t\t: " + currObs.get("feelslike_string")
                    + "\nRelative Humidity\t: " + currObs.get("relative_humidity")
                    + "\nWind\t\t\t: " + currObs.get("wind_string")
                    + "\nPressure\t\t: " + currObs.get("pressure_mb");
			
			System.out.println("\nWeather Conditions:");
			System.out.println("-------------------------------------------------");
			System.out.println(theOutput);
		}
		catch(IOException e){
			System.out.println("It seems that a network connection is not available, or some other error occured trying to access the provided url. "
					+ "\nURL: " + ur.toString() + "\nError Message: " + e.toString());
		}
	}
}
