import Aircrafts.AircraftFactory;
import Aircrafts.Flyable;
import CustomException.InvaildFileLineException;
//import Weather.Tower;
import Aircrafts.AircraftFactory;

public class Parser {

    static void createAircrafts(String[] splited){
        Flyable t = new AircraftFactory(splited[0], splited[1], stoi(splited[3]));
    }

    static void avajLauncherParser(String fileLine) throws InvaildFileLineException {
        String[] splited = fileLine.trim().split("\\s+");
        if (splited.length == 1 && isNumeric(splited[0])){
            System.out.println(" 1");
        } else  if (splited.length != 5 || !isNumeric(splited[2]) || !isNumeric(splited[3]) || !isNumeric(splited[4]))  {
            throw new InvaildFileLineException(fileLine);
        }

        createAircrafts(splited);
    }

    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}
