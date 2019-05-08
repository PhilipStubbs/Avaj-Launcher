package Aircrafts;
import Weather.Coordinates;
import Weather.Tower;
import Weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        weatherTower.changeWeather();
        int lon = cooridinates.getLongitude();
        int lat = cooridinates.getLatitude();
        int height = cooridinates.getHeight();
        String weather = this.weatherTower.getWeather(this.cooridinates);

        if (weather.equalsIgnoreCase("SUN")){
            int sunLatMod = 10;
            int sunHeightMod = 2;
            // TODO -- Write something nice for the output.
            if (height + sunHeightMod > 100){
                // TODO -- max alt
                this.cooridinates = new Coordinates(lon, lat + sunLatMod, 100);
            }
            else {
                this.cooridinates = new Coordinates(lon, lat + sunLatMod, height + sunHeightMod);
            }
        }

        else if (weather.equalsIgnoreCase("RAIN")){
            int rainLatMod = 5;
            // TODO -- Write something nice for the output.
            this.cooridinates = new Coordinates(lon, lat + rainLatMod, height);
        }

        else if (weather.equalsIgnoreCase("FOG")){
            int fogLatMod = 1;
            // TODO -- Write something nice for the output.
            this.cooridinates = new Coordinates(lon, lat + fogLatMod, height);
        }

        else if (weather.equalsIgnoreCase("SNOW")){
            int snowHeightMod = 7;
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
        System.out.println(JetPlane.this.getName());
    }
}
