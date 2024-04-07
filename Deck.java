import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck 
{
	private final List<Card> cards = new ArrayList<Card>();
	private final List<String> suits = Arrays.asList("Hearts", "Diamonds", "Spades", "Clubs");
	
	// create a deck of card 52.
	public Deck()
	{
		for(int i = 2; i<15; i++)
		{
			for(String suit: suits)
			{
				cards.add(new Card(suit,i));
			}
		}
	}
	
	public void shuffle()
	{
		Collections.shuffle(cards);
	}
	
	public int getSize()
	{
		return this.cards.size();
	}
	
	public Card draw() {
		return cards.remove(0);
	}
	
	public String toString()
	{
		String output = "";
		for (Card a_card : cards)
		{
			output += a_card.toString() + "\n";
		}
		return output;
	}
}
