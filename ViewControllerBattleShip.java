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
		for(int i=0;i<5;i++){//user loops through 5 times to place all ships.
			
			//while(true){//add isValid()
				System.out.println("You will place your ships in this order,\nAircraft Carrier(length of 5), \n"
						+ "BattleCruiser(length of 4),\nCarrier(length of 3),\nTwo Destroyers(each a length of 2)");
				//first parameter for placement
				System.out.println("Please enter your Y co-ordinate(vertical)");
				char userY = userIn.next().charAt(0);
				
				//second parameter for placement
				System.out.println("Please enter your X co-ordinate(horizontal 1-10)");
				int userX = userIn.nextInt();
				
				//third parameter for placement
				System.out.println("Please enter the direction you wish to place the ship(1-Down,2-Right,3-Up Right,4-Down Right");
				int userDirection = userIn.nextInt();
				
				//places the head of the ship at set co-ordinates specified by the user
				int userShipStartingLocation = BSM.toArrayIndex(userY, userX);
				
				
				//Take some direction
				Direction direction = Direction.RIGHT;
				switch (userDirection) {
		        case '1': direction = Direction.DOWN;
		           break;
		        case '2': direction = Direction.RIGHT;
		        	break;
		        case '3': direction = Direction.UPRIGHT;
		        	break;
		        case '4': direction = Direction.DOWNRIGHT;
		        	break;
				}//end switch case
				
				
				switch (i) {//places ship at the set location
		        case '0': BSM.createPlayer1AC(userShipStartingLocation, direction);
		        	
		           break;
		        case '1': BSM.createPlayer1BS(userShipStartingLocation, direction);
		        	break;
		        case '2': BSM.createPlayer1C(userShipStartingLocation, direction);
		        	break;
		        case '3': BSM.createPlayer1D1(userShipStartingLocation, direction);
		        	break;
		        case '4': BSM.createPlayer1D2(userShipStartingLocation, direction);
	        	break;
				}//end switch case
				
				displayPlayer1Placement();
			//}//end while loop (used to check if valid move
		}//end for loop
		
		//Example of creating AircraftCarrier for player 1 after taking input and validating
		//BSM.createPlayer1AC(inputExample, down);
	}//end setUp()
	
	/*
	* Player ship placement validation some helper method to check boundaries,
	* check if placement is legal
	*/
	public void placementValidation(char row, int column, Direction direct){
		
		
		
	}

}