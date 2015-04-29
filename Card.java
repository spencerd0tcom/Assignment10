/* Spencer Binondo
 * CS110A
 * Class holds information of a playing card.  */
public class Card 
{
	public static final int HEART = 0, DIAMOND = 1, SPADE = 2, CLUB = 3, 
		JACK = 11, QUEEN = 12, KING = 13, ACE = 14;
	private int suit, value;
	
	//Constructor; sets suit and value to the received values
	public Card(int aSuit, int aValue)
	{
		suit = aSuit;
		value = aValue;
	}
	
	//Constructor; copies the values from received Card object
	public Card(Card aCard)
	{
		value = aCard.getValue();
		suit = aCard.getSuit();
	}
	
	//Returns value
	public int getValue()
	{
		return value;
	}
	
	//Returns suit
	public int getSuit()
	{
		return suit;
	}
	
	//Returns whether or not this card object and
	//received Card have equal values
	public boolean isEqual(Card aCard)
	{
		return value == aCard.getValue();
	}
	
	//Returns whether or not this card object
	//has a higher value than the received Card
	public boolean greaterThan(Card aCard)
	{
		return value > aCard.getValue();
	}
	
	//Returns an array of three more cards of the received 
	//card
	public Card[] triplicateCard()
	{
		Card[] cards = new Card[3];
		for(int i = 0; i < 3; i++)
		{
			cards[i] = new Card(i+1, this.value);
		}
		
		return cards;
	}
	
}
