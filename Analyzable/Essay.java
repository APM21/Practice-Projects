/**
   This class holds the score components of an essay and determines the total essay
   score.   
**/

public class Essay extends GradedActivity
{
   private double grammarScore; //Grammar 
   private double spellingScore; //Spelling
   private double lengthScore; //Length of essay 
   private double contentScore; //Content
   private double totalScore; //Total  
   
/**
   The constructor sets the grammar, spelling, length and content scores and 
   determines the total essay score.
   @param grammar Grammar score. 
   @param spelling Spelling score. 
   @param length Length score. 
   @param content Content score.  
**/
   
   public Essay(double grammar, double spelling, double length, 
                double content)
   {
      grammarScore = grammar; 
      spellingScore = spelling; 
      lengthScore = length; 
      contentScore = content;
      
      totalScore = grammarScore + spellingScore + lengthScore + contentScore;
      
      setScore(totalScore); 

   }
   
/**
   The setGrammarScore method sets the grammar score if it is within the range of 
   0-30.
   @param grammar Grammar score. 
**/   
   
   public void setGrammarScore(double grammar)
   {
      if (grammar < 0 || grammar > 30)
         System.out.println("Invalid. Grammar score range is 0-30 points.");
      else 
         grammarScore = grammar;
   }

/**
   The setSpellingScore method sets the spelling score if it is within the range 
   of 0-20.
   @param spelling Spelling score. 
**/   
   
   public void setSpellingScore(double spelling)
   {
      if (spelling < 0 || spelling > 20)
         System.out.println("Invalid. Spelling score range is 0-20 points.");
      else 
         spellingScore = spelling;
   }

/**
   The setLengthScore method sets the length score if it is within the range of 
   0-20.
   @param length Length score.
**/
   
   public void setLengthScore(double length)
   {
      if (length < 0 || length > 20) 
         System.out.println("Invalid. Length score range is 0-20 points.");
      else  
         lengthScore = length; 
   }
   
/**
   The setContentScore method sets the content score if it is in the range of 
   0-30.
   @param content Content score.
**/
   
   public void setContentScore(double content)
   {
      if (content < 0 || content > 30)
         System.out.println("Invalid. Content score range is 0-30 points.");
      else 
         contentScore = content; 
   }

/**
   The getGrammarScore gets the value of the grammar score. 
**/
   
   public double getGrammarScore()
   {
      return grammarScore;
   }

/**
   The getSpellingScore gets the value of the spelling score. 
**/
   
   public double getSpellingScore()
   {
      return spellingScore;
   }

/**
   The getLengthScore gets the value of the length score. 
**/
   
   public double getLengthScore()
   {
      return lengthScore;
   }

/**
   The getContentScore gets the value of the content score. 
**/
   
   public double getContentScore()
   {
      return contentScore;
   }

/**
   The calcTotalScore method calculates the total essay score and calls the 
   setScore method from the GradedActivity class if the score is in the range of 
   0-100. 
**/
   
   public void calcTotalScore()
   {
      totalScore = grammarScore + spellingScore + lengthScore + contentScore;
      
      if (totalScore > 100)
      { 
         System.out.println("Invalid. Total score is greater than 100.");                          
      }
      
      else if (totalScore < 0)
      {
         System.out.println("Invalid. Total score is less than 0."); 
      }
      
      else
         setScore(totalScore);
   }  
}