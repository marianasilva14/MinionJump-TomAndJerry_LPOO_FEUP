package dkeep.logic;

import java.util.Random;
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
	
	public int boardLimits(Board board){
		int row= board.getBoard().length-1;
		int col= board.getBoard()[0].length-1;

		boolean valid=false;

		while(!valid){

			int pos_rand;
			Random rand = new Random();
			pos_rand = rand.nextInt(4);

			switch(pos_rand){
			case 0:{
				if(posy+1 <= col && posy+1 >= 0 ){
					if(board.getBoard()[posx][posy+1] != 'X'){
						valid=true;
						return pos_rand;
					}
				}
				break;
			}
			case 1:{
				if(posy-1 <= col && posy-1 >= 0){
					if(board.getBoard()[posx][posy-1] != 'X'){
						valid=true;
						return pos_rand;
					}
				}
				break;
			}
			case 2:{
				if(posx-1 <= row && posx-1 >= 0){
					if(board.getBoard()[posx-1][posy] != 'X'){
						valid=true;
						return pos_rand;
					}
				}
				break;
			}
			case 3:{
				if(posx+1 <= row && posx+1 >= 0){
					if(board.getBoard()[posx+1][posy] != 'X'){
						valid=true;
						return pos_rand;
					}
				}
				break;
			}

			}
		}
		

		return 1;
	}
	
	public boolean checkIfMovementIsValid(Direction direction, Board b){

		switch(direction) {
		case UP:{
			if((b.getBoard()[posx-1][posy] != ' ' )&&
					(b.getBoard()[posx-1][posy] != 'k') &&
					(b.getBoard()[posx-1][posy] != 'S')){
				return false;
			}
			else
				return true;
		}
		case DOWN:{
			if((b.getBoard()[posx+1][posy] != ' ' )&&
					(b.getBoard()[posx+1][posy] != 'k') &&
					(b.getBoard()[posx+1][posy] != 'S')){
				return false;
			}
			else
				return true;
		}
		case RIGHT:{
			if((b.getBoard()[posx][posy+1] != ' ' )&&
					(b.getBoard()[posx][posy+1] != 'k') &&
					(b.getBoard()[posx][posy+1] != 'S')){
				return false;
			}
			else
				return true;
		}
		case LEFT:{
			if((b.getBoard()[posx][posy-1] != ' ' )&&
					(b.getBoard()[posx][posy-1] != 'k') &&
					(b.getBoard()[posx][posy-1] != 'S')){
				return false;
			}
			else
				return true;
		}
		}
		
		return true;

	}

	public abstract void movement(Direction direction, Board b);


}