package dkeep.logic;

import java.util.Random;
import dkeep.cli.UserInteraction.Direction;

public class Drunken extends Guard{

	private int index;
	private int move = 1;


	public Drunken(int posx,int posy) {
		super(posx,posy);
		index = 0;
	}

	private Direction directions[] = {Direction.LEFT, Direction.DOWN, Direction.DOWN, Direction.DOWN, Direction.DOWN, 
			Direction.LEFT,Direction.LEFT, Direction.LEFT,Direction.LEFT, Direction.LEFT, Direction.LEFT, Direction.DOWN,
			Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT,Direction.RIGHT, 
			Direction.RIGHT, Direction.UP,  Direction.UP, Direction.UP, Direction.UP, Direction.UP};

	public enum StateDrunken{
		G,g;
	}

	private StateDrunken status[] ={StateDrunken.G,StateDrunken.g};

	public StateDrunken state = StateDrunken.G;

	public StateDrunken getState() {
		return state;
	}

	public void setStateDrunken(StateDrunken st) {
		this.state = st;
	}

	public Drunken getDrunken(){
		return this;
	}

	public void behaviorGuard(){

	}

	public Direction reverseDrunkenDirection(){

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

		int status_rand;
		Random rand2 = new Random();
		status_rand = rand2.nextInt(2);
		StateDrunken st = status[status_rand];

		setStateDrunken(st);

		int pos_rand;
		Random rand = new Random();
		pos_rand = rand.nextInt(10);

		direction = directions[index];

		if(pos_rand == 1)
			move *= -1;

		if(st == StateDrunken.G){
			if(move == 1)
				direction = reverseDrunkenDirection();
			else
				index++;

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
			}
		}
	}

}