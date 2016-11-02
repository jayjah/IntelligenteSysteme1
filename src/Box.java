/**
 * This class represent a Box from the Gym.
 * Every Visitor gets a Box when he comes to the Gym.
 * @author Markus, Kim
 *
 */
public class Box {

	//Enum
	public enum BoxStatus {free,active,taken};
	
	/**
	 * Defines the status of the box
	 */
	public BoxStatus status;
	
	/**
	 * Holds the next box
	 */
	public Box nextBox;
	
	public Box prevBox;

	public Box above;
	
	public Box below;
	
	public Box diaaboveright;
	
	public Box diaaboveleft;
	
	public Box diabelowright;
	
	public Box diabelowleft;
	
	/**
	 * Id of the Box
	 */
	public int id;
	
	/**
	 * Constructor, initialize all attributes
	 * @param id Id of the box
	 */
	public Box(int id, BoxStatus status) {
		this.id = id;
		this.status = status;
	}
	
	/**
	 * Getter
	 * @return isFree
	 */
	public BoxStatus getStatus() {
		return status;
	}
	
	/**
	 * Setter
	 * @param isFree to set isFree
	 */
	public void setStatus(BoxStatus status) {
		this.status = status;
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
	 * @return prevBox
	 */
	public Box getPrevBox() {
		return prevBox;
	}

	/**
	 * Setter
	 * @param prevBox
	 */
	public void setPrevBox(Box prevBox) {
		this.prevBox = prevBox;
	}
	
	public Box getNextBox() {
		return nextBox;
	}

	public void setNextBox(Box nextBox) {
		this.nextBox = nextBox;
	}

	public Box getDiaaboveright() {
		return diaaboveright;
	}

	public void setDiaaboveright(Box diaaboveright) {
		this.diaaboveright = diaaboveright;
	}

	public Box getDiaaboveleft() {
		return diaaboveleft;
	}

	public void setDiaaboveleft(Box diaaboveleft) {
		this.diaaboveleft = diaaboveleft;
	}

	public Box getDiabelowright() {
		return diabelowright;
	}

	public void setDiabelowright(Box diabelowright) {
		this.diabelowright = diabelowright;
	}

	public Box getDiabelowleft() {
		return diabelowleft;
	}

	public void setDiabelowleft(Box diabelowleft) {
		this.diabelowleft = diabelowleft;
	}

	public Box getAbove() {
		return above;
	}

	public void setAbove(Box above) {
		this.above = above;
	}

	public Box getBelow() {
		return below;
	}

	public void setBelow(Box below) {
		this.below = below;
	}

}
