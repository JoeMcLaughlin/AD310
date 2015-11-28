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
		
		System.out.println("Please enter your X co-ordinate(horizontal)");
		//Take some input and convert it
		int userX = userIn.nextInt();
		
		System.out.println("Please enter your Y co-ordinate(vertical)");
		char userY = userIn.next().charAt(0);
		
		int inputExample = BSM.toArrayIndex(userY, userX);
		
		//Take some direction
		Direction down = Direction.DOWN;
		
		//input validation goes here
		
		//Example of creating AircraftCarrier for player 1 after taking input and validating
		BSM.createPlayer1AC(inputExample, down);
	}
	
	/*
	* Player ship placement validation some helper method to check boundaries,
	* check if placement is legal
	*/
	public void placementValidation(){
		
	}

}