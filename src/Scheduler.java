import java.util.ArrayList;
import java.util.LinkedList;

public class Scheduler {

	//The list for boxes that can be given to visitors
	private LinkedList<Box> possibleBoxes;
	
	//All the boxes that are either blocked or in use
	private LinkedList<Box> blockedBoxes;
	
	//The next possible box
	private Box nextPossibleBox;
	
	//Current index
	
	//For init of scheduler: Put all boxes in the constructor.
	public Scheduler(LinkedList<Box> allBoxes){
		this.possibleBoxes=allBoxes;
		this.blockedBoxes=new LinkedList<Box>();
		this.nextPossibleBox=allBoxes.get(0);
	}
	
	//Main method, called every cycle and does the main work for the scheduler
	public void work(){
		
		//Simple round robin without blocked list:
		
		//get first process in list
		this.nextPossibleBox=this.possibleBoxes.get(0);
		
		//remove that process from list
		this.possibleBoxes.remove(0);
		
		//add this process to end of list
		this.possibleBoxes.add(this.nextPossibleBox);
		
	}
	
	//Return the next possible box
	public Box getNextBox(){
		return this.nextPossibleBox;
	}
	
}
