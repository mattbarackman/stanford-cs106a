/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 * This sub-class of Karel will repair missing beepers in 
 * vertical "stone columns". Karel will start at [1,1] 
 * facing East with an infinite number of Beepers. There is
 * a column on the 1st avenue and a column every four rows.
 * The solution will accomodate any number of columns and 
 * the columns can be of any height. Each column will have 
 * some (but not all) Beepers (stones) in their correct
 * places, so Karel will need to pass over these without
 * doubling them. 
 * 
 * Matt Barackman
 * 9.3.2012
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	/* METHOD: run()
	 * 
	 * Karel will repair a column, walk to the next column,
	 * repair that column, and repeat until he hits a wall. 
	 *  
	 * pre-condition: 
	 * Karel is at the far left corner of bottom row facing East,
	 * standing on a broken column.
	 * 
	 * post-condition:
	 * Karel is standing at the far-right corner of the first row, 
	 * facing east, having repaired all the columns.
	 */
	
	public void run() {
		repairColumn();
		while (frontIsClear()){
			moveToNextColumn();
			repairColumn();
		}
	}
	
	/* METHOD: moveToNextColumn()
	 * 
	 * Karel will move forward four spaces to the next column.
	 * Columns must be exactly four spaces apart.
	 *  
	 * pre-condition: 
	 * Karel is standing on a column (hopefully fixed) facing East.
	 * 
	 * post-condition:
	 * Karel is standing on the next column, still facing East.
	 */
	
	private void moveToNextColumn() {
		move();
		move();
		move();
		move();
	}

	/* METHOD: repairColumn()
	 * 
	 * Karel will turn, ascend the column, repairing it as he goes,
	 * then descend the column, and turn to East again.
	 *  
	 * pre-condition: 
	 * Karel is standing on a partially broken column facing East.
	 * 
	 * post-condition:
	 * Karel is standing on the same spot, facing East, with the
	 * column now repaired.
	 */
	
	private void repairColumn() {
		ascendColumn();
		descendColumn();
	}
	
	/* METHOD: ascendColumn()
	 * Karel will turn left, ascend the column, and place a single
	 * beeper in all the empty spaces.
	 *  
	 * pre-condition: 
	 * Karel is standing on a partially broken column facing East.
	 * 
	 * post-condition:
	 * Karel is standing at the top of a column, facing North, with
	 * the column now repaired.
	 */
	
	private void ascendColumn() {
		turnLeft();
		while (frontIsClear()){
			placeBeeperIfEmpty();
			move();
		}
		placeBeeperIfEmpty();
	}
	
	
	/* METHOD: placeBeeperIfEmpty()
	 * 
	 * Karel will place a beeper if standing on an empty square.
	 *  
	 */
	
	private void placeBeeperIfEmpty(){
		if (noBeepersPresent()){
			putBeeper();
		}	
	}
	
	/* METHOD: descendColumn()
	 * 
	 * Karel will turn around, descend the column, and turn left to 
	 * face East.
	 *  
	 * pre-condition: 
	 * Karel is standing at the top of a repaired column facing
	 * North.
	 * 
	 * post-condition:
	 * Karel is standing at the bottom of the repaired column 
	 * facing East.
	 */
	
	private void descendColumn(){
		turnAround();
		moveToWall();
		turnLeft();
	}
	
	
	/* METHOD: descendColumn()
	 * 
	 * Karel will will move in whatever direction he is facing
	 * until he hits a wall.
	 * 
	 */
	
	private void moveToWall(){
		while (frontIsClear()){
			move();
		}	
	}
}
