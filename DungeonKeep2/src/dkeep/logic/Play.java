package dkeep.logic;

import java.util.Scanner;

import dkeep.cli.UserInteraction;
import dkeep.logic.Drunken.StateDrunken;
import dkeep.logic.Game.Direction;

public class Play {

	private Game game;
	private boolean endGame=false;


	public Play(Game game) {
		this.game = game;
	}

	public boolean play() {

		// while nao ganhou este nivel
		boolean alreadychange=false;

		while (!game.getLevel().checkIfEnds(game.getLevel().getEntities().get(0),game.getLevel().getEntities().get(1))) {
			if(game.changeLevel(game.getLevel().getEntities().get(0), game.getLevel())){
				if(game.getLevel().getEntities().get(1) instanceof Ogre){
					System.out.println("You won! Congratulations!");
				}
				return true;
			}
			if(!alreadychange){
				if (game.getLevel().getEntities().get(1) instanceof Ogre) {
					game.getLevel().getEntities().get(0).setSymbol('A');
					alreadychange=true;
				}
			}

			game.getLevel().getBoard().printBoard(game);
			// pedir movimento ao jogador
			// correr logica jogo

			UserInteraction user = new UserInteraction();
			Direction direction = user.readDirection();

			int x = game.getLevel().getEntities().get(0).getPosx();
			int y = game.getLevel().getEntities().get(0).getPosy();
			


			boolean move_valid = false;

			game.getLevel().getEntities().get(0).movement(direction);
			for(int i=1; i < game.getLevel().getEntities().size();i++){
				
				int x_e = game.getLevel().getEntities().get(i).getPosx();
				int y_e = game.getLevel().getEntities().get(i).getPosy();
				
				game.getLevel().getEntities().get(i).movement(direction);
		
			if (!game.invalidMovement(game.getLevel().getEntities().get(0), game.getLevel())) {

				if (game.getLevel().getLevel() == 2 && game.verifyS(game.getLevel().getEntities().get(0), game.getLevel())) {
					game.getLevel().getEntities().get(0).setPosx(x);
					game.getLevel().getEntities().get(0).setPosy(y);
					game.getLevel().getBoard().getBoard()[1][0] = 'S';
				}
				if (game.getLevel().getEntities().get(i) instanceof Ogre) {
					while (!move_valid) {
						if (game.invalidEntityMovement(game.getLevel().getEntities().get(i), game.getLevel())) {
							game.getLevel().getEntities().get(i).setPosx(x_e);
							game.getLevel().getEntities().get(i).setPosy(y_e);
							game.getLevel().getEntities().get(i).movement(direction);
						} else
							move_valid = true;
					}
				} else {
					if (game.getLevel().getEntities().get(1) instanceof Drunken) {
						if (((Drunken) game.getLevel().getEntities().get(1)).getState() == StateDrunken.g) {
							game.getLevel().getEntities().get(1).setPosx(x_e);
							game.getLevel().getEntities().get(1).setPosy(y_e);
						}
					}
				}
				if(game.getLevel().getEntities().get(i) instanceof Ogre){
					((Ogre)game.getLevel().getEntities().get(i)).club(game.getLevel().getBoard());
				}
			}
			

			else {
				System.out.println("Invalid movement. Try again");
				game.getLevel().getEntities().get(0).setPosx(x);
				game.getLevel().getEntities().get(0).setPosy(y);
			}
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
