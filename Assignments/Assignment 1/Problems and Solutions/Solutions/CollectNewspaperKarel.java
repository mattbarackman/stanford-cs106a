/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * The CollectNewspaperKarel subclass will walk to the door of its 
 * house, pick up the newspaper (represented by a beeper, of course), 
 * and then return to its initial position in the upper left 
 * corner of the house. Note, this program is not a general solution.
 *
 * Matt Barackman
 * 9.3.2012
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {
	
	/* METHOD: run()
	 * 
	 * pre-condition: 
	 * Karel is in the top-left corner of his house facing East.
	 * 
	 * post-condition:
	 * Karel is in the same spot as the pre-condition, still
	 * facing East, but has now picked up the beeper.
	 */

	public void run () {
		goToBeeper();
		pickBeeper();
		returnToStart();
		
	}

	/* METHOD: goToBeeper()
	 * 
	 * pre-condition: 
	 * Karel is in the top-left corner of his house facing East.
	 * 
	 * post-condition:
	 * Karel is now standing on top of the beeper, facing East.
	 */

	private void goToBeeper() {
		moveToWall();
		turnRight();
		move();
		turnLeft();
		move();
	}
	
	/* METHOD: moveToWall()
	 * 
	 * pre-condition: 
	 * Karel is facing in any direction.
	 * 
	 * post-condition:
	 * Karel will have moved in the direction he was facing, until
	 * he hit a wall.
	 */

	private void moveToWall() {
		while (frontIsClear()){
			move();
		}
	}
	
	/* METHOD: returnToStart()
	 * 
	 * pre-condition: 
	 * Karel is standing where the beeper was, with beeper in 
	 * hand, facing East.
	 * 
	 * post-condition:
	 * Karel is standing in his house, where he started, 
	 * with beeper in hand, facing East.
	 */

	private void returnToStart() {
		turnAround();
		moveToWall();
		turnRight();
		move();
		turnRight();
	}

}
