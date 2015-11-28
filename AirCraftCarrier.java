package ad310_Group;

/**
 * Creates Aircraft Carries objects
 * 
 * @Author(s) Anne, Michael, Brandon, Joe
 * @Date November 28th 2015
 */
public class AirCraftCarrier extends Boat {
    
    public static final int size = 5;

    /**
     * Constructor for Battleship ships
     * @param direction 
     * @param start 
     */
    
    public AirCraftCarrier(int head, Direction direction) {
        this.position = new int[size];
        this.boatState = new boolean[size];
        this.isSunk = false;
        this.direct = direction;
        
    }	
}