import java.io.*;

   /**
      This class writes numbers into a file and reads numbers from a file using an int array. 
   */
public class FileArray
{
   /**
      writeArray method writes the contents of an int array into a binary file. 
      @param fileName The file.
      @param array An int array. 
      @exception IOException When file cannot be found.  
   */
   static void writeArray(String fileName, int[] array) throws IOException
   {  
      //Create the binary output objects 
      FileOutputStream fstream = new FileOutputStream(fileName); 
      DataOutputStream outputFile = new DataOutputStream(fstream);
      
      System.out.println("...Wrtitng contents...");
      
      //Write array elements into the file 
      for (int i = 0; i < array.length; i++) 
      {
         outputFile.writeInt(array[i]);
      }
      
      System.out.println("Done.");
      
      //Close file
      outputFile.close();
   }
   
   /**
      readArray method reads the contents of the binary file and stores into an 
      array. 
      @param fileName The file. 
      @param array An int array.
      @exception IOException When file cannot be found.  
   */
   static void readArray(String fileName, int[] array) throws IOException
   {
      boolean endOfFile = false;//EOF flag 
      int index = 0, num; //Array index and number read from the file  
      
      //Create the binary input objects  
      FileInputStream fstream = new FileInputStream(fileName); 
      DataInputStream inputFile = new DataInputStream(fstream); 
      
      System.out.println("...Reading contents..."); 
      
      //Read contents of file 
      while (!endOfFile)
      {
         try
         {
            num = inputFile.readInt();
            array[index] = num; 
            index++;      
         }
         
         catch (EOFException error)
         {
            endOfFile = true; 
         }
      }
      
      //Close the file 
      inputFile.close(); 
      
      //Display the numbers read from the file 
      for(int number: array)
         System.out.print(number + " "); 
          
   }
}
