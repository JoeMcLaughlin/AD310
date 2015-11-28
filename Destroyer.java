package ad310_Group;

/**
 * Creates Aircraft Carries objects
 * 
 * @Author(s) Anne, Michael, Brandon, Joe
 * @Date November 28th 2015
 */

public class Destroyer extends Boat {
    
	public static final int size = 2;

    /**
     * Constructor for Battleship ships
     * @param direction 
     * @param start 
     */
    
    public Destroyer(int head, Direction direction) {
        this.position = new int[size];
        this.boatState = new boolean[size];
        this.isSunk = false;
        this.direct = direction;
        
    }	
    
}

