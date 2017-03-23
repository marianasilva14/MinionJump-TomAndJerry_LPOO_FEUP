package dkeep.logic;
import dkeep.logic.Game.Direction;
import dkeep.logic.Drunken;

/**
 * 
 * Guard.java - A subclass of Entity
 *
 */
public class Guard extends Entity{

	private int index = 0;
	private int move = 1;
	
	protected Direction directions[] = {Direction.LEFT, Direction.DOWN, Direction.DOWN, Direction.DOWN, Direction.DOWN, 
			Direction.LEFT,Direction.LEFT, Direction.LEFT,Direction.LEFT, Direction.LEFT, Direction.LEFT, Direction.DOWN,
			Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT,Direction.RIGHT, 
			Direction.RIGHT, Direction.UP,  Direction.UP, Direction.UP, Direction.UP, Direction.UP};
	
	private char symbol;
	
	/**
	 * Constructor of this class and initialize the symbol that represents the Guard
	 * @param posx represents the coordinate x of the position of the Guard
	 * @param posy represents the coordinate y of the position of the Guard
	 *
	 */
	public Guard(int posx, int posy) {
		super(posx, posy);
		symbol='G';
	}
	
	public enum GuardType{
		Rookie,Suspicious,Drunken
	}
		
	public GuardType guardType = GuardType.Rookie;
	
	/*
	public Guard getGuard(){
		return this;
	}
	*/
	
	/**
	 * Method that returns guard's type: Drunken, Suspicious or Drunken
	 * @return guardType
	 */
	public GuardType getGuardType(){
		return guardType;
	}
	
	/**
	 * Method that sets guard's type
	 * @param guardType
	 */
	public void setGuardType(GuardType g) {
		this.guardType = g;
	}
	
	/**
	 * @return symbol of the guard
	 */
	public char getSymbol(){
		return symbol;
	}
	
	/**
	 * Method that sets guard's symbol
	 * @param guardType
	 */
	public void setSymbol(char symbol){
		this.symbol=symbol;
	}
	
	/**
	 * Method responsible to move guard
	 * @param
	 * @param
	 */
	public void movement(Direction direction, Board b){
		
	}
	
	/**
	 * Method that chooses type of guard
	 * @param button
	 * @param posx
	 * @param posy
	 * @return guard's type
	 */
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