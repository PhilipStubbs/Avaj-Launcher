package Aircrafts;
import Weather.Coordinates;
import Weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        weatherTower.changeWeather();
        int lon = cooridinates.getLongitude();
        int lat = cooridinates.getLatitude();
        int height = cooridinates.getHeight();
        String weather = this.weatherTower.getWeather(this.cooridinates);

        if (weather.equalsIgnoreCase("SUN")){
            int sunLongMod = 10;
            int sunHeightMod = 2;
            // TODO -- Write something nice for the output.
            if (height + sunHeightMod > 100){
                // TODO -- max alt
                this.cooridinates = new Coordinates(lon, lat + sunLongMod, 100);
            }
            else {
                this.cooridinates = new Coordinates(lon, lat + sunLongMod, height + sunHeightMod);
            }
        }

        else if (weather.equalsIgnoreCase("RAIN")){
            int rainLongMod = 5;
            // TODO -- Write something nice for the output.
            this.cooridinates = new Coordinates(lon, lat + rainLongMod, height);
        }

        else if (weather.equalsIgnoreCase("FOG")){
            int fogLongMod = 1;
            // TODO -- Write something nice for the output.
            this.cooridinates = new Coordinates(lon, lat + fogLongMod, height);
        }

        else if (weather.equalsIgnoreCase("SNOW")){
            int snowHeightMod = 12;
            // TODO -- Write something nice for the output.
            if (height - snowHeightMod <= 0)
            {
                // TODO -- Write unregistering messages
                this.weatherTower.unregister(this);
            }
            this.cooridinates = new Coordinates(lon, lat, height - snowHeightMod);
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
    }

    public String getAircraftName() {
        return(Helicopter.this.getName());
    }
    public String getAircraftType() {
        return ("Helicopter");
    }
    public String getAircraftId() {
        return(Helicopter.this.getId());
    }
}
