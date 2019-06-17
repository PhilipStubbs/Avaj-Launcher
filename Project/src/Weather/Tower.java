package Weather;

import Aircrafts.Flyable;
import java.util.ArrayList;
import java.util.List;

import Output.SimulationOutput;

public class Tower {
	static private WeatherTower weatherTower = new WeatherTower();
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable){
		if(!observers.contains(flyable)){
		flyable.registerTower(weatherTower);
			observers.add(flyable);
			String outputLine = "Tower says: "+flyable.getAircraftType()+"#" + flyable.getAircraftName() +"("+flyable.getAircraftId()+")" + " registered to weather tower.";
			SimulationOutput.addToOutputline(outputLine);
		} else {
			System.out.println("already exists");
		}
	}

	public void unregister(Flyable flyable){
		if(observers.contains(flyable)){
			observers.remove(flyable);
		}
	}


	protected void conditionsChanged(){
		observers.forEach(flyable -> flyable.updateConditions());
	}
}
