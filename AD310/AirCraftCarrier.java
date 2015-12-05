 /**
 * Creates Aircraft Carrier objects
 * 
 * @Author(s) Anne, Michael, Brandon, Joe
 * @Date November 28th 2015
 */
public class AirCraftCarrier extends Boat {
//     public String name = "AirCraftCarrier";
//     public int size;
//     public boolean[] boatState;
//     public int[] position;
//     public boolean isSunk = false;
//     Direction direct;
//     public char[] shipCoordinates;

    /**
     * Default constructor for Aircraft Carrier objects
     */
    public AirCraftCarrier() {
        super();
        this.name = "AirCraftCarrier";
        this.size = 5;
        this.position = new int[]{0,0,0,0,0};
        this.boatState = new boolean[]{false, false, false, false, false};
        this.isSunk = false;
        this.boatChar = 'A';
    }

    /**
     * Constructor for AirCraftCarrier with parameters
     * @param starting placement of ship
     * @param direction ship will be placed
     */
    public AirCraftCarrier(int head, Direction direction) {
        this.position = new int[size];
        this.boatState = new boolean[size];
        this.isSunk = false;
        this.direct = direction;
        //this.currentSpot = head;
        this.shipCoordinates = new char[size];
    }
    
    protected void shipsCoordinates(){
    	
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
	
// 	public String toString() {
// 	    return this.name;
// 	   }
	
}