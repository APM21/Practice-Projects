import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

/** 
   This class is an applet that displays a slideshow of images with a 
   time delay.
*/
    
public class SlideshowApp extends JApplet
{    
   private JPanel titlePanel, slideShowPanel, editButtonsPanel, playButtonsPanel; //Panels
   private JLabel titleLabel, imageLabel, timeDelayLabel; //Labels
   private JTextField timeDelayText; //To set time delay 
   private JButton addBtn, deleteBtn, clearBtn, startBtn, stopBtn; //Buttons
   private JList imageList, selectedImageList; //Lists for images
   private JScrollPane scrollPane, scrollPane2; //Scrolls for image lists 
   private String[] files = {"NFL/colts.jpg", "NFL/cowboys.jpg", "NFL/dolphins.jpg", 
   "NFL/falcons.jpg", "NFL/giants.jpg", "NFL/jets.jpg", "NFL/panthers.jpg", 
   "NFL/patriots.jpg", "NFL/redskins.jpg", "NFL/saints.jpg"};//Emblems 
   private String[] teams = {"Colts", "Cowboys", "Dolphins", "Falcons", "Giants", 
   "Jets", "Panthers", "Patriots", "Redskins", "Saints"}; //Football teams
   private ArrayList<String> selectedTeams = new ArrayList<String>();//array of selected images
   private String[] finalList; //array of final list of selected images 
   private int timeDelay, secondsInput; //To set seconds
   private Timer timer; //Timer object 
   private ImageIcon image; //ImageIcon object
   private int counter = -1; //To count number of selected images

   /**
      init method
   */ 
   
   public void init()
   {
      //Creates layout manager
      setLayout(new BorderLayout());
      
      //Build panels
      buildTitlePanel();
      buildSlideShowPanel();
      buildEditButtonsPanel();
      
      //Adds title panel to the north region, slideshow panel to center region
      //and editbuttons panel to west region
      add(titlePanel,BorderLayout.NORTH); 
      add(slideShowPanel,BorderLayout.CENTER);
      add(editButtonsPanel,BorderLayout.WEST); 
      
      //Creates timer object 
      timer = new Timer(timeDelay, new TimerListener());         
   }
   
   /**
      The buildTitlePanel method creates the title of the slideshow. 
   */
   
