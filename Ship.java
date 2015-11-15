package ad310_Group;

//I'm not sure aobut this as the best way to organize creation of ship objects
//Anyone have an opinion?
//I also dunno inner vs. outer class?
/**
* Ship class will be used to create the various ship objects
*/
public abstract class Ship {
    //for ship objects since they will all inherit similar behavior
    //not sure how Brandon is structuring this, but seemed like making an interface or an abstract
    //class here could cut down the total amount of code?
    //I might be missing some functionality here
    int[] location;
    boolean[] status;
    public boolean isSunk;
    public boolean isHit;
    public int getIndex;
    public int setIndex;
    
    /**
    * Different classes for different types of ships
    */
   public class AircraftCarrier extends Ship {};    
   public class Battleship extends Ship{};
   public class Cruiser extends Ship{};
   public class Destroyer extends Ship{};
}

