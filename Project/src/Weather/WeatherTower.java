package Weather;

import Weather.Coordinates;
import Weather.WeatherProvider;

public class WeatherTower {
    WeatherProvider weatherUpdating;

    public String getWeather(Coordinates coordinates){
        return(weatherUpdating.getCurrentWeather(coordinates));
    }

    public void changeWeather(){
        // TODO -- changeWeather
    }
}
