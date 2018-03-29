/**
   This class holds data for an employee. 
*/

public class Employee 
{
   private String employeeName; //name of the employee
   private String employeeNum; //employee ID number
   private String hireDate; //hire date  
   
   /**
      This constructor sets employee's name, ID number and hire date.
      @param name The employee's name. 
      @param num The employee's ID number. 
      @param date Hire date.
      @exception InvalidEmployeeNumber When employee's ID number does not meet the 
                 requirements. 
   */
   public Employee(String name, String num, String date) throws 
                                                         InvalidEmployeeNumber
   {
      //Set employeeName and hireDate fields
      employeeName = name;
      hireDate = date; 
      
      if ((Character.isDigit(num.charAt(0)) && 
           Character.isDigit(num.charAt(1)) &&
           Character.isDigit(num.charAt(2)) && 
           num.charAt(3) == '-' && 
           (Character.isUpperCase(num.charAt(4)) && 
            (num.charAt(4) == 'A' || num.charAt(4) == 'B' || num.charAt(4) == 'C' ||
             num.charAt(4) == 'D' || num.charAt(4) == 'E' || num.charAt(4) == 'F' ||
             num.charAt(4) == 'G' || num.charAt(4) == 'H' || num.charAt(4) == 'I' ||
             num.charAt(4) == 'J' || num.charAt(4) == 'K' || num.charAt(4) == 'L' ||
             num.charAt(4) == 'M'))))
      {
      
      employeeNum = num;
      
      }
      else
         throw new InvalidEmployeeNumber(num);       
   }
   
   /**
      The setEmployeeName method sets the name of the employee.
      @param name The name of the employee.  
   */
   public void setEmployeeName(String name)
   {
      employeeName = name; 
   }
   
   /**
      The setEmployeeNumber method sets the employee ID number.
      @param num Employee ID number. 
   */
   public void setEmployeeNumber(String num) throws InvalidEmployeeNumber
   {
      if ((Character.isDigit(num.charAt(0)) && 
           Character.isDigit(num.charAt(1)) &&
           Character.isDigit(num.charAt(2)) && 
           num.charAt(3) == '-' && 
           (Character.isLetter(num.charAt(4)) && 
            Character.isUpperCase(num.charAt(4)) && 
            (num.charAt(4) == 'A' || num.charAt(4) == 'B' || num.charAt(4) == 'C' ||
             num.charAt(4) == 'D' || num.charAt(4) == 'E' || num.charAt(4) == 'F' ||
             num.charAt(4) == 'G' || num.charAt(4) == 'H' || num.charAt(4) == 'I' ||
             num.charAt(4) == 'J' || num.charAt(4) == 'K' || num.charAt(4) == 'L' ||
             num.charAt(4) == 'M'))))
      {
      
      employeeNum = num;
      
      }
      else
         throw new InvalidEmployeeNumber(num); 
   }
   /**
      The setHireDate method sets the hiring date of the employee. 
      @param date The hiring date. 
   */
   public void setHireDate(String date)
   {
      hireDate = date;
   }
   
   /**
      The getEmployeeName method returns the name of the employee. 
      @return The name of the employee. 
   */
   public String getEmployeeName()
   {
      return employeeName; 
   }
   
   /**
      The getEmployeeNumber method returns the employee's ID number. 
      @return The employee's ID number. 
   */
   public String getEmployeeNumber()
   {
      return employeeNum; 
   }
   
   /**
      The getHireDate method returns the employee's hiring date. 
      @return The hiring date. 
   */
   public String getHireDate()
   {
      return hireDate;
   }   
   
}