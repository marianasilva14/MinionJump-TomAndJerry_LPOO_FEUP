package dkeep.logic;
import dkeep.cli.UserInteraction;
import dkeep.logic.Drunken.StateDrunken;
import dkeep.logic.Drunken;
import dkeep.logic.Ogre.Direction;

import java.util.Random;
import java.util.Vector;

public class Guard extends Entity{

	public Guard(int posx, int posy, int level) {
		super(posx, posy, level);
	}

	private int posx, posy;	
	
	public static int level = 0;
	
	
	public enum GuardType{
		Rookie,Suspicious,Drunken
	}
	
	private GuardType guards[] = {GuardType.Drunken, GuardType.Rookie, GuardType.Suspicious};
	
	public GuardType guardType = GuardType.Rookie;
	
	
	public Guard getGuard(){
		return this;
	}
	
	public GuardType getGuardType(){
		return guardType;
	}
	
	public void setGuardType(GuardType g) {
		this.guardType = g;
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
	
	/*
	public void raffleGuard(){
		
		int pos_rand=0;
		
		Guard g;
		if(pos_rand == 0)
		g = new Rookie(level);
		
		Random rand = new Random();
		pos_rand = rand.nextInt(3);
		
		GuardType guard = guards[pos_rand];
		
		
		switch(guard) {
		case Rookie:
			g.movement(g);
			break;
		case Suspicious:
			g.movement(g);
			break;
		case Drunken:
			g.movement(g);
			break;
		}
	}
	*/
}