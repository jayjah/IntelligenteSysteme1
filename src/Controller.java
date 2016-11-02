import java.util.HashMap;
import java.util.Random;

/**
 * This class controlls the simulation
 * @author Markus, Kim
 *
 */
public class Controller {

	/**
	 * Possibility weather a Visitor is coming or not
	 */
	private double possibilityOfaVisitor;
	
	/**
	 * Digit of all boxes
	 */
	private int allBoxes;
	
	/**
	 * Digit of all time slots per day
	 */
	private int timeSlotsperDay;
	
	/**
	 * Hold hoch much days
	 */
	private int days;
	
	/**
	 * Hold how long the Visitors may be
	 */
	private HashMap<Integer,Integer> allVisits;
	
	/**
	 * Random Generator
	 */
	private static Random random;
	
	/**
	 * Hold the gym
	 */
	private Gym gym;
	
	/**
	 * Constructor
	 */
	public Controller(double poss, int boxes, int timeslots, int days, HashMap<Integer,Integer> visits) {
		this.possibilityOfaVisitor = poss;
		this.allBoxes = boxes;
		this.timeSlotsperDay = timeslots;
		this.days = days;
		this.allVisits = visits;
		this.random = new Random();
	}
}
