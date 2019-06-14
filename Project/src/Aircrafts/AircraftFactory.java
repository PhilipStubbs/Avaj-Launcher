package Aircrafts;

import Weather.Coordinates;
import CustomException.InvalidAircraftTypeException;

public class AircraftFactory {

    enum AircraftTypes {
        helicopter,
        jetplane,
        balloon
    }

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coords = new Coordinates(longitude, latitude, height);

        switch (AircraftTypes.valueOf(type.toLowerCase())) {
            case helicopter:
                return(new Helicopter(name, coords));

            case jetplane:
                return (new JetPlane(name, coords));

            case balloon:
                return(new Balloon(name, coords));

            default:
                return(null);
//                throw new InvalidAircraftTypeException(type + "is not vaild");
          }

     }
}
