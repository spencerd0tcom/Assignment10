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
	
	public GameHandler(Player firstPlayer, Player secondPlayer)
	{
		player1 = firstPlayer;
		player2 = secondPlayer;
		
		playedCards = new ArrayList<Card>();
		
		newRound();
		
		playedCards.add(activePlayerOneCard);
		playedCards.add(activePlayerTwoCard);
	}
	
	public GameHandler(GameHandler aGame)
	{
		player1 = aGame.getPlayer1();
		player2 = aGame.getPlayer2();
		
		playedCards = aGame.getPlayedCards();
		
		activePlayerOneCard = aGame.getActivePlayerOneCard();
		activePlayerTwoCard = aGame.getActivePlayerTwoCard();
	}
	
	public void newRound()
	{
		activePlayerOneCard = player1.draw();
		activePlayerTwoCard = player2.draw();
	}
	
	public Player getPlayer1()
	{
		return player1;
	}
	
	public Player getPlayer2()
	{
		return player2;
	}
	
	public ArrayList<Card> getPlayedCards()
	{
		return playedCards;
	}
	
	public Card getActivePlayerOneCard()
	{
		return activePlayerOneCard;
	}
	
	public Card getActivePlayerTwoCard()
	{
		return activePlayerTwoCard;
	}
	
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
			//Call warBattle method; something like
			//battleCards = warBattleHandling
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
	
	public ArrayList<Player> roundResults()//potentially have some text box manipulation
	{
		ArrayList<Player> players = new ArrayList<Player>();
		
		return players;
	}
}
