
public class Board {
	
	char[][] board = {{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'}};
	
	public void Play()
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
	
	public static void main(String[] args) {	
				
		(new Board()).Play();
	}

}
