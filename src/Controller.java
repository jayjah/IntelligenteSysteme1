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
		this.gym = new Gym(boxes);
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
			for (int slotsperday = 0; slotsperday < this.timeSlotsperDay; slotsperday++) {
				double nextvisitor = random.nextDouble();
				// weather nextvisitor is a visitor or not
				if (nextvisitor <= 0.1) {
					Box boxfornextvisitor = getNextRandomBox();
					int durationfornextvisitor = getNextRandomDurationofVisitor();
					boolean isfocus = isThisVisitoronFocus();
					Visitor visitor = new Visitor(idfornextuser,
							boxfornextvisitor, durationfornextvisitor, isfocus);
					gym.getAllVisitors().add(visitor);
					idfornextuser++;

					// Prints
					System.out.println("On Day: " + day + "; On TimeSlot: "
							+ slotsperday + "; New Visitor: "
							+ visitor.toString());
					System.out.println("Length of Blocked Box List: "
							+ gym.getAllBlockedBoxes().size());
					System.out.println("Length of Free Box List: "
							+ gym.getAllFreeBoxes().size());
					int sizeofboth = gym.getAllBlockedBoxes().size()
							+ gym.getAllFreeBoxes().size();
					System.out.println("Length of Box is: " + sizeofboth
							+ " and should be: " + allBoxes);
				}
				simulateTimeinGym();
			}
			gym.afterDay();
		}
	}
	
	/**
	 * This Method simulates the time in the gym
	 * The duration of every visitor decrements for 1 by calling
	 * If the Visitor got the focus then ...
	 */
	//TODO BoxStatus of every Visitor must be changed from active to taken after 5 "minutes"
	private void simulateTimeinGym() {
		for (int i = 0; i< gym.getAllVisitors().size(); i++) {
			if (gym.getAllVisitors().get(i).getDuration() == 5) {
				gym.getAllVisitors().get(i).getOwnBox().setStatus(BoxStatus.active);
			}
			if (gym.getAllVisitors().get(i).getDuration() == 1) {
				gym.getAllVisitors().get(i).getOwnBox().setStatus(BoxStatus.free);
				gym.getAllBlockedBoxes().remove(gym.getAllVisitors().get(i).getOwnBox());
				gym.getAllFreeBoxes().add(gym.getAllVisitors().get(i).getOwnBox());
				gym.getAllVisitors().remove(i);
			} else {
				if (gym.getAllVisitors().get(i).getFocus() && gym.getAllVisitors().get(i).getOwnBox().getStatus() == BoxStatus.active) {
					//TODO if a collision happens, then collision counter must be increment
				} else {
					gym.getAllVisitors().get(i).setDuration(gym.getAllVisitors().get(i).getDuration()-1);
				}
			}
		}
	}

	// TODO Implement if this is the Visitor nearly 15h or not
	/**
	 * Returns a boolean, weather this Visitor got the focus or not
	 * 
	 * @return
	 */
	private boolean isThisVisitoronFocus() {
		return false;
	}

	/**
	 * Get the next Random Box, which is free to take and gives it back Add the
	 * Box in gym.allBlockedBoxes and removes from gym.allFreeBoxes Add the
	 * right BoxStatus of the returns box
	 * 
	 * @return Box
	 */
	private Box getNextRandomBox() {
		boolean boxisChosen = false;
		while (boxisChosen == false) {
			int maybenextbox = random.nextInt(allBoxes);
			for (int i = 0; i<gym.getAllFreeBoxes().size(); i++) {
				if (gym.getAllFreeBoxes().get(i).getId() == maybenextbox) {
					boxisChosen = true;
					gym.getAllFreeBoxes().get(i).setStatus(BoxStatus.active);
					gym.getAllBlockedBoxes().add(gym.getAllFreeBoxes().get(i));
					gym.getAllFreeBoxes().remove(i);
					return gym.getAllBlockedBoxes().getLast();
				}
			}
//			for (Box box : gym.getAllFreeBoxes()) {
//				if (box.getId() == maybenextbox) {
//					boxisChosen = true;
//					gym.getAllBlockedBoxes().add(box);
//					gym.getAllFreeBoxes().remove(box);
//					box.setStatus(BoxStatus.active);
//					return box;
//				}
//			}
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
}
