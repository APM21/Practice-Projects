import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 

/**
   The CelsiusToFahrenheit class demonstrates the conversion of Celsius to Fahrenheit.
*/

public class CelsiusToFahrenheit extends JFrame
{
   private JPanel panel1; //Celsius section 
   private JPanel panel2; //Fahrenheit section 
   private JLabel celsiusLabel; //Celsius title 
   private JTextField celsiusTextField; //Holds selected Celsius
   private JLabel fahrenheitLabel; //Fahrenheit title  
   private JButton calcButton; //Calculates Fahrenheit 
   private final int WINDOW_WIDTH = 300; //Sets width of window 
   private final int WINDOW_HEIGHT = 250; //Sets height of window
   
   /**
      Constructor 
   */
   
   public CelsiusToFahrenheit()
   {
      //Set the title
      setTitle("Celsuis To Fahrenheit"); 
      
      //Add BorderLayout manager to the content pane 
      setLayout(new BorderLayout()); 
      
      //Specify action for the close button
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      
      //Build panels
      buildPanel();
      
      //Add panels to the content pane
      add(panel1, BorderLayout.NORTH);
      add(panel2, BorderLayout.CENTER); 
      
      //Pack and display the window
      pack();
      setVisible(true); 
      
   }
   
   /**
      The buildPanel method builds panels for Celsius and Fahrenheit sections. 
   */
   
   private void buildPanel()
   {
      //Creates labels and textfield
      celsiusLabel = new JLabel("Celsius Temperature"); 
      celsiusTextField = new JTextField(10); 
      
      fahrenheitLabel = new JLabel("Enter Celsius Temperature"); 
      
      //Creates Calculate Fahrenheit Button
      calcButton = new JButton("Calculate Fahrenheit");
      calcButton.addActionListener(new CalcButtonListener()); 
      
      //Creates panels
      panel1 = new JPanel(); 
      panel2 = new JPanel(); 
      
      //Add labels, textfield and button to panels
      panel1.add(celsiusLabel);
      panel1.add(celsiusTextField); 
      panel1.add(calcButton); 
      panel2.add(fahrenheitLabel);
      
      //Set panel borders
      panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); 
      panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); 
      
   }
   
   /**
      Private inner class handles the event that is generated when user selects the 
      Calculate Fahrenheit button.
   */
   
   private class CalcButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e) 
      {
         double celsius, fahrenheit; 
         
         celsius = Double.parseDouble(celsiusTextField.getText()); 
         
         fahrenheit = (9 / 5) * celsius + 32;
         
         fahrenheitLabel.setText(String.format("%,.1f degree(s)", fahrenheit));        
      }
   }
   
   /**
      The main method creates an instance of the CelsiusToFahrenheit class, 
      which causes it to display its window.
   */
   
   public static void main(String[] args)
   {  
      new CelsiusToFahrenheit();
   }
}