package Output;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SimulationOutput {
	private static Writer writer = null;
	private static List<String> output = new ArrayList<String>();


	static public void writeToSimulation() {
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("simulation.txt"), StandardCharsets.UTF_8));
			for (String line: output) {
				writer.write(line);
			}
		} catch (IOException ex) {
		} finally {
			try {writer.close();} catch (Exception ex) {}
		}
	}

	static public void addToOutputLine(String line) {
		output.add(line + "\n");
	}
}
