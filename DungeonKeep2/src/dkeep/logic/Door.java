package dkeep.logic;

public class Door {
	
	int posx;
	int posy;

	public Door(int posx, int posy) {
		this.posx = posx;
		this.posy = posy;
	}
	
	boolean found = false;
	
	public boolean getFound(){
		return found;
	}
	
	public void setFound(boolean door){
		this.found=door;
	}

}
