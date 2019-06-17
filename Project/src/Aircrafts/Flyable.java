package Aircrafts;

import Weather.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower WeatherTower);
    String getAircraftName();
    String getAircraftType();
    String getAircraftId();
}
