import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;
import java.util.Random;

/**
   The TicTacToeSimulator class demonstrates tic tac toe simulation.
*/

public class TicTacToeSimulator extends JFrame
{
   private JPanel spacesPanel; //To hold labels
   private JPanel buttonsPanel; //To hold buttons 
   private JLabel spaceLabel1, spaceLabel2, spaceLabel3, spaceLabel4, 
   spaceLabel5, spaceLabel6, spaceLabel7, spaceLabel8, 
   spaceLabel9; //displays X or O
   private JButton newGameBtn; //To start a new game
   private JButton exitBtn; //To exit program
   
   /**
      Constructor
   */
   
   public TicTacToeSimulator()
   {
      //Set the title
      setTitle("Tic Tac Toe Simulator");
      
      //Specify action for the close button
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //Add GridLayout manager to the content pane (2 rows, 1 column)
      setLayout(new GridLayout(2,1));
      
      //Build panels
      buildSpacesPanel();
      buildButtonsPanel();  
      
      //Add panels to the content pane
      add(spacesPanel);
      add(buttonsPanel);
      
      //Pack and display the window
      pack();
      setVisible(true);
   }
   
   /**
      The buildSpacePanel method builds panel for labels. 
   */
   
   private void buildSpacesPanel()
   {
      //Create spacesPanel
      spacesPanel = new JPanel(); 
      spacesPanel.setLayout(new GridLayout(3,3));
      
      //Create labels
      spaceLabel1 = new JLabel("_", SwingConstants.RIGHT);
      spaceLabel2 = new JLabel("_", SwingConstants.CENTER);
      spaceLabel3 = new JLabel("_", SwingConstants.LEFT); 
      spaceLabel4 = new JLabel("_", SwingConstants.RIGHT);
      spaceLabel5 = new JLabel("_", SwingConstants.CENTER); 
      spaceLabel6 = new JLabel("_", SwingConstants.LEFT); 
      spaceLabel7 = new JLabel("_", SwingConstants.RIGHT); 
      spaceLabel8 = new JLabel("_", SwingConstants.CENTER); 
      spaceLabel9 = new JLabel("_", SwingConstants.LEFT); 
      
      //Set font for labels
      spaceLabel1.setFont(new Font("Dialog", Font.BOLD, 40));
      spaceLabel2.setFont(new Font("Dialog", Font.BOLD, 40));
      spaceLabel3.setFont(new Font("Dialog", Font.BOLD, 40));
      spaceLabel4.setFont(new Font("Dialog", Font.BOLD, 40));
      spaceLabel5.setFont(new Font("Dialog", Font.BOLD, 40));
      spaceLabel6.setFont(new Font("Dialog", Font.BOLD, 40));
      spaceLabel7.setFont(new Font("Dialog", Font.BOLD, 40));
      spaceLabel8.setFont(new Font("Dialog", Font.BOLD, 40));
      spaceLabel9.setFont(new Font("Dialog", Font.BOLD, 40));
      
      //Add labels to spacesPanel
      spacesPanel.add(spaceLabel1);
      spacesPanel.add(spaceLabel2);
      spacesPanel.add(spaceLabel3);
      spacesPanel.add(spaceLabel4);
      spacesPanel.add(spaceLabel5);
      spacesPanel.add(spaceLabel6);
      spacesPanel.add(spaceLabel7);
      spacesPanel.add(spaceLabel8);
      spacesPanel.add(spaceLabel9);    
   }
   
   /**
      The buildButtonsPanel method builds panel for buttons. 
   */
   
