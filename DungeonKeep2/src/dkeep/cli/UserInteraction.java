package dkeep.cli;
import java.util.Scanner;
import dkeep.logic.Board;
import dkeep.logic.Door;
import dkeep.logic.Drunken;
import dkeep.logic.Hero;
import dkeep.logic.Hero.StateHero;
import dkeep.logic.Level;
import dkeep.logic.Guard;
import dkeep.logic.Ogre;
import dkeep.logic.Suspicious;
import dkeep.logic.Drunken.StateDrunken;
import dkeep.logic.Entity;
import dkeep.logic.Game;


public class UserInteraction {

	//public static int level = 0;

	char[][] board1 = {{'X','X','X','X','X','X','X','X','X','X'},
			{'X',' ',' ',' ','I',' ','X',' ',' ','X'},
			{'X','X','X',' ','X','X','X',' ',' ','X'},
			{'X',' ','I',' ','I',' ','X',' ',' ','X'},
			{'X','X','X',' ','X','X','X',' ',' ','X'},
			{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X',' ','X','X','X','X',' ','X'},
			{'X',' ','I',' ','I',' ','X','k',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}};

	char[][] board2 = {{'X','X','X','X','X','X','X','X','X','X'},
			{'I',' ',' ',' ',' ',' ',' ',' ','k','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}};

	//	Board b = new Board();
	//	Hero h = new Hero(1,1,level);
	//	Guard g = Guard.raffleGuard(1,8,level);
	//	Ogre o = new Ogre(1,4,level);
	//	Door d =new Door(1,0,1);

	public Level[] levels;
	public Game game;


	public enum Direction{
		RIGHT,LEFT,UP,DOWN
	}


	public static void main(String[] args) {

		UserInteraction u = new UserInteraction();
		u.play();
	}

	public UserInteraction(){
		//create level 1
		Board board1 = new Board(this.board1);
		Entity hero1 = new Hero(1,1);
		Entity guard = Guard.raffleGuard(1,8);
		Entity[] characters1 = {hero1, guard};
		Level lv1 = new Level(board1, characters1, 1);

		// create level 2
		Board board2 = new Board(this.board2);
		Entity hero2 = new Hero(7, 1);
		Entity ogre = new Ogre(1, 4);
		Entity[] characters2 = { hero2, ogre };
		Level lv2 = new Level(board2, characters2, 2);

		levels = new Level[2];
		levels[0] = lv1;
		levels[1] = lv2;
		game = new Game(levels);
	}

	public void play(){

		boolean alreadychange=false;
		
		for(int i = 0; i < levels.length;){
			//while nao ganhou este nivel
	
			while(!levels[i].checkIfEnds(levels[i].getEntities()[0], levels[i].getEntities()[1])){
				if(!alreadychange){
				if(levels[i].getLevel()==2){
					levels[i].getEntities()[0].setSymbol('A');
					i++;
					alreadychange=true;
				}
				}
				
				printBoard(levels[i]);
				//pedir movimento ao jogador
				//correr logica jogo

				char c;
				boolean win=false;

				if(game.changeLevel(levels[i].getEntities()[0], levels[i])){
					if(levels[i].getLevel()==1){
						levels[i].setLevel(2);
					}
					else
						win=true;
				}
				if(win && (1 == levels[i].getEntities()[0].getPosx() && 0 == levels[i].getEntities()[0].getPosy() ))
				{	System.out.println("You won!! Congratulations!!");
				return;
				}

				System.out.println();
				System.out.println("Please insert a character:");
				System.out.println("To move down, insert 'd'");
				System.out.println("To move up, insert 'u'");
				System.out.println("To move left, insert 'l'");
				System.out.println("To move right, insert 'r'");

				Scanner reader = new Scanner (System.in);
				c = reader.next().charAt(0); 
				c = Character.toLowerCase(c);

				while(c!='r' && c!='l' && c!='d' && c!='u'){
					System.out.println("Invalid character. Try again.");
					c = reader.next().charAt(0); 
					c = Character.toLowerCase(c);
				}

				Direction direction = Direction.UP;

				switch (c) {
				case 'u': direction = Direction.UP;
				break;
				case 'd': direction = Direction.DOWN;
				break;
				case 'l': direction = Direction.LEFT;
				break;
				case 'r': direction = Direction.RIGHT;
				break;
				default: System.out.println("Invalid character");
				break;
				}

				int x = levels[i].getEntities()[0].getPosx();
				int y = levels[i].getEntities()[0].getPosy();
				int x_e = levels[i].getEntities()[1].getPosx();
				int y_e = levels[i].getEntities()[1].getPosy();

				boolean move_valid= false;

				levels[i].getEntities()[0].movement(direction);
				levels[i].getEntities()[1].movement(direction);

				if(!game.invalidMovement(levels[i].getEntities()[0], levels[i])){

					if(levels[i].getLevel() ==2 && game.verifyS(levels[i].getEntities()[0], levels[i])){
						levels[i].getEntities()[0].setPosx(x);
						levels[i].getEntities()[0].setPosy(y);
						levels[i].getBoard().getBoard()[1][0] = 'S';
					}
					if(levels[i].getEntities()[1] instanceof Ogre){
						while(!move_valid){
							if(game.invalidEntityMovement(levels[i].getEntities()[1],levels[i]))
							{
								levels[i].getEntities()[1].setPosx(x_e);
								levels[i].getEntities()[1].setPosy(y_e);
								levels[i].getEntities()[1].movement(direction);
							}
							else
								move_valid=true;
						}
					}
					else{
						if(levels[i].getEntities()[1] instanceof Drunken){
							if(((Drunken)levels[i].getEntities()[1]).getState() == StateDrunken.g){
								levels[i].getEntities()[1].setPosx(x_e);
								levels[i].getEntities()[1].setPosy(y_e);
							}
						}
					}
				}

				else{
					System.out.println("Invalid movement. Try again");
					levels[i].getEntities()[0].setPosx(x);
					levels[i].getEntities()[0].setPosy(y);
				}

				printBoard(levels[i]);
			}

			System.out.print("You got caught! Game Over!");
			return;
		}
	}

	public void printBoard(Level lv)
	{	
		System.out.println();

		int row = lv.getBoard().getBoard().length;
		int col = lv.getBoard().getBoard()[0].length;

		Entity[] e =lv.getEntities();
		game.checkLever(e[0], lv);
		char[][] map= new char[10][10];
		
		for(int i=0; i < e.length; i++)
			lv.getBoard().entityLever(e[i]);

		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				map[i][j] = lv.getBoard().getBoard()[i][j];
			}
		}

		for(int i=0; i < e.length;i++){

			if(e[i] instanceof Guard){
				if(e[i] instanceof Drunken){
					if(((Drunken)e[i]).getState() == StateDrunken.G)
						map[e[i].getPosx()][e[i].getPosy()]=e[i].getSymbol();
					else{
						lv.getEntities()[1].setSymbol('g');
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
