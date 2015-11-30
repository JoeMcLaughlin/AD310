package ad310_Group;

/**
 * Creates Aircraft Carries objects
 * 
 * @Author(s) Anne, Michael, Brandon, Joe
 * @Date November 28th 2015
 */

public class Destroyer extends Boat {
    
	public final int size = 2;

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
    
    protected void placeBoat(int head){
		this.position[0] 	= head;
		//this.currentSpot 	= head;
		
		for(int i = 1; i <= this.size-1; i++){
			switch ( this.direct){
			case DOWN:
				this.position[i] = this.position[i-1] + 10;
				break;
			case RIGHT:
				this.position[i] = this.position[i-1] + 1;
				break;
			case UPRIGHT:
				this.position[i] = this.position[i-1] - 9;
				break;
			case DOWNRIGHT:
				this.position[i] = this.position[i-1] + 11;
				break;
			}			
		}
	}
    
}

