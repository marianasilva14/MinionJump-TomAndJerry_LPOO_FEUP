package dkeep.logic;

import java.util.Vector;

import dkeep.logic.Game.Direction;

import java.awt.Point;

public abstract class Entity {

	public int posx, posy;
	public char symbol;


	Entity(int x,int y){
		posx = x;
		posy = y;
		symbol='?';

	}
	
	public int getPosy(){
		return posy;
	}

	public int getPosx(){
		return posx;
	}
	
	public char getSymbol(){
		return symbol;
	}
	
	public void setSymbol(char symbol){
		this.symbol=symbol;
	}

	public void setPosx(int posx){
		this.posx = posx;
	}

	public void setPosy(int posy){
		this.posy = posy;
	}

	
	public abstract void movement(Direction direction);
	

}