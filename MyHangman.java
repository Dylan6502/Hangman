import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class MyHangman extends JFrame
{

///////////////////////////////////////////-VARIABLE DECLARATION-////////////////////////////////////////////////////////

   /**
	 * 
	 */
   private static final long serialVersionUID = 1L;
	
   // Lists
   private ArrayList found = new ArrayList();
   private ArrayList wrong = new ArrayList();
   private ArrayList outArray = new ArrayList();
   
   // Panels
   private JPanel mainPanel;
   private JPanel outPanel;
   private JPanel inPanel;
   private JPanel buttonPanel;
   
   // String
   private String word;
   private String output = "";
   static String temp1;
   static char[] temp2;
   static String temp3;
   private String dashes = "";
   
   // Objects
   private GraphicsForHangman stand;
   Graphics g = null;
   
   // Textbox
   private static JTextField inputBox = new JTextField(10);
   
   // Text area
   private JTextArea reveal = new JTextArea();
   
   // Label
   private JLabel inLabel = new JLabel("Enter a Letter to Guess");
   
   //Buttons
   private JButton button = new JButton("Try");
   private JButton reset = new JButton("Reset");
   
   // Integers
   private int width = 900;
   private int height = 600;
   private int numOfLetters;
   
   
   
///////////////////////////////////////////////-METHOD OBJECT-/////////////////////////////////////////////////////////////
   
   public MyHangman(String temp)
   {
      // Sets title of the window
      setTitle("Hangman");
      
      // Sets the size of the window
      setSize(width, height);
      
      // Specified action on close
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //Layout type
      setLayout(new BorderLayout());
      
      // temp from wordGen
      word = temp;
      
      //stand = new GraphicsForHangman();
      //stand.paint(g);
      
      // Calls Method
      buildMainPanel();
      buildOutPanel();
      
      add(mainPanel, BorderLayout.PAGE_START);
      add(outPanel, BorderLayout.PAGE_END);
      
      
      // Shows content
      setVisible(true);
   }
      
//////////////////////////////////////////-BUILD MAIN PANEL-//////////////////////////////////////////////////////////
      
public void buildMainPanel()
   {
      mainPanel = new JPanel();
      
      // Builds panels for objects
      buildInPanel();
      buildButtonPanel();
      
	  // Adds subpanels to the main panel
      mainPanel.add(inPanel);
      mainPanel.add(buttonPanel);
   }
   
///////////////////////////////////////////-BUILD OPENING OUTPANEL-///////////////////////////////////////////////////////////

   public void buildOutPanel()
   {
      outPanel = new JPanel();
      
      numOfLetters = word.length();
      
      for(int i = 1;i<=numOfLetters;i++)
      {//118;120
    	  dashes = dashes + "_ ";
      }//118;120
      
      reveal = new JTextArea("" + dashes, 30,30);
      reveal.setEditable(false);
      
      outPanel.add(reveal);
      
   }
   
 /////////////////////////////////////////////-INPUT PANEL-\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
   
   public void buildInPanel()
   {
      inPanel = new JPanel();
      
      inPanel.add(inLabel);
      inPanel.add(inputBox);
   }
   
 /////////////////////////////////////////////////-BUTTON PANEL-\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
   
   public void buildButtonPanel()
   {
      buttonPanel = new JPanel();
      
      button.addActionListener(new ButtonListener());
      reset.addActionListener(new ButtonListenerR());
      
      buttonPanel.add(button);
      buttonPanel.add(reset);
   }
 
 ////////////////////////////////////////////////////-PAINT FUNCTION-\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
   
   public void paint(Graphics g)
   {
		super.paint(g);
	   	
	   	//Stand to hang the character
	   	g.drawLine(500, 200, 500, 500);
	   	g.drawLine(400, 200, 500, 200);
	   	g.drawLine(400, 500, 600, 500);
	   	g.drawLine(400, 200, 400, 250);
	   	
	   	
	   	
   }
         
/////////////////////////////////////////////////////////-RESET BUTTON-///////////////////////////////////////////////////////
   
   private class ButtonListenerR implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
		  
         dispose();
         new wordGen();
         
      }
   }
   
////////////////////////////////////////////////////////TRY BUTTON/////////////////////////////////////////////////////////
   
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
    	
    	// Variable Declaration 
    	char[] letters;
    	
    	outArray = new ArrayList();
    	  	   	    	
        letters = word.toCharArray();
        
        temp1 = inputBox.getText();
     
        temp2 = temp1.toCharArray();
        // End of Variable Delcaration
        
        inputBox.setText("");
       
        try
        {
        	if(temp1.length() <= 1)
        	{               		
				if(word.contains(temp1))
				{
								
					if(!found.contains(temp2[0]))
					{
						found.add(temp2[0]);
				    }
				    
                }
                				
                else if(!word.contains(temp1))
                {
					
					if(!wrong.contains(temp2[0]))
					{
						wrong.add(temp2[0]);
				    }
				
				}               	
			}			
            else
				JOptionPane.showMessageDialog(null, "Guess is too long.");
               
         
            // Changes the text in the ouput box.  
			reveal.setText(/*reveal.getText()*/ + "\nCorrect Tries: " + found.toString() +
						   "\nWrong Tries: " + wrong.toString());
			repaint();// Keeps the things from paint method.
			
/////////////////////////////////////////////// NEEDS WORK!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!			
			
			if(found.size() == letters.length)
			{
				JOptionPane.showMessageDialog(null,"Congratz the word was " +
				word);
			}
////////////////////////////////////////////// NEEDS WORK!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                
        }
        catch(RuntimeException x)
        {
        	JOptionPane.showMessageDialog(null,"You must enter a letter");
		}
    }
 }
}
  
