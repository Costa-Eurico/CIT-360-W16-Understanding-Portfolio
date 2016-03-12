//HTTPURLConnection Example

import java.net.*;
import java.io.*;
import java.util.*;

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
			
			//get list of header fields and a set of the header keys
			Map<String, List<String>> headerMap = httpCon.getHeaderFields();
			Set<String> headerField = headerMap.keySet();
			
			System.out.println("Header details: ");
			//display all header keys and values
			for(String key : headerField) {
				System.out.println("Key: " + key + " Value: " + headerMap.get(key));
			}
			
			//read stream
			InputStream in = httpCon.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			StringBuilder result = new StringBuilder();
			String line;
			while((line = reader.readLine()) != null) {
			    result.append(line);
			}
			System.out.println("\nJSON Object\n\n" + result.toString());
		}
		catch(IOException e){
			System.out.println("It seems that a network connection is not available, or some other error occured trying to access the provided url. "
					+ "\nURL: " + ur.toString() + "\nError Message: " + e.toString());
		}
	}
}
