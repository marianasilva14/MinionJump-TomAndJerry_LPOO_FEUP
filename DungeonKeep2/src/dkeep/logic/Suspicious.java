package dkeep.logic;

import java.util.Random;

import dkeep.logic.Ogre.Direction;

public class Suspicious extends Guard{

	private int posx, posy;	
	
	public Suspicious(int posx, int posy, int level) {
		super(posx,posy,level);
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
	
	public void movement(Guard g){

		int pos_rand;
		Random rand = new Random();
		pos_rand = rand.nextInt(4);

		Direction direction = directions[pos_rand];
		
		int Suspicious_x =g.getPosx();
		int Suspicious_y=g.getPosy();

		switch(direction) {
		case UP:
			g.setPosx(Suspicious_x--);
			break;
		case DOWN:
			g.setPosx(Suspicious_x++);
			break;
		case RIGHT:
			g.setPosy(Suspicious_y++);
			break;
		case LEFT:
			g.setPosy(Suspicious_y--);
			break;
		}

	}

}