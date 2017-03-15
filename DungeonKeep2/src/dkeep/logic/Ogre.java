package dkeep.logic;
import dkeep.logic.Entity;
import dkeep.logic.Game.Direction;

import java.util.Random;


public class Ogre extends Entity{

	private char symbol;
	private int[] pos_club = {1,1};
	private boolean key=false;

	public Ogre(int posx, int posy) {
		super(posx, posy);
		symbol = 'O';
	}

	private Direction directions[] = {Direction.RIGHT, Direction.LEFT, Direction.UP, Direction.DOWN};

	public Ogre getOgre(){
		return this;
	}


	public char getSymbol(){
		return symbol;
	}

	public void setSymbol(char symbol){
		this.symbol=symbol;
	}

	public boolean getKey(){
		return key;
	}

	public void setKey(boolean b){
		key=b;
	}

	public void movement(Direction direction){

		int pos_rand;
		Random rand = new Random();
		pos_rand = rand.nextInt(4);

		if(direction == null)
			direction = directions[pos_rand];

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
			break;
		}

	}

	public void club(Board b){

		while(true){

			int pos_rand;
			Random rand = new Random();
			pos_rand = rand.nextInt(4);
			switch(pos_rand) {
			case 0:{
				if(posx-1 < 0 || posx-1 > 9)
					break;
				else if(b.getBoard()[posx-1][posy] != 'A' && b.getBoard()[posx-1][posy] != ' ')
					break;
				else{
					b.getBoard()[pos_club[0]][pos_club[1]]=' ';
					b.getBoard()[posx-1][posy]= '*';
					pos_club[0]=posx-1;
					pos_club[1]=posy;
					return;
				}
			}
			case 1:{
				if(posy+1 <0 || posy+1 >9)
					break;
				else if(b.getBoard()[posx][posy+1] != 'A' && b.getBoard()[posx][posy+1] != ' ')
					break;
				else{
					b.getBoard()[pos_club[0]][pos_club[1]]=' ';
					b.getBoard()[posx][posy+1]= '*';
					pos_club[0]=posx;
					pos_club[1]=posy+1;
					return;
				}
			}
			case 2:{
				if(posx+1<0 || posx+1 >9)
					break;
				else if(b.getBoard()[posx+1][posy] != 'A' && b.getBoard()[posx+1][posy] != ' ')
					break;
				else{
					b.getBoard()[pos_club[0]][pos_club[1]]=' ';
					b.getBoard()[posx+1][posy]= '*';
					pos_club[0]=posx+1;
					pos_club[1]=posy;
					return;
				}
			}
			case 3:{
				if(posy-1<0 || posy-1>9)
					break;
				else if(b.getBoard()[posx][posy-1] != 'A' && b.getBoard()[posx][posy-1] != ' ')
					break;
				else{
					b.getBoard()[pos_club[0]][pos_club[1]]=' ';
					b.getBoard()[posx][posy-1]= '*';
					pos_club[0]=posx;
					pos_club[1]=posy-1;
					return;
				}
			}
			}
		}
	}


}

