package Weather;

import Weather.Coordinates;
import Weather.WeatherProvider;

public class WeatherTower extends Tower {
    WeatherProvider weatherUpdating;

    public String getWeather(Coordinates coordinates){
        return(weatherUpdating.getProvider().getCurrentWeather(coordinates));
    }

    public void changeWeather(){
        // TODO -- changeWeather
        weatherUpdating.getProvider();
    }
}
