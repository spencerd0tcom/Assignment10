import java.util.ArrayList;
import java.util.Random;

/* Spencer Binondo
 * CS110A
 * Class holds an amount of cards.*/

public class Deck 
{
	public static final int DECK_SIZE = 52;
	private ArrayList <Card> theDeck;
	
	//Constructor; sets deck to have a full set of Card objects
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
	
	//Constructor; sets theDeck to the received Deck objects deck
	public Deck(Deck aDeck)
	{
		theDeck = aDeck.getDeck();
	}
	
	//Constructor; sets theDeck to the received ArrayList
	public Deck(ArrayList<Card> aDeck)
	{
		theDeck = aDeck;
	}
	
	//Randomly puts half of the deck into another ArrayList and returns it
	public ArrayList<Card> deal()
	{
		ArrayList <Card> otherHand = new ArrayList<>();
		Random cardRandomizer = new Random();
		
		for(int i = 0; i < DECK_SIZE / 2; i++)
		{
			int aCard = cardRandomizer.nextInt(theDeck.size());
			
			otherHand.add(theDeck.get(aCard));
			theDeck.remove(aCard);
		}
		
		return otherHand;
	}
	
	//Returns theDeck
	public ArrayList<Card> getDeck()
	{
		return theDeck;
	}
	
	//Returns the top card of the deck and removes it. 
	public Card draw()
	{
		Card currCard = theDeck.get(0);
		theDeck.remove(0);
		
		return currCard;
		
	}
	
	
}
