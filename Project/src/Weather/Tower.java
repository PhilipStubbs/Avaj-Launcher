package Weather;

import Aircrafts.Flyable;
import java.util.ArrayList;
import java.util.List;

import Output.SimulationOutput;

public abstract class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable){
		if(!observers.contains(flyable)){
			observers.add(flyable);
			String outputLine = "Tower says: "+flyable.getFullDetails() + ":"+ " registered to weather tower.";
			SimulationOutput.addToOutputline(outputLine);
		} else {
			System.out.println("already exists");
		}
	}

	public void unregister(Flyable flyable){
		if(observers.contains(flyable)){
			observers.remove(flyable);
			String outputLine = "Tower says: "+flyable.getFullDetails() + ":"+ " is now unregistered from weather tower.";
			SimulationOutput.addToOutputline(outputLine);
		}
	}

	protected void conditionsChanged(){
		{
			for(int i = 0; i < observers.size(); i++)
			{
				observers.get(i).updateConditions();
			}
		}
	}
}
