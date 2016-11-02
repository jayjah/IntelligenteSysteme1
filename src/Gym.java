import java.util.LinkedList;

/**
 * This class holds all boxes 
 * @author Markus, Kim
 *
 */
public class Gym {

	/**
	 * List of free Boxes
	 */
	private LinkedList<Box> allFreeBoxes;
	
	/**
	 * List of blocked Boxes
	 */
	private LinkedList<Box> allBlockedBoxes;

	/**
	 * Constructor
	 */
	public Gym() {
		allFreeBoxes = new LinkedList<Box>();
		allBlockedBoxes = new LinkedList<Box>();
	}
	
	/**
	 * Getter
	 * @return allFreeBoxes
	 */
	public LinkedList<Box> getAllFreeBoxes() {
		return allFreeBoxes;
	}
	
	/**
	 * Getter
	 * @return allBlockedBoxes
	 */
	public LinkedList<Box> getAllBlockedBoxes() {
		return allBlockedBoxes;
	}
}
