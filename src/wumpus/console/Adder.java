package wumpus.console;

public class Adder {

	 public void addPit(int row,int col,SquareBox[][]board,int dimension)
	 {
		 board[row][col].hasPit = true;
	   	 
	   	 if(row >= 1)
	   		 board[row-1][col].hasBreeze = true;
	   	 if(row <= (dimension-2))
	   		 board[row+1][col].hasBreeze = true;
	   	 if(col >= 1)
	   		 board[row][col-1].hasBreeze = true;
	   	 if(col <= (dimension-2))
	   		 board[row][col+1].hasBreeze = true;
	 }
	 
	 public void addWumpus(int row,int col,SquareBox[][]board,int dimension)
	 {
		 board[row][col].hasWumpus = true;
	   	 
	   	 if(row >= 1)
	   		 board[row-1][col].hasStench = true;
	   	 if(row <= (dimension-2))
	   		 board[row+1][col].hasStench = true;
	   	 if(col >= 1)
	   		 board[row][col-1].hasStench = true;
	   	 if(col <= (dimension-2))
	   		 board[row][col+1].hasStench = true;
	 }
	 
	 public void addGold(int row,int col,SquareBox[][]board)
	 {
		 board[row][col].hasGold = true;
	 }
}
