package dkeep.logic;

import dkeep.logic.Game.Direction;
import dkeep.logic.Guard;

/**
 * 
 * Rookie.java - A Subclass of Guard
 *
 */
public class Rookie extends Guard{

	private int index = 0;

	/**
	 * Constructor of this class and initializes index of this type of guard
	 * @param posx
	 * @param posy
	 */
	public Rookie(int posx, int posy) {
		super(posx,posy);
	}

	/**
	 * @return Rookie
	 */
	public Rookie getRookie(){
		return this;
	}

	/**
	 * Methods responsible to define the type of the movement's Rookie
	 * @param direction
	 * @param board
	 */
	public void movement(Direction direction, Board b){

		direction = directions[index];

		if(index == 23)
			index = 0;
		else
			index++;

		moveDirection(direction);

	}
}