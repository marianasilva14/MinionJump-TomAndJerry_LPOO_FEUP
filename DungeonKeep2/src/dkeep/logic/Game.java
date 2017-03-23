package dkeep.logic;

import dkeep.cli.UserInteraction;

/**
 * 
 * Game.java - Class that includes rules of the game
 *
 */
public class Game {

	public UserInteraction cli;
	public Level level;

	public enum Direction{
		RIGHT,LEFT,UP,DOWN
	}

	public Game(Level level){
		this.level=level;
	}

	/**
	 * Method that changes the doors to stairs when the hero reaches the lever
	 * @param entity
	 * @param level
	 */
	public void checkLever(Entity e, Level lv){
		if(lv.getBoard().getBoard()[e.getPosx()][e.getPosy()] == 'k'){
			e.setSymbol('K');
			int row_aux = lv.getBoard().getBoard().length;
			int col_aux = lv.getBoard().getBoard()[0].length;
			for(int i = 0; i < row_aux; i++){
				for(int j = 0; j < col_aux; j++){
					if(j == lv.getBoard().getBoard().length || j == 0 || i == lv.getBoard().getBoard().length || i == 0)
					if(lv.getBoard().getBoard()[i][j] == 'I')
						lv.getBoard().getBoard()[i][j] = 'S';}} }	
	}
	
	/**
	 * @param entity
	 * @param level
	 * @return true if entity's position is in the place of the stairs
	 */
	public boolean changeLevel(Entity e, Level lv){

		if(lv.getBoard().getBoard()[e.getPosx()][e.getPosy()] == 'S')
			return true;
		else
			return false;

	}

	public boolean entityLever(Entity e, Level lv){

		if(lv.getBoard().getBoard()[e.getPosx()][e.getPosy()] == 'k'){
			if(e instanceof Ogre){
				if(!((Ogre) e).getKey()){
					e.setSymbol('$');
					((Ogre) e).setKey(true);}
				else
					e.setSymbol('O');}
			else if(e instanceof Hero)
				e.setSymbol('K');
			return true;}
		
		else if(e instanceof Ogre){
			if(((Ogre) e).getKey())
			e.setSymbol('O');}
		
		return false;
	}

	/**
	 * Method that clean the old club's position
	 * @param board
	 */
	public void cleanClub(Board b){
		
		int row= b.getBoard().length;
		int col= b.getBoard()[0].length;
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(b.getBoard()[i][j] == '*')
					b.getBoard()[i][j]=' ';}
		}
	}

	/**
	 * @return level
	 */
	public Level getLevel() {
		return level;
	}
}
