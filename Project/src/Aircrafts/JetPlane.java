package Aircrafts;
import Output.SimulationOutput;
import Weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        int lon = cooridinates.getLongitude();
        int lat = cooridinates.getLatitude();
        int height = cooridinates.getHeight();
        String weather = this.weatherTower.getWeather(this.cooridinates);
        String outputLine;

        if (height <= 0){
            outputLine = getFullDetails() +": "+"I dont feel like flying today. " + "lon:" + lon + " lat:" +lat + " height:" + height;
            SimulationOutput.addToOutputLine(outputLine);
            this.weatherTower.unregister(this);
            return;
        }

        else if (weather.equalsIgnoreCase("SUN")){
            int sunLatMod = 10;
            int sunHeightMod = 2;
            outputLine = getFullDetails() +": "+" It sure is hot.";
            if (height + sunHeightMod > 100){
                this.cooridinates = new Coordinates(lon, lat + sunLatMod, 100);
                outputLine += " We are at max alt.";
            }
            else {
                this.cooridinates = new Coordinates(lon, lat + sunLatMod, height + sunHeightMod);
            }
        }

        else if (weather.equalsIgnoreCase("RAIN")){
            int rainLatMod = 5;
            outputLine = getFullDetails() +": "+" I should correct for the rain";
            this.cooridinates = new Coordinates(lon, lat + rainLatMod, height);
        }

        else if (weather.equalsIgnoreCase("FOG")){
            int fogLatMod = 1;
            outputLine = getFullDetails() +": "+" I cant see the ground, its too foggy.";
            this.cooridinates = new Coordinates(lon, lat + fogLatMod, height);
        }

        else if (weather.equalsIgnoreCase("SNOW")){
            int snowHeightMod = 7;
            if (height - snowHeightMod <= 0)
            {
                outputLine = getFullDetails() +": "+" Landing due to snow. " + "lon:" + lon + " lat:" +lat + " height:" + (height - snowHeightMod);
                SimulationOutput.addToOutputLine(outputLine);
                this.weatherTower.unregister(this);
                return;
            } else {
                outputLine = getFullDetails() +": "+" so much snow!";
            }
            this.cooridinates = new Coordinates(lon, lat, height - snowHeightMod);
        }
        else {
            outputLine = getFullDetails() + " something has gone wrong!";
        }
        SimulationOutput.addToOutputLine(outputLine);
    }

    public void registerTower(WeatherTower weatherTower){
        weatherTower.register(this);
       this.weatherTower = weatherTower;
    }

    public String getAircraftName() {return(JetPlane.this.getName()); }
    public String getAircraftType() { return ("JetPlane"); }
    public String getAircraftId() {return(JetPlane.this.getId()); }
    public String getFullDetails(){ return(getAircraftType()+"#" + getAircraftName() +"("+getAircraftId()+")"); }

}
