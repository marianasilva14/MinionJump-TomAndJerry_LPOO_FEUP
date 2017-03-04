package dkeep.logic;

import java.util.Random;

import dkeep.logic.Hero.StateHero;
import dkeep.logic.Rookie.Direction;

public class Drunken extends Guard{

	private int posx, posy;	
	private int index;
	
	public Drunken(int posx,int posy,int level) {
		super(posx,posy, level);
		index=0;
	}

	public enum Direction{
		RIGHT,LEFT,UP,DOWN
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
		pos_rand = rand.nextInt(2);
		
		Direction direction = directions[index];
		StateDrunken st = status[pos_rand];
		
		int Drunken_x =g.getPosx();
		int Drunken_y=g.getPosy();
		
		if(index == 23)
			index = 0;
		else
			index++;

		switch(direction) {
		case UP:{
			if(st== StateDrunken.G)
			g.setPosx(Drunken_x--);
		}
			break;
		case DOWN:{
			if(st== StateDrunken.G)
			g.setPosx(Drunken_x++);
			break;
		}
		case RIGHT:{
			if(st== StateDrunken.G)
			g.setPosy(Drunken_y--);
			break;
		}
		case LEFT:{
			if(st== StateDrunken.G)
			g.setPosy(Drunken_y--);
		}
		}
	}
	
}