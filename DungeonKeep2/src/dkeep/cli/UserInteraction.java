package dkeep.cli;
import java.util.Scanner;
import dkeep.logic.Board;
import dkeep.logic.Hero;
import dkeep.logic.Hero.StateHero;
import dkeep.logic.Guard;
import dkeep.logic.Ogre;

public class UserInteraction {

	Board b = new Board();
	Hero h = new Hero(level);
	Guard g = new Guard(level);
	Ogre o = new Ogre(level);

	public enum Direction{
		RIGHT,LEFT,UP,DOWN
	}

	public static int level = 0;

	public static void main(String[] args) {

		new UserInteraction().play();
	}

	public void play(){
		printBoard(level);
		char c;

		while(!b.checkIfEnds(h.getPosx(), h.getPosy(),level, g, o)){

			if(b.changeLevel(h.getPosx(), h.getPosy(), level))
				level = 1;

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

			int x = h.getPosx();
			int y = h.getPosy();
			int x_o = o.getPosx();
			int y_o = o.getPosx();

			h.move(direction);
			o.movement();

			if(!b.invalidMovement(h.getPosx(), h.getPosy(), level)){
				if(level == 0)
					g.movement();
				else{
					if(!b.invalidMovement(o.getPosx(), o.getPosy(), level))
						o.movement();
				}
			}
			else{
				System.out.println("Invalid movement. Try again");
				h.setPosx(x);
				h.setPosy(y);
				o.setPosx(x_o);
				o.setPosy(y_o);
			}

			printBoard(level);
		}

		System.out.print("You got caught! Game Over!");
	}

	public void printBoard(int level)
	{	
		char[][] board = b.getBoard(level);

		int hero_x= h.getPosx();
		int hero_y= h.getPosy();
		int guard_x = g.getPosx();
		int guard_y = g.getPosy();
		int ogre_x = o.getPosx();
		int ogre_y = o.getPosy();

		int row = board.length;
		int col = board[0].length;

		b.checkLever(hero_x,hero_y,level);
		b.heroIsArmed(hero_x,hero_y,level,h);
		b.winGame(hero_x, hero_y, level, h);

		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(level == 1){
					if(h.getState() != StateHero.ARMED){
						if(i == hero_x && j == hero_y)
							System.out.print("A ");
						else if(i == guard_x && j == guard_y && level == 0)
							System.out.print("G ");
						else if(i == ogre_x && j == ogre_y && level == 1)
							System.out.print("O ");
						else
							System.out.print(board[i][j]+" ");
					}
					else{
						if(i == hero_x && j == hero_y)
							System.out.print("K ");
						else if(i == guard_x && j == guard_y && level == 0)
							System.out.print("G ");
						else if(i == ogre_x && j == ogre_y && level == 1)
							System.out.print("O ");
						else
							System.out.print(board[i][j]+" ");
					}
				}
				else{
					if(i == hero_x && j == hero_y)
						System.out.print("H ");
					else if(i == guard_x && j == guard_y && level == 0)
						System.out.print("G ");
					else if(i == ogre_x && j == ogre_y && level == 1)
						System.out.print("O ");
					else
						System.out.print(board[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
}
