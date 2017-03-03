package dkeep.logic;
import dkeep.cli.UserInteraction;
import dkeep.logic.Ogre.Direction;

import java.util.Random;
import java.util.Vector;

public class Guard extends Entity{

	private int posx, posy;	
	private int index;
	
	public enum GuardType{
		Rookie,Suspicious,Drunken
	}
	
	public enum Direction{
		RIGHT,LEFT,UP,DOWN
	}
	private Direction directions[] = {Direction.LEFT, Direction.DOWN, Direction.DOWN, Direction.DOWN, Direction.DOWN, 
			Direction.LEFT,Direction.LEFT, Direction.LEFT,Direction.LEFT, Direction.LEFT, Direction.LEFT, Direction.DOWN,
			Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT,Direction.RIGHT, 
			Direction.RIGHT, Direction.UP,  Direction.UP, Direction.UP, Direction.UP, Direction.UP};
	
	private GuardType guards[] = {GuardType.Drunken, GuardType.Rookie, GuardType.Suspicious};
	
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
	
	public void raffleGuard(){
		
		int pos_rand;
		Random rand = new Random();
		pos_rand = rand.nextInt(3);
		
		GuardType guard = guards[pos_rand];
		
		switch(guard) {
		case Rookie:
			posx--;
			break;
		case Suspicious:
			posx++;
			break;
		case Drunken:
			posy++;
		}
	}
}