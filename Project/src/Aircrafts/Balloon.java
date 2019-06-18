package Aircrafts;
import Output.SimulationOutput;
import Weather.WeatherTower;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Balloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        int lon = cooridinates.getLongitude();
        int lat = cooridinates.getLatitude();
        int height = cooridinates.getHeight();
        String weather = this.weatherTower.getWeather(this.cooridinates);
        String outputLine;

        if (weather.equalsIgnoreCase("SUN")){
            int sunLongMod = 2;
            int sunHeightMod = 4;
            outputLine = getFullDetails() +": "+" Its nice an sunny up here.";
            if (height + sunHeightMod > 100){
                this.cooridinates = new Coordinates(lon, lat + sunLongMod, 100);
            }
            else {
                this.cooridinates = new Coordinates(lon, lat + sunLongMod, height + sunHeightMod);
            }
        }

        else if (weather.equalsIgnoreCase("RAIN")){
            int rainHeightMod = 5;

            if (height - rainHeightMod <= 0)
            {
                outputLine = getFullDetails() +": "+" I'm Landing due to the rain.";
                this.weatherTower.unregister(this);
            } else {
                outputLine = getFullDetails() + ": " + " Its quite rainy up here.";
            }

            this.cooridinates = new Coordinates(lon, lat, height - rainHeightMod);
        }

        else if (weather.equalsIgnoreCase("FOG")){
            int fogHeightMod = 3;

            if (height - fogHeightMod <= 0)
            {
                outputLine = getFullDetails() + ": " + " I'm landing due to the fog";
                this.weatherTower.unregister(this);
            }else {
                outputLine = getFullDetails() + ": " + " I cant see anything due to the fog, hope I dont crash..";
            }
            this.cooridinates = new Coordinates(lon, lat, height - fogHeightMod);
        }

        else if (weather.equalsIgnoreCase("SNOW")){
            int snowHeightMod = 15;
            if (height - snowHeightMod <= 0)
            {
                outputLine = getFullDetails() + ": " + " I'm landing due to the snow";
                this.weatherTower.unregister(this);
            } else {
                outputLine = getFullDetails() + ": " + " The snow is nice.";
            }
            this.cooridinates = new Coordinates(lon, lat, height - snowHeightMod);
        }
        else {
            outputLine = getFullDetails() + " something has gone wrong!";
        }

        SimulationOutput.addToOutputline(outputLine);
    }

    public void registerTower(WeatherTower weatherTower){
        weatherTower.register(this);
        this.weatherTower = weatherTower;
    }

    public String getAircraftName() {
        return(Balloon.this.getName());
    }
    public String getAircraftType() {
        return ("Balloon");
    }
    public String getAircraftId() {
        return(Balloon.this.getId());
    }
    public String getFullDetails(){ return(getAircraftType()+"#" + getAircraftName() +"("+getAircraftId()+")"); }
}
