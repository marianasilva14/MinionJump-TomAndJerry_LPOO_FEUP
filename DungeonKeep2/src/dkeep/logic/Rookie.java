package dkeep.logic;

import dkeep.logic.Guard;

public class Rookie extends Guard{

	private int index = 0;

	public Rookie(int posx, int posy, int level) {
		super(posx,posy,level);
		index=0;
	}

	public enum Direction{
		RIGHT,LEFT,UP,DOWN
	}
	private Direction directions[] = {Direction.LEFT, Direction.DOWN, Direction.DOWN, Direction.DOWN, Direction.DOWN, 
			Direction.LEFT,Direction.LEFT, Direction.LEFT,Direction.LEFT, Direction.LEFT, Direction.LEFT, Direction.DOWN,
			Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT,Direction.RIGHT, 
			Direction.RIGHT, Direction.UP,  Direction.UP, Direction.UP, Direction.UP, Direction.UP};

	public Rookie getRookie(){
		return this;
	}

	public void movement(){

		Direction direction = directions[index];

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