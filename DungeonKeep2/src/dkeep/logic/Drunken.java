package dkeep.logic;

import java.util.Random;
import dkeep.logic.Game.Direction;

/**
 * 
 * Drunken.java - A Subclass of Guard
 *
 */
public class Drunken extends Guard{

	private int index;
	private int move = 1;

	/**
	 * Constructor of this class and initializes index of this type of guard
	 * @param posx
	 * @param posy
	 */
	public Drunken(int posx,int posy) {
		super(posx,posy);
		index = 0;
	}

	public enum StateDrunken{
		G,g;
	}

	private StateDrunken status[] ={StateDrunken.G,StateDrunken.g};

	public StateDrunken state = StateDrunken.G;

	/**
	 * @return state of this guard
	 */
	public StateDrunken getState() {
		return state;
	}

	/**
	 * Methods that sets the state of the Drunken
	 * @param state of the Drunken
	 */
	public void setStateDrunken(StateDrunken st) {
		this.state = st;
	}

	/**
	 * Methods responsible to define the type of the movement's drunken
	 * @param direction
	 * @param board
	 */
	public void movement(Direction direction, Board b){

		int status_rand;
		Random rand2 = new Random();
		status_rand = rand2.nextInt(2);
		StateDrunken st = status[status_rand];

		setStateDrunken(st);
		
		randDirection(direction);
		
		if(st == StateDrunken.G){
			setSymbol('G');
			movementGuard(direction);
		}
	}

}