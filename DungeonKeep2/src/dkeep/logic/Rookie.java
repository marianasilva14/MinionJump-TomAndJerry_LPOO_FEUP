package dkeep.logic;

import dkeep.logic.Guard;

public class Rookie extends Guard{

	private int posx, posy;	
	private int index=0;

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

	public void movement(Guard g){

		Direction direction = directions[index];

		if(index == 23)
			index = 0;
		else
			index++;
		
		int Rookie_x =g.getPosx();
		int Rookie_y=g.getPosy();

		switch(direction) {
		case UP:
			g.setPosx(Rookie_x--);
			break;
		case DOWN:
			g.setPosx(Rookie_x++);
			break;
		case RIGHT:
			g.setPosy(Rookie_y++);
			break;
		case LEFT:
			g.setPosy(Rookie_y--);
			break;
		}

	}
}