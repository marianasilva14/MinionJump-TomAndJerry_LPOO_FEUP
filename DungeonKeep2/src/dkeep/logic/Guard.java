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
	
	public static int level = 0;
	
	
	public enum GuardType{
		Rookie,Suspicious,Drunken
	}
		
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
	
	public void movement(){
		
	}
	
	public static Guard raffleGuard(int posx, int posy, int level){
		
		Guard g;
		int pos_rand=0;
		Random rand = new Random();
		pos_rand = rand.nextInt(3);
		
		switch(pos_rand) {
		case 0:
			g = new Rookie(posx,posy,level);
			break;
		case 1:
			g = new Suspicious(posx,posy,level);
			break;
		case 2:
			g = new Drunken(posx,posy,level);
			break;
		default:
			g = new Rookie(posx,posy,level);
		break;
		}
		
		return g;
	}
	
}