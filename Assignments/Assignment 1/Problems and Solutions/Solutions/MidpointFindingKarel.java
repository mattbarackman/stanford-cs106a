/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 * Matt Barackman
 * 9.3.2012
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	/* METHOD: run()
	 * 
	 * The general strategy is to have Karel drop beeper at either
	 * end of the first row and keep working his way towards the
	 * center dropping beepers closer and closer until his lines of
	 * beepers extending from both ends finally meet. He will at
	 * that point be standing on the (or one of the two) center
	 * columns. Next he will stating clearing the rest of the beepers,
	 * by walking towards the right wall picking up all the beepers.
	 * Then turning around and walking till he reaches the first
	 * beeper (the center) and cleaning up all the beepers to the
	 * left of that beeper. Than he simply turns around and walks back
	 * to the center.
	 * 
	 * pre-condition: 
	 * Karel is in the bottom-left corner of the window facing East.
	 * 
	 * post-condition:
	 * Karel is now standing on top of a lone beeper in the center 
	 * of the bottom row (or in one of the two center columns if
	 * there are an even number of columns.)
	 * 
	 */
	
	public void run() {
		putBeeper();
		walkToWall();
		putBeeper();
		turnAround();
		walkToBeeper();
		while (noBeepersPresent()){
			putBeeper();
			turnAround();
			walkToBeeper();
		}
		clearRightOfCenter();
		clearLeftOfCenter();
		turnAround();
		walkToBeeper();
		move();
		
	}
	
	/* METHOD: clearRightOfCenter()
	 * 
	 * This will clear all Beepers to the right of the Center.
	 * 
	 * pre-condition: 
	 * Karel is in the middle of the grid standing on a beeper,
	 * facing East.
	 * 
	 * post-condition:
	 * Karel is standing at the far-right of the first row, having
	 * cleared all the beepers from the center along the way.
	 */
	
	private void clearRightOfCenter(){
		clearToWall();
	}

	/* METHOD: clearRightOfCenter()
	 * 
	 * This will clear all Beepers to the wall in whatever way
	 * Karel is facing. There can only be one or zero beepers on
	 * each square.
	 * 
	 * pre-condition: 
	 * Karel is facing in any direction.
	 * 
	 * post-condition:
	 * Karel has now travelled to the wall and has cleared all
	 * beepers along the way. 
	 */
	
	private void clearToWall(){
		while (frontIsClear()){
			move();
			if (beepersPresent()){
				pickBeeper();
			}
		}
	}	
	
	/* METHOD: clearLeftOfCenter()
	 * 
	 * Karel will turn around, walk to the center beeper, than
	 * walk to the left wall clearing all the beepes along
	 * the way. 
	 *  
	 * pre-condition: 
	 * Karel is at the far right corner of bottom row facing East
	 * with no beepers between Karel and the center beeper.
	 * 
	 * post-condition:
	 * Karel is standing at the far-left corner of the first row, 
	 * facing west, having cleared all the beepers from the center 
	 * to the left wall. There is no only one beeper in the center
	 * of the bottom row.
	 */
	
	private void clearLeftOfCenter(){
		turnAround();
		walkToBeeper();
		move();
		while (frontIsClear()){
			move();
			pickBeeper();
		}
	}
	
	/* METHOD: walkToWall()
	 * 
	 * Facing in any direction, Karel will walk until he hits a
	 * wall. 
	 */
	
	private void walkToWall(){
		while (frontIsClear()){
			move();
		}
	}
	
	/* METHOD: walkToBeeper()
	 * 
	 * Facing in any direction, Karel will walk until there is a
	 * beeper directly in front of him.
	 */

	private void walkToBeeper(){
		move();
		while (noBeepersPresent()){
			move();
		}
		moveBackward();
	}
	
	/* METHOD: moveBackware()
	 * 
	 * Karel will move backward one square while remaining
	 * facing in the same direction.
	 */

	private void moveBackward(){
		turnAround();
		move();
		turnAround();
	}

}
