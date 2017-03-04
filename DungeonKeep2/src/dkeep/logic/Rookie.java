package dkeep.logic;

import dkeep.logic.Guard;

public class Rookie extends Guard{

	private int posx, posy;	
	private int index;

	public Rookie(int level) {
		super(level);
		posx=1;
		posy=8;
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

	public int getPosy(){
		return posy;
	}

	public int getPosx(){
		return posx;
	}

	public void setPosx(int posx){
		this.posx = posx;
	}

	public void setPosy(int posy){
		this.posy = posy;
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