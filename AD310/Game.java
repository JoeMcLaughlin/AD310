 

public class Game {
	public static void main(String[] args){
		BattleShipModel player1 = new BattleShipModel();
		BattleShipModel player2 = new BattleShipModel();
		ViewControllerBattleShip viewControl1 = new ViewControllerBattleShip(player1);
		ViewControllerBattleShip viewControl2 = new ViewControllerBattleShip(player2);
		
		//prints rules for setting up defensive boards for both players
		System.out.println("Player One PLACE YOUR SHIPS!");
		viewControl1.printSetupRules(player1);
		viewControl1.setUp(player1);
		System.out.println("Player Two PLACE YOUR SHIPS!");
		viewControl2.printSetupRules(player2);
		viewControl2.setUp(player2);
		
		//prints rules for the play mode
		viewControl1.printPlayRules();
		boolean isGameOver = false;
		boolean player1Turn = true;
		boolean check = true;
		while (isGameOver == false) {
		    if (player1.isGameOver() == true || player2.isGameOver() == true) {
		        isGameOver = true;
		      }

		    if ( player1Turn == true ) {
		        System.out.println("Player One Attack!");
		        player1Turn = viewControl1.attack(player1, player2);
		        isGameOver = player2.isGameOver();
		      }

		    if ( player1Turn == false ) {
		        System.out.println("Player Two Attack!");
		        player1Turn = !viewControl2.attack(player2, player1);
		        isGameOver = player1.isGameOver();
		      }
		}
		if (player1.isGameOver() == true) {
		    System.out.println("PLAYER TWO IS THE WINNER!");
		}
		if (player2.isGameOver() == true) {
		    System.out.println("PLAYER ONE IS THE WINNER!");
		  }
		
	}
	

}