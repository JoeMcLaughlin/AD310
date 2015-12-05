 

public class Boat {
    public String name;
    public int          size;
    public boolean[]    boatState;
    public int[]        position;
    public boolean      isSunk;
    Direction           direct;
    public char[]       shipCoordinates;
    public char         boatChar;
    public int          hits;
    
     /**
      * Default constructor for boat objects
      */
      public Boat() {
        this.size = 0;
        this.boatState = new boolean[0];
        this.position = new int[0];
        this.isSunk = false;
        this.name = "Boat";
        this.boatChar = ' ';
        this.hits = 0;
 
      }
    
     /**
      * Method that takes the attack input and returns true if the attack is a hit
      */
      public boolean attack(int position){
         int countHits = 0;
         for(int i = 0; i < this.size; i++){
             countHits++;
         }
         if(countHits == this.size){
             this.isSunk = true;
         }
         for(int i = 0; i < this.size; i++){
             if( this.position[i] == position){
                 this.boatState[i] = true; //true for hit
                 return true;
             }
             
         }
         //no hits were made
         return false;
      }
    
     /**
      * Checks ship placement and write to board if placement is
      * acceptable, returns false is placement info is bad
      */
     public boolean placeBoat(char row, int column, Direction direction, char[] defensiveBoard) {
         if ( shipInBounds(row, column, direction) == false) {
             System.out.println("Invalid ship placement, ship goes out of bounds! \n");
             return false;
         } else if ( checkOverlap(row, column, direction, defensiveBoard) == false ) {
             System.out.println("Invalid ship placement, ship overlaps previously placed ships! \n");
             return false;
         } else {
             System.out.println("Ship has been sucessfully placed!");
             return true;
         }
    }
    
     /**
     * Checks that ship placement is in bounds of board, returns false if out of bounds
     * @param row the character of the row
     * @param column the number of the column
     * @param direction for ship placement, see the direction constants
     * @return true if ship placement is valid  
     * @throws IllegalStateException The game is not in setup Mode
     */
     public boolean shipInBounds(char row, int column, Direction direction) {
         //check int values of the character for boundary checking, A = 65, J = 74
         char character = Character.toUpperCase(row);
         
         //now check if the ship will fall within the legal board boundaries 
         //this does NOT yet check against other ships!!
         switch (direction) {
             case RIGHT: return (column + (size-1)) <= 10;
             case DOWN: return (character + (size-1)) <= 74;
             case UPRIGHT: return (column + (size-1)) <= 10 && (character - (size-1)) >= 65;
             case DOWNRIGHT: return (column + (size-1)) <= 10 && (character + (size-1)) <= 74;
         }
         return true;
     }     
    
     /**
      * Checks for overlap and returns true if the ship placement is valid
      * @param row of placement
      * @param col of placement
      * @param direction of placement
      * @param the defensive board that is being updated
      */
     public boolean checkOverlap(char row, int col, Direction direction, char[] defensiveBoard){
         boolean test = false;
         switch (direction) {
             case RIGHT: test = testRight(row, col, defensiveBoard);
                break;
             case DOWN: test = testDown(row, col, defensiveBoard);
                break;
             case UPRIGHT: test = testUpright(row, col, defensiveBoard);
                break;
             case DOWNRIGHT: test = testDownright(row, col, defensiveBoard);
                break;       
            }
         return test;
     }
     
     /**
      * Helper method to check downright(diagonal/SE) placement: returns true if placement is
      * legal, false if illegal
      * @param row the character of the row
      * @param column the number of the column
      * @param the defensive board that is being updated
      * @return true is placement is legal, false if illegal
      * @throw NullPointerException if the placement goes off the board grid
      */
     public boolean testDownright(char row, int col, char[] defensiveBoard) {
         int length = this.size;
         int start = toArrayIndex(row, col);
         boolean overlap = false;
         
         //create an array index to check possible placement against defensive board
         int[] checkBoard = new int[length];
         for (int i=0; i < length; i++) {
             checkBoard[i] = start;
             start+=11;
         }

         //test the test array against defensive board indices
         for (int i=0; i<length; i++) {
             if (defensiveBoard[checkBoard[i]] != ' ') {
             return false;
            }
         }
         
         //check if it crosses other ships
         for (int i=0; i < length-1; i++) {
             if (defensiveBoard[start-10] != ' ' && defensiveBoard[start-10] == defensiveBoard[start+1]) {
                 return false;
                }      
         }
        
         //no overlap problems if reaches this point, so assign indexes to boat object
         this.position = checkBoard;
         for (int i=0; i < length; i++) {
             defensiveBoard[position[i]] = boatChar;
         }
         return true;
     }
     
