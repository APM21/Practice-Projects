/**
   InvalidEmployeeNumber exceptions are thrown by Employee class when an invalid 
   employee number is passed to the constructor. 
*/
public class InvalidEmployeeNumber extends Exception
{
   public InvalidEmployeeNumber(String employeeNum)
   {
      super("ERROR: " + employeeNum + " is an invalid employee number."); 
   }  
}