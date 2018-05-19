/**
   The CargoShip class holds general data about a cargo ship.
**/

public class CargoShip extends Ship 
{
   private int cargoCapacity; //capacity of cargo currently held
   
   /**
      The constructor sets the name of the ship, the year built and the capacity 
      of the cargo. 
      @param shipName The name of the ship. 
      @param yearBuilt The year built. 
      @param capacity The capacity of cargo in tons. 
   **/
   
   public CargoShip(String shipName, String yearBuilt, int capacity)
   {
      super(shipName, yearBuilt); 
      cargoCapacity = capacity; 
   }
   
   /**
      The setCargoCapacity method sets the capacity of cargo.
      @param capacity The capacity of cargo in tons. 
   **/
   
   public void setCargoCapacity(int capacity)
   {
      cargoCapacity = capacity; 
   }
   
   /**
      The getCargoCapacity method returns the capacity of cargo. 
      @return The capacity of cargo in tons. 
   **/
   
   public int getCargoCapacity()
   {
      return cargoCapacity; 
   }
   
   /**
      The toString method returns a String containing cargo ship information.
      @return Cargo ship info.
   **/
   
   @Override
   public String toString()
   {
      String str =  String.format("Ship Name: %s%n" +  
                                  "Cargo Capacity: %,d tons ", 
                                  getShipName(), cargoCapacity); 
                   
      return str;  
   }
}