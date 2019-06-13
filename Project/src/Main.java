import Aircrafts.AircraftFactory;
import Aircrafts.Flyable;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static List<String> readFileInList(String fileName)
    {

        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }

        catch (IOException e) {
            System.out.println("Something Went Wrong");
//            e.printStackTrace();
        }
        return lines;
    }

      public static void main(String[] args) {
            BufferedReader br = null;
            if (args.length == 1) {
                try {
                    br = new BufferedReader(new FileReader(args[0]));
                    String line;

                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                        // TODO -- point this to the avaj_launcher parser.
                    }

                } catch (IOException e) {
                    System.out.println("Invalid File");
                } finally {
                    try {
                        if (br != null) {
                            br.close();
                        }
                    } catch (IOException e) {
                        System.out.println("Error closing");
                    }
                }
            } else {
                System.out.println("No file");
            }


        Flyable t = new AircraftFactory().newAircraft("balloon","test",1,1,1);

        t.getAirNames();

    }
}
