package dkeep.cli;
import java.util.Scanner;
import dkeep.logic.Board;
import dkeep.logic.Door;
import dkeep.logic.Drunken;
import dkeep.logic.Hero;
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

	
	public static Game game;
	
	public static void main(String[] args) {
		
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

		// create level 2
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
	
}