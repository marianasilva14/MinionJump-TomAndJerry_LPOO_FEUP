package dkeep.logic;
import dkeep.cli.UserInteraction;
import dkeep.logic.Guard;
import dkeep.logic.Guard.GuardType;
import dkeep.logic.Hero;
import dkeep.logic.Drunken.StateDrunken;
import dkeep.logic.Hero.StateHero;
import dkeep.logic.Hero;
import dkeep.logic.Drunken;

public class Board {
	/*
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
	 */

	private char map[][];
	private static int nr_times;

	public Board(){
	}

	public Board(char b[][]){
		map=b;
	}
	
	public char[][] getBoard(){
		return map;
	}

	public char getSymbol(int posx, int posy){
		return map[posx][posy];
	}


/*
	public int positionXLever(Entity e){
			if(map[e.getPosx()][e.getPosy()] == 'k')
				return posx;
		return 0;
	}

	public int positionYLever(int posx, int posy, int level){
		if(level == 1){
			if(map[posx][posy] == 'k')
				return posy;
		}
		return 0;
	}

	public int positionXDoor(int posx, int posy, int level){
		if(level == 1){
			if(map[posx][posy] == 'I')
				return posx;
		}
		return 0;
	}

	public int positionYDoor(int posx, int posy, int level){
		if(level == 1){
			if(map[posx][posy] == 'I')
				return posy;
		}
		return 0;
	}
*/

/*
	public void heroIsArmed(Entity e){
		if(level == 1){
			if(e.getPosx() == positionXLever(e.getPosx(),e.getPosy()) && e.getPosy() == positionYLever(e.getPosx(), e.getPosy()))
				h.setState(StateHero.ARMED);
		}
	}
*/
}
