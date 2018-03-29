/**
   InvalidShift exceptions are thrown by ProductionWorker class when a number
   besides 1 or 2 is passed into the constructor or the setShift method.  
*/
public class InvalidShift extends Exception
{
   public InvalidShift()
   {
      super("ERROR: Invalid shift number. Enter 1 (day) or 2 (night).");
   }
}