     /**
      * Helper method to check upright(diagonal/NE) placement: returns true if placement is
      * legal, false if illegal
      * @param row the character of the row
      * @param column the number of the column
      * @param the defensive board that is being updated
      * @return true is placement is legal, false if illegal
      * @throw NullPointerException if the placement goes off the board grid
      */
     public boolean testUpright(char row, int col, char[] defensiveBoard) {
         int length = this.size;
         int start = toArrayIndex(row, col);
         boolean overlap = false;
         
         //create an array index to check possible placement against defensive board
         int[] checkBoard = new int[length];
         for (int i=0; i < length; i++) {
             checkBoard[i] = start;
             start-=9;
         }
            
         //test the test array against defensive board indices
         for (int i=0; i<length; i++) {
             if (defensiveBoard[checkBoard[i]] != ' ') {
             return false;
            }
         }
         
         //test for overlap of other ships
         for (int i=0; i < length-1; i++) {
             if (defensiveBoard[checkBoard[i]-10] != ' ' && defensiveBoard[checkBoard[i]-10] == defensiveBoard[checkBoard[i]+1]) {
                 return false;
                }      
         }
        
         //no overlap problems if reaches this point, so assign indexes to boat object
         this.position = checkBoard;
         for (int i=0; i < length; i++) {
             defensiveBoard[position[i]] = boatChar;
         }
         return true;
     }
     
     /**
      * Helper method to check down (SOUTH) placement: returns true if placement is
      * legal, false if illegal
      * @param row the character of the row
      * @param column the number of the column
      * @param the defensive board that is being updated
      * @return true is placement is legal, false if illegal
      * @throw NullPointerException if the placement goes off the board grid
      */
     public boolean testDown(char row, int col, char[] defensiveBoard) {
         int length = this.size;
         int start = toArrayIndex(row, col);
         boolean overlap = false;
         
         //create an array index to check possible placement against defensive board
         int[] checkBoard = new int[length];
         for (int i=0; i < length; i++) {
             checkBoard[i] = start;
             start+=10;
         }
            
        //if the array index overlaps a non blank square on the defensive board, 
        //overlap true activates
         for (int i = 0; i < length; i++) {
             if (defensiveBoard[checkBoard[i]] != ' ') {
                 return false;
            }
        }
        
        //if we get this far in the code there is no overlap
        this.position = checkBoard;
        for (int i=0; i < length; i++) {
             defensiveBoard[position[i]] = boatChar;
        }
        return true;     
     }
     
     /**
      * Helper method to check right (EAST) placement: returns true if placement is
      * legal, false if illegal
      * @param row the character of the row
      * @param column the number of the column
      * @param the defensive board that is being updated
      * @return true is placement is legal, false if illegal
      * @throw NullPointerException if the placement goes off the board grid
      */
     public boolean testRight(char row, int col, char[] defensiveBoard) {
         int length = this.size;
         int start = toArrayIndex(row, col);
         boolean overlap = false;
         
         //create an array index to check possible placement against defensive board
         int[] checkBoard = new int[length];
         for (int i=0; i < length; i++) {
             checkBoard[i] = start;
             start++;
            }
            
        //if the array index overlaps a non blank square on the defensive board, 
        //overlap true activates
         for (int i = 0; i < length; i++) {
             if (defensiveBoard[checkBoard[i]] != ' ') {
                 return false;
            }
         }
        
         //if we get this far the placement is legal
        this.position = checkBoard;
        for (int i=0; i < length; i++) {
             defensiveBoard[position[i]] = boatChar;
        }
         return true;
     }
     
     /**
      * Returns true if the ship has been hit
      * @param index of array that is being attacked
      * @playerModel defensive board of oppenent player
      */
     public boolean isHit(int index, BattleShipModel playerModel) {

         for (int i=0; i < size; i++) {
             if (position[i] == index) {
                 boatState[i] = true;
                 hits++;
                 if (hits < size) { //update board to display the hit 
                     playerModel.offensiveBoard[index] = 'H';
                     return true;
                    } else {//the ship is sunk
                        //update board to show letter of sunk ship
                        playerModel.totalShipsSunk++;
                        for (int j=0; j < size; j++) {
                            playerModel.offensiveBoard[position[j]] = boatChar;
                        }
                        return true;
                    }
             }
         }
         
         //if we make it this far it is a miss.
         playerModel.offensiveBoard[index] = 'M';
         return false;
     }
     
     /**
      * Tests if a boat is sunk and updates the state of the game accordingly
      */
     public boolean isSunk(BattleShipModel playerModel) {
         if (hits == size) {
             return true;
            }
            return false;
        }
        
     
     /**
      * Returns the length of the ship
      */
     public int getSize(){
         return this.size;
     }
    
     /**
      * Returns true if ship is sunk
      */
     public boolean getSunk(){
        return isSunk;
     }
    
     /**
      * Returns the name of the ship
      */
     public String toString(){
         return name;
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
