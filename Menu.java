import java.util.Scanner;

public class Menu {
	
	Scanner input = new Scanner(System.in);
	
	public void startTheGame()
	{
		System.out.println("Welcome to the game!\n");
		
		System.out.println("Let's begin by naming each player! \n");
		
		System.out.print("Please enter the name of the first player: ");
		String firstPlayer = input.nextLine();
		
		System.out.print("Please enter the name of the second player: ");
		String secondPlayer = input.nextLine();
		
		// instantiate the deck object
		Deck deck = new Deck();
		Player player1 = new Player(firstPlayer);
		Player player2 = new Player(secondPlayer);
		deck.shuffle();
		
		// deal cards to each player
		for(int i = 0; i<52; i++)
		{
			if(i%2 == 0)
			{
				player1.draw(deck);
			}
			else
			{
				player2.draw(deck);
			}
		}
		
		System.out.println("Let's begin with the first player!\n");
		
		System.out.println("=======================================");
		// the game starts for 26 rounds
		for(int i = 0; i<26; i++)
		{
			System.out.println("Round #" + (i+1));
			System.out.println();
			System.out.println("First player goes!");
			
			int cardFirstPlayer = cardSelected(player1,i);
			
			Card player1_card = player1.dealCard(cardFirstPlayer);
			
			
			
			System.out.println("Now it's the turn of the second player!!");
			
			int cardSecondPlayer = cardSelected(player2,i);
			
			Card player2_card = player2.dealCard(cardSecondPlayer);
			
			System.out.println();
			System.out.println("======================================="); 
			System.out.println("Result for the round number #"+(i+1));
			System.out.println();
			System.out.print(firstPlayer + "'s ");
			player1_card.describe();
			
			System.out.println();
			System.out.print(secondPlayer + "'s ");
			player2_card.describe();
			
			System.out.println();
			
			//validating card values
			if(player1_card.getValue()> player2_card.getValue())
			{
				player1.scoreIncrement();
				System.out.println(firstPlayer+ " wins this round.");
			}
			
			else if(player2_card.getValue()> player1_card.getValue())
			{
				player2.scoreIncrement();
				System.out.println(secondPlayer+ " wins this round.");
			}
			
			else
			{
				System.out.println("This round is a tie, neither player wins.");
			}
			
			System.out.println();
			
			//display the winner for each round
			System.out.println();
			System.out.printf(firstPlayer+"'s score = %d\n", player1.getScore());
			System.out.printf(secondPlayer+"'s score = %d\n", player2.getScore());
			System.out.println();
			System.out.println("=======================================");
			
		}
		
		System.out.println("Final result after 26 rounds.");
		
		//display the winner for the game
		System.out.println();
		System.out.printf(firstPlayer+"'s final score = %d\n", player1.getScore());
		System.out.printf(secondPlayer+"'s final score = %d\n", player2.getScore());
		System.out.println();
		
		System.out.println(); 
		if(player1.getScore() > player2.getScore())
		{
			System.out.println("Congratulations, " + firstPlayer);
			System.out.println("You are the winner!");
			
		}
		else if(player1.getScore() < player2.getScore())
		{
			System.out.println("Congratulations, " + secondPlayer);
			System.out.println("You are the winner!");			
		}
		else
		{
			System.out.println("War ends in a tied.");
		}
		
		
		
	}
	
	public void viewRules()
	{
		System.out.println("Greetings and welcome to the game rules page!");
		System.out.println("This game has pretty simple rules.");
		System.out.println();
		System.out.println("**  There can be only two players in this game."
				+ "\n    A full deck of cards is dealt to two players."
				+ "\n    Each player receives 26 cards out of a standard 52-card deck. ");
		System.out.println("**  In each round, both players need to drop one card from their hands, and whoever has the card with the highest value gets one point. ");
		System.out.println("**  If the cards that are dealt have the same value, then it is a tie, and neither player wins. ");
		System.out.println("**  Finally, after a maximum of 26 rounds, the winner will be the one with the most points.");
	}
	
	public int cardSelected(Player player,int i)
	{
		System.out.println("Press SPACE and then ENTER key to reveal your cards. ");
		String cont = input.nextLine() ;
	    while(!cont.equals(" ")) 
	    {
	        cont = input.nextLine();

	    }
		System.out.println("=======================================================================");
		System.out.println();
		player.describe();
		System.out.println();
		System.out.println("=======================================================================");
		int choice = 0;
		
		//loop until the user input the correct choice
		do
		{
			System.out.print("Please select a card to deal: (Enter the number from 1 to " + (26-i)+"):");
			choice = input.nextInt();
		
			if(choice   <1 || choice >26)
			{
				System.out.println("Please enter the correct choice in the range between: 1-" + (26-i)+"):");
			}
		
		}while(choice   <1 ||choice >26);
		
		Card selected_Card = player.selected(choice-1);
		
		
		System.out.println("You selected ");
		selected_Card.describe();
		int confirm_option1 = 0;
		System.out.println();
		
		do
		{
			System.out.println("\nDo you want to use this card? ");
			System.out.println("1). Yes ");
			System.out.println("2). No ");
			System.out.println("Please confirm your choice: "); 
		
			confirm_option1 = input.nextInt();
		
			System.out.println();
		
			if(confirm_option1 == 1)
			{
				return (choice -1);
			}
		
			else if(confirm_option1 == 2)
			{
				System.out.println("Please select the card again.");
				cardSelected(player,i);
			}
		
			else
			{
				System.out.println("Please select the valid option");
			}
		
		}while(confirm_option1   <1 || confirm_option1 >2);
		
		return (choice -1);

		
	}
	
	

}
