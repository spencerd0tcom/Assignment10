import java.util.ArrayList;

/* Spencer Binondo 
 * CS110A
 * Class holds info about player specific cards*/

public class Player extends Deck 
{
	private ArrayList<Card> inactiveHand;
	
	//Constructor; sets the deck from Deck inheritance and instantiates 
	//inactiveHand
	public Player(ArrayList<Card> aDeck)
	{
		super(aDeck);
		
		inactiveHand = new ArrayList<Card>();
	}
	
	//Receives an ArrayList and inserts them into
	//inactiveHand
	public void winHandling(ArrayList<Card> wonCards)
	{
		for(Card aCard: wonCards)
		{
			inactiveHand.add(aCard);
		}
	}
	
	//Empties inactiveHand into theDeck
	public void reshuffle()
	{
		for(Card aCard: inactiveHand)
		{
			this.getDeck().add(aCard);
		}
		
		inactiveHand.clear();
	}
	
	//Returns the size of inactiveHand
	public int inactiveHandSize()
	{
		return inactiveHand.size();
	}
}