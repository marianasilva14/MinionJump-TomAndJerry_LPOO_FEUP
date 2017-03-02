package dkeep.logic;
import java.awt.Point;
import dkeep.cli.UserInteraction;
import dkeep.logic.Guard;

import dkeep.logic.Hero;

public class Board {

	char[][][] board = {{{'X','X','X','X','X','X','X','X','X','X'},
		{'X',' ',' ',' ','I',' ','X',' ',' ','X'},
		{'X','X','X',' ','X','X','X',' ',' ','X'},
		{'X',' ','I',' ','I',' ','X',' ',' ','X'},
		{'X','X','X',' ','X','X','X',' ',' ','X'},
		{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X','X','X',' ','X','X','X','X',' ','X'},
		{'X',' ','I',' ','I',' ','X','k',' ','X'},
		{'X','X','X','X','X','X','X','X','X','X'}}, 

			{{'X','X','X','X','X','X','X','X','X','X'},
			{'I',' ',' ',' ','O',' ',' ',' ','k','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ','*',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}}};


	public Board(){
	}


	public char[][] getBoard(int level){
		return board[level];
	}

	public boolean invalidMovement(int posx, int posy, int level){

		if(board[level][posx][posy] == 'X' || board[level][posx][posy] == 'I')
			return true;
		else
			return false;

	}

	public void checkLever(int posx, int posy, int level){

		if(board[level][posx][posy] == 'k')
		{
			int row_aux = board[level].length;
			int col_aux = board[level][0].length;

			for(int i = 0; i < row_aux; i++)
			{
				for(int j = 0; j < col_aux; j++)
				{
					if(board[level][i][j] == 'I')
						board[level][i][j] = 'S';
				}
			}
		}	
	}

	public boolean checkIfEnds(int posx,int posy, int level, Guard g, Ogre o){
		if(level ==0)
		{
			if((posx-1 == g.getPosx() && posy== g.getPosy()) || (posx+1 == g.getPosx() && posy == g.getPosy()) || (posx == g.getPosx() && posy-1 == g.getPosy()) || (posx == g.getPosx() && posy+1 == g.getPosy()))
				return true;
			else
				return false;
		}
		else{
			if((posx-1 == o.getPosx() && posy== o.getPosy()) || (posx+1 == o.getPosx() && posy == o.getPosy()) || (posx == o.getPosx() && posy-1 == o.getPosy()) || (posx == o.getPosx() && posy+1 == o.getPosy()))
				return true;
			else
				return false;
		}

	}

	public boolean changeLevel(int posx, int posy, int level){

		if(board[level][posx][posy] == 'S')
			return true;

		return false;
	}
}