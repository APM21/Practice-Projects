/**
   The Ship class holds general data about a ship. Classes representing specific
   types of ships should inherit from this class.  
**/

public class Ship 
{
   private String shipName; //Name of the ship 
   private String yearBuilt; //The year the ship was built 
      
   /**
      The constructor sets the name of the ship and the year it was built.
      @param name The ship name. 
      @param year The year built. 
   **/
   
   public Ship(String name, String year)
   {  
      shipName = name; 
      yearBuilt = year; 
   } 
   
   /**
      The setName method sets the name of the ship. 
      @param name The ship name.
   **/
   
   public void setName(String name)
   {
      shipName = name;   
   }
   
   /**
      The setYear method sets the year the ship was built.
      @param year The year built.
   **/
   
   public void setYear(String year) 
   {
      yearBuilt = year; 
   }
   
   /**
      The getShipName method returns the name of the ship.
      @return The ship name. 
   **/
   
   public String getShipName()
   {
      return shipName;
   }
   
   /**
      The getYear method returns the year it was built.
      @return The year built.
   **/
   
   public String getYear()
   {
      return yearBuilt; 
   }
   
   /**
      The toString method returns a string containing ship information.
      @return Ship info.
   **/
   
   public String toString()
   {
      String str = "Ship Name: " + shipName + "\n" + 
                   "Year Built: " + yearBuilt; 
                   
      return str;
   }
}