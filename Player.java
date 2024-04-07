import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Card> hand = new ArrayList<Card>();
	
	private int score;
	private String name;
	
	public Player()
	{
		score = 0;
	}
	
	public Player(String newName)
	{
		name = newName;
		score = 0;
	}
	
	public void describe()
	{
		System.out.printf("%s ,these are the cards you have: \n", name);
		int i=1;
		for(Card card: hand)
		{
			System.out.print(i + ") ");
			card.describe();
			i++;
			System.out.println();
		}
	}
	
	public Card dealCard(int i)
	{
		return hand.remove(i);
	}
	
	public void draw(Deck deck)
	{
		hand.add(deck.draw());
	}
	
	public void scoreIncrement() 
	{
		score++;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public Card selected(int j)
	{
		return hand.get(j);
	}
	
}
