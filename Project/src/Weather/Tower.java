package Weather;

import Aircrafts.Flyable;
import java.util.ArrayList;
import java.util.List;

public class Tower {
    static private WeatherTower weatherTower = new WeatherTower();
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        if(!observers.contains(flyable)){
        flyable.registerTower(weatherTower);
            observers.add(flyable);
        }
    }

    public void unregister(Flyable flyable){
        if(observers.contains(flyable)){
            observers.remove(flyable);
        }
    }

//    public void printFlyable(){
//        for (Flyable spaceShip: observers) {
//            System.out.println("" + spaceShip.);
//        }
//    }

    protected void conditionsChanged(){
        observers.forEach(flyable -> flyable.updateConditions());
    }
}
