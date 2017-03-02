package dkeep.logic;

import java.util.Vector;
import dkeep.cli.UserInteraction;

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
		}
		else{
			posx=1;
			posy=8;
			index=0;
		}

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
		/*int[][] index = {{1,8},{1,7},{2,7},{3,7},{4,7},{5,7},{5,6},{5,5},{5,4},{5,3},
				{5,2},{5,1},{6,1},{6,2},{6,3},{6,4},{6,5},{6,6},{6,7},{6,8},{5,8},{4,8},{3,8},{2,8}};*/
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