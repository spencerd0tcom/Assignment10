
public class DeckTester {

	public static void main(String[] args) 
	{
		Deck currDeck = new Deck();
		
		Player hand1 = new Player(currDeck.deal());
		Player hand2 = new Player(currDeck.getDeck());
		
		currDeck = null;
		
		System.out.println("Hand 1 has: ");
		for(Card currCard: hand1.getDeck())
		{
			System.out.println("Value: " + currCard.getValue() + "   Suit: " + currCard.getSuit());
		}
		
		System.out.println("\n\nHand 2 has:");
		for(Card currCard: hand2.getDeck())
		{
			System.out.println("Value: " + currCard.getValue() + "   Suit: " + currCard.getSuit());
		}

	}

}
