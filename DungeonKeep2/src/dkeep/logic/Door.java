package dkeep.logic;

public class Door extends Entity{

	Door(int posx, int posy, int level) {
		super(posx, posy, level);
	}
	
	boolean found = false;
	
	public boolean getFound(){
		return found;
	}
	
	public void setFound(boolean door){
		this.found=door;
	}

}
