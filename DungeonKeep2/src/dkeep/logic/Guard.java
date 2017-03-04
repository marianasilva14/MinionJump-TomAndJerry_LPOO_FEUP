package dkeep.logic;
import dkeep.cli.UserInteraction;
import dkeep.logic.Ogre.Direction;

import java.util.Random;
import java.util.Vector;

public class Guard extends Entity{

	private int posx, posy;	

	
	public enum GuardType{
		Rookie,Suspicious,Drunken
	}
	
	private GuardType guards[] = {GuardType.Drunken, GuardType.Rookie, GuardType.Suspicious};
	
	public Guard(int level){

	}
	public Guard getGuard(){
		return this;
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
	
	
	public void raffleGuard(){
		
		int pos_rand;
		Random rand = new Random();
		pos_rand = rand.nextInt(3);
		
		GuardType guard = guards[pos_rand];
		
		switch(guard) {
		case Rookie:
			posx--;
			break;
		case Suspicious:
			posx++;
			break;
		case Drunken:
			posy++;
		}
	}
}