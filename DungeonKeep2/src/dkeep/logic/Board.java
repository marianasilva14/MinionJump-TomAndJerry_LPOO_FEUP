package dkeep.logic;
import dkeep.cli.UserInteraction;
import dkeep.logic.Guard;
import dkeep.logic.Hero;
import dkeep.logic.Hero.StateHero;
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
			{'I',' ',' ',' ',' ',' ',' ',' ','k','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
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
		
		if(level == 0){
			if(board[level][posx][posy] == 'X' || board[level][posx][posy] == 'I')
				return true;
			else
				return false;
		}
		else{
			if(board[level][posx][posy] == 'X')
				return true;
			else
				return false;
		}
		

	}

	public void checkLever(int posx, int posy, int level){

		if(level == 0){
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

	}

	public boolean checkIfEnds(int posx,int posy, int level, Guard g, Ogre o){
		if(level == 0)
		{
			if((posx-1 == g.getPosx() && posy == g.getPosy()) || (posx+1 == g.getPosx() && posy == g.getPosy()) || (posx == g.getPosx() && posy-1 == g.getPosy()) || (posx == g.getPosx() && posy+1 == g.getPosy()))
				return true;
			else
				return false;
		}
		else{
			if((posx-1 == o.getPosx() && posy == o.getPosy()) || (posx+1 == o.getPosx() && posy == o.getPosy()) || (posx == o.getPosx() && posy-1 == o.getPosy()) || (posx == o.getPosx() && posy+1 == o.getPosy()) || (posx == o.getPosx() && posy == o.getPosy()))
				return true;
			else
				return false;
		}

	}

	public boolean changeLevel(int posx, int posy, int level){

		if(board[level][posx+1][posy] == 'S' || board[level][posx][posy+1] == 'S' || board[level][posx-1][posy] == 'S' || board[level][posx][posy-1] == 'S')
			return true;

		return false;
	}

	public int positionXLever(int posx, int posy, int level){
		if(level == 1){
			if(board[level][posx][posy] == 'k')
				return posx;
		}
		return 0;
	}

	public int positionYLever(int posx, int posy, int level){
		if(level == 1){
			if(board[level][posx][posy] == 'k')
				return posy;
		}
		return 0;
	}

	public int positionXDoor(int posx, int posy, int level){
		if(level == 1){
			if(board[level][posx][posy] == 'I')
				return posx;
		}
		return 0;
	}

	public int positionYDoor(int posx, int posy, int level){
		if(level == 1){
			if(board[level][posx][posy] == 'I')
				return posy;
		}
		return 0;
	}
/*
	public void ogreLever(int posx, int posy, int level, Ogre o){
		if(level == 1){
			if(posx == positionXLever(posx, posy, level) && posy == positionYLever(posx, posy, level))
				board[level][posx][posy] = '$';
		}
	}
*/	
	public void heroIsArmed(int posx, int posy, int level, Hero h){
		if(level == 1){
			if(posx == positionXLever(posx, posy, level) && posy == positionYLever(posx, posy, level))
				h.setState(StateHero.ARMED);
		}
	}

	public void winGame(int posx, int posy, int level, Hero h){
		if(level == 1){
			if(h.getState() == StateHero.ARMED)
				if(posx == positionXDoor(posx, posy, level) && posy == positionYDoor(posx, posy, level)){
					board[level][posx][posy] = 'I';
					System.out.println("You won! Congratulations!");
				}
		}
	}
}
