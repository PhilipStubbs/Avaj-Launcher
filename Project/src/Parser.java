import Aircrafts.AircraftFactory;
import Aircrafts.Flyable;
import CustomException.InvaildFileLineException;
import Weather.Tower;
import Aircrafts.AircraftFactory;
import CustomException.InvalidAircraftTypeException;

public class Parser {

    private static void createAircrafts(String[] split, Tower tower) throws InvalidAircraftTypeException {
        String type = split[0];
        String name = split[1];
        int longitude = Integer.parseInt(split[2]);
        int latitude = Integer.parseInt(split[3]);
        int height = Integer.parseInt(split[4]);
        Flyable spaceShip = new AircraftFactory().newAircraft(type, name, longitude, latitude, height);
        // TODO -- add weather tower to spaceships

        tower.register(spaceShip);
        spaceShip.getAirNames();
    }

    static void avajLauncherParser(String fileLine, Tower tower) throws InvaildFileLineException ,InvalidAircraftTypeException {
        String[] split = fileLine.trim().split("\\s+");
        if (split.length == 1 && isNumeric(split[0])){


            // TODO -- do something about the first one
            return;
        } else  if (split.length != 5 || !isNumeric(split[2]) || !isNumeric(split[3]) || !isNumeric(split[4]))  {
            throw new InvaildFileLineException(fileLine);
        }

        createAircrafts(split, tower);
    }

    private static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}
