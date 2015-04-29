import java.util.ArrayList;

import javax.swing.*;

/* Spencer Binondo
 * CS110A 
 * Class changes GUI text and images based on game flow*/

public class CardInterpreter extends GameHandler
{
	//Constructor; takes twoPplayer objects and calls GameHandler constructor
	public CardInterpreter(Player firstPlayer, Player secondPlayer)
	{
		super(firstPlayer, secondPlayer);
	}
	
	//Constructor; takes a GameHandler object and invokes GameHandler copy constructor
	public CardInterpreter(GameHandler aGame)
	{
		super(aGame);
	}
	
	//Method sets the text from createGUIValues() in an ArrayList formated for the GUI to handle
	public ArrayList<String> roundTextCreation()
	{
		
		ArrayList<String> guiText = createGUIValues();
		
	
		standardBattleHandling();
		
		//
		if(getActivePlayerOneCard().isEqual(getActivePlayerTwoCard()))
		{	
			ArrayList<String> newGUIText = createGUIValues();
			String newLableText = guiText.get(0) + "\nWar!" + newGUIText.get(0);
			guiText.set(0, newLableText);
			guiText.set(1, newGUIText.get(1));
			guiText.set(2, newGUIText.get(2));
			
		}
		if(getActivePlayerOneCard().greaterThan(getActivePlayerTwoCard()))
		{
			guiText.set(0, guiText.get(0) + "\nPlayer 1 wins this round.");
		}
		else
		{
			guiText.set(0, guiText.get(0) + "\nPlayer 2 wins this round");
		}
		
		return guiText;
	}
	
	//Creates the individual strings for the GUI values
	public ArrayList<String> createGUIValues()
	{
		ArrayList <String> guiText = new ArrayList<>();
		String labelText = "You played a ";
		String card1 = "";
		String card2 = "";
		
		switch(getActivePlayerOneCard().getValue())
		{
			case(2):
				labelText += "2 of ";
				card1 += "2";
				break;
			case(3):
				labelText += "3 of ";
				card1 += "3";
				break;
			case(4):
				labelText += "4 of ";
				card1 += "4";
				break;
			case(5):
				labelText += "5 of ";
				card1 += "5";
				break;
			case(6):
				labelText += "6 of ";
				card1 += "6";
				break;
			case(7):
				labelText += "7 of ";
				card1 += "7";
				break;
			case(8):
				labelText += "8 of ";
				card1 += "8";
				break;
			case(9):
				labelText += "9 of ";
				card1 += "9";
				break;
			case(10):
				labelText += "10 of ";
				card1 += "10";
				break;
			case(Card.JACK):
				labelText += "Jack of ";
				card1 += "jack";
				break;
			case(Card.QUEEN):
				labelText += "Queen of ";
				card1 += "queen";
				break;
			case(Card.KING):
				labelText += "King of ";
				card1 += "king";
				break;
			case(Card.ACE):
				labelText += "Ace of ";
				card1 += "ace";
				break;
		}
		
		switch(getActivePlayerOneCard().getSuit())
		{
			case(Card.HEART):
				labelText += "hearts";
				card1 += "h";
				break;
			case(Card.DIAMOND):
				labelText += "diamonds";
				card1 += "d";
				break;
			case(Card.SPADE):
				labelText += "spades";
				card1 += "s";
				break;
			case(Card.CLUB):
				labelText += "clubs";
				card1 += "c";
				break;
		}
		
		card1 += ".jpg";
		
		labelText += ".\nYour opponent played ";
		
		switch(getActivePlayerTwoCard().getValue())
		{
			case(2):
				labelText += "2 of ";
				card2 += "2";
				break;
			case(3):
				labelText += "3 of ";
				card2 += "3";
				break;
			case(4):
				labelText += "4 of ";
				card2 += "4";
				break;
			case(5):
				labelText += "5 of ";
				card2 += "5";
				break;
			case(6):
				labelText += "6 of ";
				card2 += "6";
				break;
			case(7):
				labelText += "7 of ";
				card2 += "7";
				break;
			case(8):
				labelText += "8 of ";
				card2 += "8";
				break;
			case(9):
				labelText += "9 of ";
				card2 += "9";
				break;
			case(10):
				labelText += "10 of ";
				card2 += "10";
				break;
			case(Card.JACK):
				labelText += "Jack of ";
				card2 += "jack";
				break;
			case(Card.QUEEN):
				labelText += "Queen of ";
				card2 += "queen";
				break;
			case(Card.KING):
				labelText += "King of ";
				card2 += "king";
				break;
			case(Card.ACE):
				labelText += "Ace of ";
				card2 += "ace";
				break;
			}
		
		switch(getActivePlayerTwoCard().getSuit())
		{
			case(Card.HEART):
				labelText += "hearts";
				card2 += "h";
				break;
			case(Card.DIAMOND):
				labelText += "diamonds";
				card2 += "d";
				break;
			case(Card.SPADE):
				labelText += "spades";
				card2 += "s";
				break;
			case(Card.CLUB):
				labelText += "clubs";
				card2 += "c";
				break;
		}
		
		guiText.add(labelText);
		guiText.add(card1);
		guiText.add(card2);
		
		return guiText;
		
	}
	
	
}
