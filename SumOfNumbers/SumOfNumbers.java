import java.util.Scanner; 

/**
   This program demonstrates the sum of all integers from 1 up to selected number.
*/
public class SumOfNumbers 
{
   public static void main(String[] args)
   {
      int num, sum; //Selected number and the sum of integers 
      
      //Create Scanner object for keyboard input
      Scanner keyboard = new Scanner(System.in); 
                                                
      //Retrieves selected integer
      System.out.print("Enter integer: "); 
      num = keyboard.nextInt();
      
      //Finds the sum of numbers 
      sum = sumOfNumbers(num);
      
      //Prints out the sum 
      System.out.println("The sum of all integers from 1 to " + num + " is " + 
                         sum + ".");
   }
/**
   sumOfNumbers method calculates the sum of all integers from 1 up to selected 
   number.
   @param number Selected number. 
   @return The sum of all integers from 1 to number. 
*/
   public static int sumOfNumbers(int number)
   {
      if (number == 1) 
         return 1; 
      else 
         return number + sumOfNumbers(number - 1);  
   }
}