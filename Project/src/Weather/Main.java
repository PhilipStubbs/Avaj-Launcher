package Weather;

import CustomException.AircraftExistsException;
import CustomException.InvaildFileLineException;
import CustomException.InvalidAircraftTypeException;
import Output.SimulationOutput;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {


	  public static void main(String[] args) throws InvalidAircraftTypeException, AircraftExistsException {
			BufferedReader br = null;
			int gameTime = 0;
			int round = -1;

			if (args.length == 1) {
				try {
					WeatherTower weatherTower = new WeatherTower();

					br = new BufferedReader(new FileReader(args[0]));
					String line;

					/*  Grabs first line to check simulation time */
					if ((line = br.readLine()) != null) {
						gameTime = Parser.checkFirstLine(line);
					}

					/*  Grabs the rest of the lines to check/create ships */
					while ((line = br.readLine()) != null) {
						Parser.avajLauncherParser(line, weatherTower);
					}

					/*  simulation */
					while (++round <= gameTime){
						weatherTower.changeWeather();
					}
					SimulationOutput.writeToSimulation();
					System.out.println("Finished running simulation " + gameTime+" times.");

				} catch (IOException | InvaildFileLineException e) {
					e.printStackTrace();
				}
				finally {
					try {
						if (br != null) {
							br.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Error closing");
					}
				}
			} else {
				System.out.println("No file");
			}

	}
}

