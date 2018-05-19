/**
   The CruiseShip class holds general data about a cruise ship. 
**/

public class CruiseShip extends Ship
{
   private int maxPassengers; //Max number of passengers 
   
   /**
      The constructor sets the name of the ship, the year built, and the max 
      number of passengers. 
      @param shipName The name of the ship. 
      @param yearBuilt The year built. 
      @param max The max number of passengers.
   **/
   
   public CruiseShip(String shipName, String yearBuilt, int max)
   {
      super(shipName, yearBuilt);   
      maxPassengers = max; 
   } 
   
   /**
      The setMaxPassengers sets the max number of passengers. 
      @param max The max number of passsengers. 
   **/
   
   public void setMaxPassengers(int max)
   {
      maxPassengers = max; 
   }
   
   /**
      The getMaxPassengers returns the max number of passengers.
      @return The max number of passengers. 
   **/
   
   public int getMaxPassengers()
   {
      return maxPassengers; 
   }
   
   /**
      The toString method returns a string containing cruise ship information.
      @return Cruise ship info. 
   **/
   
   @Override
   public String toString()
   {
      String str = String.format("Ship Name: %s%n" +  
                                 "Max Passengers: %,d ", 
                                getShipName(), maxPassengers); 
      
      return str; 
   }
}