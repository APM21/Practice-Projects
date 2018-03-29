/**
   InvalidPayRate exceptions are thrown by ProductionWorker class when a negative
   pay rate is passed into the constructor or the setPayRate method.  
*/
public class InvalidPayRate extends Exception 
{
   public InvalidPayRate()
   {
      super("ERROR: Pay rate is negative."); 
   }
}