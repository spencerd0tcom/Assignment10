import java.util.ArrayList;

/* Spencer Binondo 
 * CS110A
 * Class holds info about player specific cards*/

public class Player extends Deck 
{
	private ArrayList<Card> inactiveHand;
	
	public Player(ArrayList<Card> aDeck)
	{
		super(aDeck);
		
		inactiveHand = new ArrayList<Card>();
	}
	
	public void winHandling(ArrayList<Card> wonCards)
	{
		for(Card aCard: wonCards)
		{
			inactiveHand.add(aCard);
		}
	}
	
	public void reshuffle()
	{
		for(Card aCard: inactiveHand)
		{
			this.getDeck().add(aCard);
		}
	}
}