/**
   This program demonstrates polymorphism and inheritance using the Ship, 
   CruiseShip, and CargoShip classes.  
**/

public class ShipDemo
{
   public static void main(String[] args)
   {
      Ship[] shipArray = new Ship[4];
      
      shipArray[0] = new Ship("Santa Maria", "1460"); 
      shipArray[1] = new CruiseShip("Royal Princess", "2013", 3600); 
      shipArray[2] = new CargoShip("Colombo Express", "2005", 93750); 
      shipArray[3] = new CargoShip("Emma Mersk", "2006", 170794);
      
      for (int i = 0; i < shipArray.length; i++)
      {
         System.out.println(shipArray[i]);
         
         System.out.println(); 
      } 
   } 
}