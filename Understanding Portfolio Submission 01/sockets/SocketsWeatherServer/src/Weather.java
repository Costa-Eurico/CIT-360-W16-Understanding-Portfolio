/**
 * Created by eucosta on 1/28/16.
 */

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Weather {

    public static JSONObject getWeather(String state, String city) throws IOException {

        if (!city.equals("") && !state.equals("")) {
            URL wu = new URL("http://api.wunderground.com/api/22b4347c464f868e/conditions/q/" + state + "/" + city + ".json");

            try {
                //HttpURLConnection hpCon = (HttpURLConnection) wu.openConnection();
                InputStream is = (InputStream) wu.getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = null;
                StringBuffer sb = new StringBuffer();

                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                String sContent = sb.toString();

                JSONObject json = new JSONObject(sContent);

                return json;

            } catch (java.io.IOException e) {
                throw e;
            }

        } else {
            throw new IllegalArgumentException("City and State are required Argumetns");
        }
    }
}
