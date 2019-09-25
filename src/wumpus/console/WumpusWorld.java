package wumpus.console;
import java.util.Scanner;

public class WumpusWorld {
     static SquareBox[][] board;
     static int dimension=10;
	
    public void exploreWorld () 
    {
    	Scanner input = new Scanner(System.in);
	   	Adder adder = new Adder();
	   	Board pb = new Board();
	   	board = new SquareBox[dimension][dimension];
     	 
	   	 for(int i=0;i<dimension;i++)
	   	 {
	   		 for(int j=0;j<dimension;j++)
	   		 {
	   			 board[i][j]=new SquareBox();
	   		 }
	   	 } 
	   	 
	   	 System.out.print("\nEnter the number of pits: ");
	   	 
	   	 
	   		 
	   	 adder.addPit(dimension-6, 4-1,board,dimension);
	   	 adder.addPit(dimension-3, 6-1,board,dimension);
	   	 adder.addPit(dimension-8, 5-1,board,dimension);
	   	 
	   	 adder.addWumpus(dimension-4, 7-1,board,dimension);
	   	 adder.addGold(dimension-2, 8-1,board);
	   	 
	   	 int startingRowLocation = 0;
	   	 int startingColLocation = 0;
	   	 int startingRowPrevious = -1, startingColPrevious = -1;
	   	 
	   	 int moves = 0;
	   	 System.out.println("\nInitial state:");
	
	   	 pb.printWumpusBoard(startingRowLocation,startingColLocation,board,dimension);   //Print the wumpus board
	   	 
	   	 while(!board[startingRowLocation][startingColLocation].hasGold) {
	   		 board[startingRowLocation][startingColLocation].isExplored = true;
	   		 board[startingRowLocation][startingColLocation].pitStatus = SquareBox.NOT_PRESENT;
	   		 board[startingRowLocation][startingColLocation].wumpusStatus = SquareBox.NOT_PRESENT;
	   		 
	   		 if(!board[startingRowLocation][startingColLocation].hasBreeze) {
	   			 if(startingRowLocation >= 1 && board[startingRowLocation-1][startingColLocation].pitStatus == SquareBox.UNSURE)
	   				 board[startingRowLocation-1][startingColLocation].pitStatus = SquareBox.NOT_PRESENT;
	   			 if(startingRowLocation <= (dimension-2) && board[startingRowLocation+1][startingColLocation].pitStatus == SquareBox.UNSURE)
	   				 board[startingRowLocation+1][startingColLocation].pitStatus = SquareBox.NOT_PRESENT;
	   			 if(startingColLocation >= 1 && board[startingRowLocation][startingColLocation-1].pitStatus == SquareBox.UNSURE)
	   				 board[startingRowLocation][startingColLocation-1].pitStatus = SquareBox.NOT_PRESENT;
	   			 if(startingColLocation <= (dimension-2) && board[startingRowLocation][startingColLocation+1].pitStatus == SquareBox.UNSURE)
	   				 board[startingRowLocation][startingColLocation+1].pitStatus = SquareBox.NOT_PRESENT;
	   		 }
	   		 
	   		 if(!board[startingRowLocation][startingColLocation].hasStench) {
	   			 if(startingRowLocation >= 1 && board[startingRowLocation-1][startingColLocation].wumpusStatus == SquareBox.UNSURE)
	   				 board[startingRowLocation-1][startingColLocation].wumpusStatus = SquareBox.NOT_PRESENT;
	   			 if(startingRowLocation <= (dimension-2) && board[startingRowLocation+1][startingColLocation].wumpusStatus == SquareBox.UNSURE)
	   				 board[startingRowLocation+1][startingColLocation].wumpusStatus = SquareBox.NOT_PRESENT;
	   			 if(startingColLocation >= 1 && board[startingRowLocation][startingColLocation-1].wumpusStatus == SquareBox.UNSURE)
	   				 board[startingRowLocation][startingColLocation-1].wumpusStatus = SquareBox.NOT_PRESENT;
	   			 if(startingColLocation <= (dimension-2) && board[startingRowLocation][startingColLocation+1].wumpusStatus == SquareBox.UNSURE)
	   				 board[startingRowLocation][startingColLocation+1].wumpusStatus = SquareBox.NOT_PRESENT;
	   		 }
	 
	   		 boolean foundNewPath = false;
	   		 
	   		 if(startingRowLocation >= 1 && !((startingRowLocation-1) == startingRowPrevious && startingColLocation == startingColPrevious) && board[startingRowLocation-1][startingColLocation].isExplored == false && board[startingRowLocation-1][startingColLocation].pitStatus == SquareBox.NOT_PRESENT && board[startingRowLocation-1][startingColLocation].wumpusStatus == SquareBox.NOT_PRESENT) {
	   			 startingRowPrevious = startingRowLocation;
	   			 startingColPrevious = startingColLocation;
	   			 
	   			 startingRowLocation--;
	   			 foundNewPath = true;
	   		 }
	   		 else if(startingRowLocation <= (dimension-2) && !((startingRowLocation+1) == startingRowPrevious && startingColLocation == startingColPrevious) && board[startingRowLocation+1][startingColLocation].isExplored == false && board[startingRowLocation+1][startingColLocation].pitStatus == SquareBox.NOT_PRESENT && board[startingRowLocation+1][startingColLocation].wumpusStatus == SquareBox.NOT_PRESENT) {
	   			 startingRowPrevious = startingRowLocation;
	   			 startingColPrevious = startingColLocation;
	   			 
	   			 startingRowLocation++;
	   			 foundNewPath = true;
	   		 }
	   		 else if(startingColLocation >= 1 && !(startingRowLocation == startingRowPrevious && (startingColLocation-1) == startingColPrevious) && board[startingRowLocation][startingColLocation-1].isExplored == false && board[startingRowLocation][startingColLocation-1].pitStatus == SquareBox.NOT_PRESENT && board[startingRowLocation][startingColLocation-1].wumpusStatus == SquareBox.NOT_PRESENT) {
	   			 startingRowPrevious = startingRowLocation;
	   			 startingColPrevious = startingColLocation;
	   			 
	   			 startingColLocation--;
	   			 foundNewPath = true;
	   		 }
	   		 else if(startingColLocation <= (dimension-2) && !(startingRowLocation == startingRowPrevious && (startingColLocation+1) == startingColPrevious) && board[startingRowLocation][startingColLocation+1].isExplored == false && board[startingRowLocation][startingColLocation+1].pitStatus == SquareBox.NOT_PRESENT && board[startingRowLocation][startingColLocation+1].wumpusStatus == SquareBox.NOT_PRESENT) {
	   			 startingRowPrevious = startingRowLocation;
	   			 startingColPrevious = startingColLocation;
	   			 
	   			 startingColLocation++;
	   			 foundNewPath = true;
	   		 }
	   		 
	   		 if(!foundNewPath) {
	   			 int temp1 = startingRowPrevious;
	   			 int temp2 = startingColPrevious;
	   			 
	   			 startingRowPrevious = startingRowLocation;
	   			 startingColPrevious = startingColLocation;
	   			 
	   			 startingRowLocation = temp1;
	   			 startingColLocation = temp2;
	   		 }
	   		 
	   		 moves++;
	 
	   		 System.out.println("\n\nMove " + moves + ":");
	
	   		pb.printWumpusBoard(startingRowLocation,startingColLocation,board,dimension);
	 
	   		 if(moves > dimension*dimension) {
	   			 System.out.println("\nNo solution found!");
	   			 break;
	   		 }
	   	 }
	   	 
	   	 if(moves <= dimension*dimension)
	   		 System.out.println("\nFound gold in " + moves + " moves.");
	   	 
	   	 input.close();
	    }
	 
	  
}
