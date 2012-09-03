/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * The CheckerboardKarel class should draw a checkerboard using 
 * beepers, as described in Assignment 1. Karel will start in
 * the bottom left-corner facing East and will place a beeper on
 * its current location. It will start by going east, and snaking 
 * up the board, placing a beeper on every other square. It should 
 * be able to handle any size grid. 
 * 
 * Matt Barackman
 * 9.3.2012
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	
	/*METHOD: run()
	 * 
	 *pre-condition: 
	 *see above
	 *
	 *post-condition:
	 *completed checkerboard with Karel in either
	 *of the top two corners (the right side for grids with an odd 
	 *number of rows, the left side for grids with an odd number
	 *of lines). 
	 *
	 *Note: While this method does eventually complete the
	 *checkerboard, this bit of code really initializes Karel's 
	 *motion starting with the bottom line.
	 */
	
	public void run(){
		putBeeper();
		completeEastLine();
	}
	
	/*
	 *METHOD: completeEastLine()
	 *
	 *pre-condition:
	 *Karel is facing East at the left-most square of a new line.
	 *
	 *post-condition
	 *Karel is either facing West on the next line
	 *up or program is finished.
	 *
	 *
	 *Note: completeEastLine and completeWestLine make use of
	 *mutual recursion to have Karel alternate rows to complete
	 *the checkerboard.
	 */

	private void completeEastLine(){
		alternateToWall();
		turnLeft();
		if (frontIsClear()){
			startNextLine();
			turnLeft();
			completeWestLine();
		}
	}

	/*METHOD: completeWeestLine()
	 * 
	 *pre-condition: 
	 *Karel is facing West on a new line.
	 *
	 *post-condition: 
	 *Karel is either facing East on the next line up or program 
	 *is finished.
	 */
	
	private void completeWestLine(){
		alternateToWall();
		turnRight();
		if (frontIsClear()){
			startNextLine();
			turnRight();
			completeEastLine();
		}
	}
	
	/*METHOD: startNextLine()
	 * 
	 *pre-condition: 
	 *Karel is at the end of a line facing the next row up and he may or may
	 *not be presently on a beeper.
	 *
	 *post-condition: 
	 *Karel has now moved to the next row up and is still facing 
	 *up. Karel has also placed a beeper on his current square
	 *if he wasn't on one before and hasn't placed one if he was
	 *on one before.
	 */
	
	private void startNextLine(){
		if (beepersPresent()){
			move();	
		}
		else {
			move();
			putBeeper();
		}
	}
	
	/*METHOD: alternateToWall()
	 *pre-condition: 
	 *Karel is either facing East or West at the beginning of a 
	 *new line.
	 *
	 *post-condition: 
	 *Karel has now traversed the line and has in doing so has
	 *placed beepers on every other square.
	 */
	
	private void alternateToWall(){
		while (frontIsClear()){
			if (beepersPresent()){
				move();
			}
			else {
				move();
				putBeeper();
			}
		}
	}
}
