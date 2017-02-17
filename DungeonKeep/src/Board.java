import java.util.Scanner;

public class Board {
	
	char[][] board = {{'X','X','X','X','X','X','X','X','X','X'},
			{'X','H',' ',' ','I',' ','X',' ','G','X'},
			{'X','X','X','X','X','X','X',' ',' ','X'},
			{'X',' ','I',' ','I',' ','X',' ',' ','X'},
			{'X','X','X',' ','X','X','X',' ',' ','X'},
			{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X',' ','X','X','X','X',' ','X'},
			{'X',' ','I',' ','I',' ','X','k',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}};
	
	int row=1;
	int col=1;
	
	public void printBoard()
	{
		int row = board.length;
		int col = board[0].length;
		
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				System.out.print(board[i][j]+" ");
			}
			
			System.out.println();
		}
	}
	
	public void Play()
	{
		printBoard();
		
		System.out.println();
		System.out.println("Please insert a character.");
		System.out.println("To move down, insert 'd'");
		System.out.println("To move up, insert 'u'");
		System.out.println("To move left, insert 'l'");
		System.out.println("To move right, insert 'r'");
		
		Scanner reader = new Scanner(System.in);
		char c = reader.next().charAt(0);
		
		 switch (c) {
         case 'u': movementUp();
                  break;
         case 'd': movementDown();
                  break;
         case 'l': movementLeft();
         		break;
         case 'r': movementRight();
  					break;
         default: System.out.println("Invalid character");
                  break;
		 }
	}
	
	public void movementUp(){
		
		board[row][col]= ' ';
		board[row-1][col]='H';
		
		printBoard();
	
	}
	
	public void movementDown(){
		
		row +=1;
	}
	
	public void movementLeft(){
		
		col -=1;
	}
	
	public void movementRight(){
		col +=1;
	}
	
	
	
	public static void main(String[] args) {	
				
		(new Board()).Play();
	}

}
