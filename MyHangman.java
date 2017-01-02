import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyHangman extends JFrame
{//0

///////////////////////////////////////////VARIABLE DECLARATION////////////////////////////////////////////////////////

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
   // Lists
   private ArrayList found = new ArrayList();
   
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
   
   //Text area
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
   
   
   
///////////////////////////////////////////////METHOD OBJECT/////////////////////////////////////////////////////////////
   
   public MyHangman(String temp)
   {//1
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
   }//1;
      
//////////////////////////////////////////BUILD MAIN PANEL//////////////////////////////////////////////////////////
      

public void buildMainPanel()
   {//2
      mainPanel = new JPanel();
      
      //buildOutPanel();
      buildInPanel();
      buildButtonPanel();
      
      //mainPanel.add(outPanel);
      mainPanel.add(inPanel);
      mainPanel.add(buttonPanel);
   }//2;
   
///////////////////////////////////////////BUILD OPENING OUTPANEL///////////////////////////////////////////////////////////

   public void buildOutPanel()
   {//3
      outPanel = new JPanel();
      
      numOfLetters = word.length();
      
      for(int i = 1;i<=numOfLetters;i++){//4
    	  dashes = dashes + "_ ";
      }//4;
      
      reveal = new JTextArea("" + dashes, 30,30);
      reveal.setEditable(false);
      
      outPanel.add(reveal);
      
   }//3;
   
 /////////////////////////////////////////////-INPUT PANEL-\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
   
   public void buildInPanel()
   {//5
      inPanel = new JPanel();
      
      inPanel.add(inLabel);
      inPanel.add(inputBox);
   }//5;
   
 /////////////////////////////////////////////////-BUTTON PANEL-\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
   
   public void buildButtonPanel()
   {//6
      buttonPanel = new JPanel();
      
      button.addActionListener(new ButtonListener());
      reset.addActionListener(new ButtonListenerR());
      
      buttonPanel.add(button);
      buttonPanel.add(reset);
   }//6;
 
 ////////////////////////////////////////////////////-PAINT FUNCTION-\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
   public void paint(Graphics g){//7
		super.paint(g);
	   	
	   	//Stand to hang the character
	   	g.drawLine(500, 200, 500, 500);
	   	g.drawLine(400, 200, 500, 200);
	   	g.drawLine(400, 500, 600, 500);
	   	g.drawLine(400, 200, 400, 250);
	   	
	   	
	   	
   }//7;
      
   
/////////////////////////////////////////////////////////RESET BUTTON///////////////////////////////////////////////////////
   private class ButtonListenerR implements ActionListener
   {//8
      public void actionPerformed(ActionEvent e)
      {//9
         dispose();
         new wordGen();
         

      }//9;
   }//8;
   
////////////////////////////////////////////////////////TRY BUTTON/////////////////////////////////////////////////////////

   
   

 private class ButtonListener implements ActionListener
   {//10
      public void actionPerformed(ActionEvent e)
      {//11
    	 
    	char[] letters;
    	
    	found = new ArrayList();
    	  	   	    	
        letters = word.toCharArray();
        
        temp1 = inputBox.getText();
        
        temp2 = temp1.toCharArray();
        
        output = "";
        try{//12
        	if(temp1.length() <= word.length()){//13
                
                		for(int j = 0; j < word.length(); j++){//14
                			if(temp2[0] == letters[j]){//15
                				output = output + temp2[0];
                				found.add(temp2[0]);
                			}//15;
                			else{
                				output = output + "_ ";
                				found.add("_");
                			}
                		}//14;
                	
                
                		}//13;
                		else
                			System.out.print("Guess is too long.");
                

                reveal.setText(found.toString());
                
        }//12;
        catch(Exception x){//16
        	System.out.print("Fuck");
        }//16;
        
        
            
    }//11;

    
 }//10;
 
 
       
}//0;
  