package Weather;
import Aircrafts.Coordinates;

import java.util.Random;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider(){}

	public static WeatherProvider getProvider(){
	   return(weatherProvider);
	}

	public String getCurrentWeather(Coordinates coordinates){
		Random rn = new Random();
		int randomSeed = (coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude() + (rn.nextInt() %4)) % 4;
		if (randomSeed > 3){
			randomSeed = 3;
		} else if (randomSeed < 0){
			randomSeed = 0;
		}
		return (weather[randomSeed]);
	}
}
