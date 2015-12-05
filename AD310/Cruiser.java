 

/**
 * Creates Aircraft Carries objects
 * 
 * @Author(s) Anne, Michael, Brandon, Joe
 * @Date November 28th 2015
 */

public class Cruiser extends Boat {
//     public String name = "Cruiser";
// 	public int size = 3;
//     public boolean[] boatState;
//     public int[] position;
//     public boolean isSunk = false;
//     Direction direct;
//     public char[] shipCoordinates;	
	
    /**
     * Default constructor for Cruiser objects
     */
    public Cruiser() {
        super();
        this.name = "Cruiser";
        this.size = 3;
        this.boatState = new boolean[]{false, false, false};
        this.position = new int[]{0,0,0};
        this.isSunk = false;
        this.boatChar = 'C';
    }
    
    /**
     * Constructor for Cruiser ships
     * @param direction 
     * @param start 
     */
    public Cruiser(int head, Direction direction) {
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
