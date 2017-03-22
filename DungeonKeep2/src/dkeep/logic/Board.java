package dkeep.logic;
import java.util.ArrayList;

import dkeep.logic.Guard;
import dkeep.logic.Drunken.StateDrunken;
import dkeep.logic.Drunken;
/**
 * 
 * Board.java - Class that represents the board of the game
 *
 */
public class Board {

	private char map[][];

/**
 * Constructor of this class
 * @param board
 */
	public Board(char b[][]){
		map=copy(b);
	}

	/**
	 * @return board
	 */
	public char[][] getBoard(){
		return map;
	}
	/*
	public char getSymbol(int posx, int posy){
		return map[posx][posy];
	}
*/
	/**
	 * Method that checks the limits of the board
	 * @param entity
	 * @return true if all entities respects the limits of the board
	 */
	public boolean checkLimits(Entity e){

		int row= map.length-1;
		int col= map[0].length-1;


		if (e.getPosy() == col || e.getPosy() == 0
				|| e.getPosx() == row || e.getPosx() == 0)
			return false;
		else if ((e.getPosy()+1 <= col && e.getPosy()+1 >= 0)
				&& (e.getPosy()-1 <= col && e.getPosy()-1 >= 0)
				&& (e.getPosx()-1 <= row && e.getPosx()-1 >= 0)
				&& (e.getPosx()+1 <= row && e.getPosx()+1 >= 0))
			return true;

		else
			return false;
	}
	/*
	public void printBoard(Game game)
	{	
		System.out.println();

		int row = game.getLevel().getBoard().getBoard().length;
		int col = game.getLevel().getBoard().getBoard()[0].length;

		ArrayList<Entity> e =game.getLevel().getEntities();
		game.checkLever(e.get(0), game.getLevel());
		char[][] map= new char[10][10];

		for(int i=0; i < e.size(); i++)
			game.entityLever(e.get(i), game.getLevel());


		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				map[i][j] = game.getLevel().getBoard().getBoard()[i][j];
			}
		}
		for(int i=0; i < e.size();i++){

			if(e.get(i) instanceof Guard){
				if(e.get(i) instanceof Drunken){
					if(((Drunken)e.get(i)).getState() == StateDrunken.G)
						map[e.get(i).getPosx()][e.get(i).getPosy()]=e.get(i).getSymbol();
					else{
						game.getLevel().getEntities().get(i).setSymbol('g');
						map[e.get(i).getPosx()][e.get(i).getPosy()]=e.get(i).getSymbol();
					}
				}
				else
					map[e.get(i).getPosx()][e.get(i).getPosy()]=e.get(i).getSymbol();
			}
			else
				map[e.get(i).getPosx()][e.get(i).getPosy()]=e.get(i).getSymbol();
		}

		for(int i=0; i < map.length;i++){
			for(int j=0; j< map[0].length;j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}

		System.out.println();
	}

*/
	/**
	 * Method that convert board to string
	 * @param game
	 * @return string that represents the board
	 */
	public String printBoardToString(Game game){
		String gamestring="";
		char[][] map = new char[10][10];

		int row = game.getLevel().getBoard().getBoard().length;
		int col = game.getLevel().getBoard().getBoard()[0].length;

		ArrayList<Entity> e = game.getLevel().getEntities();
		if(game.getLevel().getBoard().checkLimits(e.get(0)))
			game.checkLever(e.get(0), game.getLevel());

		for(int i=0; i < e.size(); i++)
			game.entityLever(e.get(i), game.getLevel());

		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				map[i][j] = game.getLevel().getBoard().getBoard()[i][j];
			}
		}
		
		for(int i=0; i < e.size();i++){
			if(e.get(i) instanceof Guard){
				if(e.get(i) instanceof Drunken){
					if(((Drunken)e.get(i)).getState() == StateDrunken.G)
						map[e.get(i).getPosx()][e.get(i).getPosy()]=e.get(i).getSymbol();
					else{
						game.getLevel().getEntities().get(i).setSymbol('g');
						map[e.get(i).getPosx()][e.get(i).getPosy()]=e.get(i).getSymbol();
					}
				}
				else
					map[e.get(i).getPosx()][e.get(i).getPosy()]=e.get(i).getSymbol();
			}
			else
				map[e.get(i).getPosx()][e.get(i).getPosy()]=e.get(i).getSymbol();
		}

		for(int i=0; i< map.length;i++){
			for(int j=0; j < map[0].length;j++){
				gamestring+=map[i][j];
			}
			gamestring+='\n';
		}

		gamestring += '\n';
		
		return gamestring;

	}
	
	/**
	 * Method that makes a copy of board
	 * @param layout
	 * @return copy of board
	 */
	public char[][] copy(char[][] layout){
		char[][] copy = new char[layout.length][layout[0].length];
		for(int i=0;i<layout.length;i++){
			for(int j=0; j<layout[0].length;j++){
				copy[i][j]=layout[i][j];
			}
		}
		return copy;
	}
}
