package Weather;
import java.util.concurrent.ThreadLocalRandom;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider(){}

	public static WeatherProvider getProvider(){
	   return(weatherProvider);
	}

	public String getCurrentWeather(Coordinates coordinates){
		int randomSeed = (coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude()) % 4;
		return (weather[randomSeed]);
	}
}
