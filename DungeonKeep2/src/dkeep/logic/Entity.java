package dkeep.logic;

import java.util.Vector;
import java.awt.Point;

public class Entity {

	public int posx, posy;
	public int level;

	Entity(int x,int y, int level){
		posx = x;
		posy = y;
		this.level=level;
	}
	
	public int getPosy(){
		return posy;
	}

	public int getPosx(){
		return posx;
	}

	public void setPosx(int posx){
		this.posx = posx;
	}

	public void setPosy(int posy){
		this.posy = posy;
	}

	public void setlevel(int level) {
		this.level = level;
	}
}