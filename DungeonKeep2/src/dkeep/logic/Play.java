package dkeep.logic;

import java.util.Scanner;

import dkeep.cli.UserInteraction;
import dkeep.logic.Drunken.StateDrunken;
import dkeep.logic.Game.Direction;

public class Play{

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

			UserInteraction user = new UserInteraction();
			Direction direction = user.readDirection();

			int x = game.getLevel().getEntities().get(0).getPosx();
			int y = game.getLevel().getEntities().get(0).getPosy();

			game.getLevel().getEntities().get(0).movement(direction, game.getLevel().getBoard());
			game.cleanClub(game.getLevel().getBoard());	


			for(int i=1; i < game.getLevel().getEntities().size();i++){

				if(game.getLevel().getEntities().get(i) instanceof Ogre)
					((Ogre)game.getLevel().getEntities().get(i)).movement(direction, game.getLevel().getBoard(),(Hero)game.getLevel().getEntities().get(0));
				else
					game.getLevel().getEntities().get(i).movement(direction, game.getLevel().getBoard());

				if (game.getLevel().getLevel() == 2 && game.verifyS(game.getLevel().getEntities().get(0), game.getLevel())) {
					game.getLevel().getEntities().get(0).setPosx(x);
					game.getLevel().getEntities().get(0).setPosy(y);
					game.getLevel().getBoard().getBoard()[1][0] = 'S';
				}

				if(game.getLevel().getEntities().get(i) instanceof Ogre){
					((Ogre)game.getLevel().getEntities().get(i)).club(game.getLevel().getBoard());

				}

			}

		}
		game.getLevel().getBoard().printBoard(game);
		System.out.print("You got caught! Game Over!");
		endGame=true;
		return true;

	}

	public boolean end() {
		return endGame;
	}
}
