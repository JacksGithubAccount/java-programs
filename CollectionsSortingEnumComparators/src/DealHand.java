
public class DealHand {
	CardDeck deck = new CardDeck();
	public void dealHand()
	{
		deck.printDeck();
		deck.shuffle();
		System.out.println("=============");
		System.out.println();
		deck.printDeck();
		System.out.println("------------------");
		deck.dealHand();
		deck.printHand();
		System.out.println();
		System.out.println("------------------");
		deck.sortHand();
		deck.printHand();
	}
	
}
 