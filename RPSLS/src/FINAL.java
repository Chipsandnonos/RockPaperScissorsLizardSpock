/*
 * Program: Rock Paper Scissors
 * Student Name: Rahul
 * Student Number: 661174
 * Description: A replication of Rock Paper Scissors Lizard Spock RPSLS from the show the Big Bang Theory.
 */
import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class FINAL  extends Applet implements ActionListener
{
	
	
	
	//global variables needed for the program to run
  JRadioButton rock; //rock button
  JRadioButton paper; //paper button
  JRadioButton scissor;//scissor button
  JRadioButton spock; //spock button
  JRadioButton lizard;//lizard button
  
  char computerc; //the computers choice
  char userc; //the users choice
  int pScore;//the players score
  int cScore;//the computers score
  JLabel worl; //the win/lose label
  JButton go; //the duel button
  JLabel picP;//the players choice picture
  JLabel picC; //the computers choice picture
  JLabel lUSCORE; //the label which has the users score
  JLabel lCSCORE;// the label which has the computers score
  JButton reset; //the reset button 
  
  public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FINAL frame = new FINAL();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
  public void init()
  {
    
    setLayout(new GridLayout(8,5));  //using grid layout, an 8x5 grid
    JLabel fill = new JLabel (""); //fillers to fill in blank grid spaces in my grid layout format
    JLabel fill2 = new JLabel ("");
    JLabel fill3 = new JLabel ("");
    JLabel fill4 = new JLabel ("");
    JLabel fill5 = new JLabel ("");
    JLabel fill6 = new JLabel ("");
    JLabel fill7 = new JLabel ("");
    JLabel title = new JLabel ("Rock, Paper , Scissors, Lizard, Spock!");//title
    title.setFont (new Font ("Jokerman", Font.BOLD, 20)); //properties of the titles text
    title.setForeground (new Color (255,0,255));
    JLabel pick = new JLabel ("Pick one: "); //initialization of label which asks user to pick something
    pick.setFont( new Font("Arial", Font.BOLD, 15));
    JLabel pChoice = new JLabel ("Your choice: ");  //initialization of label which asks user to pick something
    pChoice.setFont( new Font("Arial", Font.BOLD, 15));
    JLabel cChoice = new JLabel ("Computers choice: "); //initialization of label which asks user to pick something
    cChoice.setFont( new Font("Arial", Font.BOLD, 15));
    
    rock = new JRadioButton ("Rock");  //initialization of choice buttons
    rock.setFont(new Font("Arial", Font.BOLD, 15));//set text properties of buttons
    paper = new JRadioButton ("Paper");
    paper.setFont(new Font("Arial", Font.BOLD, 15));
    scissor = new JRadioButton ("Scissor");
    scissor.setFont(new Font("Arial", Font.BOLD, 15));
    spock = new JRadioButton ("Spock");
    spock.setFont(new Font("Arial", Font.BOLD, 15));
    lizard = new JRadioButton ("Lizard");
    lizard.setFont(new Font("Arial", Font.BOLD, 15));
    
    lUSCORE = new JLabel ("Your score: " + pScore); //initialization of score boards
    lUSCORE.setFont( new Font("Arial", Font.BOLD, 20));//set text properties of labels
    lCSCORE = new JLabel ("Computer score: " + cScore);
    lCSCORE.setFont( new Font("Arial", Font.BOLD, 20));
    go = new JButton ("DUEL!");  //initialization of the go button
    go.addActionListener(this);//enables button
    go.setActionCommand("go");
    worl = new JLabel (""); // //initialization of win or lose label
    worl.setFont( new Font ("Serif", Font.BOLD, 30));
    worl.setBackground( new Color (255,0,0));
    
    picP = new JLabel (""); //initialization of images for the computers and users choices
    picC = new JLabel ("");
    reset = new JButton ("Reset");  //initialization of reset button
    reset.addActionListener(this);
    reset.setActionCommand("reset");
    
    add(title); //adds all components to the screen in order
    add(fill);
    add(fill2);
    add (lUSCORE);
    add (lCSCORE);
    add(fill3);
    add (pick);
    
    add(rock);
    add(paper);
    add(scissor);
    add(spock);
    add(lizard);
    add(go);
    
    
    add(reset);
    add (fill5);
    
    add (pChoice);
    add(cChoice);
    add(fill6);
    add (picP);
    add (picC);
    add (fill7);
    
    
    
    
    add(worl);
    nBackground();
    
   
  }
  //In the win and lose method, I change the color of the background to math the outcome
    //however radio button do not take the specified background color, so you have to specifically state that they do
    //if I repeated this in each branch of my if and else loop, it would look disjointed and bad
    //so I made a method to change everything, and I would call that method everytime I need to change the background
  public void nBackground() //nuetral background
  {
   setBackground(new Color (255,255,0));
   rock.setBackground(new Color (255,255,0));
   paper.setBackground(new Color (255,255,0));
   scissor.setBackground(new Color (255,255,0));
   lizard.setBackground(new Color (255,255,0));
   spock.setBackground(new Color (255,255,0));
                   
  }
  public void wBackground() //win background
  {
   setBackground(new Color (0,255,255));
   rock.setBackground(new Color (0,255,255));
   paper.setBackground(new Color (0,255,255));
   scissor.setBackground(new Color (0,255,255));
   lizard.setBackground(new Color (0,255,255));
   spock.setBackground(new Color (0,255,255));
  }
  public void lBackground() //lose background
  {
   setBackground(new Color (255,0,0));
   rock.setBackground(new Color (255,0,0));
   paper.setBackground(new Color (255,0,0));
   scissor.setBackground(new Color (255,0,0));
   lizard.setBackground(new Color (255,0,0));
   spock.setBackground(new Color (255,0,0));
  
  }
   public void playGame() //method that plays the RPSLS, and sets the outcome
    {
    if (computerc == userc) //goes over each possible outcome of the RPSLS, and dictates who wins, and incriments the winning side
      { worl.setText("You drawed"); // if they are the same, they draw
        nBackground();}
      else if ((computerc == 'z') && ((userc == 'r')||(userc== 's')))
      {
        worl.setText("You lose :("); //changes the worl label to you lose
        cScore++; //incriments the computers score
        lCSCORE.setText("Computer Score: " + cScore);//re-initializes the computers label
        lBackground(); //sets the appropriate background
      } //repeated for each other outcome
      else if ((computerc == 'r') && ((userc == 's')||(userc == 'l')) )
      {
        worl.setText("You lose :(");
        cScore++;
        lCSCORE.setText("Computer Score: " + cScore);
        
         lBackground();
       
      }
      else if ((computerc == 's') && ((userc == 'p')||(userc == 'l')))
      {
        worl.setText("You lose :(");
        cScore++;
        lCSCORE.setText("Computer Score: " + cScore);
         lBackground();
      }
      else if ((computerc == 'p') && ((userc == 'r')||(userc == 'z')))
      {
        worl.setText("You lose :(");
        cScore++;
        lCSCORE.setText("Computer Score: " + cScore);
         lBackground();
      }
      else if ((computerc == 'l') && ((userc == 'z')||(userc == 'p')))
      {
        worl.setText("You lose :(");
        cScore++;
        lCSCORE.setText("Computer Score: " + cScore);
         lBackground();
      }
      else  //no ther possibilities for computer to win, so the user wins by process of elimenation of the possible outcomes
      {
        worl.setText("You win :)");
        pScore++;
        lUSCORE.setText("Your Score: " + pScore);
         wBackground();
      }
    }
   public void computerC ()//method which makes the computers choice
   {
   int compR = (int)(Math.random()*5+1); //gets a random integer which will decide the computers choice of rock, paper, scissors, lizard or spock
      if (compR == 1) //if the number is 1, it will pick rock
      {
        
        computerc = 'r'; //sets computers choice
        picC.setIcon(createImageIcon ("rock.jpg"));//sets the computers choice image
        //is repeated for the other 4 possiilities
      }
      else if (compR == 2) 
      {
        computerc = 'p';
        picC.setIcon(createImageIcon ("paper.gif"));
      }
      else if ( compR == 3)
      { computerc = 's';
        picC.setIcon(createImageIcon ("scissor.jpg"));
         }
      else if (compR == 4)
      {
        computerc = 'z';
        picC.setIcon(createImageIcon ("spock.jpg"));
        
      }
      else 
      {
        computerc = 'l';
        picC.setIcon(createImageIcon ("lizard.jpg"));
      }
   
   }
  public void actionPerformed (ActionEvent e)
  {
    
    if (e.getActionCommand().equals("reset")) //if the reset button is pushed it resets the scores of the player and coomputer
    {
      cScore = 0;
      lCSCORE.setText("Computer Score: " + cScore);
      pScore = 0;
      lUSCORE.setText("Your Score: " + pScore);
     
    }
    else //if the other button is pushed (duel)
    {
      //if the user did not select anything, I wanted to make it so that nothing happens (RPSLSwise), and they will be prompted to pick something
      //to do this I exported my playRPSLS and computers choice to methods, so that if the user did not pick anything, it would not still play the RPSLS (because it was all in action performed)
      //so to fix this I made them all into methods, which would only trigger if the user picked something
      if (rock.isSelected()) //checks which radio button was selected
      {
        userc = 'r'; //sets the users choice
        picP.setIcon(createImageIcon ("rock.jpg"));//sets the users image
        computerC (); //gets computers choice
        playGame (); //gets outcome of round
      } //is repeated for each other choice, the user can make
      else if (paper.isSelected())
      {
        userc = 'p';
        picP.setIcon(createImageIcon ("paper.gif"));
        computerC ();
        playGame ();
      }
      else if (scissor.isSelected())
      {
        userc = 's';
        picP.setIcon(createImageIcon ("scissor.jpg"));
        computerC ();
        playGame ();
      }
      else if (lizard.isSelected())
      {
        userc = 'l';
        picP.setIcon(createImageIcon ("lizard.jpg"));
        computerC ();
        playGame ();
      
      }
      
      else if (spock.isSelected())
      {
        userc = 'z';
        picP.setIcon(createImageIcon ("spock.jpg"));
        computerC ();
        playGame ();
       }
      else //if the user does not do anything, it gives them a prompt as well as some motivation with the graphics I choose
      {
        worl.setText("PLEASE PICK SOMETHING!!!!!!!");
        picP.setIcon(createImageIcon ("you.jpg"));
        picC.setIcon(createImageIcon ("idiot.jpg"));
      }
      
    }
   
  }
  
  protected static ImageIcon createImageIcon (String path) //create image method
  {
    java.net.URL imgURL = FINAL.class.getResource(path);
    
    if (imgURL != null)
      return new ImageIcon (imgURL);
    
    else 
    {
      System.err.println ("Couldn't find path: " + path);
      return null;
    }
  }
}