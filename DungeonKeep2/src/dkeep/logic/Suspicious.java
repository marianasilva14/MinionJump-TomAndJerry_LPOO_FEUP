package dkeep.logic;

import java.util.Random;

import dkeep.logic.Ogre.Direction;

public class Suspicious extends Guard{

	private int index = 0;

	private int move = 1;
	
	public Suspicious(int posx, int posy, int level) {
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

	public Suspicious getSuspicious(){
		return this;
	}

	public Direction reverseDirection(){

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

	public void movement(){
 
		int pos_rand;
		Random rand = new Random();
		pos_rand = rand.nextInt(10);

		Direction direction = directions[index];

		if(pos_rand == 1)
			move *= -1;

		if(move == 1)
			direction = reverseDirection();
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