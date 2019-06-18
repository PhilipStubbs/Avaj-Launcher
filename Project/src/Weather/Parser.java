package Weather;

import Aircrafts.AircraftFactory;
import Aircrafts.Flyable;
import CustomException.AircraftExistsException;
import CustomException.InvaildFileLineException;
import CustomException.InvalidAircraftTypeException;

public class Parser {

	static int checkFirstLine(String fileLine) throws InvaildFileLineException {
		String[] split = fileLine.trim().split("\\s+");
		if (split.length == 1 && isNumeric(split[0])){
			return (Integer.parseInt(split[0]));
		} else {
			throw new InvaildFileLineException(fileLine);
		}
	}

	private static void createAircraft(String[] split,  WeatherTower weatherTower) throws InvalidAircraftTypeException {
		String type = split[0];
		String name = split[1];
		int longitude = Integer.parseInt(split[2]);
		int latitude = Integer.parseInt(split[3]);
		int height = Integer.parseInt(split[4]);
		Flyable spaceShip = new AircraftFactory().newAircraft(type, name, longitude, latitude, height);
		spaceShip.registerTower(weatherTower);
	}

	static void avajLauncherParser(String fileLine, WeatherTower weatherTower) throws InvaildFileLineException ,InvalidAircraftTypeException, AircraftExistsException {
		String[] split = fileLine.trim().split("\\s+");
		if (split.length != 5)  {
			throw new InvaildFileLineException(fileLine + "\"->\""+ "invalid amount of arguments:"+split.length);
		}
		else  if (!isNumeric(split[2])) {
			throw new InvaildFileLineException(fileLine + "\"->\""+ split[2]);
		}
		else  if (!isNumeric(split[3])) {
			throw new InvaildFileLineException(fileLine + "\"->\""+ split[3]);
		}
		else  if (!isNumeric(split[4])) {
			throw new InvaildFileLineException(fileLine + "\"->\""+ split[4]);
		}

		createAircraft(split ,weatherTower);
	}

	private static boolean isNumeric(String strNum) {
		try {
			int	i = Integer.parseInt(strNum);
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
		return true;
	}
}
