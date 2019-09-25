package wumpus.console;

public class Board {

	
	public void printWumpusBoard(int row,int col,SquareBox [][] board,int order)
	{
		//System.out.println("ok asen print korai\n");
		for(int i=0; i<order; i++) {
	   		 for(int j=0; j<order; j++) {
	   			 char displayChar = '-';
	   			 if(row == i && col == j)
	   				 displayChar = '*';
	   			 else if(board[i][j].hasPit)
	   				 displayChar = 'O';
	   			 else if(board[i][j].hasWumpus)
	   				 displayChar = 'X';
	   			 else if(board[i][j].hasGold)
	   				 displayChar = 'G';
	   			 
	   			 System.out.print(displayChar + "\t");
	   		 }
	   		 System.out.println();
	}
}
}
