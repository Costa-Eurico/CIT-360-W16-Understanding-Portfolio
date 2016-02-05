import org.json.JSONObject;

import java.io.IOException;

public class SocketWeatherProtocol {
    private static final int WAITING = 0;
    private static final int SENTCONNECTED = 1;
    private static final int SENTRESULT = 2;
    private static final int ANOTHER = 3;
    private int state = WAITING;

    private String country = "";
    private String city = "";

    public String processInput(String theInput) {
        String theOutput = null;
        JSONObject json = null;

        if (state == WAITING) {
            theOutput = "You've successfully connected to the weather server!";
            state = SENTCONNECTED;
        } else if (state == SENTCONNECTED) {
            String[] aInput = theInput.split("%");

            country = aInput[0];
            city = aInput[1];

            try {

                json = Weather.getWeather(country, city);
                JSONObject currObs = (JSONObject) json.get("current_observation");

                theOutput = "Weather: " + currObs.get("weather")
                        + "\nTemperature: " + currObs.get("temperature_string")
                        + "\nWindchill: " + currObs.get("feelslike_string")
                        + "\nRelative Humidity: " + currObs.get("relative_humidity")
                        + "\nWind: " + currObs.get("wind_string")
                        + "\nPressure: " + currObs.get("pressure_mb");

                state = SENTRESULT;

            } catch (IOException e) {
                theOutput = e.getMessage();
            }
        } else {
            theOutput = "Bye.";
        }

        return theOutput;
    }
}
