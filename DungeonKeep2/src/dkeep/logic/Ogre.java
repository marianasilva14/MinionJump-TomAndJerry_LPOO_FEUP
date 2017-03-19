package dkeep.logic;
import dkeep.logic.Entity;
import dkeep.logic.Game.Direction;
import java.util.Random;


public class Ogre extends Entity{

	private char symbol;
	private int[] pos_club = {1,1};
	private boolean key=false;
	private int nrOfMoves=-1;

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
	
	public int getNrOfMoves(){
		return nrOfMoves;
	}
	
	public void setNrOfMoves(int nr){
		nrOfMoves=nr;
	}

	public void movement(Direction direction, Board b, Hero hero){

		int pos_rand = boardLimits(b);
		boolean invalid=false;
		
		if(nrOfMoves ==2){
			symbol='O';
			nrOfMoves=-1;
		}
		if(nrOfMoves >-1)
			nrOfMoves++;

		if(!checkIfMovementIsValid(direction,b))
			invalid=true;

		if(verifyI(direction, b))
			invalid=true;
		
		if(ogreNextToTheHero(direction,b,hero)){
			symbol='8';
			nrOfMoves++;
		}

		if(nrOfMoves == -1){
		if(!invalid){

			switch(pos_rand) {
			case 0:
				posy++;
				break;
			case 1:
				posy--;
				break;
			case 2:
				posx--;
				break;
			case 3:
				posx++;
				break;

			}
		}
		}
	}
	
	public boolean ogreNextToTheHero(Direction direction, Board b, Hero hero){
		if( (posx-1 == hero.getPosx() && posy == hero.getPosy()) || 
				(posx+1 == hero.getPosx() && posy == hero.getPosy()) ||
				(posx == hero.getPosx() && posy+1 == hero.getPosy()) ||
				(posx == hero.getPosx() && posy-1== hero.getPosy()))
			return true;
		else
			return false;
	}

	public boolean verifyI(Direction direction, Board b){

		switch(direction) {
		case UP:{
			if(b.getBoard()[posx-1][posy] == 'I')
				return true;
			else
				return false;
		}
		case DOWN:{
			if(b.getBoard()[posx+1][posy] == 'I')
				return true;
			else
				return false;
		}
		case RIGHT:{
			if(b.getBoard()[posx][posy+1] == 'I')
				return true;
			else
				return false;
		}
		case LEFT:{
			if(b.getBoard()[posx][posy-1] == 'I')
				return true;
			else
				return false;
		}
		}
		return true;

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
							pos_club[0]=posx;
							pos_club[1]=posy+1;
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
						pos_club[0]=posx+1;
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
						pos_club[0]=posx;
						pos_club[1]=posy-1;
						return;
					}
					else if(b.getBoard()[posx][posy-1] != 'A' && b.getBoard()[posx][posy-1] != ' ')
						break;
					else{
						b.getBoard()[posx][posy-1]= '*';
						pos_club[0]=posx;
						pos_club[1]=posy-1;
						return;
					}
				}
				}
			}
		}


		public void movement(Direction direction, Board b) {
			
		}


	}

