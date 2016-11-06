/**
 * Box Status Enum free = free to take, active = a Visitor is in front of the Box,
 * taken = Visitor is in the gym, but not in front of the Box
 * 
 * @author Markus, Kim
 * 
 */

/**
	 *
	 *Status of the box: free: free - active: someone is within his 5min cycle; taken: box is free but nobody at the box.
	 */
public enum BoxStatus {
	free, active, taken
}
