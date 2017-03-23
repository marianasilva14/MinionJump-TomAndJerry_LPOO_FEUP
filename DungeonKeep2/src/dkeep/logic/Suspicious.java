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
	 * Methods responsible to define the type of the movement's Suspicious
	 * @param direction
	 * @param board
	 */
	public void movement(Direction direction, Board b){

		randDirection(direction);
		
		movementGuard(direction);
	}

}