/**
 * This class represent a Box from the Gym. Every Visitor gets a Box when he
 * comes to the Gym.
 * 
 * @author Markus, Kim
 * 
 */
public class Box {

	/**
	 * Defines the status of the box
	 */
	private BoxStatus status;

	/**
	 * Holds the next box
	 */
	private Box right;

	/**
	 * Holds the previews box
	 */
	private Box left;

	/**
	 * Holds the box above this box
	 */
	private Box above;

	/**
	 * Holds the box below this box
	 */
	private Box below;

	/**
	 * Id of the Box
	 */
	private int id;

	/**
	 * Constructor, initialize all attributes
	 * 
	 * @param id
	 *            Id of the box
	 */
	public Box(int id, BoxStatus status) {
		this.id = id;
		this.status = status;
	}
	
	/**
	 * Null Constructor
	 * @param id = 9999 (null Value)
	 */
	public Box(int id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return isFree
	 */
	public BoxStatus getStatus() {
		return status;
	}

	/**
	 * Setter
	 * 
	 * @param isFree
	 *            to set isFree
	 */
	public void setStatus(BoxStatus status) {
		this.status = status;
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
	 * @return prevBox
	 */
	public Box getPrevBox() {
		return left;
	}

	/**
	 * Setter
	 * 
	 * @param prevBox
	 */
	public void setPrevBox(Box prevBox) {
		this.left = prevBox;
	}

	/**
	 * Getter
	 * 
	 * @return nextBox
	 */
	public Box getNextBox() {
		return right;
	}

	/**
	 * Setter
	 * 
	 * @param nextBox
	 */
	public void setNextBox(Box nextBox) {
		this.right = nextBox;
	}

	/**
	 * Getter
	 * 
	 * @return above.right
	 */
	public Box getDiaaboveright() {
		return above.getNextBox();
	}

	/**
	 * Getter
	 * 
	 * @return above.left
	 */
	public Box getDiaaboveleft() {
		return above.getPrevBox();
	}

	/**
	 * Getter
	 * 
	 * @return below.right
	 */
	public Box getDiabelowright() {
		return below.getNextBox();
	}

	/**
	 * Getter
	 * 
	 * @return below.left
	 */
	public Box getDiabelowleft() {
		return below.getPrevBox();
	}

	/**
	 * Getter
	 * 
	 * @return above
	 */
	public Box getAbove() {
		return above;
	}

	/**
	 * Setter
	 * 
	 * @param above
	 */
	public void setAbove(Box above) {
		this.above = above;
	}

	/**
	 * Getter
	 * 
	 * @return below
	 */
	public Box getBelow() {
		return below;
	}

	/**
	 * Setter
	 * 
	 * @param below
	 */
	public void setBelow(Box below) {
		this.below = below;
	}

}
