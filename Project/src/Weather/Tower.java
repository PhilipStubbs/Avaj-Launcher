package Weather;

import Aircrafts.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {

    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        if(!observers.contains(flyable)){
            observers.add(flyable);
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
