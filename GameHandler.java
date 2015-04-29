import java.util.ArrayList;

/* Spencer Binondo
 * CS110A
 * Class handles game results by processing cards.  */
public class GameHandler 
{
	private Player player1; 
	private Player player2;
	private ArrayList<Card> playedCards;
	private Card activePlayerOneCard;
	private Card activePlayerTwoCard;
	
	//Constructor; instantiates GameHandler with the values of the received Player objects
	public GameHandler(Player firstPlayer, Player secondPlayer)
	{
		player1 = firstPlayer;
		player2 = secondPlayer;
		
		playedCards = new ArrayList<Card>();
		
		newRound();
		
		playedCards.add(activePlayerOneCard);
		playedCards.add(activePlayerTwoCard);
	}
	
	//Constructor; copies values of received GameHandler object
	public GameHandler(GameHandler aGame)
	{
		player1 = aGame.getPlayer1();
		player2 = aGame.getPlayer2();
		
		playedCards = aGame.getPlayedCards();
		
		activePlayerOneCard = aGame.getActivePlayerOneCard();
		activePlayerTwoCard = aGame.getActivePlayerTwoCard();
	}
	
	//Sets the new cards to the next cards in each player's decks; reshuffles decks
	//if they're empty
	public void newRound()
	{
		if(player1.getDeck().isEmpty())
		{
			reshufflePlayer1();
		}
		if(player2.getDeck().isEmpty())
		{
			reshufflePlayer2();
		}
		
		activePlayerOneCard = player1.draw();
		activePlayerTwoCard = player2.draw();
	}
	
	//Returns player1
	public Player getPlayer1()
	{
		return player1;
	}
	
	//Returns player1
	public Player getPlayer2()
	{
		return player2;
	}
	
	//Reshuffles player1's deck
	public void reshufflePlayer1()
	{
		player1.reshuffle();
	}
	
	//Reshuffles player2's deck
	public void reshufflePlayer2()
	{
		player2.reshuffle();
	}
	
	//Returns player1's current deck size
	public int getPlayer1DeckSize()
	{
		return player1.getDeck().size();
	}
	
	//Returns player2's current deck size
	public int getPlayer2DeckSize()
	{
		return player1.getDeck().size();
	}
	
	//Returns the size of player1's inactive card stack
	public int getPlayer1InactiveSize()
	{
		return player1.inactiveHandSize();
	}
	
	//Returns the size of player2's inactive card stack
	public int getPlayer2InactiveSize()
	{
		return player2.inactiveHandSize();
	}
	
	//Returns the currently played cards as an ArrayList
	public ArrayList<Card> getPlayedCards()
	{
		return playedCards;
	}
	
	//Returns player1's current active card
	public Card getActivePlayerOneCard()
	{
		return activePlayerOneCard;
	}
	
	//Returns player2's current active card
	public Card getActivePlayerTwoCard()
	{
		return activePlayerTwoCard;
	}
	
	//Evaluates the winner of the current round and sends the winning cards to the respective
	//player's inactive pile
	public void standardBattleHandling()
	{
	
		if(activePlayerOneCard.isEqual(activePlayerTwoCard))
		{
			warBattleHandling();
		}
		else if(activePlayerOneCard.greaterThan(activePlayerTwoCard))
		{
			player1.winHandling(playedCards);
			
		}
		else
		{
			player2.winHandling(playedCards);
		}
		
	}
	
	//Handles battles when war occurs
	public void warBattleHandling()
	{
		playedCards.add(player1.draw());
		playedCards.add(player2.draw());
		
		activePlayerOneCard = player1.draw();
		activePlayerTwoCard = player2.draw();
		
		playedCards.add(activePlayerOneCard);
		playedCards.add(activePlayerTwoCard);
		
		if(activePlayerOneCard.isEqual(activePlayerTwoCard))
		{
			warBattleHandling();
		}
		if(activePlayerOneCard.greaterThan(activePlayerTwoCard))
		{
			player1.winHandling(playedCards);
		}
		else
		{
			player2.winHandling(playedCards);
		}
		
	}
}
