/* Spencer Binondo
 * CS110A
 * GUI for game of war.  */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class WarGUI extends JFrame
{
   private Deck gameDeck;
   private Player player1;
   private Player player2;
   private CardInterpreter theGame;
   private JPanel upperPanel,lowerPanel;  // break up regions
   private JButton playButton;    // grid of buttons
   private JLabel playerCard, playerInfo, cpuCard, cpuInfo, gameInfo;  // game status
   private JLabel title;   // static title
   // build the GUI
   
   public WarGUI()
   {
      setLayout(new GridLayout(2,2));
      
      // create game instance
      gameDeck = new Deck();
      player1 = new Player(gameDeck.deal());
      player2 = new Player(gameDeck.getDeck());
      theGame = new CardInterpreter(player1, player2);
      
      // setup containers and components
      upperPanel = new JPanel(new GridLayout(2, 1));
      cpuInfo = new JLabel("CPU Active Card");
      cpuCard = new JLabel();
      upperPanel.add(cpuInfo);
      upperPanel.add(cpuCard);
    
      add(upperPanel);
      
      gameInfo = new JLabel();
      add(gameInfo);
      
      lowerPanel = new JPanel(new GridLayout(2, 1));
      playerCard = new JLabel();
      playerInfo = new JLabel("PlayerActive Card");
      lowerPanel.add(playerCard);
      lowerPanel.add(playerInfo);
      add(lowerPanel);
      
      playButton = new JButton("Play");
      playButton.addActionListener(new ButtonListener());
      
      add(playButton);
   }
   // handle button events
   private class ButtonListener implements ActionListener
   {
	  ArrayList<String> guiText = new ArrayList<>();
	   
      public void actionPerformed(ActionEvent e)
      {     
    	  guiText = theGame.roundTextCreation();
    	  
    	  
      }
      
      
      // disable all buttons
      // private method of TicTacToe class
      // not static because it accesses instance variables
      private void disableAll()
      {
         for (int r=0;r<Board.SIZE;r++)
            for(int c=0;c<Board.SIZE;c++)
            {
               buttons[r][c].setEnabled(false);
            }
      
      }
   }     


}