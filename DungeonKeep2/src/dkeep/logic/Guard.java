package dkeep.logic;
import dkeep.cli.UserInteraction;

import java.util.Random;
import java.util.Vector;

public class Guard extends Entity{

	private int posx, posy;	
	private int index;
	
	public enum Direction{
		RIGHT,LEFT,UP,DOWN
	}
	private Direction directions[] ={Direction.LEFT, Direction.DOWN, Direction.DOWN, Direction.DOWN, Direction.DOWN, 
			Direction.LEFT,Direction.LEFT, Direction.LEFT,Direction.LEFT, Direction.LEFT, Direction.LEFT, Direction.DOWN,
			Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT,Direction.RIGHT, 
			Direction.RIGHT, Direction.UP,  Direction.UP, Direction.UP, Direction.UP, Direction.UP};
	
	public Guard(int level){
		if(level == 0){
			posx=1;
			posy=8;
			index=0;
		}/*
		else{
			posx=1;
			posy=8;
			index=0;
		}*/

	}
	public Guard getGuard(){
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
		}
		
	}
}