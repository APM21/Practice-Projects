import java.io.*;

/**
   This program opens a binary file, writes the contents of an int array to the 
   file and then reads the file and prints out the contents from an int array. 
*/
public class FileArrayDemo
{
   public static void main(String[] args) throws IOException 
   {
      //Creates FileArray object
      FileArray file1 = new FileArray();
      
      //An array to write into the file
      int[] nums = {1,2,3,4,5,6}; 
      
      //An array to store the file contents 
      int[] inputs = new int[nums.length];   
      
      //Write contents
      file1.writeArray("Numbers.txt", nums); 
      
      //Read and display contents
      file1.readArray("Numbers.txt", inputs);  
      
   }
}