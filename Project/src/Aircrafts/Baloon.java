package Aircrafts;
import Weather.Coordinates;
import Weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
        // TODO -- Baloon
    }

    public void updateConditions(){
        weatherTower.changeWeather();
        // TODO -- updateConditions
    }

    public void registerTower(WeatherTower weatherTower){
        // TODO -- registerTower
    }
}
