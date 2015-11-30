package ad310_Group;

import java.util.Scanner;

//This class will use the information stored inside the model
public class ViewControllerBattleShip
{
	//Our Model of BattleShip
	BattleShipModel BSM;
	Scanner userIn = new Scanner(System.in);
	
	public ViewControllerBattleShip()
	{
		this.BSM = new BattleShipModel();
	}
	
	//Print out player 1 placement                                                                                                                                                                        
	public void displayPlayer1Placement(){
		//Use this model object and use the print method, pass it the model's player 1 offense board.
		this.BSM.printOffenseBoard(BSM.player1Offense);
	}
	
	//Print out player 2 placement
	public void displayPlayer2Placement(){
		//Use this model object and use the print method, pass it the model's player 1 offense board.
		this.BSM.printOffenseBoard(BSM.player2Offense);
	}
	
	
	/*
	* Create a SetUp Mode method to create the ships based on player turn
	* 
	* This method needs to do the following:
	* 
	* Take a players input: and convert it
	* 
	* Perform placement validation
	*/
	public void setUp(){
		
		//player one
		for(int i=0;i<5;i++){//user loops through 5 times to place all ships.
			
			//while(true){//add isValid() && noShips()
				System.out.println("You will place your ships in this order,\n#1-Aircraft Carrier(length of 5), \n"
						+ "#2-BattleCruiser(length of 4),\n#3-Carrier(length of 3),\n#4 Destroyer#1(length of 2)"
						+ "\n#5 Destroyer#2(length of 2)");
				
				System.out.println("\n\nPlease place ship #" + (i+1));
				//first parameter for placement
				System.out.println("Please enter your Y co-ordinate(vertical)");
				char userY = userIn.next().charAt(0);
				
				//second parameter for placement
				System.out.println("Please enter your X co-ordinate(horizontal 1-10)");
				int userX = userIn.nextInt();
				
				//third parameter for placement
				
				
				//places the head of the ship at set co-ordinates specified by the user
				int userShipStartingLocation = BSM.toArrayIndex(userY, userX);
				
				System.out.println("Please enter the direction you wish to place the ship(1-Down,2-Right,3-Up Right,4-Down Right");
				int userDirection = userIn.nextInt();
				//Take some direction
				Direction direction = null;
				switch (userDirection) {
		        case 1: direction = Direction.DOWN;
		           break;
		        case 2: direction = Direction.RIGHT;
		        	break;
		        case 3: direction = Direction.UPRIGHT;
		        	break;
		        case 4: direction = Direction.DOWNRIGHT;
		        	break;
				}//end switch case
				
				
				switch (i) {//places ship at the set location
		        case 0: 
		        	BSM.createPlayer1AC(userShipStartingLocation, direction);
		        	//do while !legal
		        		//BSM.player1AC.placeBoat(userShipStartingLocation);
		        	//
		            break;
		        case 1: 
		        	BSM.createPlayer1BS(userShipStartingLocation, direction);
		        	break;
		        case 2: 
		        	BSM.createPlayer1C(userShipStartingLocation, direction);
		        	break;
		        case 3: 
		        	BSM.createPlayer1D1(userShipStartingLocation, direction);
		        	break;
		        case 4: 
		        	BSM.createPlayer1D2(userShipStartingLocation, direction);
	        	break;
				}//end switch case
				
				//BSM.createPlayer1AC(userShipStartingLocation, direction);
				//System.out.print(BSM.getPlayer1Placement());
				for(int j = 0; j< BSM.player1AC.size; j++)
				{
					System.out.println(BSM.player1AC.position[j]);
				}
				for(int k = 0; k< 101; k++)
				{
				
					System.out.println("board Position #"+k +" : "+ BSM.player1DefensePrint[k]);
				}
			//}//end while loop (used to check if valid move
		}//end for loop
		
		
		
		/**************************************|||||*******************************/
		
		//player two
				for(int i=0;i<5;i++){//user loops through 5 times to place all ships.
					
					//while(true){//add isValid() && noShips()
					System.out.println("Player 2's turn.....");
					System.out.println("You will place your ships in this order,\n#1-Aircraft Carrier(length of 5), \n"
							+ "#2-BattleCruiser(length of 4),\n#3-Carrier(length of 3),\n#4 Destroyer#1(length of 2)"
							+ "\n#5 Destroyer#2(length of 2)");
					System.out.println("\n\nPlease place ship #" + (i+1));
					//first parameter for placement
					System.out.println("Please enter your Y co-ordinate(vertical)");
					char userY = userIn.next().charAt(0);
					
					//second parameter for placement
					System.out.println("Please enter your X co-ordinate(horizontal 1-10)");
					int userX = userIn.nextInt();
					
					//third parameter for placement
					
					
					//places the head of the ship at set co-ordinates specified by the user
					int userShipStartingLocation = BSM.toArrayIndex(userY, userX);
					
					System.out.println("Please enter the direction you wish to place the ship(1-Down,2-Right,3-Up Right,4-Down Right");
					int userDirection = userIn.nextInt();
					//Take some direction
					Direction direction = null;
					switch (userDirection) {
			        case 1: direction = Direction.DOWN;
			           break;
			        case 2: direction = Direction.RIGHT;
			        	break;
			        case 3: direction = Direction.UPRIGHT;
			        	break;
			        case 4: direction = Direction.DOWNRIGHT;
			        	break;
					}//end switch case
					
					
					switch (i) {//places ship at the set location
			        case 0: 
			        	BSM.createPlayer2AC(userShipStartingLocation, direction);
			        	//do while !legal
			        		//BSM.player1AC.placeBoat(userShipStartingLocation);
			        	//
			            break;
			        case 1: 
			        	BSM.createPlayer2BS(userShipStartingLocation, direction);
			        	break;
			        case 2: 
			        	BSM.createPlayer2C(userShipStartingLocation, direction);
			        	break;
			        case 3: 
			        	BSM.createPlayer2D1(userShipStartingLocation, direction);
			        	break;
			        case 4: 
			        	BSM.createPlayer2D2(userShipStartingLocation, direction);
		        	break;
					}//end switch case
					
					//BSM.createPlayer1AC(userShipStartingLocation, direction);
					//System.out.print(BSM.getPlayer1Placement());
					for(int j = 0; j< BSM.player2AC.size; j++)
					{
						System.out.println(BSM.player2AC.position[j]);
					}
					for(int k = 0; k< 101; k++)
					{
					
						System.out.println("board Position #"+k +" : "+ BSM.player2DefensePrint[k]);
					}
					//}//end while loop (used to check if valid move
				}//end for loop
		
		
		/**************************************|||||*******************************/
		
		//Example of creating AircraftCarrier for player 1 after taking input and validating
		//BSM.createPlayer1AC(inputExample, down);
	}//end setUp()
	
