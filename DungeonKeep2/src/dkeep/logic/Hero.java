package dkeep.logic;

import dkeep.cli.UserInteraction.Direction;

public class Hero extends Entity{

	public Hero(int posx, int posy, int level) {
		super(posx, posy, level);

		if(level == 0){
			posx=1;
			posy=1;
		}
		else{
			posx=1;
			posy=9;
		}
	}

	public enum StateHero{
		ARMED,DISARMED
	}

	public StateHero state = StateHero.DISARMED;

	public StateHero getState() {
		return state;
	}
	
	public void setState(StateHero state) {
		this.state = state;
	}

	public void move(Direction direction){
		switch(direction) {
		case UP:
			posx--;
			break;
		case DOWN:
			posx++;
			break;
		case RIGHT:
			posy++;
			break;
		case LEFT:
			posy--;
		}
	}
}