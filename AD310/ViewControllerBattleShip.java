import java.util.Scanner;

/**
 * Control/View class that dictates the flow of the game coordinating with
 * the BattleShipModel objects
 */
public class ViewControllerBattleShip {
    Scanner userIn = new Scanner(System.in);
    BattleShipModel battleshipmodel;
    boolean setupMode = true;
    
    public ViewControllerBattleShip(BattleShipModel playerModel) {
        this.battleshipmodel = playerModel;
    }
    
    /*
    * Interface for player to enter their placement values and print to the board
    */
    public void setUp(BattleShipModel playerModel){
        if (setupMode == false) {
            System.out.println("Setup methods are not available during play mode.");
            return;
        }
        Boat[] boatsToPlace = playerModel.shipArray;
        int col;
        char row;
        Direction direction;
        
        for (int i=0; i < boatsToPlace.length; i++) {
            do {
                System.out.println("Time to place your " + boatsToPlace[i].toString() +
                    " length " + boatsToPlace[i].size);
                System.out.println("Please enter the row of placement, A-J: ");
                String rowString = userIn.next();
                rowString = rowString.toUpperCase();
                while (rowString.length() > 1 || rowString.charAt(0) < 65 || rowString.charAt(0) > 74 ) {
                    playerModel.printDefensiveBoard(playerModel.defensiveBoard);
                    System.out.println("Please enter a valid row, A-J: ");
                    rowString = userIn.next();
                }
                row = rowString.toUpperCase().charAt(0);
                System.out.println("Please enter the column of placement, 1-10: ");
                col = userIn.nextInt();
                while (col < 1 || col > 10) {
                    playerModel.printDefensiveBoard(playerModel.defensiveBoard);
                    System.out.println("Please re enter a valid column, 1-10: ");
                    col = userIn.nextInt();
                }
                System.out.println("Please enter direction of placement: \n" +
                    "Enter 1 for down/south \n" +
                    "Enter 2 for right/east \n" +
                    "Enter 3 for upright/NE \n" +
                    "Enter 4 for downright/SE \n");
                int directionInt = userIn.nextInt();
                while (directionInt < 1 || directionInt > 4) {
                    System.out.println("Please enter a valid number, 1-4");
                    directionInt = userIn.nextInt();
                }
                direction = intToDirection(directionInt);
            }
            while (
                //now we have gathered placement information, time to pass to placement for validation
                boatsToPlace[i].placeBoat(row, col, direction, playerModel.defensiveBoard) == false );
            playerModel.printDefensiveBoard(playerModel.defensiveBoard);
        }
        setupMode = false;
        System.out.println("You have now entered the attack portion of the game! \n \n");
    }
    
    public Direction intToDirection(int directionInt) {
        Direction direction = Direction.DOWN;
        switch (directionInt) {
            case 1: direction = Direction.DOWN;
                break;
            case 2: direction = Direction.RIGHT;
                break;
            case 3: direction = Direction.UPRIGHT;
                break;
            case 4: direction = Direction.DOWNRIGHT;
                break;
            }
            return direction;
    }
    
    public void printSetupRules(BattleShipModel playerModel) {
        System.out.println("You have " + playerModel.totalShips + " ships to place: ");
            
        for (int i = 0; i < playerModel.totalShips; i++) {
            System.out.println(" - #" + (i+1)  + " " + playerModel.shipArray[i].toString() + " length " + 
            playerModel.shipArray[i].getSize() );
       }
       System.out.println("");
       System.out.println("To place a ship you must enter the following information: \n" +
           " - Row of placement: A-J \n" +
           " - Column of placement: 1-10 \n" +
           " - Direction of placement, choose from the following: \n" +
           "   Down (S), Right (E), Upright (NE), Downright (SE) \n" +
           "You will place ships in order from largest to smallest length. \n" +
           "\n" );
      
    }
    
    public void printPlayRules() {
        System.out.println("How to play battleship: \n" +
            " - Players will alternate attacks on one anothers defensive boards. \n" +
            " - To attack, players will provide the row and column of attack. \n" +
            " - If the attack hits the opponents ship, the current player's turn continues. \n" +
            " - If the attack misses the ships, turn taking will resume. \n" +
            " - The first player to sink all of the opponent's ships is the winner. \n" +
            " - Player One will take the FIRST ATTACK \n");
        
    }
    
    /*
     * Accepts input from the user and returns true if the attack has hit one of the ships
     */
    public boolean attack(BattleShipModel playerModel, BattleShipModel opponentModel) {
        
        Boat[] boatsToPlace = playerModel.shipArray;
        int col;
        char row;
        int index = 0;
        opponentModel.offensiveBoard[0] = 'X';
        
        //get attack info from user
        System.out.println("Make an attack");
        System.out.println("If you attack a square a second time you will be prompted for new" +
            "placement information");
        System.out.println("Please enter the row of attack, A-J: ");
        String rowString = userIn.next();
        rowString = rowString.toUpperCase();
        while (rowString.length() > 1 || rowString.charAt(0) < 65 || rowString.charAt(0) > 74 ) {
            System.out.println("Please enter a valid row, A-J: ");
            rowString = userIn.next();
        }
        row = rowString.toUpperCase().charAt(0);
        System.out.println("Please enter the column of placement, 1-10: ");
        col = userIn.nextInt();
        while (col < 1 || col > 10) {
            System.out.println("Please re enter a valid column, 1-10: ");
            col = userIn.nextInt();
        }
        index = toArrayIndex(row, col);    
    while ( opponentModel.offensiveBoard[index] != ' ') {
        System.out.println("Please re enter the row of attack, A-J: ");
        //String 
        rowString = userIn.next();
        rowString = rowString.toUpperCase();
        while (rowString.length() > 1 || rowString.charAt(0) < 65 || rowString.charAt(0) > 74 ) {
            System.out.println("Please enter a valid row, A-J: ");
            rowString = userIn.next();
        }
        row = rowString.toUpperCase().charAt(0);
        System.out.println("Please re enter the column of placement, 1-10: ");
        col = userIn.nextInt();
        while (col < 1 || col > 10) {
            System.out.println("Please re enter a valid column, 1-10: ");
            col = userIn.nextInt();
        }
        index = toArrayIndex(row, col);
    }
        
        //playerModel test this information against ship objects of opponent player
        for (Boat boat : opponentModel.shipArray) {
            if ( boat.isHit(index, opponentModel) == true) {
                if ( boat.isSunk(opponentModel) == false) {
                    System.out.println("You have hit a " + boat.name + "\n");
                    opponentModel.printOffensiveBoard(opponentModel.offensiveBoard);
                    return true;
                } else { //boat is sunk
                    System.out.println("YOU HAVE SUNK THE " + boat.name + "\n");
                    opponentModel.printOffensiveBoard(opponentModel.offensiveBoard);
                    return true;
                } 
            }
       }
        System.out.println("MISS! \n \n");
        return false;
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
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
