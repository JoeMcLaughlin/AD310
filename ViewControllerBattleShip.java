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
		
		
		for(int i=0;i<=5;i++){//user loops through 5 times to place all ships.
			
			//while(true){//add isValid() && noShips()
				System.out.println("You will place your ships in this order,\nAircraft Carrier(length of 5), \n"
						+ "BattleCruiser(length of 4),\nCarrier(length of 3),\nTwo Destroyers(each a length of 2)");
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
		        		BSM.player1AC.placeBoat(userShipStartingLocation);
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
				System.out.print(BSM.player1AC.direct);
				for(int j = 0; j< BSM.player1AC.size; j++)
				{
				
					System.out.println(BSM.player1AC.position[j]);
				}
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

	/*
	* Displays the rules of the game.
	*/
	public void printRules(){
		System.out.print(BSM.rules());
	}
	
	
	//helper input validation method for attack above
    public boolean areCoordinatesValid(String str)
    {boolean isValidLetter=false;
        boolean isValidNumber=false;
        if (str.charAt(0) =='A' || str.charAt(0) =='B' ||
        str.charAt(0) =='C' || str.charAt(0) =='D' ||
        str.charAt(0) =='E' || str.charAt(0) =='F' ||
        str.charAt(0) =='G' || str.charAt(0) =='H' ||
        str.charAt(0) =='I' || str.charAt(0) =='J')
        {System.out.println(" true test coordinates are " +str.charAt(0)+str.charAt(1));
            isValidLetter=true;
            System.out.println("Letter is valid");}

        if ((str.length()==3 && str.charAt(1)=='1' && str.charAt(2)=='0') ||
        (str.length()==2 && (str.charAt(1) =='1' || str.charAt(1) =='2' ||  
                str.charAt(1) =='3' || str.charAt(1) =='4' ||
                str.charAt(1) =='5' || str.charAt(1) =='6' ||
                str.charAt(1) =='7' || str.charAt(1) =='8' ||
                str.charAt(1) =='9')))
        {isValidNumber= true;
            System.out.println("Number is valid");}

        return isValidLetter && isValidNumber;

    }
	
	
}