package dkeep.logic;

import dkeep.logic.Drunken.StateDrunken;

public class Level {

	private Board board;
	private int level;
	private Entity[] entities;


	public Level(Board b, Entity[] entities, int l){
		this.board=b;
		this.level=l;
		this.entities=entities;

	}
	
	public Level(Board b){
		entities = new Entity[2];
		board=b;

		int row= b.getBoard().length;
		int col= b.getBoard()[0].length;
		
		for(int i=0; i < row; i++){
			for(int j=0; j < col; j++){
				if(b.getBoard()[i][j] == 'H'){
					entities[0]= new Hero(i,j);
					b.getBoard()[i][j]= ' ';
				}
				else if(b.getBoard()[i][j] == 'G'){
					level=1;
					entities[1]= Guard.raffleGuard(i,j);
					b.getBoard()[i][j]= ' ';
				}
				else if(b.getBoard()[i][j] == 'O'){
					level=2;
					entities[1]=new Ogre(i,j);
					b.getBoard()[i][j]= ' ';
				}
				
			}
		}
	}


	public Board getBoard(){
		return board;
	}

	public int getLevel(){
		return level;
	}

	public void setLevel(int lv){
		this.level=lv;
	}
	public void setBoard(Board board) {
		this.board = board;
	}

	public Entity[] getEntities(){
		return entities;
	}

	public boolean checkIfEnds(Entity hero, Entity capture){

		if(capture instanceof Drunken){
			if(((Drunken)capture).getState() == StateDrunken.g)
				return false;
		}
		else{
			if((hero.getPosx()-1 == capture.getPosx() && hero.getPosy()== capture.getPosy()) || (hero.getPosx()+1 == capture.getPosx() && hero.getPosy()== capture.getPosy()) || (hero.getPosx() == capture.getPosx() && hero.getPosy()-1 == capture.getPosy()) || (hero.getPosx() == capture.getPosx() && hero.getPosy()+1 == capture.getPosy()))
				return true;
		}
		return false;
	}

	public void setEntities(Entity[] entities) {
		this.entities=entities;
		
	}

	
}
