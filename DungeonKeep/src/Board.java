import java.util.Scanner;

public class Board {

	char[][] board = {{'X','X','X','X','X','X','X','X','X','X'},
			{'X','H',' ',' ','I',' ','X',' ','G','X'},
			{'X','X','X',' ','X','X','X',' ',' ','X'},
			{'X',' ','I',' ','I',' ','X',' ',' ','X'},
			{'X','X','X',' ','X','X','X',' ',' ','X'},
			{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X',' ','X','X','X','X',' ','X'},
			{'X',' ','I',' ','I',' ','X','k',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}};

	int row = 1;
	int col = 1;
	
	int row_guard=1;
	int col_guard=8;

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

	public boolean checkGuard()
	{
		if(board[row-1][col] == 'G' || board[row+1][col] == 'G' || board[row][col-1] == 'G'|| board[row][col+1] == 'G')
			return true;

		return false;
	}
	
	public void checkLever(){
		int row_aux = board.length;
		int col_aux = board[0].length;

		for(int i = 0; i < row_aux; i++)
		{
			for(int j = 0; j < col_aux; j++)
			{
				if(board[i][j] == 'I')
					board[i][j] = 'S';
			}
		}

		printBoard();

	}


	public void chooseOption()
	{
		if(checkGuard()) 
			System.out.print("You got caught! Game Over!");
		else{
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
	}

	public void Play()
	{
		printBoard();
		chooseOption();
	}
	
	public void movementGuard(){
		if(board[row_guard-1][col_guard]== 'X' && board[row_guard][col_guard+1]== 'X')
		{
			board[row_guard][col_guard-1]= 'G';
			board[row_guard][col_guard] =  ' ';
			col_guard=col_guard-1;
		}
		
		else if(board[row_guard][col_guard-1]== 'X')
		{
			board[row_guard+1][col_guard]= 'G';
			board[row_guard][col_guard] =  ' ';
			row_guard=row_guard+1;
		}	
		else if(board[row_guard+1][col_guard]== ' ' && board[row_guard][col_guard+2] == 'X')
		{
			board[row_guard][col_guard-1]= 'G';
			board[row_guard][col_guard] =  ' ';
			col_guard=col_guard-1;
		}
		else if(board[row_guard-1][col_guard]== ' ' && board[row_guard-1][col_guard+1] == 'X')
		{
			board[row_guard][col_guard-1]= 'G';
			board[row_guard][col_guard] =  ' ';
			col_guard=col_guard-1;
		}
		else if(board[row_guard][col_guard-1]== ' ' && board[row_guard-1][col_guard] == 'X')
		{
			board[row_guard][col_guard-1]= 'G';
			board[row_guard][col_guard] =  ' ';
			col_guard=col_guard-1;
		}
		
		else if(board[row_guard-1][col_guard]== 'X' && board[row_guard][col_guard-1]== 'I')
		{
			board[row_guard+1][col_guard]= 'G';
			board[row_guard][col_guard] =  ' ';
			row_guard=row_guard+1;
		}
		
		else if(board[row_guard-1][col_guard]== ' ' && board[row_guard+1][col_guard]== 'X')
		{
			board[row_guard][col_guard+1]= 'G';
			board[row_guard][col_guard] =  ' ';
			col_guard=col_guard+1;
		}
		else if(board[row_guard+1][col_guard]== ' ' && board[row_guard+1][col_guard+1]== 'X')
		{
			board[row_guard][col_guard+1]= 'G';
			board[row_guard][col_guard] =  ' ';
			col_guard=col_guard+1;
		}
		
		else if(board[row_guard][col_guard+1]== 'X')
		{
			board[row_guard-1][col_guard]= 'G';
			board[row_guard][col_guard] =  ' ';
			row_guard=row_guard-1;
		}
	}

	public void movementUp(){

		if(board[row-1][col] == ' ')
		{
			board[row][col]= ' ';
			board[row-1][col]='H';
			movementGuard();
			printBoard();
			row=row-1;
			chooseOption();
		}
		else if(board[row-1][col] == 'k'){
			checkLever();
			System.out.print("You managed to open the doors!");
			chooseOption();
		}
		else if(board[row-1][col] == 'X'|| board[row-1][col] == 'I') 
		{
			System.out.print("Invalid movement! Try again");
			chooseOption();
		}


	}

	public void movementDown(){	
	
		if(board[row+1][col] == ' ')
		{
			board[row][col]= ' ';
			board[row+1][col]='H';
			movementGuard();
			printBoard();
			row=row+1;
			chooseOption();
		}
		else if(board[row+1][col] == 'k'){
			checkLever();
			System.out.print("You managed to open the doors!");
			chooseOption();
		}
		else if(board[row+1][col] == 'X'|| board[row+1][col] == 'I') 
		{
			System.out.print("Invalid movement! Try again");
			chooseOption();
		}


	}

	public void movementLeft(){

		if(board[row][col-1] == ' ')
		{
			board[row][col]= ' ';
			board[row][col-1]='H';
			movementGuard();
			printBoard();
			col=col-1;
			chooseOption();
		}

		else if(board[row][col-1] == 'k'){
			checkLever();
			System.out.print("You managed to open the doors!");
			chooseOption();
		}
		else if(board[row][col-1] == 'X'|| board[row][col-1] == 'I') 
		{
			System.out.print("Invalid movement! Try again");
			chooseOption();
		}

	}

	public void movementRight(){
		if(board[row][col+1] == ' ')
		{
			board[row][col]= ' ';
			board[row][col+1]='H';
			movementGuard();
			printBoard();
			col=col+1;
			chooseOption();
		}

		else if(board[row][col+1] == 'k'){
			checkLever();
			System.out.print("You managed to open the doors!");
			chooseOption();
		}
		else if(board[row][col+1] == 'X'|| board[row][col+1] == 'I') 
		{
			System.out.print("Invalid movement! Try again");
			chooseOption();
		}
	}

	public static void main(String[] args) {	

		(new Board()).Play();
	}

}
