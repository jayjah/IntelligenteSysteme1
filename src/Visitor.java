/**
 * This class represents a visitor from the gym
 * @author Markus, Kim
 *
 */
public class Visitor {
	
	/**
	 * Id of the Visitor
	 */
	public int id;
	
	/**
	 * Holds the Box
	 */
	public Box ownBox;
	
	/**
	 * Duration of how long the visitor will be in the gym
	 */
	public int duration;
	
	/**
	 * Weather it's the focusperson or not
	 */
	public boolean gotTheFocus;
	
	/**
	 * Constructor
	 * @param id Id of the Visitor
	 */
	public Visitor(int id, Box box, int duration, boolean focus) {
		this.id = id;
		this.ownBox = box;
		this.duration = duration;
		this.gotTheFocus = focus;
	}
	
	/**
	 * Getter
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Getter
	 * @return ownBox
	 */
	public Box getOwnBox() {
		return ownBox;
	}

	/**
	 * Getter
	 * @return gotTheFocus
	 */
	public boolean getifVisitorisFocusPerson() {
		return gotTheFocus;
	}
}
