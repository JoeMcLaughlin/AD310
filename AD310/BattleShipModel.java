 /**
  * The Battleship Model objects hold all the player information for the game.  Each player
  * has their own Battleship Object
  * 
  * @Team: Anne, Joe, Michael, Brandon
  * @Dec 4, 2015
  */

public class BattleShipModel {
    //Direction options in this version of battleship
    Direction[] directionOptions= {Direction.DOWN, Direction.RIGHT, Direction.UPRIGHT, Direction.DOWNRIGHT};
    
    //Number of Ships in this version of battleship
    public int totalShips = 5;
    public int totalShipsSunk = 0;
    
    //Boats available to the player in this version of battleship
    public AirCraftCarrier  aircraftCarrier;
    public BattleShip       battleship;
    public Cruiser          cruiser;
    public Destroyer        destroyer1;
    public Destroyer        destroyer2;
    Boat[] shipArray;

    //Offensive Board
    public char[]   offensiveBoard;// 0 no play, 1 miss, 2 hit
    // This will be empty except the actual ships will have a character
    public char[]   defensiveBoard;

    /**
     * Default constructor for a battle ship model
     */
    public BattleShipModel(){
        this.totalShips = 5;
        this.totalShipsSunk = 0;
        this.defensiveBoard = new char[101];
        for (int i=0; i < 101; i++) {
            defensiveBoard[i] = ' ';
        }
 
        this.offensiveBoard = new char[101];
        for (int i=0; i < 101; i++) {
            defensiveBoard[i] = ' ';
        }
        
        this.aircraftCarrier = new AirCraftCarrier();
        this.battleship = new BattleShip();
        this.cruiser = new Cruiser();
        this.destroyer1 = new Destroyer();
        this.destroyer2 = new Destroyer();
        
        this.shipArray = new Boat[]{aircraftCarrier, battleship, cruiser, destroyer1, destroyer2};
        for(int i = 0; i < 101; i++){
            this.offensiveBoard[i] = ' ';
            this.defensiveBoard[i] = ' ';
        }
    }

    /**
     * Prints current board status
     */
    public void printOffensiveBoard(char[] player) {
        char letter = 'A';
        System.out.println("   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 ");
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                System.out.print("___|");
            }
            System.out.println("____");
            System.out.print(" " + letter + " ");
            for (int j = 1; j < 11; j++) {
                System.out.print("| " + offensiveBoard[10*i+j] + " ");
            }
            System.out.println("");
            letter = (char)(letter+1);
        }
        System.out.println("___|___|___|___|___|___|___|___|___|___|____");  
        System.out.println("");
    }

    /**
     * Prints current defensive board status
     */
    public void printDefensiveBoard(char[] board) {
        char letter = 'A';
        System.out.println("   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 ");
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                System.out.print("___|");
            }
            System.out.println("____");
            System.out.print(" " + letter + " ");
            for (int j = 1; j < 11; j++) {
                System.out.print("| " + defensiveBoard[10*i+j] + " ");
            }
            System.out.println("");
            letter = (char)(letter+1);
        }
        System.out.println("___|___|___|___|___|___|___|___|___|___|____");  
        System.out.println("");
    }
    
    /**
     * Helper method to turn alpha numeric input (i.e. A 8) into a number index of the
     * main board array
     * @param alphabetic coordinate of input row
     * @param numerical coordinate of input column
     * @throws IllegalArgumentException if character input is out of bounds
     * @throws IllegalArgumentException if column input is out of bounds
     */
     public int toArrayIndex(char row, int column){
        char character = Character.toUpperCase(row);
        if (character < 65 || character > 74) {
            throw new IllegalArgumentException("Row input is out of bounds.");
           }
        if (column < 1 || column > 10) {
            throw new IllegalArgumentException("Column input is out of bounds.");
           }
        int arrayIndex = 0;
        switch (character) {
            case 'A': arrayIndex = (10*0) + column;
               break;
            case 'B': arrayIndex = (10*1) + column;
               break;
            case 'C': arrayIndex = (10*2) + column;
               break;
            case 'D': arrayIndex = (10*3) + column;
               break;
            case 'E': arrayIndex = (10*4) + column;
               break;
            case 'F': arrayIndex = (10*5) + column;
               break;
            case 'G': arrayIndex = (10*6) + column;
               break;
            case 'H': arrayIndex = (10*7) + column;
               break;
            case 'I': arrayIndex = (10*8) + column;
               break;
            case 'J': arrayIndex = (10*9) + column;
               break;             
        }
        return arrayIndex;
    }
     
     
    /**
     * Returns true if game is over, returns false if game is ongoing
     */
    public boolean isGameOver() {
        if (totalShipsSunk == 5) {
            return true;
        }
        return false;
    }
     
}
