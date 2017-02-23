import java.util.Random;
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

	char[][] newBoard = {{'X','X','X','X','X','X','X','X','X','X'},
			{'I',' ',' ',' ','O',' ',' ',' ','k','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','H',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}};

	int row = 1;
	int col = 1;

	int new_row = 8;
	int new_col = 1;

	int row_guard=1;
	int col_guard=8;

	int row_ogre=1;
	int col_ogre=4;

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

	public void printNewBoard()
	{
		int row = newBoard.length;
		int col = newBoard[0].length;

		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				System.out.print(newBoard[i][j]+" ");
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

	public boolean checkOgre()
	{
		if(newBoard[new_row-1][new_col] == 'O' || newBoard[new_row+1][new_col] == 'O' || newBoard[new_row][new_col-1] == 'O'|| newBoard[new_row][new_col+1] == 'O')
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

	public void newChooseOption()
	{
		if(checkOgre()) 
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
			case 'u': newMovementUp();
			break;
			case 'd': newMovementDown();
			break;
			case 'l': newMovementLeft();
			break;
			case 'r': newMovementRight();
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
		else if(board[row_guard][col_guard+1]== 'X')
		{
			board[row_guard-1][col_guard]= 'G';
			board[row_guard][col_guard] =  ' ';
			row_guard=row_guard-1;
		}
		else if(board[row_guard+1][col_guard]== ' ' && board[row_guard+1][col_guard+1]== 'X')
		{
			board[row_guard][col_guard+1]= 'G';
			board[row_guard][col_guard] =  ' ';
			col_guard=col_guard+1;
		}
		else if(board[row_guard+1][col_guard]== ' ' && board[row_guard-1][col_guard] == ' ' && board[row_guard-1][col_guard-1] == 'X')
		{
			board[row_guard][col_guard-1]= 'G';
			board[row_guard][col_guard] =  ' ';
			col_guard=col_guard-1;
		}
	}

	public void movementOgre(){

		int pos_rand;
		Random rand = new Random();
		pos_rand = rand.nextInt((4+1) - 1) + 1;

		if(pos_rand == 1 && newBoard[row_ogre-1][col_ogre] == ' ')
		{
			newBoard[row_ogre][col_ogre] = ' ';
			if(newBoard[row_ogre-1][col_ogre] == 'k')
				newBoard[row_ogre-1][col_ogre] = '$';
			else
				newBoard[row_ogre-1][col_ogre] = 'O';
			row_ogre = row_ogre - 1;
		}
		else if(pos_rand == 2 && newBoard[row_ogre+1][col_ogre] == ' ')
		{
			newBoard[row_ogre][col_ogre] = ' ';
			if(newBoard[row_ogre+1][col_ogre] == 'k')
				newBoard[row_ogre+1][col_ogre] = '$';
			else
				newBoard[row_ogre+1][col_ogre] = 'O';
			row_ogre = row_ogre + 1;
		}
		else if(pos_rand == 3 && newBoard[row_ogre][col_ogre-1] == ' ')
		{
			newBoard[row_ogre][col_ogre] = ' ';
			if(newBoard[row_ogre][col_ogre-1] == 'k')
				newBoard[row_ogre][col_ogre-1] = '$';
			else
				newBoard[row_ogre][col_ogre-1] = 'O';
			col_ogre = col_ogre - 1;
		}
		else if(pos_rand == 4 && newBoard[row_ogre][col_ogre+1] == ' ')
		{
			newBoard[row_ogre][col_ogre] = ' ';
			if(newBoard[row_ogre][col_ogre+1] == 'k')
				newBoard[row_ogre][col_ogre+1] = '$';
			else
				newBoard[row_ogre][col_ogre+1] = 'O';
			col_ogre = col_ogre + 1;
		}
	}

	public void movementUp(){

		if(board[row-1][col] == ' ')
		{
			board[row][col]= ' ';
			board[row-1][col]='H';
			//movementGuard();
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
		else if(board[row-1][col] == 'S')
		{
			printNewBoard();
			newChooseOption();
		}
		else if(newBoard[row-1][col] == ' ')
		{
			newBoard[new_row][new_col]= ' ';
			if(newBoard[1][8] == ' ')
				newBoard[new_row-1][new_col]='K';
			else
				newBoard[new_row-1][new_col]='H';

			printNewBoard();
			new_row=new_row-1;
			chooseOption();
		}
		else if(newBoard[new_row-1][new_col] == 'k'){

			newBoard[new_row-1][new_col] = ' ';
			chooseOption();
		}
	}

	public void movementDown(){	

		if(board[row+1][col] == ' ')
		{
			board[row][col]= ' ';
			board[row+1][col]='H';
			//movementGuard();
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
		else if(board[row+1][col] == 'S')
		{
			printNewBoard();
			newChooseOption();
		}
		else if(newBoard[new_row+1][new_col] == ' ')
		{
			newBoard[new_row][new_col]= ' ';
			if(newBoard[1][8] == ' ')
				newBoard[new_row+1][new_col]='K';
			else
				newBoard[new_row+1][new_col]='H';
			printNewBoard();
			new_row=new_row+1;
			chooseOption();
		}
		else if(newBoard[new_row-1][new_col] == 'k'){

			newBoard[new_row-1][new_col] = ' ';
			chooseOption();
		}
	}

	public void movementLeft(){

		if(board[row][col-1] == ' ')
		{
			board[row][col]= ' ';
			board[row][col-1]='H';
			//movementGuard();
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
		else if(board[row][col-1] == 'S')
		{
			printNewBoard();
			newChooseOption();
		}
		else if(newBoard[new_row][new_col-1] == ' ')
		{
			newBoard[new_row][new_col]= ' ';
			if(newBoard[1][8] == ' ')
				newBoard[new_row][new_col-1]='K';
			else
				newBoard[new_row][new_col-1]='H';
			printNewBoard();
			new_col=new_col-1;
			chooseOption();
		}
		else if(newBoard[new_row-1][new_col] == 'k'){

			newBoard[new_row-1][new_col] = ' ';
			chooseOption();
		}
	}

	public void movementRight(){
		if(board[row][col+1] == ' ')
		{
			board[row][col]= ' ';
			board[row][col+1]='H';
			//movementGuard();
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
		else if(board[row][col+1] == 'S')
		{
			printNewBoard();
			newChooseOption();
		}
		else if(newBoard[new_row][new_col+1] == ' ')
		{
			newBoard[new_row][new_col]= ' ';
			if(newBoard[1][8] == ' ')
				newBoard[new_row][new_col+1]='K';
			else
				newBoard[new_row][new_col+1]='H';
			printNewBoard();
			new_col=new_col+1;
			chooseOption();
		}
		else if(newBoard[new_row-1][new_col] == 'k'){

			newBoard[new_row-1][new_col] = ' ';
			chooseOption();
		}
	}

	public void newMovementUp(){
		if(newBoard[new_row-1][new_col] == ' ')
		{
			newBoard[new_row][new_col]= ' ';
			if(newBoard[1][8] == ' ')
				newBoard[new_row-1][new_col]='K';
			else
				newBoard[new_row-1][new_col]='H';
			movementOgre();
			printNewBoard();
			new_row=new_row-1;
			newChooseOption();
		}
		else if(newBoard[new_row-1][new_col] == 'I'&& newBoard[1][8] == ' '){
			newBoard[new_row][new_col]= ' ';
			newBoard[new_row-1][new_col] = 'S';
			movementOgre();
			printNewBoard();
			System.out.println("You win! Congratulations!");
		}
		else if(newBoard[new_row-1][new_col] == 'k'){

			newBoard[new_row-1][new_col] = ' ';
			movementOgre();
			newChooseOption();
		}
		else if(newBoard[new_row-1][new_col] == 'X') 
		{
			System.out.print("Invalid movement! Try again");
			newChooseOption();
		}
	}

	public void newMovementDown(){	

		if(newBoard[new_row+1][new_col] == ' ')
		{
			newBoard[new_row][new_col]= ' ';
			if(newBoard[1][8] == ' ')
				newBoard[new_row+1][new_col]='K';
			else
				newBoard[new_row+1][new_col]='H';
			movementOgre();
			printNewBoard();
			new_row=new_row+1;
			newChooseOption();
		}
		else if(newBoard[new_row+1][new_col] == 'I'&& newBoard[1][8] == ' '){
			newBoard[new_row][new_col]= ' ';
			newBoard[new_row+1][new_col] = 'S';
			movementOgre();
			printNewBoard();
			System.out.println("You win! Congratulations!");
		}		
		else if(newBoard[new_row-1][new_col] == 'k'){

			newBoard[new_row-1][new_col] = ' ';
			movementOgre();
			newChooseOption();
		}
		else if(newBoard[new_row+1][new_col] == 'X') 
		{
			System.out.print("Invalid movement! Try again");
			newChooseOption();
		}
	}

	public void newMovementLeft(){
		if(newBoard[new_row][new_col-1] == ' ')
		{
			newBoard[new_row][new_col]= ' ';
			if(newBoard[1][8] == ' ')
				newBoard[new_row][new_col-1]='K';
			else
				newBoard[new_row][new_col-1]='H';
			movementOgre();
			printNewBoard();
			new_col=new_col-1;
			newChooseOption();
		}
		else if(newBoard[new_row][new_col-1] == 'I'&& newBoard[1][8] == ' '){
			newBoard[new_row][new_col]= ' ';
			newBoard[new_row][new_col-1] = 'S';
			movementOgre();
			printNewBoard();
			System.out.println("You win! Congratulations!");
		}
		else if(newBoard[new_row-1][new_col] == 'k'){

			newBoard[new_row-1][new_col] = ' ';
			movementOgre();
			newChooseOption();
		}
		else if(newBoard[new_row][new_col-1] == 'X') 
		{
			System.out.print("Invalid movement! Try again");
			newChooseOption();
		}
	}

	public void newMovementRight(){

		if(newBoard[new_row][new_col+1] == ' ')
		{
			newBoard[new_row][new_col]= ' ';
			if(newBoard[1][8] == ' ')
				newBoard[new_row][new_col+1]='K';
			else
				newBoard[new_row][new_col+1]='H';
			movementOgre();
			printNewBoard();
			new_col=new_col+1;
			newChooseOption();
		}
		else if(newBoard[new_row][new_col+1] == 'I'&& newBoard[1][8] == ' '){
			newBoard[new_row][new_col]= ' ';
			newBoard[new_row][new_col+1] = 'S';
			movementOgre();
			printNewBoard();
			System.out.println("You win! Congratulations!");
		}
		else if(newBoard[new_row-1][new_col] == 'k'){
			
			newBoard[new_row-1][new_col] = ' ';
			movementOgre();
			newChooseOption();
		}
		else if(newBoard[row][col+1] == 'X') 
		{
			System.out.print("Invalid movement! Try again");
			newChooseOption();
		}
	}

	public static void main(String[] args) {

		(new Board()).Play();
	}
}