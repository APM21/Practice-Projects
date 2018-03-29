/**
   This class demonstrates the exceptions thrown by the Employee and 
   ProductionWorker classes respectively. 
*/
public class ExceptionProjectDemo
{
   public static void main(String[] args) throws Exception
   {
      try
      {
         Employee employee1 = new Employee("Adam Lallana", "323-P", "10/8/2015");
      }
      catch (InvalidEmployeeNumber e) 
      {
         System.out.println(e.getMessage());   
      }
      
      try
      {
         ProductionWorker worker1 = new ProductionWorker("Adam Lallana", 
         "323-A", "10/8/2015", 3, 22.50);
      }
      catch (InvalidShift e) 
      {
         System.out.println(e.getMessage());   
      }
      
      try
      {
         ProductionWorker worker1 = new ProductionWorker("Adam Lallana", 
         "323-A", "10/8/2015", 2, -22.50);
      }
      catch (InvalidPayRate e) 
      {
         System.out.println(e.getMessage());   
      }
      
      try
      {
         ProductionWorker worker1 = new ProductionWorker("Adam Lallana", 
         "323-P", "10/8/2015", 2, -22.50);
      }
      catch (InvalidPayRate e) 
      {
         System.out.println(e.getMessage());   
      }
   }
}