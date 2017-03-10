package dkeep.logic;

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

	public void movement(Direction direction){
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