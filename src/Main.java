import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {
		// all Boxes, 75 per row
		short boxes = 150;

		// possibility if a visitor is coming to the gym or not
		double possibilityOfaVisitor = 0.1;

		// all time slots per day, one timeslots means 10 seconds
		short timeSlotsperDay = 4320;

		// number of days; how often the focus person'll visit the gym 
		short days = 1000;

		// get an array of all
		int[] allvisits = new int[50127];
		BufferedReader reader;
		int counter = 0;
		try {
			reader = new BufferedReader(new FileReader(new File(
					"src/resources/Belegungszeiten.txt")));
			while (reader.readLine() != null) {
				String line = reader.readLine();
				String[] array = line.split(" ");
				int timeofbeingingym = Integer.parseInt(array[0]);
				int howoft = Integer.parseInt(array[1]);
				for (int i = howoft; i > 0; i--) {
					allvisits[counter] = timeofbeingingym;
					counter++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Startpoint of simulation
		long startPoint = System.currentTimeMillis();
		System.out.println("Started at: " + startPoint);

		// Start the simulation
		Controller controll = new Controller(possibilityOfaVisitor, boxes,
				timeSlotsperDay, days, allvisits);
		controll.letTheSimulationRun();
		
		// Endpoint of simulation
		long endPoint = System.currentTimeMillis();
		System.out.println("Ended at: " + endPoint);
		long difference = endPoint - startPoint;
		System.out.println("Differnece between Startpoint and Endpoint (in millisec): " + difference);
	}
}
