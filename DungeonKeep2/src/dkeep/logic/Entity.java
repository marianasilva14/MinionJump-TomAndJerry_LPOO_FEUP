package dkeep.logic;

import java.util.Vector;
import java.awt.Point;

public class Entity {

	public Point p;
	public int level;

	Entity(int posx,int posy, int level){
		p = new Point(posx,posy);
		this.level=level;
	}
	
	public Point getP() {
		return p;
	}
	
	public void setP(Point p) {
		this.p = p;
	}

	public void setlevel(int level) {
		this.level = level;
	}
}