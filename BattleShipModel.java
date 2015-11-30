package ad310_Group;

public class BattleShipModel
{
	/*
	* Player 1 boats
	*/
	public AirCraftCarrier 	player1AC;
	public BattleShip 		player1BS;
	public Cruiser			player1C;
	public Destroyer		player1D1;
	public Destroyer		player1D2;
	

	/*
	* Player 2 boats
	*/
	public AirCraftCarrier 	player2AC;
	public BattleShip 		player2BS;
	public Cruiser			player2C;
	public Destroyer		player2D1;
	public Destroyer		player2D2;
	
	/*
	* Player 1 Boards
	*/
	public int[] 	player1Offense;// 0 no play, 1 miss, 2 hit
	/*
	* This will be empty except the actual ships will have a character
	*/
	public char[]		player1DefensePrint;
 
	/*
	* Player 2 Boards
	*/
	public int[] 	player2Offense;// 0 no play, 1 miss, 2 hit
	/*
	* This will be empty except the actual ships will have a character
	*/
	public char[]		player2DefensePrint;
	
	public BattleShipModel(){
		this.player1DefensePrint 	= new char[101];
		this.player1Offense 		= new int[101];
		
		this.player2DefensePrint 	= new char[101];
		this.player2Offense 		= new int[101];
		for(int i = 0; i < 101; i++){
			this.player1Offense[i] = 0;
			this.player2Offense[i] = 0;
			this.player1DefensePrint[i] = ' ';
			this.player2DefensePrint[i] = ' ';
		}
	}

    /**
     * Prints current board status
     */
    public void printOffenseBoard(int[] player) {
        char letter = 'A';
        //First ___ is the spacer for Letters in the table... *thanks for comment!
        System.out.println("  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10|");
        for (int i = 0; i < 10; i++) {
        	//System.out.print("___");
            System.out.print(" " + letter + "|");
        	for (int k = 0; k < 10; k++) {
                System.out.print("___|");
            }
            
            for (int j = 0; j < 10; j++) {
            	if(player[i]==2)
            		System.out.print("|" + " H ");
            	else if(player[i]==1)
            		System.out.print("|" + " M ");
            }
            System.out.println("");
            letter = (char)(letter+1);
        }
        //System.out.println("    ___|___|___|___|___|___|___|___|___|___|");  
        System.out.println("");
    }

