/**
 * This class represent a Box from the Gym. Every Visitor gets a Box when he
 * comes to the Gym.
 * 
 * @author Markus, Kim
 * 
 */
public class Box {
	/**
	 * Duration of how long the Visitor'll be in gym, this'll be decrement
	 */
	private int duration;
	
	/**
	 * Check all neighbours for a collision with this box and return true as soon as one happens; false if not.
	 */
	public boolean checkNeighboursForCollision(){
		if (this.getAbove() != null) {
			if (this.getAbove().getStatus() == BoxStatus.active) {
				return true;
			}
		}
		if (this.getBelow() != null) {
			if (this.getBelow().getStatus() == BoxStatus.active) {
				return true;
			}
		}
		if (this.getDiaaboveleft() != null) {
			if (this.getDiaaboveleft().getStatus() == BoxStatus.active) {
				return true;
			}
		}
		if (this.getDiaaboveright() != null) {
			if (this.getDiaaboveright().getStatus() == BoxStatus.active) {
				return true;
			}
		}
		if (this.getDiabelowleft() != null) {
			if (this.getDiabelowleft().getStatus() == BoxStatus.active) {
				return 	true;
			}
		}
		if (this.getDiabelowright() != null) {
			if (this.getDiabelowright().getStatus() == BoxStatus.active) {
				return true;
			}
		}
		if (this.getNextBox() != null) {
			if (this.getNextBox().getStatus() == BoxStatus.active) {
				return 	true;
			}
		}
		if (this.getPrevBox() != null) {
			if (this.getPrevBox().getStatus() == BoxStatus.active) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Same as checkNeighbouersForCollision but checks within the 5-Minutes period of the visitors.
	 */
	public boolean checkNeighboursForCollisionFirstPeriod(){
		if (this.getAbove() != null) {
			if (this.getAbove().getDuration() < 30) {
				return true;
			}
		}
		if (this.getBelow() != null) {
			if (this.getBelow().getDuration() < 30) {
				return true;
			}
		}
		if (this.getDiaaboveleft() != null) {
			if (this.getDiaaboveleft().getDuration() < 30) {
				return true;
			}
		}
		if (this.getDiaaboveright() != null) {
			if (this.getDiaaboveright().getDuration() < 30) {
				return true;
			}
		}
		if (this.getDiabelowleft() != null) {
			if (this.getDiabelowleft().getDuration() < 30) {
				return 	true;
			}
		}
		if (this.getDiabelowright() != null) {
			if (this.getDiabelowright().getDuration() < 30) {
				return true;
			}
		}
		if (this.getNextBox() != null) {
			if (this.getNextBox().getDuration() < 30) {
				return 	true;
			}
		}
		if (this.getPrevBox() != null) {
			if (this.getPrevBox().getDuration() < 30) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Same as checkNeighbouersForCollision but checks for collisions at the end-cycles of the neighbour box
	 */
	public boolean checkNeighboursForCollisionSecondPeriod(int duration){
		if (this.getAbove() != null) {
			if (this.getAbove().getDuration() - duration >=-30 && this.getAbove().getDuration() - duration <=30) {
				return true;
			}
		}
		if (this.getBelow() != null) {
			if (this.getBelow().getDuration() - duration >=-30 && this.getBelow().getDuration() - duration <=30) {
				return true;
			}
		}
		if (this.getDiaaboveleft() != null) {
			if (this.getDiaaboveleft().getDuration() - duration >=-30 && this.getDiaaboveleft().getDuration() - duration <=30) {
				return true;
			}
		}
		if (this.getDiaaboveright() != null) {
			if (this.getDiaaboveright().getDuration() - duration >=-30 && this.getDiaaboveright().getDuration() - duration <=30) {
				return true;
			}
		}
		if (this.getDiabelowleft() != null) {
			if (this.getDiabelowleft().getDuration() - duration >=-30 && this.getDiabelowleft().getDuration() - duration <=30) {
				return 	true;
			}
		}
		if (this.getDiabelowright() != null) {
			if (this.getDiabelowright().getDuration() - duration >=-30 && this.getDiabelowright().getDuration() - duration <=30) {
				return true;
			}
		}
		if (this.getNextBox() != null) {
			if (this.getNextBox().getDuration() - duration >=-30 && this.getNextBox().getDuration() - duration <=30) {
				return 	true;
			}
		}
		if (this.getPrevBox() != null) {
			if (this.getPrevBox().getDuration() - duration >=-30 && this.getPrevBox().getDuration() - duration <=30) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Getter
	 * 
	 * @returns duration
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
	 * Getter
	 * 
	 * @returns originDuration
	 */
	public int getOriginDuration() {
		return originDuration;
	}

	/**
	 * Setter
	 * 
	 * @param originDuration
	 */
	public void setOriginDuration(int originDuration) {
		this.originDuration = originDuration;
	}

	/**
	 * Duration of how long the Visitor'll be in gym
	 */
	private int originDuration;
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
		if(above==null)
			return null;
		return above.getNextBox();
	}

	/**
	 * Getter
	 * 
	 * @return above.left
	 */
	public Box getDiaaboveleft() {
		if(above==null)
			return null;
		return above.getPrevBox();
	}

	/**
	 * Getter
	 * 
	 * @return below.right
	 */
	public Box getDiabelowright() {
		if(below==null)
			return null;
		return below.getNextBox();
	}

	/**
	 * Getter
	 * 
	 * @return below.left
	 */
	public Box getDiabelowleft() {
		if(below==null)
			return null;
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
