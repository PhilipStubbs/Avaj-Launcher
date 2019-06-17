package Weather;
import java.util.concurrent.ThreadLocalRandom;

public class WeatherProvider {
	private WeatherProvider weatherProvider;
	private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider(){
		// TODO -- Weather.WeatherProvider
	}

	public WeatherProvider getProvider(){
	   return(this.weatherProvider);
	}

	public String getCurrentWeather(Coordinates coordinates){
		int randomSeed = (coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude()) % 4;
		return (weather[randomSeed]);
	}
}
