package dkeep.logic;
import dkeep.logic.Game.Direction;
import dkeep.logic.Drunken.StateDrunken;
import dkeep.logic.Drunken;

import java.util.Random;
import java.util.Vector;

public class Guard extends Entity{

	private char symbol;
	
	public Guard(int posx, int posy) {
		super(posx, posy);
		symbol='G';
	}
	
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
	
	public char getSymbol(){
		return symbol;
	}
	
	public void setSymbol(char symbol){
		this.symbol=symbol;
	}
	
	public void movement(Direction direction, Board b){
		
	}
	
	public static Guard raffleGuard(int button, int posx, int posy){
	
		Guard g;
		
		switch(button) {
		case 0:
			g = new Suspicious(posx,posy);
			break;
		case 1:
			g = new Drunken(posx,posy);
			break;
		case 2:
			g = new Rookie(posx,posy);
			break;
		default:
			g = new Rookie(posx,posy);
		break;
		}
		
		return g;
	}
	
}