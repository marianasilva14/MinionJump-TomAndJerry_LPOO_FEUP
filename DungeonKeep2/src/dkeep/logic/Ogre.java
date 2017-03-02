package dkeep.logic;
import java.util.Random;

import dkeep.logic.Entity;

public class Ogre extends Entity{

	private int posx, posy;	
	public enum Direction{
		RIGHT,LEFT,UP,DOWN
	}
	
	private Direction directions[] = { Direction.RIGHT, Direction.LEFT, Direction.UP, Direction.DOWN};
	
	public Ogre(int level)
	{
		if(level ==1)
		{
			posx=1;
			posy=4;
		}
	}
	public Ogre getOgre(){
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

		int pos_rand;
		Random rand = new Random();
		pos_rand = rand.nextInt(3);
		
		Direction direction = directions[pos_rand];
		
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

