package wumpus.console;
public class SquareBox {
    public static final int NOT_PRESENT = 0;
    public static final int UNSURE = 1;
    
    public boolean hasStench,hasWumpus,hasBreeze,hasPit,hasGold;
    public boolean isExplored;
    
    public int pitStatus = UNSURE;
    public int wumpusStatus = UNSURE;
     
    
}
