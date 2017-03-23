package dkeep.logic;

import java.util.Random;

import dkeep.logic.Game.Direction;

/**
 * 
 * Suspicous.java - A Subclass of Guard
 *
 */
public class Suspicious extends Guard{

	private int index = 0;
	private int move = 1;
	
	/**
	 * Constructor of this class and initializes index of this type of guard
	 * @param posx
	 * @param posy
	 */
	public Suspicious(int posx, int posy) {
		super(posx,posy);
	}
	/**
	 * @return Suspicious
	 */
	public Suspicious getSuspicious(){
		return this;
	}

	/**
	 * Method responsible to reverse Suspicious's direction
	 * @return direction
	 */
/*	public Direction reverseSuspiciousDirection(){

		index--;
		if(index < 0)
			index += directions.length;
		
		Direction direction = directions[index];
		
		switch(direction){
		case UP:
			direction= direction.DOWN;
			break;
		case DOWN:
			direction= direction.UP;
			break;
		case LEFT:
			direction= direction.RIGHT;
			break;
		case RIGHT:
			direction= direction.LEFT;
			break;
		}
		
		return direction;
	}
*/
	/**
	 * Methods responsible to define the type of the movement's Suspicious
	 * @param direction
	 * @param board
	 */
	public void movement(Direction direction, Board b){

		randDirection(direction);
		
		if(move == 1)
			direction = reverseGuardDirection();
		else{
			index++;
		}
		
		if(index >= directions.length)
			index -= directions.length;
		
		switch(direction) {
		case UP:
			posx--;
			break;
		case DOWN:
			posx++;
			break;
		case RIGHT:
			posy++;
			break;
		case LEFT:
			posy--;
			break;
		}

	}

}