package Aircrafts;
import Output.SimulationOutput;
import Weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        int lon = cooridinates.getLongitude();
        int lat = cooridinates.getLatitude();
        int height = cooridinates.getHeight();
        String weather = this.weatherTower.getWeather(this.cooridinates);
        String outputLine;

        if (height <= 0){
            outputLine = getFullDetails() +": "+"we having engine problems, cannot take off. " + "lon:" + lon + " lat:" + lat + " height:" + height;
            SimulationOutput.addToOutputLine(outputLine);
            this.weatherTower.unregister(this);
            return;
        }
        else if (weather.equalsIgnoreCase("SUN")){
            int sunLongMod = 10;
            int sunHeightMod = 2;
            outputLine = getFullDetails() +": "+" The sun is so bright";
            if (height + sunHeightMod > 100){
                this.cooridinates = new Coordinates(lon + sunLongMod, lat , 100);
                outputLine += " We are at max alt.";
            }
            else {
                this.cooridinates = new Coordinates(lon + sunLongMod, lat , height + sunHeightMod);
            }
        }

        else if (weather.equalsIgnoreCase("RAIN")){
            int rainLongMod = 5;
            outputLine = getFullDetails() +": "+" Lets try avoid the rain next time.";
            this.cooridinates = new Coordinates(lon + rainLongMod, lat , height);
        }

        else if (weather.equalsIgnoreCase("FOG")){
            int fogLongMod = 1;
            outputLine = getFullDetails() +": "+" This is what I would imagine hell would be like.";
            this.cooridinates = new Coordinates(lon + fogLongMod, lat , height);
        }

        else if (weather.equalsIgnoreCase("SNOW")){
            int snowHeightMod = 12;
            if (height - snowHeightMod <= 0)
            {
                outputLine = getFullDetails() +": "+" Too much snow. We must land. " + "lon:" + lon + " lat:" +lat + " height:" + (height - snowHeightMod);
                SimulationOutput.addToOutputLine(outputLine);
                this.weatherTower.unregister(this);
                return;
            } else {
                outputLine = getFullDetails() +": "+" I feel like we shouldn't fly in the snow?";
            }
            this.cooridinates = new Coordinates(lon, lat, height - snowHeightMod);
        } else {
            outputLine = getFullDetails() + " something has gone wrong!";
        }

        SimulationOutput.addToOutputLine(outputLine);

    }

    public void registerTower(WeatherTower weatherTower){
        weatherTower.register(this);
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
    public String getFullDetails(){ return(getAircraftType()+"#" + getAircraftName() +"("+getAircraftId()+")"); }
}
