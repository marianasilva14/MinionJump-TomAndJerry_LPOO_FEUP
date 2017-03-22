package dkeep.logic;

import java.util.ArrayList;

import dkeep.logic.Drunken.StateDrunken;

public class Level {

	private Board board;
	private int level;
	private ArrayList<Entity> entities;


	public Level(Board b, ArrayList<Entity> entities, int l){
		this.board=b;
		this.level=l;
		this.entities=entities;

	}

	public Level(Board b, int guard){
		entities = new ArrayList<Entity>();
		board=b;

		int row= b.getBoard().length;
		int col= b.getBoard()[0].length;

		for(int i=0; i < row; i++){
			for(int j=0; j < col; j++){
				if(b.getBoard()[i][j] == 'H'){
					Entity entity_hero= new Hero(i,j);
					entities.add(entity_hero);
					b.getBoard()[i][j]= ' ';
				}
				else if(b.getBoard()[i][j] == 'G'){
					level=1;
					Entity entity_guard=  Guard.raffleGuard(guard,i,j);
					entities.add(entity_guard);
					b.getBoard()[i][j]= ' ';
				}
				else if(b.getBoard()[i][j] == 'O'){
					level=2;
					Entity entity_ogre= new Ogre(i,j);
					entities.add(entity_ogre);
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

	public ArrayList<Entity> getEntities(){
		return entities;
	}

	public boolean checkIfEnds(Entity hero, Entity capture){

		if(board.checkLimits(hero)){
		if(capture instanceof Drunken){
			if(((Drunken)capture).getState() == StateDrunken.g)
				return false;
		}

		else if(capture instanceof Ogre){
		
			if((board.getBoard()[hero.getPosx()-1][hero.getPosy()] == '*') || (board.getBoard()[hero.getPosx()+1][hero.getPosy()] == '*') || (board.getBoard()[hero.getPosx()][hero.getPosy()-1] == '*') || (board.getBoard()[hero.getPosx()][hero.getPosy()+1] == '*'))
				return true;
			else if((hero.getPosx()-1 == capture.getPosx() && hero.getPosy()== capture.getPosy()) 
					|| (hero.getPosx()+1 == capture.getPosx() && hero.getPosy()== capture.getPosy()) 
					|| (hero.getPosx() == capture.getPosx() && hero.getPosy()-1 == capture.getPosy()) 
					|| (hero.getPosx() == capture.getPosx() && hero.getPosy()+1 == capture.getPosy()))
				return false;
			
			return false;
		}

		if((hero.getPosx()-1 == capture.getPosx() && hero.getPosy()== capture.getPosy()) || 
				(hero.getPosx()+1 == capture.getPosx() && hero.getPosy()== capture.getPosy()) || 
				(hero.getPosx() == capture.getPosx() && hero.getPosy()-1 == capture.getPosy()) || 
				(hero.getPosx() == capture.getPosx() && hero.getPosy()+1 == capture.getPosy()))
			return true;
		}
		return false;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities=entities;
	}


}
