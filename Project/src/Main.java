import Aircrafts.AircraftFactory;
import Aircrafts.Flyable;
import CustomException.InvaildFileLineException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {


      public static void main(String[] args) {
            BufferedReader br = null;
            if (args.length == 1) {
                try {
                    br = new BufferedReader(new FileReader(args[0]));
                    String line;

                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                        Parser.avajLauncherParser(line);
                        // TODO -- point this to the avaj_launcher parser.
                    }

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


        Flyable t = new AircraftFactory().newAircraft("balloon","Ballon1",1,1,1);

        t.getAirNames();

    }


}