    /**
     * Prints current defensive board status
     */
    public void printDefensiveBoard(int[] player) {
        char letter = 'A';
        //First ___ is the spacer for Letters in the table... *thanks for comment!
        System.out.println("  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10|");
        for (int i = 0; i < 10; i++) {
        	//System.out.print("___");
            System.out.print(" " + letter + "|");
        	for (int k = 0; k < 10; k++) {
                System.out.print("___|");
            }
            
            for (int j = 0; j < 10; j++) {
            	if(player[i]==2)
            		System.out.print("|" + " H ");
            	else if(player[i]==1)
            		System.out.print("|" + " M ");
            }
            System.out.println("");
            letter = (char)(letter+1);
        }
        //System.out.println("    ___|___|___|___|___|___|___|___|___|___|");  
        System.out.println("");
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
     
     /*
      * Create Ships
      */
     public void createPlayer1AC(int start, Direction direction){
    	this.player1AC = new AirCraftCarrier(start, direction);
    	/*for(int j = 0; j< this.player1AC.size;j++){
    		
    	}*/
    	this.player1AC.placeBoat(start);
    	int counter = 0;
    	for(int i = 0; i < player1DefensePrint.length; i++){
    		if(counter < this.player1AC.size)
    		{
    			if(i == this.player1AC.position[counter]){
    			
    				player1DefensePrint[i] = 'A';
    				counter++;
    			}
    			
    			//start++;
    		}
    	}
     }
     public void createPlayer2AC(int start, Direction direction){
    	this.player2AC = new AirCraftCarrier(start, direction);
    	for(int i = 0; i < player1DefensePrint.length; i++){
    		//if(player2AC.position[i]==i){
    			player2DefensePrint[i] = 'A';
    		//}
    	}
     }
     public void createPlayer1BS(int start, Direction direction){
    	this.player1BS = new BattleShip(start, direction);
    	for(int i = 0; i < player1DefensePrint.length; i++){
    		//if(player1BS.position[i]==i){
    			player1DefensePrint[i] = 'B';
    		//}
    	}
     }
     public void createPlayer2BS(int start, Direction direction){
    	this.player2BS = new BattleShip(start, direction);
    	for(int i = 0; i < player1DefensePrint.length; i++){
    		//if(player1BS.position[i]==i){
    			player1DefensePrint[i] = 'B';
    		//}
    	}
     }
     public void createPlayer1C(int start, Direction direction){
    	this.player1C = new Cruiser(start, direction);
    	for(int i = 0; i < player1DefensePrint.length; i++){
    		//if(player1C.position[i]==i){
    			player1DefensePrint[i] = 'C';
    		//}
    	}
     }
     public void createPlayer2C(int start, Direction direction){
    	this.player2C = new Cruiser(start, direction);
    	for(int i = 0; i < player1DefensePrint.length; i++){
    		//if(player1C.position[i]==i){
    			player1DefensePrint[i] = 'C';
    		//}
    	}
     }
     public void createPlayer1D1(int start, Direction direction){
    	this.player1D1 = new Destroyer(start, direction);
    	for(int i = 0; i < player1DefensePrint.length; i++){
    		//if(player1D1.position[i]==i){
    			player1DefensePrint[i] = 'D';
    		//}
    	}
     }
     public void createPlayer1D2(int start, Direction direction){
    	this.player1D2 = new Destroyer(start, direction);
    	for(int i = 0; i < player1DefensePrint.length; i++){
    		//if(player1D2.position[i]==i){
    			player1DefensePrint[i] = 'D';
    		//}
    	}
     }
     public void createPlayer2D1(int start, Direction direction){
    	this.player2D1 = new Destroyer(start, direction);
    	for(int i = 0; i < player1DefensePrint.length; i++){
    		//if(player2D1.position[i]==i){
    			player1DefensePrint[i] = 'D';
    		//}
    	}
     }
     public void createPlayer2D2(int start, Direction direction){
    	this.player2D2 = new Destroyer(start, direction);
    	for(int i = 0; i < player1DefensePrint.length; i++){
    		//if(player2D2.position[i]==i){
    			player1DefensePrint[i] = 'D';
    		//}
    	}
     }
     
     //If you need to see if it was played or not
     public int[] getPlayer1Board(){
    	return this.player1Offense;
     }
     public int[] getPlayer2Board(){
    	return this.player2Offense;
     }
     
     //If you need to see placement
     public char[] getPlayer1Placement(){
    	return this.player1DefensePrint;
     }
     public char[] getPlayer2Placement(){
    	return this.player2DefensePrint;
     }

     
     /*
      * Player 2 offense board is player 1 defense
      * 
      * Player 2 attacks player 1's ships, and changes player1's defense boards
      */
     public void changeOffenseStatePlayer2(int position){
    		if(player1AC.attack(position)){
    			this.player2Offense[position] = 2;//Hit
    		}
    		else if(player1BS.attack(position)){
    			this.player2Offense[position] = 2;
    		}
    		else if(player1C.attack(position)){
    			this.player2Offense[position] = 2;
    		}
    		else if(player1D1.attack(position)){
    			this.player2Offense[position] = 2;
    		}
    		else if(player1D2.attack(position)){
    			this.player2Offense[position] = 2;
    		}
    		else{
    			this.player2Offense[position] = 1;//Miss
    		}
     }
     
     /*
      * Player 1 offense board is player 2 defense
      * 
      * Player 2 attacks player 1's ships, and changes player1's defense boards
      */
     public void changeOffenseStatePlayer1(int position){
    		if(player2AC.attack(position)){
    			this.player1Offense[position] = 2;//Hit
    		}
    		else if(player2BS.attack(position)){
    			this.player1Offense[position] = 2;//Hit
    		}
    		else if(player2C.attack(position)){
    			this.player1Offense[position] = 2;//Hit
    		}
    		else if(player2D1.attack(position)){
    			this.player1Offense[position] = 2;//Hit
    		}
    		else if(player2D2.attack(position)){
    			this.player1Offense[position] = 2;//Hit
    		}
    		else{
    			this.player1Offense[position] = 1;//Miss    			 
    		}
     }
     
     /**
      * Rules for the game
      */
     public String rules()
     {
         return "        Battleship Rules\n"+
             "Players take turns guessing the coordinates of the\n"+
             "opponent's ships until one player has a success, or hit.\n"+
             "Once there has been a hit, the successful player goes \n"+
             "again. Otherwise, turn-taking is resumed. \n"+
             "Depending on the size of the ship, it will take at \n"+
             "least two hits to sink a ship. The player that sinks \n"+
             "all their opponents' ships wins.\n";
     }

   
     
}
