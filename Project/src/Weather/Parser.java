package Weather;

import Aircrafts.AircraftFactory;
import Aircrafts.Flyable;
import CustomException.AircraftExistsException;
import CustomException.InvaildFileLineException;
import Weather.Tower;
import Aircrafts.AircraftFactory;
import CustomException.InvalidAircraftTypeException;
import java.util.ArrayList;
import java.util.List;

import java.util.regex.Pattern;

public class Parser {
	private static List<String> shipNames = new ArrayList<String>();

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

		shipNames.add(name);
		// TODO -- add weather tower to spaceships

//		tower.register(spaceShip);
//		spaceShip.getAirNames();
	}

	static void avajLauncherParser(String fileLine, WeatherTower weatherTower) throws InvaildFileLineException ,InvalidAircraftTypeException, AircraftExistsException {
		String[] split = fileLine.trim().split("\\s+");
		if (split.length != 5)  {
			throw new InvaildFileLineException(fileLine);
		}
//		else if (shipNames.contains(split[1])) {
//			throw new AircraftExistsException(fileLine + " -> With name:\""+ split[1]);
//		}
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
//			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
		return true;
	}
}
