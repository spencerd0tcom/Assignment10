import java.util.ArrayList;
import java.util.Random;

/* Spencer Binondo
 * CS110A
 * Class holds an amount of cards.*/

public class Deck 
{
	private final int PLAYING_CARD_DECK_SIZE = 52;
	private ArrayList <Card> theDeck;
	
	public Deck()
	{
		theDeck = new ArrayList<>();
		for(int i = 2; i <= 14; i++ )
		{
			Card currCard = new Card(0,i);
			Card [] cards = currCard.triplicateCard();
			
			theDeck.add(currCard);
			for(Card aCard: cards)
			{
				theDeck.add(aCard);
			}
		}
	}
	
	public Deck(Deck aDeck)
	{
		theDeck = aDeck.getDeck();
	}
	
	public Deck(ArrayList<Card> aDeck)
	{
		theDeck = aDeck;
	}
	
	public ArrayList<Card> deal()
	{
		ArrayList <Card> otherHand = new ArrayList<>();
		Random cardRandomizer = new Random();
		
		for(int i = 0; i < PLAYING_CARD_DECK_SIZE / 2; i++)
		{
			int aCard = cardRandomizer.nextInt(theDeck.size());
			
			otherHand.add(theDeck.get(aCard));
			theDeck.remove(aCard);
		}
		
		return otherHand;
	}
	
	public ArrayList<Card> getDeck()
	{
		return theDeck;
	}
	
	public Card draw()
	{
		Card currCard = theDeck.get(0);
		theDeck.remove(0);
		
		return currCard;
		
	}
	
	
}
