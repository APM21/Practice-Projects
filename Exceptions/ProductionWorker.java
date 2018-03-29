/**
   This class holds data for a production worker. 
*/
public class ProductionWorker extends Employee 
{
   private int shift; //day or night shift
   private double payRate; //pay rate 
   
   /**
      This constructor sets the worker's name, the worker's ID number, the hiring
      date, the worker's shift and worker's pay.
      @param name Worker's name. 
      @param num Worker's ID number. 
      @param date Hiring date. 
      @param dayNight Worker's shift. 
      @param pay Worker's pay. 
      @exception InvalidShift When a number besides 1 or 2 is chosen.
      @exception InvalidEmployeeNumber When employee's ID number does not meet the 
                 requirements. 
      @exception InvalidPayRate When the selected employee's pay rate is negative.  
   */ 
   
   public ProductionWorker(String name, String num, String date, 
                           int dayNight, double pay) throws InvalidShift,
                                                            InvalidEmployeeNumber, 
                                                            InvalidPayRate
   {
      //Call the superclass constructor
      super(name, num, date);
      
      if (dayNight == 1 || dayNight == 2)
         shift = dayNight;
      else 
         throw new InvalidShift(); 
      
      if (pay >= 0)
         payRate = pay;
      else 
         throw new InvalidPayRate(); 
   }
   
   /**
      The setShift method sets the worker's shift. 
      @param dayNight Worker's shift. 
      @exception InvalidShift When a number besides 1 or 2 is selected.      
   */
   
   public void setShift(int dayNight) throws InvalidShift
   {
      if (dayNight == 1 || dayNight == 2)
         shift = dayNight;
      else 
         throw new InvalidShift();
   }
   
   /**
      The setPayRate method sets the worker's pay rate. 
      @param pay Worker's pay. 
      @exception InvalidPayRate When the pay rate is negative. 
   */
   
   public void setPayRate(double pay) throws InvalidPayRate
   {
      if (pay >= 0)
         payRate = pay;
      else 
         throw new InvalidPayRate(); 
   }
   
   /**
      The getShift method returns the worker's shift.
      @return Worker's shift. 
   */
   
   public int getShift()
   {
      return shift;
   }
   
   /**
      The getPayRate method returns the worker's pay rate. 
      @return Worker's pay rate. 
   */
   
   public double getPayRate()
   {
      return payRate;
   }
}