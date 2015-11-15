package ad310_Group;


/**
 * The programmatic interface for the Battleship Controller class.
 * This interface will coordinate between user input and 
 * the current state of the model
 * 
 * @author Michael Gorsuch
 * @author Anne Thorsteinson
 * @author Joe McLaughlin
 * @author Brandon Heinrich
 */
public interface BattleshipControllerInterface
{
    //I don't think interfaces have fields, but we should have a couple
    //boolean setupMode;
    //boolean playMode;
    //boolean player1turn;
    
    /**
     * User input initializes new game and begins setup mode
     */
    //This method should signal the Model to create a new
    //blank game board
    //This method should also print out a Sting that explains
    //the placement rules for our game:
    //Horizontal: EAST placement, places to the right
    //Vertical: SOUTH placement, places down
    //Diagonal(required direction NE or SE): places in given direction
    public void newGame();

    /**
     * Prompts user for placement info, ONLY creates ship object/passes info to model if the 
     * placement returns as VALID
     * @param type of ship to be placed
     * @param char marker of row to begin ship placement
     * @param column to begin ship placement
     */
    //not exactly sure how this will work, prompt ship by ship?
    //this needs to check validation, so it will call valid input method
    //need some controller so this only happens 5 times in a set order
    public void placeShip(Ship type, char row, int column);
    
    /**
     * Validates the user input for ship placement
     * @param type of ship
     * @param row of placement
     * @param column of placement
     * @param direction of placement
     * @return true if the placement is legal      
     */
    //we are going to have to write several different check methods here
    //separate check methods will test boundaries and will check vs. existing
    //ship placement --> I think ship placement should be in a set order
    //meaning: first place AC, then Battleship, then Carrier, then D
    public boolean checkPlacement(Ship type, char row, int column, Direction direction);
    
    /**
     * Checks horizontal placement
     * @param type of ship
     * @param row of placement
     * @param column of placement
     * @return true if the placement is legal   
     */
    public boolean checkHoriz(Ship type, char row, int column);
    
    /**
     * Checks vertical placement
     * @param type of ship
     * @param row of placement
     * @param column of placement
     * @return true if the placement is legal  
     */
    public boolean checkVert(Ship type, char row, int column);
    
    /**
     * Checks diagonal NE placement
     * @param type of ship
     * @param row of placement
     * @param column of placement
     * @return true if the placement is legal  
     */
    public void checkDiagNE(Ship type, char row, int column);
    
    /**
     * Checks diagonal SE placement
     * @param type of ship
     * @param row of placement
     * @param column of placement
     * @return true if the placement is legal  
     */
    public void checkDiagSE(Ship type, char row, int column);

    /**
     * Prompts user input for their shot
     * @param row of attack
     * @param column of attack
     */
    //should check that the shot inputs are valid
    //this shoudl probably also update whose turn it is
    public void makeShot(char row, int column);
    
    /**
     * Checks that shot input is valid before passing to the model
     * @param row of attack
     * @param column of attack
     */
    //this will have to communicate with model to see if shot has already been called
    public boolean isValidShot(char row, int column);
}


