package dkeep.logic;

public class Game {

	private Level[] levels;
	
	public Game(Level[] lvs){
		levels=lvs;
	}
	
	
	public boolean invalidMovement(Entity e, Level lv){

		if(e.getPosx() <0 || e.getPosy()<0)
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
		if(lv.getBoard().getBoard()[e.getPosx()][e.getPosy()] == 'X' || lv.getBoard().getBoard()[e.getPosx()][e.getPosy()] == 'I'){
			return true;
		}
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
}
