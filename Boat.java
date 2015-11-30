package ad310_Group;

public abstract class Boat {

	public int 			size;
	public boolean[]	boatState;
	public int[]		position;
	public boolean		isSunk;
	Direction			direct;
	public char[]		shipCoordinates;
	//public int 			currentSpot;
	
	protected void placeBoat(int head){
		
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
