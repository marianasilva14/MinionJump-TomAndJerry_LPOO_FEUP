package dkeep.logic;

import dkeep.cli.UserInteraction;

public class Game {

	public UserInteraction cli;
	public Level level;

	public enum Direction{
		RIGHT,LEFT,UP,DOWN
	}

	public Game(Level level){
		this.level=level;
	}

	public boolean invalidMovement(Entity e, Level lv){

		if(e.getPosx() < 0 || e.getPosy()< 0 || e.getPosx() >= lv.getBoard().getBoard().length || e.getPosy() >= lv.getBoard().getBoard()[0].length)
			return true;

		if(lv.getLevel()==1){
			if(lv.getBoard().getBoard()[e.getPosx()][e.getPosy()] == 'X' || lv.getBoard().getBoard()[e.getPosx()][e.getPosy()] == 'I')
				return true;
			else
				return false;
		}
		else{
			if(lv.getBoard().getBoard()[e.getPosx()][e.getPosy()] == 'X')
				return true;
			else
				return false;
		}
	}


	public boolean verifyS(Entity e, Level lv){
		if(lv.getBoard().getBoard()[e.getPosx()][e.getPosy()] == 'I')
			return true;
		else
			return false;
	}

	public boolean invalidEntityMovement(Entity e, Level lv){

		if(lv.getBoard().getBoard()[e.getPosx()][e.getPosy()] == 'X' || lv.getBoard().getBoard()[e.getPosx()][e.getPosy()] == 'I')
			return true;
		else
			return false;
	}

	public void checkLever(Entity e, Level lv){

		if(lv.getBoard().getBoard()[e.getPosx()][e.getPosy()] == 'k')
		{
			e.setSymbol('K');
			int row_aux = lv.getBoard().getBoard().length;
			int col_aux = lv.getBoard().getBoard()[0].length;

			for(int i = 0; i < row_aux; i++)
			{
				for(int j = 0; j < col_aux; j++)
				{
					if(lv.getBoard().getBoard()[i][j] == 'I')
						lv.getBoard().getBoard()[i][j] = 'S';
				}
			}
		}	


	}
	
	public boolean changeLevel(Entity e, Level lv){

		if(lv.getBoard().getBoard()[e.getPosx()][e.getPosy()] == 'S')
			return true;
		else
			return false;

	}

	public boolean entityLever(Entity e, Level lv){

		if(lv.getBoard().getBoard()[e.getPosx()][e.getPosy()] == 'k'){
			if(e instanceof Ogre){
				if(!((Ogre) e).getKey()){
					e.setSymbol('$');
					((Ogre) e).setKey(true);
				}
				else
					e.setSymbol('O');
			}
			else if(e instanceof Hero)
				e.setSymbol('K');
			return true;
		}
		
		else if(e instanceof Ogre){
			if(((Ogre) e).getKey())
			e.setSymbol('O');
		}
		
		return false;
	}

	public void cleanClub(Board b){
		
		int row= b.getBoard().length;
		int col= b.getBoard()[0].length;
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(b.getBoard()[i][j] == '*')
					b.getBoard()[i][j]=' ';
			}
		}
	}

	public Level getLevel() {
		return level;
	}
}
