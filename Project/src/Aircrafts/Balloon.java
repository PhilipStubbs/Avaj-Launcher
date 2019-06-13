package Aircrafts;
import Weather.Coordinates;
import Weather.Tower;
import Weather.WeatherTower;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private Tower tower;

    Balloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        weatherTower.changeWeather();
        int lon = cooridinates.getLongitude();
        int lat = cooridinates.getLatitude();
        int height = cooridinates.getHeight();
        String weather = this.weatherTower.getWeather(this.cooridinates);

        if (weather.equalsIgnoreCase("SUN")){
            int sunLongMod = 2;
            int sunHeightMod = 4;
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
            int rainHeightMod = 5;
            // TODO -- Write something nice for the output.
            if (height - rainHeightMod <= 0)
            {
                // TODO -- Write unregistering messages
                this.weatherTower.unregister(this);
            }
            this.cooridinates = new Coordinates(lon, lat, height - rainHeightMod);
        }

        else if (weather.equalsIgnoreCase("FOG")){
            int fogHeightMod = 3;
            // TODO -- Write something nice for the output.
            if (height - fogHeightMod <= 0)
            {
                // TODO -- Write unregistering messages
                this.weatherTower.unregister(this);
            }
            this.cooridinates = new Coordinates(lon, lat, height - fogHeightMod);
        }

        else if (weather.equalsIgnoreCase("SNOW")){
            int snowHeightMod = 15;
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

    public void getAirNames() {
        System.out.println(Balloon.this.getName());
    }

}
