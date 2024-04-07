public class Card {
	//Attributes

	private String name_card;
	private int value;
	
	public Card(String aSuit, int valueOfCard)
	{
		value = valueOfCard;
		
		switch(valueOfCard)
		{
			case 2: 
				name_card = "2";
				break;
			case 3:
				name_card = "3";
				break;
			case 4:
				name_card = "4";
				break;
			case 5:
				name_card = "5";
				break;
			case 6:
				name_card = "6";
				break;
			case 7:
				name_card = "7";
				break;
			case 8:
				name_card = "8";
				break;
			case 9:
				name_card = "9";
				break;
			case 10:
				name_card = "10";
				break;
			case 11:
				name_card = "Jack";
				break;
			case 12:
				name_card = "Queen";
				break;
			case 13:
				name_card = "King";
				break;
			case 14:
				name_card = "Ace";
				break;
		}
		
		name_card += " of " + aSuit;

	}
	
	// getters and setters
	public String getName()
	{
		return name_card;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void setName(String name)
	{
		this.name_card = name;
	}
	
	public void setValue(int value)
	{
		this.value = value;
	}

	public void describe() {
		System.out.printf("Card: %s", name_card);
	}
	
	public String toString()
	{
		return this.name_card;
	}
	
}
