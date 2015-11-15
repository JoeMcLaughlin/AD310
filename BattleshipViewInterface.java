package ad310_Group;

/**
 * The programmatic interface for the Battleship View Class.
 * This interface will contain methods that respond to status updates
 * from the model and adjust the view accordingly
 * 
 * @author Michael Gorsuch
 * @author Anne Thorsteinson
 * @author Joe McLaughlin
 * @author Brandon Heinrich
 */
public interface BattleshipViewInterface
{
    /**
     * When signalled by the model, creates new blank playing field
     */
    public void createSetupBoard();
    
    /**
     * When signalled by the model, print out new game info to clients
     */
    //info should include placement rules
    //info should include which player will play first
    public void printRules();
    
    /**
     * When signalled by the model, show ship placement on board
     */
    public void showShipPlacement();
    
    //We need to make a design decision, but for now I think we should move
    //forward with Brandon's idea and after the placement mode display only
    //the offensive boards
    
    /**
     * When signalled by the model, update Hit and Miss of shots on the
     * offensive boards
     */
    public void updateGameStatus();
    
    /**
     * Prints message to players that game is over, when signalled 
     * by the model
     */
    public void isGameOver();
}
