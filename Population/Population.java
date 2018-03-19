import java.util.Scanner; 

/**
   This program demonstrates the prediction of the size of a population of 
   organisms after a number of days. 
*/
public class Population 
{
   public static void main(String[] args)
   {
      //Initial population, number of days, total population  
      int startPop, days, totalPop;
      double increase; //average daily population increase as a percentage  
      
      //Creates Scanner Object
      Scanner keyboard = new Scanner(System.in);
      
      do 
      {
         //Retrieves initial population
         System.out.print("Enter starting size of population: "); 
         startPop = keyboard.nextInt(); 
      } while (startPop < 2);
      
      do 
      {
         //Retrieves percentage average daily population increase
         System.out.print("Enter percentage average daily population increase: ");
         increase = keyboard.nextDouble(); 
      } while (increase < 0);
      
      do 
      {
         //Retrieves number of days
         System.out.print("Enter number of days they will multiply: ");
         days = keyboard.nextInt(); 
      } while (days < 1);
      
      //Finds total population 
      int total = calculateTotalPop(startPop, increase, days);
      
      //Prints out total population
      System.out.println(total);
   } 
/** 
   The calculateTotalPop method calculates the total population. 
   @param pop Initial population. 
   @param percent Average daily increase. 
   @param numOfDays Number of days. 
   @return The total population.   
*/   
   public static int calculateTotalPop(int pop, double percent, int numOfDays)
   {
      if (numOfDays > 0)
      {
         pop *= (1 + (percent / 100));
         return calculateTotalPop(pop, percent, numOfDays - 1);
      } 
      
      else 
         return pop; 
   } 
}