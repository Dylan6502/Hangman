import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class wordGen extends JFrame{
	
////////////////////////////////////////////-VARIABLE DECLIRATION-\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Array
    private String[] easywords = {"easy", "easier", "easiest"};
    private String[] mediumwords ={"medium", "mediumer", "mediumest"};
    private String[] hardwords = {"hard", "harder", "hardest"};
    private String[] words = {"Someting went wrong"};
    private String[] diffi = {"easy", "medium", "hard"};
    
    // Strings
    private String word;
    private String randomWord;
    private String temp;
    
    // ComboBox
    JComboBox<Object> diffiList = new JComboBox<Object>(diffi);
    
    // Int
    private int index = 0;
    private int randomWordNumber = (int) (Math.random() * 3);
    
    // File io
    private PrintWriter easyFile;
    private PrintWriter mediumFile;
    
    // Buttons
    private JButton button = new JButton("Select");
    
    // Panel
    private JPanel radioPanel;
    
    // File
    private File file;
    
    // Scanner
    private Scanner inputFile;
    
    // Internal Objedcts
    private GraphicsForHangman stand;
    
///////////////////////////////////////////-MAIN OBJECT-\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    
    public wordGen(){
    	
    	 // Sets title of the window
        setTitle("Difficulty");
        
        // Sets the size of the window
        setSize(500, 500);
        
        // Specified action on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Layout type
        setLayout(new FlowLayout());
        
        button.addActionListener(new ButtonListener());
        
        buildRadioPanel();
        
        add(radioPanel);
        add(button);
        
        setVisible(true);
    }
    
 ////////////////////////////////////////////-BUILD RADIO PANEL-\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    
    public void buildRadioPanel(){
    	
    	radioPanel = new JPanel();
    	radioPanel.add(diffiList);
    }
    
    
    
/////////////////////////////////////////////-"SELECT" BUTTON ACTION-\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    
	private class ButtonListener implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {

    	  
    	   index = diffiList.getSelectedIndex();
    	   
    	   
    	   
    	   if(index == 0){
    	   
    	   
    	   																																			try {
			makeEasyFile();
    	   																																			} catch (IOException e1) {
    	   	/*
    	   	 * Useless code to your right -->																																				// TODO Auto-generated catch block
    	   	 */
    	   																																				e1.printStackTrace();
    	   																																			}
    	   																																			
    	   }
    	   
    	   if(index == 1){
    	   	try {
				makeMediumFile();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}															
    	   }
    	   																																			try {
			word = getFile();
    	   																																			} catch (FileNotFoundException e1) {
    	   	/*
    	   	 *  Same useless code scroll right -->																																			// TODO Auto-generated catch block
    	   	 */
    	   																																				e1.printStackTrace();
    	   																																			}
    	   dispose();
    	   new MyHangman(word);
    	   
   
     }
    
  }
	
////////////////////////////////////////////////-MAKE EASY FILE-\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public File makeEasyFile() throws IOException{
		
		easyFile = new PrintWriter("easy.txt");// Creates or replaces a .txt file with the name easy.
		
		file = new File("easy.txt");
		
		for(int i = 0; i < 3; i++){
		easyFile.println(easywords[i]);// Writes the words from easyword array to the "easy.txt" file.
		}
		
		easyFile.close();// Closes the file so that anything left in the buffer will be
						 // written to the disk from the ram.
		
		return file;
		
		
	}
	
	public File makeMediumFile() throws IOException{
		
		mediumFile = new PrintWriter("medium.txt");// Creates or replaces a .txt file with name easy.
		
		file = new File("medium.txt");
		
		for(int i = 0; i < 3; i++){
		mediumFile.println(mediumwords[i]);// Writes the word "medium to the "medium" to the medium.txt file.
		}
		
		mediumFile.close();// Closes the file.
		
		return file;
	}
	
////////////////////////////////////////////-GET FILE INFO-\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public String getFile() throws FileNotFoundException{
		
		
		inputFile = new Scanner(file);
		
		String line1 = inputFile.nextLine();
		
		String line2 = inputFile.nextLine();
		
		String line3 = inputFile.nextLine();
		
		if(randomWordNumber == 1){
			return line1;
		}
		
		else if(randomWordNumber == 2){
			return line2;
		}
		
		else
			return line3;
		
		
		
	}
	
////////////////////////////////////////////-SET WORD-\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public void setWord(String w /*randomWord = w*/){
		
		temp = w;// randomWord saved here.
	}
	
///////////////////////////////////////////-GET WORD-\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    
    public String getWord(){
    	
    	return temp;
    }
}
