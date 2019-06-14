package Aircrafts;

import Weather.Coordinates;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates cooridinates;
    private static long idCounter;

    public Aircraft(String name, Coordinates coordinates){

        this.id = nextid();
        this.name = name;
        this.cooridinates = coordinates;
    }

    public String getName() {
        return name;
    }

    private long nextid(){

        return (Aircraft.idCounter++);
    }
}
