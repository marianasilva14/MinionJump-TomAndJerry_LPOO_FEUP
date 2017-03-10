package dkeep.logic;

import java.util.Scanner;

import dkeep.cli.UserInteraction;
import dkeep.logic.Drunken.StateDrunken;
import dkeep.logic.Game.Direction;

public class Play {

	private Level level;
	private Game game;
	private boolean endGame=false;
	
	
	public Play(Level level,Game game) {
		this.level = level;
		this.game = game;
	}

	public boolean play() {

		// while nao ganhou este nivel
		boolean alreadychange=false;
	
		while (!level.checkIfEnds(level.getEntities()[0], level.getEntities()[1])) {
			if(game.changeLevel(level.getEntities()[0], game.getLevel())){
				if(level.getEntities()[1] instanceof Ogre){
					System.out.println("You won! Congratulations!");
				}
				return true;
			}
			if(!alreadychange){
			if (level.getEntities()[1] instanceof Ogre) {
				level.getEntities()[0].setSymbol('A');
				alreadychange=true;
			}
			}

			game.getLevel().getBoard().printBoard(game);
			// pedir movimento ao jogador
			// correr logica jogo

			char c;

			System.out.println();
			System.out.println("Please insert a character:");
			System.out.println("To move down, insert 'd'");
			System.out.println("To move up, insert 'u'");
			System.out.println("To move left, insert 'l'");
			System.out.println("To move right, insert 'r'");

			Scanner reader = new Scanner(System.in);
			c = reader.next().charAt(0);
			c = Character.toLowerCase(c);

			while (c != 'r' && c != 'l' && c != 'd' && c != 'u') {
				System.out.println("Invalid character. Try again.");
				c = reader.next().charAt(0);
				c = Character.toLowerCase(c);
			}

			Direction direction = Direction.UP;

			switch (c) {
			case 'u':
				direction = Direction.UP;
				break;
			case 'd':
				direction = Direction.DOWN;
				break;
			case 'l':
				direction = Direction.LEFT;
				break;
			case 'r':
				direction = Direction.RIGHT;
				break;
			default:
				System.out.println("Invalid character");
				break;
			}

			int x = level.getEntities()[0].getPosx();
			int y = level.getEntities()[0].getPosy();
			int x_e = level.getEntities()[1].getPosx();
			int y_e = level.getEntities()[1].getPosy();

			boolean move_valid = false;

			level.getEntities()[0].movement(direction);
			level.getEntities()[1].movement(direction);

			if (!game.invalidMovement(level.getEntities()[0], level)) {

				if (level.getLevel() == 2 && game.verifyS(level.getEntities()[0], level)) {
					level.getEntities()[0].setPosx(x);
					level.getEntities()[0].setPosy(y);
					level.getBoard().getBoard()[1][0] = 'S';
				}
				if (level.getEntities()[1] instanceof Ogre) {
					while (!move_valid) {
						if (game.invalidEntityMovement(level.getEntities()[1], level)) {
							level.getEntities()[1].setPosx(x_e);
							level.getEntities()[1].setPosy(y_e);
							level.getEntities()[1].movement(direction);
						} else
							move_valid = true;
					}
				} else {
					if (level.getEntities()[1] instanceof Drunken) {
						if (((Drunken) level.getEntities()[1]).getState() == StateDrunken.g) {
							level.getEntities()[1].setPosx(x_e);
							level.getEntities()[1].setPosy(y_e);
						}
					}
				}
			}

			else {
				System.out.println("Invalid movement. Try again");
				level.getEntities()[0].setPosx(x);
				level.getEntities()[0].setPosy(y);
			}

			game.getLevel().getBoard().printBoard(game);
		}

		System.out.print("You got caught! Game Over!");
		endGame=true;
		return true;
		
	}

	public boolean end() {
		return endGame;
	}
}
