/**
 * This class represents a visitor from the gym
 * 
 * @author Markus, Kim
 * 
 */
public class Visitor {

	/**
	 * Id of the Visitor
	 */
	private int id;

	/**
	 * Holds the Box
	 */
	private Box ownBox;

	/**
	 * Duration of how long the Visitor will be in the gym
	 */
	private int duration;

	/**
	 * Weather it's the focusperson or not
	 */
	private boolean gotTheFocus;
	
	/**
	 * Collision counter
	 */
	private int collision;

	/**
	 * Constructor
	 * 
	 * @param id
	 *            Id of the Visitor
	 */
	public Visitor(int id, Box box, int duration, boolean focus) {
		this.id = id;
		this.ownBox = box;
		this.duration = duration;
		this.gotTheFocus = focus;
		this.collision = 0;
	}

	/**
	 * Getter
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter
	 * 
	 * @return ownBox
	 */
	public Box getOwnBox() {
		return ownBox;
	}

	/**
	 * Getter
	 * 
	 * @return gotTheFocus
	 */
	public boolean getFocus() {
		return gotTheFocus;
	}

	/**
	 * Getter
	 * 
	 * @return duration
	 */
	public int getDuration() {
		return duration;
	}
	
	/**
	 * Setter
	 * 
	 * @param duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	/**
	 * Increments the collision
	 */
	public void incrementCollision() {
		this.collision++;
	}
	
	/**
	 * Getter
	 * 
	 * @return collision
	 */
	public int getCollisionCounter() {
		return collision;
	}

	/**
	 * to String Method
	 * 
	 * @return String representation of this Visitor
	 */
	public String toString() {
		return "Visitor ID: " + getId() + " Box ID: " + getOwnBox().getId()
				+ " Duration: " + getDuration() + " Focus? " + getFocus();
	}
}
