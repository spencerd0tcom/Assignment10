/* Spencer Binondo
 * CS110A
 * Class holds information of a playing card.  */
public class Card 
{
	public static final int HEART = 0, DIAMOND = 1, SPADE = 2, CLUB = 3, 
		JACK = 11, QUEEN = 12, KING = 13, ACE = 14;
	private int suit, value;
	
	public Card(int aSuit, int aValue)
	{
		suit = aSuit;
		value = aValue;
	}
	
	public Card(Card aCard)
	{
		value = aCard.getValue();
	}
	
	public int getValue()
	{
		return value;
	}
	
	public int getSuit()
	{
		return suit;
	}
	
	public boolean isEqual(Card aCard)
	{
		if(value == aCard.getValue())
		{
			return true;
		}
		
		return false;
	}
	
	public boolean greaterThan(Card aCard)
	{
		if(value > aCard.getValue())
		{
			return true;
		}
		
		return false;
	}
	
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
