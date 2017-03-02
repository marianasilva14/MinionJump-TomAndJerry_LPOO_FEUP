package dkeep.cli;
import java.util.Scanner;

import dkeep.logic.Board;
import dkeep.logic.Hero;

public class UserInteraction {

	Board b = new Board();
	Hero h = new Hero(level);
	
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
			switch (c) {
			case 'u':h.move(direction.UP);
			break;
			case 'd': h.move(direction.DOWN);
			break;
			case 'l': h.move(direction.LEFT);
			break;
			case 'r': h.move(direction.RIGHT);
			break;
			default: System.out.println("Invalid character");
			break;
			}
			
			printBoard(level);
		}
	}
	
	public void printBoard(int level)
	{	
		char[][] board = b.getBoard(level);
		int x= h.getPosx();
		int y= h.getPosy();  //x, y
		//board[x][y] = 'H';
		int row = board.length;
		int col = board[0].length;

		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(i == x && j == y)
					System.out.print("H");
				else
					System.out.print(board[i][j]+" ");
			}

			System.out.println();
		}
	}
}
