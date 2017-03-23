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
		//index=0;
	}
/*
	private Direction directions[] = {Direction.LEFT, Direction.DOWN, Direction.DOWN, Direction.DOWN, Direction.DOWN, 
			Direction.LEFT,Direction.LEFT, Direction.LEFT,Direction.LEFT, Direction.LEFT, Direction.LEFT, Direction.DOWN,
			Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT,Direction.RIGHT, 
			Direction.RIGHT, Direction.UP,  Direction.UP, Direction.UP, Direction.UP, Direction.UP};
*/
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