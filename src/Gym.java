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
	 * Holds all Visitors who visits the Gym
	 */
	private LinkedList<Visitor> allVisitors;
	
	/**
	 * Holds all focus Visitors who visits the gym
	 */
	private LinkedList<Visitor> allFocusVisitors;
	
	/**
	 * Weather the focus Visitor was here today or not
	 */
	private boolean focusVisitorwasHere;

	
	/**
	 * Constructor
	 */
	public Gym(short allBoxes, short days) {
		this.allFreeBoxes = new LinkedList<Box>();
		this.allVisitors = new LinkedList<Visitor>();
		this.allFocusVisitors = new LinkedList<Visitor>();
		this.focusVisitorwasHere = false;
		initializeBoxes(allBoxes);
	}

	/**
	 * Initialize all Boxes with their neighbors and set them to allFreeBoxes
	 * 
	 * @param allBoxes
	 *            how many boxes exist
	 */
	private void initializeBoxes(short allBoxes) {
		//initialize all boxes
		for (int counterforboxes = 0; counterforboxes < allBoxes; counterforboxes++) {
			Box newBox = new Box(counterforboxes, BoxStatus.free);
			allFreeBoxes.add(newBox);
		}
		//initialize neighbors of all boxes
		for (int i = 0; i < allBoxes; i++) {
			//first Box
			if (getAllFreeBoxes().get(i).getId() == 0) {
				getAllFreeBoxes().get(i).setAbove(null);
				getAllFreeBoxes().get(i).setBelow(getAllFreeBoxes().get(allBoxes/2));
				getAllFreeBoxes().get(i).setPrevBox(null);
				getAllFreeBoxes().get(i).setNextBox(getAllFreeBoxes().get(i+1));
				continue;
			}
			//last Box
			if (getAllFreeBoxes().get(i).getId() == allBoxes-1) {
				getAllFreeBoxes().get(i).setAbove(getAllFreeBoxes().get(allBoxes/2-1));
				getAllFreeBoxes().get(i).setBelow(null);
				getAllFreeBoxes().get(i).setPrevBox(getAllFreeBoxes().get(i-1));
				getAllFreeBoxes().get(i).setNextBox(null);
				continue;
			}
			//last Box in first row
			if (getAllFreeBoxes().get(i).getId() == allBoxes/2-1) {
				getAllFreeBoxes().get(i).setAbove(null);
				getAllFreeBoxes().get(i).setBelow(getAllFreeBoxes().get(allBoxes-1));
				getAllFreeBoxes().get(i).setPrevBox(getAllFreeBoxes().get(i-1));
				getAllFreeBoxes().get(i).setNextBox(null);
				continue;
			}
			//first Box in second row
			if (getAllFreeBoxes().get(i).getId() == allBoxes/2) {
				getAllFreeBoxes().get(i).setAbove(getAllFreeBoxes().get(0));
				getAllFreeBoxes().get(i).setBelow(null);
				getAllFreeBoxes().get(i).setPrevBox(null);
				getAllFreeBoxes().get(i).setNextBox(getAllFreeBoxes().get(i+1));
				continue;
			}
			//boxes in first row
			if (getAllFreeBoxes().get(i).getId() < allBoxes/2) {
				getAllFreeBoxes().get(i).setAbove(null);
				getAllFreeBoxes().get(i).setBelow(getAllFreeBoxes().get(allBoxes/2+i));
				getAllFreeBoxes().get(i).setPrevBox(getAllFreeBoxes().get(i-1));
				getAllFreeBoxes().get(i).setNextBox(getAllFreeBoxes().get(i+1));
				continue;
			}
			//boxes in second row
			if (getAllFreeBoxes().get(i).getId() >= allBoxes/2) {
				getAllFreeBoxes().get(i).setAbove(getAllFreeBoxes().get(i-allBoxes/2));
				getAllFreeBoxes().get(i).setBelow(null);
				getAllFreeBoxes().get(i).setPrevBox(getAllFreeBoxes().get(i-1));
				getAllFreeBoxes().get(i).setNextBox(getAllFreeBoxes().get(i+1));
				continue;
			}
		}
	}
	
	/**
	 * Getter
	 * 
	 * @return focusVisitorwasHere
	 */
	public boolean getFocusVisitorwasHere() {
		return focusVisitorwasHere;
	}

	/**
	 * Setter
	 * 
	 * @param focusVisitorwasHere
	 */
	public void setFocusVisitorwasHere(boolean focusVisitorwasHere) {
		this.focusVisitorwasHere = focusVisitorwasHere;
	}

	/**
	 * Getter
	 * 
	 * @return allFocusVisitors
	 */
	public LinkedList<Visitor> getAllFocusVisitors() {
		return allFocusVisitors;
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
	 * Retrieves  allFocusVisitors in a string; Use for printing
	 * @return content
	 */
	public String printAllFocusVisitors() {
		String content = "List of all Focus Visitors: ";
		content += "Size: " +allFocusVisitors.size() + "\n";
		for (Visitor visitor : allFocusVisitors) {
			content += "ID: " +visitor.getId() + " Focus: " + visitor.getFocus() + " Duration: " + visitor.getDuration() + " Box ID: " + visitor.getOwnBox().getId() + " Collsision: " + visitor.getCollisionCounter() + "\n";
		}
		return content;
	}
}
