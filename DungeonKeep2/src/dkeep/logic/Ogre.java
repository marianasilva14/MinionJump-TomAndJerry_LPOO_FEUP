package dkeep.logic;
import dkeep.logic.Entity;
import dkeep.cli.UserInteraction.Direction;

import java.util.Random;
import java.util.Vector;

public class Ogre extends Entity{

	private char symbol;
	
	public Ogre(int posx, int posy) {
		super(posx, posy);
		symbol = 'O';
	}

	private Direction directions[] = {Direction.RIGHT, Direction.LEFT, Direction.UP, Direction.DOWN};

	public Ogre getOgre(){
		return this;
	}
	
	public char getSymbol(){
		return symbol;
	}
	
	public void setSymbol(char symbol){
		this.symbol=symbol;
	}

	public void movement(Direction direction){

		int pos_rand;
		Random rand = new Random();
		pos_rand = rand.nextInt(4);

		direction = directions[pos_rand];

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