   private void buildTitlePanel()
   {
      //Creates panel 
      titlePanel = new JPanel();
      
      //Sets layout, border 
      titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
      titlePanel.setBorder(BorderFactory.createEtchedBorder());
      
      //Creates label and sets font, foreground color
      titleLabel = new JLabel("Slideshow"); 
      titleLabel.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 30));
      titleLabel.setForeground(Color.MAGENTA);
      
      //Adds label to panel
      titlePanel.add(titleLabel);   
   }
   
   /**
      The buildSlideShowPanel method creates the slideshow to display images.
   */
   private void buildSlideShowPanel() 
   {
      //Creates panel
      slideShowPanel = new JPanel(); 
      
      //Creates label and sets size of label     
      imageLabel = new JLabel();
      imageLabel.setPreferredSize(new Dimension(275,250));
      
      //Adds label to the panel  
      slideShowPanel.add(imageLabel);  
   }
   
   /**
      The buildEditButtonsPanel creates the buttons used to manage the slideshow.
   */
   private void buildEditButtonsPanel()
   {
      //Creates editButtonsPanel, sets border, size and layout of the panel
      editButtonsPanel = new JPanel(); 
      editButtonsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
      editButtonsPanel.setPreferredSize(new Dimension(200,300));
      editButtonsPanel.setLayout(new GridLayout(3,1));
      
      //Creates buttonsPanel, listPanel and playButtonsPanel 
      JPanel buttonsPanel = new JPanel();
      JPanel listPanel = new JPanel();
      listPanel.setLayout(new GridLayout(1,2));
      playButtonsPanel = new JPanel();
      
      //Creates add, delete, clear buttons 
      addBtn = new JButton("Add Image"); 
      deleteBtn = new JButton("Delete Image");
      clearBtn = new JButton("Clear Images");  
      
      //Creates timer label, textfield
      timeDelayLabel = new JLabel("Time Delay (in seconds)");
      timeDelayText = new JTextField("1",5);
      
      //Adds an action listener for buttons
      addBtn.addActionListener(new ButtonsListener());
      deleteBtn.addActionListener(new ButtonsListener());
      clearBtn.addActionListener(new ButtonsListener());
      
      //Creates lists
      imageList = new JList(teams);
      imageList.setVisibleRowCount(2);
      scrollPane = new JScrollPane(imageList); 
      
      selectedImageList = new JList(); 
      selectedImageList.setVisibleRowCount(2);
      scrollPane2 = new JScrollPane(selectedImageList);
      
      //Creates start, stop buttons 
      startBtn = new JButton("Start Slideshow");
      stopBtn = new JButton("Stop Slideshow");
      
      //Adds actionlistener for buttons 
      startBtn.addActionListener(new ButtonsListener());
      stopBtn.addActionListener(new ButtonsListener()); 
      
      //Adds to buttonsPanel
      buttonsPanel.add(addBtn); 
      buttonsPanel.add(deleteBtn); 
      buttonsPanel.add(clearBtn); 
      buttonsPanel.add(timeDelayLabel);
      buttonsPanel.add(timeDelayText);
      
      //Adds to listPanel
      listPanel.add(scrollPane);
      listPanel.add(scrollPane2);
      
      //Adds to playButtonsPanel
      playButtonsPanel.add(startBtn); 
      playButtonsPanel.add(stopBtn);
      
      //Adds to editButtonsPanel
      editButtonsPanel.add(buttonsPanel);
      editButtonsPanel.add(listPanel);
      editButtonsPanel.add(playButtonsPanel);      
   }
   
   /**
      Private inner class that handles button events. When an event occurs, 
      the slideshow starts/stops or lists items are added/deleted. 
   */
   
   private class ButtonsListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         String selectedTeam;

         if (e.getSource() == addBtn)
         {
            if (selectedTeams.size() < 11)
            {
               selectedTeam = (String) imageList.getSelectedValue();
            
               selectedTeams.add(selectedTeam);
            
               finalList = new String[selectedTeams.size()];
  
               int index = 0;           
               for (String team: selectedTeams)
               {
                  finalList[index] = team;
                  index++;         
               }                       
              
               selectedImageList.setListData(finalList);   
            } 
            
            else 
               JOptionPane.showMessageDialog(null, "List has reached maximum");       
         }
         
         else if (e.getSource() == deleteBtn)
         {
            if (selectedTeams.size() == 0) 
               JOptionPane.showMessageDialog(null, "List is empty");
            
            else
            {
               selectedTeam = (String) selectedImageList.getSelectedValue();
            
               selectedTeams.remove(selectedTeam);
            
               finalList = new String[selectedTeams.size()];            
                          
               int index = 0; 
            
               for (String team: selectedTeams)
               {
                  finalList[index] = team;
                  index++;         
               }
                                     
               selectedImageList.setListData(finalList);
            }
         }
         
         else if (e.getSource() == clearBtn)
         {
            if (selectedTeams.size() == 0)   
               JOptionPane.showMessageDialog(null, "List is empty"); 
            else
            {
               selectedTeams = new ArrayList<String>();
               finalList = new String[0];
               selectedImageList.setListData(finalList);
            }
         }
         
         else if (e.getSource() == startBtn)
         {
            secondsInput = Integer.parseInt(timeDelayText.getText());
            timeDelay = secondsInput * 1000;
            timer.setDelay(timeDelay);
            
            timer.start(); 
         }
         
         else if (e.getSource() == stopBtn)
         {
            timer.stop(); 
         }
      }
   }
   
   /**
      Private inner class that handles Timer object's action events. 
   */
   private class TimerListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         counter++;
         
         //Counter restarts if it reaches end of list
         if (counter > finalList.length - 1)
         {
            counter = 0;
         }
         
         //Selected list item displays image 
         switch(finalList[counter])
         {
            case "Colts":
            {
               image = new ImageIcon(files[0]);
               imageLabel.setIcon(image);    
               break;
            }
               
            case "Cowboys":
            {
               image = new ImageIcon(files[1]);
               imageLabel.setIcon(image);    
               break;
            }
               
            case "Dolphins":
            {
               image = new ImageIcon(files[2]);
               imageLabel.setIcon(image);    
               break;
            }
               
            case "Falcons":
            {
               image = new ImageIcon(files[3]);
               imageLabel.setIcon(image);    
               break;
            } 
               
            case "Giants":
            {
               image = new ImageIcon(files[4]);
               imageLabel.setIcon(image);    
               break;
            }
               
            case "Jets":
            {
               image = new ImageIcon(files[5]);
               imageLabel.setIcon(image);    
               break;
            }
               
            case "Panthers":
            {
               image = new ImageIcon(files[6]);
               imageLabel.setIcon(image);    
               break;
            } 
               
            case "Patriots": 
            {
               image = new ImageIcon(files[7]);
               imageLabel.setIcon(image);    
               break;
            }
               
            case "Redskins":
            {
               image = new ImageIcon(files[8]);
               imageLabel.setIcon(image);    
               break;
            }
               
            case "Saints":
            {
               image = new ImageIcon(files[9]);
               imageLabel.setIcon(image);    
               break;
            }
          
         }
      }
   }
}