package Aircrafts;
import Weather.Coordinates;
import Weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        weatherTower.changeWeather();
        // TODO -- updateConditions
    }

    public void registerTower(WeatherTower weatherTower){
        // TODO -- registerTower
    }
}
