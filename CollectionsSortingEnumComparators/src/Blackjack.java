import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
enum WinnerEnum {Player, Dealer, Unknown};

public class Blackjack {
	Scanner scanner = new Scanner(System.in);
	LinkedList<Card> playersHand = new LinkedList<Card>();
	LinkedList<Card> dealersHand = new LinkedList<Card>();
	LinkedList<Integer> playersValues = new LinkedList<Integer>();
	LinkedList<Integer> dealersValues = new LinkedList<Integer>();
	CardDeck deck = new CardDeck();
	Card card = null;
	WinnerEnum winner;
	int i = 0;
	int bestPlayerValue = 0;
	int bestDealerValue = 0;
	int choiceInt = 0;
	boolean dealerDone = false;
	boolean playerBust = false;
	boolean dealerBust = false;
	public void dealHand()
	{
		boolean done = false;
		deck.shuffle();
		
			playersHand.add(deck.getCard(i));
			i++;
			playersHand.add(deck.getCard(i));
			i++;
			System.out.println("Player's Hand");
			printPlayersHand(playersHand);
			dealersHand.add(deck.getCard(i));
			i++;
			dealersHand.add(deck.getCard(i));
			i++;
			System.out.println();
			System.out.println("Dealer's Hand");
			printDealersHand(dealersHand);
		while (! done)
		{
			System.out.println();
			System.out.println("What  do you do?");
			System.out.println("[1] - Hit");
			System.out.println("[2] - Stay");
			try
			{
			choiceInt = scanner.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("That's not a choice.");
				continue;
			}
			
			if(choiceInt == 1)
			{
				playersHand.add(deck.getCard(i));
				
				System.out.println("Player's Hand");
				printPlayersHand(playersHand);
				if(findValue(playersHand) > 21)
				{
					System.out.println("Busted!");
					done = true;
					playerBust = true;
					break;
				}
				//see if blackjack
				for(int t = 0; t < playersHand.size(); t++)
				{
					if(playersHand.get(t).getSuitValue() == 3 || playersHand.get(t).getSuitValue() == 1 && playersHand.get(t).getFaceValue() == 10)
					{
						
					}
				}
				i++;
			}
			else if(choiceInt == 2)
			{
				if(dealerDone = true)
				{
					done = true;
				}
			}
			else
			{
				System.out.println("That's not a choice.");
				continue;
			}
			if(findValue(playersHand) == 21)
			{
				System.out.println("You win!");
				done = true;
				break;
			}
			//derrr
			if(findValue(dealersHand) < 17)
			{
				dealersHand.add(deck.getCard(i));
				i++;
				System.out.println("Dealer's Hand");
				printDealersHand(dealersHand);
				
			}
			else
			{
				dealerDone = true;
			}
			if(findValue(dealersHand) > 21)
			{
				System.out.println("Dealer Busted!");
				System.out.println("Dealer's Hand");
				printDealersFullHand(dealersHand);
				dealerBust = true;
				done = true;
				break;
			}
			if(findValue(dealersHand) == 21)
			{
				System.out.println("Dealer Wins!");
				System.out.println("Dealer's Hand");
				printDealersFullHand(dealersHand);
				done = true;
				break;
			}
			
			
		}
		if(findValue(playersHand) > findValue(dealersHand) && playerBust == false)
		{
			System.out.println("You win!");
			System.out.println("Player's Hand");
			printPlayersHand(playersHand);
			System.out.println();
			System.out.println("Dealer's Hand");
			printDealersFullHand(dealersHand);
		}
		if(findValue(playersHand) < findValue(dealersHand) && dealerBust == false)
		{
			System.out.println("Dealer win!");
			System.out.println("Player's Hand");
			printPlayersHand(playersHand);
			System.out.println();
			System.out.println("Dealer's Hand");
			printDealersFullHand(dealersHand);
		}
		if(findValue(playersHand) == findValue(dealersHand) && dealerBust == false && playerBust == false)
		{
			System.out.println("Draw!");
			System.out.println("Player's Hand");
			printPlayersHand(playersHand);
			System.out.println();
			System.out.println("Dealer's Hand");
			printDealersFullHand(dealersHand);
		}
	}
	
	private static void printPlayersHand(LinkedList<Card> playersHand)
	{
		for(int i =0; i<playersHand.size(); i++)
			System.out.printf("%-19s%s", playersHand.get(i),((i+1)%4==0)?"\n":"");
	}
	private static void printDealersFullHand(LinkedList<Card> dealersHand)
	{
		for(int i =0; i<dealersHand.size(); i++)
			System.out.printf("%-19s%s", dealersHand.get(i),((i+1)%4==0)?"\n":"");
	}
	private static void printDealersHand(LinkedList<Card> dealersHand)
	{
		System.out.print("Unknown   ");
		for(int i =1; i<dealersHand.size(); i++)
			System.out.printf("%-19s%s", dealersHand.get(i),((i+1)%4==0)?"\n":"");
	}
	private static ArrayList<Integer> values(LinkedList<Card> hand)
	{
		ArrayList<Integer> values = new ArrayList<Integer>();
		for(int i = 0; i < hand.size(); i++)
		{
			values.add(hand.get(i).getFaceValue());
		}
		return values;
	}
	private static void printValues(LinkedList<Integer> values)
	{
		for(int i =0; i<values.size(); i++)
			System.out.printf("%-19s%s", values.get(i),((i+1)%4==0)?"\n":"");
	}
	private static int findValue(LinkedList<Card> hand)
	{
		int handValue = 0;
		for(int m = 0; m < hand.size(); m ++)
			handValue += hand.get(m).getFaceValue();
		return handValue;
	}
}
