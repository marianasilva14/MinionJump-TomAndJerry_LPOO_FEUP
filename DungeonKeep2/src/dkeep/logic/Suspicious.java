package dkeep.logic;

import java.util.Random;

import dkeep.cli.UserInteraction.Direction;

public class Suspicious extends Guard{

	private int index = 0;

	private int move = 1;
	
	public Suspicious(int posx, int posy) {
		super(posx,posy);
		index=0;
	}
	
	private Direction directions[] = {Direction.LEFT, Direction.DOWN, Direction.DOWN, Direction.DOWN, Direction.DOWN, 
			Direction.LEFT,Direction.LEFT, Direction.LEFT,Direction.LEFT, Direction.LEFT, Direction.LEFT, Direction.DOWN,
			Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT,Direction.RIGHT, 
			Direction.RIGHT, Direction.UP,  Direction.UP, Direction.UP, Direction.UP, Direction.UP};

	public Suspicious getSuspicious(){
		return this;
	}

	public Direction reverseSuspiciousDirection(){

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

	public void movement(Direction direction){
 
		int pos_rand;
		Random rand = new Random();
		pos_rand = rand.nextInt(10);

		direction = directions[index];

		if(pos_rand == 1)
			move *= -1;

		if(move == 1)
			direction = reverseSuspiciousDirection();
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