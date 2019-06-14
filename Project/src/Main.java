import Aircrafts.AircraftFactory;
import Aircrafts.Flyable;
import CustomException.InvaildFileLineException;
import CustomException.InvalidAircraftTypeException;
import Weather.Tower;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {


      public static void main(String[] args) throws InvalidAircraftTypeException {
            BufferedReader br = null;
            int gameTime;
            int round = 0;
            Tower tower = new Tower();
            if (args.length == 1) {
                try {
                    br = new BufferedReader(new FileReader(args[0]));
                    String line;

                    while ((line = br.readLine()) != null) {
//                        System.out.println(line);
                        Parser.avajLauncherParser(line, tower);
                    }
//                    while (round <= gameTime){
//                        // TODO -- simulation
//                        System.out.println("do simulation stuff here");
//                    }

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

          System.out.println("No file");

//        Flyable t = new AircraftFactory().newAircraft("balloon","Ballon1",1,1,1);

//        t.getAirNames();

    }


}

