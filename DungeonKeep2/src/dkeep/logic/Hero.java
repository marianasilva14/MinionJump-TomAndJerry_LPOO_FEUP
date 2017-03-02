package dkeep.logic;
//import dkeep.logic.Entity;

import dkeep.cli.UserInteraction.Direction;

public class Hero extends Entity{
	
	private int posx, posy;
	
	public Hero(int level){
		if(level == 0){
			posx=1;
			posy=1;
		}
		
		else{
			posx=1;
			posy=8;
		}
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
	/*
	public void movementUp(int level){

		int row,col;		
		row = getPosy();
		col = getPosx();

		if(board[0][row-1][col] == ' ')
		{
			board[0][row][col]= ' ';
			board[0][row-1][col]='H';
			row=row-1;
			h.setPosy(row);
		}
	}

	public void movementDown(int level){
		int row,col;		
		row = getPosy();
		col = getPosx();

		if(board[0][row+1][col] == ' ')
		{
			board[0][row][col]= ' ';
			board[0][row+1][col]='H';
			row=row+1;
			h.setPosy(row);
		}
	}

	public void movementRight(int level){

		int row,col;

		row = getPosy();
		col = getPosx();

		if(board[0][row][col+1] == ' ')
		{
			board[0][row][col]= ' ';
			board[0][row][col+1]='H';
			col=col+1;
			h.setPosx(col);
		}	
	}

	public void movementLeft(int level){
		int row,col;

		row = h.getPosy();
		col = h.getPosx();

		if(board[0][row][col-1] == ' ')
		{
			board[0][row][col]= ' ';
			board[0][row][col-1]='H';
			col=col-1;
			h.setPosx(col);
		}	
	}*/
}