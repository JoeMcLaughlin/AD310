package ad310_Group;

public abstract class Boat {

	public int 			size;
	public boolean[]	boatState;
	public int[]		position;
	public boolean		isSunk;
	Direction			direct;
	
	protected void placeBoat(int head){
		this.position[0] 	= head;
		int currentSpot 	= head;
		
		for(int i = 1; 1 < this.size; i++){
			switch ( this.direct){
			case DOWN:
				this.position[i] = currentSpot + 10;
			case RIGHT:
				this.position[i] = currentSpot + 1;
			case UPRIGHT:
				this.position[i] = currentSpot - 9;
			case DOWNRIGHT:
				this.position[i] = currentSpot + 11;
			}			
		}
	}
	
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
	
	public int getSize(){
		return this.size;
	}
	
	public boolean getSunk(){
		return isSunk;
	}
	
}
