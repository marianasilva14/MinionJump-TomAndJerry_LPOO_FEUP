package dkeep.logic;

import java.util.Random;

import dkeep.logic.Hero.StateHero;
import dkeep.logic.Rookie.Direction;

public class Drunken extends Guard{

	private int posx, posy;	
	private int index;
	
	public Drunken(int level) {
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
	
	public void movement(){
		
		int pos_rand;
		Random rand = new Random();
		pos_rand = rand.nextInt(2);
		
		Direction direction = directions[index];
		StateDrunken st = status[pos_rand];
		
		if(index == 23)
			index = 0;
		else
			index++;

		switch(direction) {
		case UP:{
			if(state== state.G)
			posx--;
		}
			break;
		case DOWN:{
			if(state== state.G)
			posx++;
			break;
		}
		case RIGHT:{
			if(state== state.G)
			posy++;
			break;
		}
		case LEFT:{
			if(state== state.G)
			posy--;
		}
		}
	}
	
}