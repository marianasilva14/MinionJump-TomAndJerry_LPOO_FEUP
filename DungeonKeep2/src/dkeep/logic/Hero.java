package dkeep.logic;

import java.util.Random;

import dkeep.logic.Game.Direction;

public class Hero extends Entity{

	private char symbol;

	public Hero(int posx, int posy) {
		super(posx, posy);
		symbol = 'H';
	}

	public char getSymbol(){
		return symbol;
	}

	public void setSymbol(char symbol){
		this.symbol=symbol;
	}

	public void movement(Direction direction, Board b){

		boolean invalid=false;
		
		if(!checkIfMovementIsValid(direction,b))
			invalid=true;
		
		switch(direction) {
		case UP:
			if(!invalid)
			posx--;
			break;
		case DOWN:
			if(!invalid)
			posx++;
			break;
		case RIGHT:
			if(!invalid)
			posy++;
			break;
		case LEFT:
			if(!invalid)
			posy--;
			break;
		}
	}
}