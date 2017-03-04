package dkeep.logic;

import java.util.Random;

import dkeep.logic.Ogre.Direction;

public class Suspicious extends Guard{

	private int posx, posy;	
	
	public Suspicious(int level) {
		super(level);
		posx=1;
		posy=8;
		// TODO Auto-generated constructor stub
	}
	
	public enum Direction{
		RIGHT,LEFT,UP,DOWN
	}

	private Direction directions[] = {Direction.RIGHT, Direction.LEFT, Direction.UP, Direction.DOWN};

	public Suspicious getSuspicious(){
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
	public void behaviorGuard(){
		
	}
	
	public void movement(){

		int pos_rand;
		Random rand = new Random();
		pos_rand = rand.nextInt(4);

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
			break;
		}

	}

}