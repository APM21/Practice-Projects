/**
   This class holds grades of graded activities, exams and essays. 
*/

public class CourseGrades extends GradedActivity implements Analyzable 
{
   private GradedActivity[] grades = new GradedActivity[4]; //Numeric scores 
   
/**
   The setLab method sets the first element of the grades array. 
   @param lab The lab score.   
*/

   public void setLab(GradedActivity lab)
   {
      grades[0] = lab;   
   } 

/**
   The setPassFailExam method sets the second element of the grades array.
   @param passFail The exam score. 
*/ 
  
   public void setPassFailExam(PassFailExam passFail)
   {
      grades[1] = passFail; 
   }

/**
   The setEssay method sets the third element of the grades array.
   @param essay The essay score. 
*/
 
   public void setEssay(Essay essay)
   {
      grades[2] = essay; 
   }

/**
   The setFinalExam method sets the fourth element of the grades array.
   @param exam The final exam score. 
*/
   
   public void setFinalExam(FinalExam exam)
   {
      grades[3] = exam;
   }

/**
   The toString method returns a String containing grades information. 
   @return Grades info.
*/
   
   public String toString()
   {
      String str = String.format("Lab Score: %.1f%n" +  
                                 "Pass/Fail Exam: %.1f%n" + 
                                 "Essay Score: %.1f%n" + 
                                 "Final Exam Score: %.1f%n", grades[0].getScore(), 
                                 grades[1].getScore(), grades[2].getScore(), 
                                 grades[3].getScore());
      return str;     
   }
   
/**
   The getAverage method returns the average of the grades.
   @return Average of the grades from the grades array.
*/
   
   public double getAverage()
   {
      double average; 
      
      average = (grades[0].getScore() + grades[1].getScore() + 
                 grades[2].getScore() + grades[3].getScore()) / grades.length;
      
      return average;  
   }
   
/**
   The getHighest method returns the grade with the highest score.
   @return The highest grade from the grades array. 
*/

   public GradedActivity getHighest()
   {
      double highest = grades[0].getScore(); 
      int index = 0; 
      
      for (int i = 1; i < grades.length; i++)
      {
         if (grades[i].getScore() > highest)
            index = i;    
      }
      
      return grades[index];    
   }

/**
   The getLowest method returns the grade with the lowest score. 
   @return The lowest grade from the grades array. 
*/
   
   public GradedActivity getLowest()
   {
      double lowest = grades[0].getScore(); 
      int index = 0; 
      
      for (int i = 1; i < grades.length; i++) 
      {
         if (grades[i].getScore() < lowest) 
            index = i; 
      }
      
      return grades[index]; 
   }
     
}