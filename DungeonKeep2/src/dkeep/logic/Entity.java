package dkeep.logic;

import java.util.Random;

import dkeep.logic.Game.Direction;

/**
 * 
 * Entity.java - Class that represents all entities of the game
 *
 */
public abstract class Entity {

	public int posx, posy;
	public char symbol;

	/**
	 * Constructor of this class
	 * @param x represents the coordinate x of the position of the entity
	 * @param y represents the coordinate y of the position of the entity
	 */
	Entity(int x,int y){
		posx = x;
		posy = y;
		symbol='?';

	}

	/**
	 * @return posy of entity
	 */
	public int getPosy(){
		return posy;
	}

	/**
	 * @return posx of entity
	 */
	public int getPosx(){
		return posx;
	}

	/**
	 * @return symbol of entity
	 */
	public char getSymbol(){
		return symbol;
	}

	/**
	 * Method that sets the symbol of entity
	 * @param symbol
	 */
	public void setSymbol(char symbol){
		this.symbol=symbol;
	}

	/**
	 * Method that sets position x of entity
	 * @param posx
	 */
	public void setPosx(int posx){
		this.posx = posx;
	}

	/**
	 * Method that sets position y of entity
	 * @param posx
	 */
	public void setPosy(int posy){
		this.posy = posy;
	}

	/**
	 * Method that checks the limits of the board
	 * @param board
	 * @return pos_rand if valid
	 */
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

	public boolean conditionsToMove(Direction direction, Board b, int x, int y){
		if((b.getBoard()[x][y] != ' ' )&&
				(b.getBoard()[x][y] != 'k') &&
				(b.getBoard()[x][y] != 'S')){
			return false;
		}
		else
			return true;
	}

	/**
	 * Method that checks if movement is valid
	 * @param direction
	 * @param board
	 * @return true if movement is valid
	 */
	public boolean checkIfMovementIsValid(Direction direction, Board b){

		switch(direction) {
		case UP:
			if(!conditionsToMove(direction, b, posx-1, posy))
				return false;
			break;
		case DOWN:
			if(!conditionsToMove(direction, b, posx+1, posy))
				return false;
			break;
		case RIGHT:
			if(!conditionsToMove(direction, b, posx, posy+1))
				return false;
			break;
		case LEFT:
			if(!conditionsToMove(direction, b, posx, posy-1))
				return false;
			break;
		}

		return true;

	}
	/**
	 * Abstract method responsible to move entities
	 * @param direction
	 * @param board
	 */
	public abstract void movement(Direction direction, Board b);


}