package Aircrafts;
import Weather.Coordinates;
import Weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
        // TODO -- Helicopter
    }

    public void updateConditions(){
        weatherTower.changeWeather();
        // TODO -- updateConditions
    }

    public void registerTower(WeatherTower weatherTower){
        // TODO -- registerTower
    }
}
