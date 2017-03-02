package dkeep.cli;
import java.util.Scanner;

import dkeep.logic.Board;
import dkeep.logic.Hero;
import dkeep.logic.Guard;

public class UserInteraction {

	Board b = new Board();
	Hero h = new Hero(level);
	Guard g = new Guard(level);

	public enum Direction{
		RIGHT,LEFT,UP,DOWN
	}

	public static int level= 0;

	public static void main(String[] args) {

		new UserInteraction().play();
	}

	public void play(){
		printBoard(level);
		char c;

		while(!b.checkIfEnds()){
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
			boolean valid=false;


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

			int x= h.getPosx();
			int y = h.getPosy();

			h.move(direction);

			if(!b.invalidMovement(h.getPosx(), h.getPosy(), level)){
				valid=true;
				g.movement();
			}
			else{
				System.out.println("Invalid movement. Try again");
				h.setPosx(x);
				h.setPosy(y);
			}

			printBoard(level);
		}

	}

	public void printBoard(int level)
	{	
		char[][] board = b.getBoard(level);

		int hero_x= h.getPosx();
		int hero_y= h.getPosy();
		int guard_x = g.getPosx();
		int guard_y = g.getPosy();

		int row = board.length;
		int col = board[0].length;

		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(i == hero_x && j == hero_y)
					System.out.print("H ");
				else if(i == guard_x && j == guard_y)
					System.out.print("G ");
				else
					System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}


	}
}
