import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class Main {
	
	public static void main(String[] args) {
		System.out.println("started ...");
		
		//all Boxes, 75 per row
		int boxes = 150;
		
		//all visitors, depends on possibility
		//int visitors;
		
		//possibility if a visitor is coming to the gym or not
		double possibilityOfaVisitor = 0.1;
		
		//all time slots per day, one timeslots means 10 seconds
		int timeSlotsperDay = 4320;
		
		//number of days
		int days = 30;
		
		HashMap<Integer, Integer> allvisits = new HashMap<Integer,Integer>();
		BufferedReader reader;
		String content = "";
		try {
			reader = new BufferedReader(new FileReader(new File("/home/jayjah/Schreibtisch/Belegungszeiten.txt")));
			while (reader.readLine()!=null) {
				String line = reader.readLine();
				String[] array = line.split(" ");
				int timeofbeingingym = Integer.parseInt(array[0]);
				int howoft = Integer.parseInt(array[1]);
				allvisits.put(timeofbeingingym, howoft);
			}
			System.out.println(allvisits.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
