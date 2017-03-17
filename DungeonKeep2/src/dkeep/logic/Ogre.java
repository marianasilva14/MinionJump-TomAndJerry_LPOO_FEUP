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

	public void movement(Direction direction, Board b){
		
		int pos_rand = boardLimits(b);
		boolean invalid=false;
		
		if(!checkIfMovementIsValid(direction,b))
			invalid=true;
		
		switch(pos_rand) {
		case 0:
			if(!invalid)
			posy++;
			break;
		case 1:
			if(!invalid)
			posy--;
			break;
		case 2:
			if(!invalid)
			posx--;
			break;
		case 3:
			if(!invalid)
			posx++;
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
				if (b.getBoard()[posx-1][posy] == 'X' ||  b.getBoard()[posx-1][posy] == 'I')
					break;
				else if(b.getBoard()[posx-1][posy] == 'k')
				{
					pos_club[0]=posx-1;
					pos_club[1]=posy;
					return;
				}
				else if(b.getBoard()[posx-1][posy] != 'A' && b.getBoard()[posx-1][posy] != ' ')
					break;
				else{
					b.getBoard()[posx-1][posy]= '*';
					pos_club[0]=posx-1;
					pos_club[1]=posy;
					return;
				}
			}
			case 1:{
				if(b.getBoard()[posx][posy+1] == 'X' || b.getBoard()[posx][posy+1] == 'I')
					break;
				else if( b.getBoard()[posx][posy+1] == 'k'){
					{
						pos_club[0]=posx-1;
						pos_club[1]=posy;
						return;
					}
				}
				else if(b.getBoard()[posx][posy+1] != 'A' && b.getBoard()[posx][posy+1] != ' ')
					break;
				else{
					b.getBoard()[posx][posy+1]= '*';
					pos_club[0]=posx;
					pos_club[1]=posy+1;
					return;
				}
			}
			case 2:{
				if(b.getBoard()[posx+1][posy] == 'X'|| b.getBoard()[posx+1][posy] == 'I')
					break;
				else if(b.getBoard()[posx+1][posy] == 'k'){
					pos_club[0]=posx-1;
					pos_club[1]=posy;
					return;
				}
				else if(b.getBoard()[posx+1][posy] != 'A' && b.getBoard()[posx+1][posy] != ' ')
					break;
				else{
					b.getBoard()[posx+1][posy]= '*';
					pos_club[0]=posx+1;
					pos_club[1]=posy;
					return;
				}
			}
			case 3:{
				if( b.getBoard()[posx][posy-1] == 'X' || b.getBoard()[posx][posy-1] == 'I')
					break;
				else if(b.getBoard()[posx][posy-1] == 'k'){
					pos_club[0]=posx-1;
					pos_club[1]=posy;
					return;
				}
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

