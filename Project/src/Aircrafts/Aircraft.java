package Aircrafts;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates cooridinates;
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates){

        this.id = nextid();
        this.name = name;
        this.cooridinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public String getId(){
        return (Long.toString(id));
    }

    private long nextid(){

        return (Aircraft.idCounter++);
    }
}
