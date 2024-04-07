/* CS 282 Intermediate Java Spring 2023
  * Cuyamaca College
  * Samvathna Em
  * Card Game Project
  * This card game project is intended to program the modified version of WAR card game.
  * This game will be text-driven and require users to type their choices from the keyboard.
  */

import java.util.Scanner;
public class WarGame 
{	
	
	public static void main(String[] args) 
	{
		System.out.println("<<<<<<<<<<<<<<<<<<<***>>>>>>>>>>>>>>>>>>>");
		System.out.println("              WAR card game");
		System.out.println("<<<<<<<<<<<<<<<<<<<***>>>>>>>>>>>>>>>>>>>");
		
		Menu game = new Menu();
		
		int choice=99;
		

		
		while(choice != 4)
		{
			choice = menu();
			switch(choice) 
			{
				case 1: 
					game.startTheGame();
					break;
				case 2: 
					game.viewRules();
					break;
				case 3:
					testMenu();
					break;
				case 4:
					System.out.println("Goodbye! ");
					break;
			}
		}
	}
	
	public static int menu()
	{
		int choice = 99;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("============================================");
		System.out.println("Welcome to the new version WAR card game:");
		System.out.println("1. Start a new game.\n"+
						   "2. View the rules of the game.\n"+
						   "3. Test calls.\n"+
						   "4. Exit Program\n");
		System.out.println("============================================");
		
		System.out.println("Please select your option: ");
		try 
		{
			choice = sc.nextInt();
			while(choice < 1 || choice >3)
			{
				System.out.println("Please enter a valid menu choice: ");
				
				choice = sc.nextInt();
			}
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("!!Non Integer entered!!");
			sc.next();
			choice=99;
		}
		

		
		System.out.println(); //prints blank line
		return choice;
	}
	
	//test mode
	public static void testMenu()
	{
			System.out.println("Test calls");
			
			Deck deck = new Deck();
			
			Scanner input = new Scanner(System.in);
			
			int choice = 99;

			while (choice != 5)
			{
				choice = menuForTest();
				switch (choice)
				{
				case 1:
					
					deck = new Deck();
					System.out.println("The new deck has been created.");
					break;
				
				case 2:
					deck.shuffle();
					System.out.println("The deck has been shuffled.");
					break;
				
				case 3:

					Card topCard = deck.draw();
					System.out.println("The top card of the deck is: " + topCard);
					System.out.println("This card has been removed from the deck.");
					
					break;
				
				case 4:
					System.out.println("Printing the current cards in the deck.");
					String current_Deck = deck.toString();
					System.out.println(current_Deck);
					break;
					
				case 5:
					System.out.println("Goodbye!");
					break;

				}
			}
	}

	private static int menuForTest()
	{
			int choice = 99;
			Scanner sc = new Scanner(System.in);

			System.out.println("======================================================="); 
			System.out.println("Enter the number for the Operation you wish to perform:");
			System.out.println("1. Create a new deck.\n"
					+ "2. Suffle the current deck of cards.\n"
					+ "3. View the top card and deal it out of the deck.\n"
					+ "4. Printing the current deck.\n"
					+ "5. Exit the test calls.\n");
			System.out.println("======================================================="); 
			System.out.println("Enter Choice: ");

			try
			{
				choice = sc.nextInt();
				while (choice < 1 || choice > 5)
				{
					System.out.println("Please enter a valid menu choice: ");

					choice = sc.nextInt();
				}
			}

			catch (java.util.InputMismatchException e)
			{
				System.out.println("!!Non Integer entered!!");
				sc.next();
				choice = 99;
			}

			System.out.println(); // prints blank line
			return choice;
	}
	
}
