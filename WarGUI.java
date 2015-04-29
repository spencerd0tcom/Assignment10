/* Spencer Binondo
 * CS110A
 * GUI for game of war.  */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class WarGUI extends JFrame implements ActionListener
{

	private Deck gameDeck;
	private Player player1;
	private Player player2;
	private CardInterpreter theGame;
	private JPanel upperPanel,lowerPanel;  
	private JButton playButton;    
	private JLabel playerCard, playerInfo, cpuCard, cpuInfo;
	private JTextField gameInfo;
	private JLabel title;   
	private ArrayList<String> guiText;
   
	public WarGUI()
	{
		guiText = new ArrayList<>();
	   
		setLayout(new GridLayout(2,2));
      
		// create game instance
		gameDeck = new Deck();
		player1 = new Player(gameDeck.deal());
		player2 = new Player(gameDeck.getDeck());
		theGame = new CardInterpreter(player1, player2);
      
		//setup containers and components
		upperPanel = new JPanel(new GridLayout(2, 1));
		cpuInfo = new JLabel("CPU Active Card");
		cpuCard = new JLabel();
		upperPanel.add(cpuInfo);
		upperPanel.add(cpuCard);
    
		add(upperPanel);
      
		gameInfo = new JTextField();
		add(gameInfo);
      
		lowerPanel = new JPanel(new GridLayout(2, 1));
		playerCard = new JLabel();
		playerInfo = new JLabel("PlayerActive Card");
		lowerPanel.add(playerCard);
		lowerPanel.add(playerInfo);
		add(lowerPanel);
      
		playButton = new JButton("Play");
		playButton.setActionCommand("play");
		playButton.addActionListener(this);
		
		add(playButton);
   }
   
	//Action handler, changes images and text; invokes methods to change game information within those objects
	public void actionPerformed(ActionEvent e)
	{
		//
		if(e.getActionCommand().equals("play"))
		{
			guiText = theGame.createGUIValues();
			gameInfo.setText(guiText.get(0));
		   
			ImageIcon card1 = new ImageIcon(guiText.get(1));
			playerCard.setIcon(card1);
		   
			ImageIcon card2 = new ImageIcon(guiText.get(2));
			cpuCard.setIcon(card2);
		   
			if(theGame.getPlayer1DeckSize() == Deck.DECK_SIZE)
			{
				gameInfo.setText(gameInfo.getText() + "\nPlayer 1 Wins!");
				playButton.setActionCommand("");
			}
			else if(theGame.getPlayer1DeckSize() == Deck.DECK_SIZE)
			{
				gameInfo.setText(gameInfo.getText() + "\nPlayer 2 Wins!");
				playButton.setActionCommand("");
			}
		   
			theGame.newRound();
		   
		}
	}
}
   
   