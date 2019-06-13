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
        String currentPath =  Paths.get("").toAbsolutePath().toString();;
        String path = currentPath + "/scenario.txt";
        List l = readFileInList(path);
        Iterator<String> itr = l.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

        System.out.println(path);
        System.out.println(l.toString());
        Flyable t = new AircraftFactory().newAircraft("balloon","test",1,1,1);

        t.getAirNames();

    }
}