	/*
	* Player ship placement validation some helper method to check boundaries,
	* check if placement is legal
	*/
	public void placementValidation(char row, int column, Direction direct){
		
		
		
	}

	/*
	* Displays the rules of the game.
	*/
	public void printRules(){
		System.out.print(BSM.rules());
	}
	
	
	public boolean areCoordinatesValid(String str)
    {
        
        boolean isValidLetter=false;
        boolean isValidNumber=false;
        
        //change users input to upper case for validation test
        char row = str.toUpperCase().charAt(0);
        
        //test for letter
        if (row =='A' || row =='B' || row =='C' || row =='D' || row =='E' || row =='F' ||
                row =='G' || row =='H' || row =='I' || row =='J')
        {
            System.out.println(" true test coordinates are " +str.charAt(0)+str.charAt(1));
            isValidLetter=true;
            System.out.println("Letter is valid");
        }else{
            throw new IllegalArgumentException("Column input is not a letter.");
        }
        
        //test for number
        if (str.length()==3)
        {//user is on the 10th column
            char c1 = str.charAt(1);
            char c2 = str.charAt(2);
            if (Character.isDigit(c1) && Character.isDigit(c2) )
            {//both inputs are numbers
                if(c1 == '1' && c2 == '0')
                {//only 10 is a valid entry
                    isValidNumber= true;
                    System.out.println("Number is valid");
                }else{
                    throw new IllegalArgumentException("Row input too high/low.");
                }
            }else{
                throw new IllegalArgumentException("Row input is not a number.");
            }
        }
        //test for number
        if (str.length()==2)
        {//all other columns from 1-9
            char c1 = str.charAt(1);
            if (Character.isDigit(c1)){
                int validateXCoordiante = str.charAt(1);
                if(validateXCoordiante >='1' || validateXCoordiante <='9'){
                    isValidNumber= true;
                    System.out.println("Number is valid");
                }else{
                    throw new IllegalArgumentException("Row input too high/low.");
                }
            }else{
                throw new IllegalArgumentException("Row input is not a number.");
            }
        }

        return isValidLetter && isValidNumber;
    }

	
	
}