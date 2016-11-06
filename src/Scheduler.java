import java.util.LinkedList;
import java.util.Random;

public class Scheduler {

	// The list for boxes that can be given to visitors
	private LinkedList<Box> possibleBoxes;

	// The next possible box
	private Box nextPossibleBox;

	/**
	 * Random Generator
	 */
	public static Random random = new Random();

	public int blockedBoxCounter = 0;

	// Current index

	// For init of scheduler: Put all boxes in the constructor.
	public Scheduler(LinkedList<Box> allBoxes) {
		this.possibleBoxes = allBoxes;
		this.nextPossibleBox = allBoxes.get(0);
	}

	// Main method, called every cycle and does the main work for the scheduler
	public void work() {

		// Simple round robin without blocked list:

		// get first process in list
		this.nextPossibleBox = this.possibleBoxes.get(0);

		// remove that process from list
		this.possibleBoxes.remove(0);

		// add this process to end of list
		this.possibleBoxes.add(this.nextPossibleBox);

	}

	// Return the next possible box
	public Box getNextBox() {
		if (this.blockedBoxCounter == this.possibleBoxes.size())
			return null;
		return this.getNextRandomBox();
		// return this.nextPossibleBox;
	}

	public Box getNextBox(int duration) {
		if (this.blockedBoxCounter == this.possibleBoxes.size())
			return null;
		// return this.getNextRandomBox();

		Box nextbox = this.predictSort(duration);
		if (nextbox == null) {
			return getNextRandomBox();
		}
		return nextbox;
		// return this.nextPossibleBox;
	}

	private Box predictSort(int duration) {
		for (int i = 0; i < 3; i++) {
			for (Box box : possibleBoxes) {
				if (box.getStatus() == BoxStatus.free) {

					if (i == 0
							&& !box.checkNeighboursForCollision()
							&& !box.checkNeighboursForCollisionFirstPeriod()
							&& !box.checkNeighboursForCollisionSecondPeriod(duration)) {
						return box;
					}
					if (i == 1 && !box.checkNeighboursForCollision()
							&& !box.checkNeighboursForCollisionFirstPeriod()) {
						return box;
					}
					if (i == 2 && !box.checkNeighboursForCollision()) {
						return box;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Every BoxStatus must be set to free after a day
	 */
	public void resetAfterDay() {
		for (Box box : possibleBoxes) {
			box.setStatus(BoxStatus.free);
		}
	}

	/**
	 * Get the next Random Box, which is free to take and gives it back Set
	 * BoxStatus to active
	 * 
	 * @return Box
	 */
	private Box getNextRandomBox() {
		Box b;
		do {
			b = possibleBoxes.get(random.nextInt(possibleBoxes.size()));
		} while (b.getStatus() != BoxStatus.free);
		return (b);
		/*
		 * int maybenextbox = random.nextInt(possibleBoxes.size()); for (int i =
		 * 0; i < possibleBoxes.size(); i++) { if (possibleBoxes.get(i).getId()
		 * == maybenextbox) { possibleBoxes.get(i).setStatus(BoxStatus.active);
		 * return possibleBoxes.get(i); } } return null;
		 */
	}
}
