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

	public void printBoard(Game game)
	{	
		System.out.println();

		int row = game.getLevel().getBoard().getBoard().length;
		int col = game.getLevel().getBoard().getBoard()[0].length;

		Entity[] e =game.getLevel().getEntities();
		game.checkLever(e[0], game.getLevel());
		char[][] map= new char[10][10];
		
		for(int i=0; i < e.length; i++)
			game.entityLever(e[i], game.getLevel());


		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				map[i][j] = game.getLevel().getBoard().getBoard()[i][j];
			}
		}

		for(int i=0; i < e.length;i++){

			if(e[i] instanceof Guard){
				if(e[i] instanceof Drunken){
					if(((Drunken)e[i]).getState() == StateDrunken.G)
						map[e[i].getPosx()][e[i].getPosy()]=e[i].getSymbol();
					else{
						game.getLevel().getEntities()[1].setSymbol('g');
						map[e[i].getPosx()][e[i].getPosy()]=e[i].getSymbol();
					}
				}
				else
					map[e[i].getPosx()][e[i].getPosy()]=e[i].getSymbol();
			}
			else
				map[e[i].getPosx()][e[i].getPosy()]=e[i].getSymbol();
		}

		for(int i=0; i < map.length;i++){
			for(int j=0; j< map[0].length;j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
		
		System.out.println();
	}
}
