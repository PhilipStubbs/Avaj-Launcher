package Aircrafts;

import Weather.Coordinates;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates cooridinates;
    private static long idCounter;

    public Aircraft(String name, Coordinates coordinates){
        // TODO -- Aircrafts.Aircraft
    }

    private long nextid(){
        return (Aircraft.idCounter + 1);
    }
}