   private void buildButtonsPanel()
   {
      //Create buttonsPanel
      buttonsPanel = new JPanel(); 
      buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 7));
      
      //Create New Game button
      newGameBtn = new JButton("New Game");
      newGameBtn.setMnemonic(KeyEvent.VK_N);
      newGameBtn.addActionListener(new NewGameListener()); 
      
      //Create Exit button
      exitBtn = new JButton("Exit");
      exitBtn.setMnemonic(KeyEvent.VK_X);
      exitBtn.addActionListener(new ExitListener()); 
      
      //Add buttons to buttonsPanel
      buttonsPanel.add(newGameBtn); 
      buttonsPanel.add(exitBtn);
   }
   
   /**
      Private inner class handles the event that is generated when user selects
      New Game button. 
   */
   
   private class NewGameListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         int letterNum = 0, spaceRow = 0, spaceCol = 0, turns = 0; 
         int[][] spaces = new int[3][3]; //Spaces array
         boolean gameOver = false, emptySpace = true;
        
         //Create Random instance
         Random rand = new Random();
         
         
         while (!gameOver)
         {
            //Determine player's turn
            if (turns == 0)
               letterNum = rand.nextInt(2) + 1;
            else 
            {
               if (letterNum == 1)
                  letterNum = 2;
               else 
                  letterNum = 1;
            }
            
            //Search space row and column
            if (emptySpace)
            {
               spaceRow = rand.nextInt(3);
               spaceCol = rand.nextInt(3); 
            }

            //Determine if space is already filled
            if (!(spaces[spaceRow][spaceCol] == 1 || 
                  spaces[spaceRow][spaceCol] == 2))
            {  
                  //Set flag
                  emptySpace = true;
                  
                  //Input number into space array
                  spaces[spaceRow][spaceCol] = letterNum; 
                  
                  //Calls method for selected space 
                  if (spaceRow == 0)
                  {
                     if (spaceCol == 0)
                     {
                        displayInLabel(spaceLabel1, letterNum);
                     }
                     
                     else if (spaceCol == 1)
                     {
                        displayInLabel(spaceLabel2, letterNum);
                     }
                     
                     else
                     {
                        displayInLabel(spaceLabel3, letterNum);
                     }
                  }
               
                  else if (spaceRow == 1) 
                  {
                     if (spaceCol == 0)
                     {
                        displayInLabel(spaceLabel4, letterNum);
                     }
                     
                     else if (spaceCol == 1)
                     {
                        displayInLabel(spaceLabel5, letterNum);
                     }
                     
                     else
                     {
                        displayInLabel(spaceLabel6, letterNum);
                     }   
                  }
               
                  else
                  {
                     if (spaceCol == 0)
                     {
                        displayInLabel(spaceLabel7, letterNum);
                     }
                     
                     else if (spaceCol == 1)
                     {
                        displayInLabel(spaceLabel8, letterNum);
                     }
                     
                     else
                     {
                        displayInLabel(spaceLabel9, letterNum);
                     }
                  }
                  
                  //Increase turns
                  turns++; 
             }
               
             else 
             {
                  //Search new space   
                  emptySpace = false;
                  spaceRow = rand.nextInt(3);
                  spaceCol = rand.nextInt(3); 
              } 

            //Determine result 
            if (turns > 4)
            {
               //Determine a possible winner
               gameOver = determineWinner();
               
               //Determine possible tie
               if (turns == 9 && gameOver == false)
               {
                  gameOver = true; 
                  JOptionPane.showMessageDialog(null, "Tie!");
               }      
            }
         } 
         
         //Clear inputs 
         if (gameOver)
         {
            spaceLabel1.setText("_");
            spaceLabel2.setText("_"); 
            spaceLabel3.setText("_"); 
            spaceLabel4.setText("_"); 
            spaceLabel5.setText("_"); 
            spaceLabel6.setText("_"); 
            spaceLabel7.setText("_");
            spaceLabel8.setText("_");
            spaceLabel9.setText("_");
         }
      }
   }
   
   /**
      The displayInLabel method displays X or O in respective label. 
      @param labelText The selected label. 
      @param num A random number which is either 1 or 2.
   */
   
   private void displayInLabel(JLabel labelText, int num)
   {
      //Display text for selected label
      if (num == 1)
         labelText.setText("X");
      else 
         labelText.setText("O");
   }
   
   /**
      The determineWinner method determines whether there is a winner among
      player X or player O.   
      @return True if game is over, false if not.  
      
   */
   
   private boolean determineWinner()
   {
      //Check labels 
      if ((spaceLabel1.getText().equals("X") && spaceLabel2.getText().equals("X") 
           && spaceLabel3.getText().equals("X")) || //space 1,2,3
                   
          (spaceLabel1.getText().equals("X") && spaceLabel4.getText().equals("X") 
           && spaceLabel7.getText().equals("X")) || //space 1,4,7
                   
          (spaceLabel1.getText().equals("X") && spaceLabel5.getText().equals("X") 
           && spaceLabel9.getText().equals("X")) || //space 1,5,9
                   
          (spaceLabel2.getText().equals("X") && spaceLabel5.getText().equals("X") 
           && spaceLabel8.getText().equals("X")) || //space 2,5,8
                   
          (spaceLabel3.getText().equals("X") && spaceLabel6.getText().equals("X") 
           && spaceLabel9.getText().equals("X")) || //space 3,6,9
                   
          (spaceLabel3.getText().equals("X") && spaceLabel5.getText().equals("X")
           && spaceLabel7.getText().equals("X")) || //space 3,5,7
                   
          (spaceLabel4.getText().equals("X") && spaceLabel5.getText().equals("X") 
           && spaceLabel6.getText().equals("X")) || //space 4,5,6
                   
          (spaceLabel7.getText().equals("X") && spaceLabel8.getText().equals("X") 
           && spaceLabel9.getText().equals("X"))) //space 7,8,9
      { 
         //Player X wins, game is over
         JOptionPane.showMessageDialog(null, "X Wins!");
         return true;       
      }
               
      else if ((spaceLabel1.getText().equals("O") && 
                spaceLabel2.getText().equals("O") && 
                spaceLabel3.getText().equals("O")) || //spaces 1,2,3
                         
               (spaceLabel1.getText().equals("O") && 
                spaceLabel4.getText().equals("O") && 
                spaceLabel7.getText().equals("O")) || //spaces 1,4,7
                         
               (spaceLabel1.getText().equals("O") && 
                spaceLabel5.getText().equals("O") && 
                spaceLabel9.getText().equals("O")) || //spaces 1,5,9
                        
               (spaceLabel2.getText().equals("O") && 
                spaceLabel5.getText().equals("O") && 
                spaceLabel8.getText().equals("O")) || //spaces 2,5,8 
                        
               (spaceLabel3.getText().equals("O") && 
                spaceLabel6.getText().equals("O") && 
                spaceLabel9.getText().equals("O")) || //spaces 3,6,9
               
               (spaceLabel3.getText().equals("O") && 
                spaceLabel5.getText().equals("O") && 
                spaceLabel7.getText().equals("O")) || //spaces 3,5,7
                        
               (spaceLabel4.getText().equals("O") && 
                spaceLabel5.getText().equals("O") && 
                spaceLabel6.getText().equals("O")) || //spaces 4,5,6
                        
               (spaceLabel7.getText().equals("O") && 
                spaceLabel8.getText().equals("O") && 
                spaceLabel9.getText().equals("O"))) //spaces 7,8,9
      {
         //Player O wins, game is over 
         JOptionPane.showMessageDialog(null, "O wins!");         
         return true;
      }
       
      //No winner, game continues
      return false;
   }
   
   /**
      Private inner class handles the event that is generated when the user
      selects the Exit button.   
   */
   
   private class ExitListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //Ends program
         System.exit(0);
      }
   }
   
   /**
      The main method creates an instance of the TicTacToe class, which causes 
      it to display its window.
   */
   public static void main(String[] args)
   {
      new TicTacToeSimulator();
   } 
}