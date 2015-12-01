package ad310_Group;

public class Game {
	public static void main(String[] args){
		ViewControllerBattleShip theViewController = new ViewControllerBattleShip();
		BattleShipModel theModel = new BattleShipModel();
		
		
		theViewController.printRules();
		theViewController.displayPlayer1Placement();
		theViewController.setUp();
		theViewController.shot();
		
	}
}