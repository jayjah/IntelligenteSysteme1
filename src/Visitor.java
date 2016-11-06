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
	 * Weather it's the focusperson or not
	 */
	private boolean gotTheFocus;
	
	/**
	 * Collision counter
	 */
	private int collision;
	
	/**
	 * How often a collision hapens during the first and last 5 minutes
	 */
	private int tempCollisionCounter;
	
	/**
	 * Factor to get timeslots from minutes
	 */
	private static short minutesTotimeslots = 6;

	/**
	 * Constructor
	 * 
	 * @param id
	 *            Id of the Visitor
	 */
	public Visitor(int id, Box box, int duration, boolean focus) {
		this.id = id;
		this.ownBox = box;
		this.ownBox.setDuration(duration*minutesTotimeslots);
		this.ownBox.setOriginDuration(duration*minutesTotimeslots);
		this.gotTheFocus = focus;
		this.collision = 0;
		this.tempCollisionCounter = 0;
	}
	
	/**
	 * Getter
	 * 
	 * @return tempCollisionCounter
	 */
	public int getTempCollisionCounter() {
		return tempCollisionCounter;
	}
	
	/**
	 * Increments tempCollisionCounter
	 */
	public void incrementTempCollisionCounter() {
		this.tempCollisionCounter++;
	}
	
	/**
	 * Reset tempCollisionCounter to intial value
	 */
	public void resetTempCollisionCounter() {
		this.tempCollisionCounter = 0;
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
		return this.ownBox.getDuration();
	}
	
	/**
	 * Getter
	 * 
	 * @return originDuration
	 */
	public int getOriginDuration() {
		return this.ownBox.getOriginDuration();
	}
	
	/**
	 * Decrement duration
	 * 
	 * @param duration
	 */
	public void decrementDuration() {
		this.ownBox.setDuration(this.ownBox.getDuration()-1);
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
