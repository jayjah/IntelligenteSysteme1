import java.util.LinkedList;

/**
 * This class holds all Boxes and Visitors
 * 
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
	 * Holds all Visitors who visits the Gym
	 */
	private LinkedList<Visitor> allVisitors;

	/**
	 * Constructor
	 */
	public Gym(short allBoxes) {
		allFreeBoxes = new LinkedList<Box>();
		allBlockedBoxes = new LinkedList<Box>();
		allVisitors = new LinkedList<Visitor>();
		initializeBoxes(allBoxes);
	}

	/**
	 * Initialize all Boxes with their neighbors and set them to allFreeBoxes
	 * 
	 * @param allBoxes
	 *            how many boxes exist
	 */
	private void initializeBoxes(short allBoxes) {
		for (int counterforboxes = 0; counterforboxes < allBoxes; counterforboxes++) {
			Box newBox = new Box(counterforboxes, BoxStatus.free);
			allFreeBoxes.add(newBox);
		}
		// TODO Initialize all neighbors of all boxes in allFreeBoxes
		// for (Box box : allFreeBoxes) {

		// }
	}
	
	/**
	 * 
	 */
	public void afterDay() {
		for (int i = 0; i<allVisitors.size(); i++) {
			allVisitors.remove(i);
		}
		for (int i = 0; i<allBlockedBoxes.size(); i++) {
			allBlockedBoxes.get(i).setStatus(BoxStatus.free);
			allFreeBoxes.add(allBlockedBoxes.get(i));
			allBlockedBoxes.remove(i);
		}
	}

	/**
	 * Getter
	 * 
	 * @return allVisitors
	 */
	public LinkedList<Visitor> getAllVisitors() {
		return allVisitors;
	}

	/**
	 * Getter
	 * 
	 * @return allFreeBoxes
	 */
	public LinkedList<Box> getAllFreeBoxes() {
		return allFreeBoxes;
	}

	/**
	 * Getter
	 * 
	 * @return allBlockedBoxes
	 */
	public LinkedList<Box> getAllBlockedBoxes() {
		return allBlockedBoxes;
	}
}
