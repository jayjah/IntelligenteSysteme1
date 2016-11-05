import java.util.Random;

/**
 * This class controls the simulation
 * 
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
	private short allBoxes;

	/**
	 * Digit of all time slots per day
	 */
	private short timeSlotsperDay;

	/**
	 * Hold hoch much days
	 */
	private short days;

	/**
	 * Hold how long the Visitors may be
	 */
	private int[] allVisits;

	/**
	 * Random Generator
	 */
	private static Random random = new Random();

	/**
	 * Hold the gym
	 */
	private Gym gym;
	
	private Scheduler scheduler;

	/**
	 * Constructor
	 */
	public Controller(double poss, short boxes, short timeslots, short days,
			int[] visits) {
		this.possibilityOfaVisitor = poss;
		this.allBoxes = boxes;
		this.timeSlotsperDay = timeslots;
		this.days = days;
		this.allVisits = visits;
		this.gym = new Gym(boxes,days);
		
		//init scheduler
		this.scheduler=new Scheduler(this.gym.getAllFreeBoxes());
	}

	/**
	 * Starts/Runs the simulation
	 */
	public void letTheSimulationRun() {
		simulateVisitors();
	}

	/**
	 * Simulate the Visitors, weather they go to the gym or not
	 */
	private void simulateVisitors() {
		// simulation for each day
		for (int day = 0; day < this.days; day++) {
			int idfornextuser = 0;
			// simulation for each timeslot
			for (int currentslot = 0; currentslot < this.timeSlotsperDay; currentslot++) {
				double nextvisitor = random.nextDouble();
				// weather nextvisitor is a visitor or not
				if (nextvisitor <= 0.1) {
					
					
					//Box boxfornextvisitor = getNextRandomBox();
						
						//Integrated scheduler
						Box boxfornextvisitor=this.scheduler.getNextBox();
						this.scheduler.work();
					
					
					
					if (boxfornextvisitor != null) {
						int durationfornextvisitor = getNextRandomDurationofVisitor();
						boolean isfocus = isThisVisitoronFocus(currentslot);
						Visitor visitor = new Visitor(idfornextuser,
								boxfornextvisitor, durationfornextvisitor,
								isfocus);
						gym.getAllVisitors().add(visitor);
						if (visitor.getFocus()) 
							gym.setFocusVisitorwasHere(true);
						idfornextuser++;
						// Prints
//						if (visitor.getFocus()) 
//							System.out.println(visitor);
//						System.out.println("On Day: " + day + "; On TimeSlot: "
//								+ currentslot + "; New Visitor: "
//								+ visitor.toString());
//						System.out.println("Length of Blocked Box List: "
//								+ gym.getAllBlockedBoxes().size());
//						System.out.println("Length of Free Box List: "
//								+ gym.allFreeBoxes().size());
//						int sizeofboth = gym.getAllBlockedBoxes().size()
//								+ gym.allFreeBoxes().size();
//						System.out.println("Length of Box is: " + sizeofboth
//								+ " and should be: " + allBoxes);
					}
				}
				simulateTimeinGym();
			}
			gym.afterDay();
		}
	}

	/**
	 * This Method simulates the time in the gym The duration of every visitor
	 * decrements for 1 by calling If the Visitor got the focus then ...
	 */
	private void simulateTimeinGym() {
		for (int i = 0; i < gym.getAllVisitors().size(); i++) {
			// after first five minutes of visitor
			if (gym.getAllVisitors().get(i).getOriginDuration()
					- gym.getAllVisitors().get(i).getDuration() == 30) {
				gym.getAllVisitors().get(i).getOwnBox()
						.setStatus(BoxStatus.taken);
				if (gym.getAllVisitors().get(i).getFocus() && gym.getAllVisitors().get(i).getTempCollisionCounter() > 0) {
					gym.getAllVisitors().get(i).incrementCollision();
					gym.getAllVisitors().get(i).resetTempCollisionCounter();
				}
			}
			// last five minutes of visitor
			if (gym.getAllVisitors().get(i).getDuration() == 30) {
				gym.getAllVisitors().get(i).getOwnBox()
						.setStatus(BoxStatus.active);
			}
			// last 10seconds of visitor
			if (gym.getAllVisitors().get(i).getDuration() == 1) {
				gym.getAllVisitors().get(i).getOwnBox()
						.setStatus(BoxStatus.free);
				if (gym.getAllVisitors().get(i).getFocus() && gym.getAllVisitors().get(i).getTempCollisionCounter() > 0) {
					gym.getAllVisitors().get(i).incrementCollision();
				}
				if (gym.getAllVisitors().get(i).getFocus()) {
					gym.getAllFocusVisitors().add(gym.getAllVisitors().get(i));
				}
				gym.getAllBlockedBoxes().remove(
						gym.getAllVisitors().get(i).getOwnBox());
				gym.getAllFreeBoxes().add(gym.getAllVisitors().get(i).getOwnBox());
				gym.getAllVisitors().remove(i);
			} else {
				// if focus is true and boxstatus == active
				if (gym.getAllVisitors().get(i).getFocus()
						&& gym.getAllVisitors().get(i).getOwnBox().getStatus() == BoxStatus.active) {
					checkAndsetCollision(gym.getAllVisitors().get(i));
					gym.getAllVisitors().get(i).decrementDuration();
				} else {
					gym.getAllVisitors().get(i).decrementDuration();
				}
			}
		}
	}
	
	//TODO fix NullPointerException, maybe causes because the initialization of the
	// neighbor boxes failed, see in Gym.initializeBoxes()
	/**
	 * Check if a neighbour box of this visitor got a the BoxStatus.active
	 * @param visitor 
	 */
	private void checkAndsetCollision(Visitor visitor) {
		int nullBox = 9999;
		if (visitor.getOwnBox().getAbove().getId() != nullBox) {
			if (visitor.getOwnBox().getAbove()
					.getStatus() == BoxStatus.active) {
				visitor.incrementTempCollisionCounter();
			}
		}
		if (visitor.getOwnBox().getBelow().getId() != nullBox) {
			if (visitor.getOwnBox().getBelow()
					.getStatus() == BoxStatus.active) {
				visitor.incrementTempCollisionCounter();
			}
		}
		if (visitor.getOwnBox()
				.getDiaaboveleft() != null) {
			if (visitor.getOwnBox()
					.getDiaaboveleft().getStatus() == BoxStatus.active) {
				visitor.incrementTempCollisionCounter();
			}
		}
		if (visitor.getOwnBox()
				.getDiaaboveright() != null) {
			if (visitor.getOwnBox()
					.getDiaaboveright().getStatus() == BoxStatus.active) {
				visitor.incrementTempCollisionCounter();
			}
		}
		if (visitor.getOwnBox()
				.getDiabelowleft() != null) {
			if (visitor.getOwnBox()
					.getDiabelowleft().getStatus() == BoxStatus.active) {
				visitor.incrementTempCollisionCounter();
			}
		}
		if (visitor.getOwnBox()
				.getDiabelowright() != null) {
			if (visitor.getOwnBox()
					.getDiabelowright().getStatus() == BoxStatus.active) {
				visitor.incrementTempCollisionCounter();
			}
		}
		if (visitor.getOwnBox().getNextBox().getId() != nullBox) {
			if (visitor.getOwnBox()
					.getNextBox().getStatus() == BoxStatus.active) {
				visitor.incrementTempCollisionCounter();
			}
		}
		if (visitor.getOwnBox().getPrevBox().getId() != nullBox) {
			if (visitor.getOwnBox()
					.getPrevBox().getStatus() == BoxStatus.active) {
				visitor.incrementTempCollisionCounter();
			}
		}
	}

	/**
	 * Returns a boolean, weather this Visitor got the focus or not The first
	 * person between 14:50 and 15:10 will be the focus visitor If there is no
	 * focus set between 14:50 and 15:10, then it will be the next visitor
	 * 
	 * @return boolean
	 */
	private boolean isThisVisitoronFocus(int currentTimeSlot) {
		boolean focusexist = false;
		for (Visitor visitor : gym.getAllVisitors()) {
			if (visitor.getFocus() == true)
				focusexist = true;
		}
		if (focusexist == false && !gym.getFocusVisitorwasHere()) {
			// between 14:50 and 15:10
			if (timeSlotsperDay / 2 - 60 < currentTimeSlot
					&& timeSlotsperDay / 2 + 60 > currentTimeSlot)
				return true;
			// first person after 15:10
			if (timeSlotsperDay / 2 + 60 < currentTimeSlot)
				return true;
			return false;
		} else
			return false;
	}

	// TODO Implement an own idea to chose the perfect box for the current
	// visitor
	/**
	 * 
	 * @return Box
	 */
	private Box getNextBox() {
		return null;
	}

	/**
	 * Get the next Random Box, which is free to take and gives it back Add the
	 * Box in gym.allBlockedBoxes and removes from gym.allFreeBoxes Add the
	 * right BoxStatus of the returns box
	 * 
	 * @return Box
	 */
	private Box getNextRandomBox() {
		if (gym.getAllFreeBoxes().size() > 0) {
			int maybenextbox = random.nextInt(allBoxes);
			for (int i = 0; i < gym.getAllFreeBoxes().size(); i++) {
				if (gym.getAllFreeBoxes().get(i).getId() == maybenextbox) {
					gym.getAllFreeBoxes().get(i).setStatus(BoxStatus.active);
					gym.getAllBlockedBoxes().add(gym.getAllFreeBoxes().get(i));
					Box randomBox = gym.getAllFreeBoxes().get(i);
					gym.getAllFreeBoxes().remove(i);
					return randomBox;
				}
			}
		}
		return null;
	}

	/**
	 * Get a Random Duration out of the allVisits Array
	 * 
	 * @return duration of a Visitor
	 */
	private int getNextRandomDurationofVisitor() {
		int duration = random.nextInt(allVisits.length);
		return allVisits[duration];
	}
	
	/**
	 * Retrieves  allFocusVisitors in a string; Use for printing
	 * @return allFocusVisitors
	 */
	public String printAllFocusVisitors() {
		return gym.printAllFocusVisitors();
	}
	
	//use for testing
	public int averageOfCollision() {
		int counter = 0;
		for (Visitor visitor : gym.getAllFocusVisitors()) {
			counter+= visitor.getCollisionCounter();
		}
		return counter;
	}
}
