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
	
	public Board getBoard(){
		return board;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setLevel(int lv){
		this.level=lv;
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
	
}
