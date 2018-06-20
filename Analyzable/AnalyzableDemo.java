/**
   This program demonstrates the CourseGrades class, which implements the 
   Analyzable interface.  
**/

public class AnalyzableDemo 
{
   public static void main(String[] args) 
   {
      CourseGrades grades = new CourseGrades(); 
      
      GradedActivity lab = new GradedActivity(); 
      
      lab.setScore(75);
      
      PassFailExam exam1 = new PassFailExam(10, 2, 70); 
      
      Essay essay = new Essay(25, 18, 20, 22); 
      
      FinalExam finalExam = new FinalExam(50, 3); 
      
      grades.setLab(lab);
      grades.setPassFailExam(exam1);
      grades.setEssay(essay); 
      grades.setFinalExam(finalExam); 
      
      System.out.println(grades);
      
      GradedActivity highest = grades.getHighest();
      GradedActivity lowest = grades.getLowest(); 
      
      System.out.printf("Average: %.1f%n" + 
                        "Highest: %.1f%n" + 
                        "Lowest: %.1f%n", grades.getAverage(), highest.getScore(),
                        lowest.getScore()); 
   }
}
