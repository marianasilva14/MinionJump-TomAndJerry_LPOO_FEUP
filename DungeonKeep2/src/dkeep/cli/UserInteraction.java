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
import dkeep.logic.Play;
import dkeep.logic.Suspicious;
import dkeep.logic.Drunken.StateDrunken;
import dkeep.logic.Entity;
import dkeep.logic.Game;
import dkeep.logic.Game.Direction;


public class UserInteraction {

	//public static int level = 0;
	private static Level[] levels;

	static char[][] level1 = {{'X','X','X','X','X','X','X','X','X','X'},
			{'X',' ',' ',' ','I',' ','X',' ',' ','X'},
			{'X','X','X',' ','X','X','X',' ',' ','X'},
			{'X',' ','I',' ','I',' ','X',' ',' ','X'},
			{'X','X','X',' ','X','X','X',' ',' ','X'},
			{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X',' ','X','X','X','X',' ','X'},
			{'X',' ','I',' ','I',' ','X','k',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}};

	static char[][] level2 = {{'X','X','X','X','X','X','X','X','X','X'},
			{'I',' ',' ',' ',' ',' ',' ',' ','k','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}};

	
	static char[][] board = {
			{'X','X','X','X','X'},
			{'X','H',' ','G','X'},
			{'I',' ',' ',' ','X'},
			{'I','k',' ',' ','X'},
			{'X','X','X','X','X'}
	};
	
	 
	//	Board b = new Board();
	//	Hero h = new Hero(1,1,level);
	//	Guard g = Guard.raffleGuard(1,8,level);
	//	Ogre o = new Ogre(1,4,level);
	//	Door d =new Door(1,0,1);


	public static Game game;
	public static void main(String[] args) {

//		UserInteraction u = new UserInteraction();
//		u.play();
		
		// create level 1
		Board board1 = new Board(level1);
		Entity hero1 = new Hero(1, 1);
		Entity guard = Guard.raffleGuard(1, 8);
		Entity[] characters1 = { hero1, guard };
		Level lv = new Level(board1, characters1, 1);
		Game game = new Game(lv);
		Play lv1_play=new Play(lv,game);
		while(!lv1_play.play());
		if(lv1_play.end()){
			return;//perde no nivel 1
		};

//		create level 2
		Board board2 = new Board(level2);
		Entity hero2 = new Hero(7, 1);
		Entity ogre = new Ogre(1, 4);
		Entity[] characters2 = { hero2, ogre };
		lv.setBoard(board2);
		lv.setLevel(2);		
		lv.setEntities(characters2);
		Game game2 = new Game(lv);
		Play lv2_play=new Play(lv,game2);
		while(!lv2_play.play());
		if(lv2_play.end()){
			return;//perde no nivel 1
		};
	}

//	public UserInteraction(){
//		
//		
//		
//		
//	}
/*
	public void play(){

		boolean alreadychange=false;
		
		for(int i = 0; i < levels.length;){
			//while nao ganhou este nivel
	
			while(!levels[i].checkIfEnds(levels[i].getEntities()[0], levels[i].getEntities()[1])){
				if(!alreadychange){
				if(levels[i].getEntities()[1] instanceof Ogre){
					levels[i].getEntities()[0].setSymbol('A');
					alreadychange=true;
				}
				}
				
				printBoard(levels[i]);
				//pedir movimento ao jogador
				//correr logica jogo

				char c;
				if(i != levels.length-1 && game.changeLevel(levels[i].getEntities()[0], levels[i])){
					i++;
				}

				if(i==levels.length-1  && (1 == levels[i].getEntities()[0].getPosx() && 0 == levels[i].getEntities()[0].getPosy() ))
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

					if(levels[i].getEntities()[1] instanceof Ogre && game.verifyS(levels[i].getEntities()[0], levels[i])){
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
	}*/


}
