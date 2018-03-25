import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class CardDeck {
	private List<Card> list;
	private Card[] deck;
	private List<Card> hand;
	
	public CardDeck()
	{
		deck = new Card[52];
		int count = 0;
		for(Suit suit : Suit.values())
			for(Face face : Face.values())
				deck[count++] = new Card(face, suit);
		list = Arrays.asList(deck);
		hand = new ArrayList<Card>();
	}
	public void shuffle()
	{
		Collections.shuffle(list);
	}
	public void printDeck()
	{
		for(int i =0; i<list.size(); i++)
			System.out.printf("%-19s%s", list.get(i),((i+1)%4==0)?"\n":"");
	}
	public void dealHand()
	{
		for(int i =0;i<13;i++)
			hand.add(list.get(i));
	}
	public void sortHand()
	{
		CardComparator cardComparator = new CardComparator();
		Collections.sort(hand,cardComparator);
	}
	public void printHand()
	{
		for(int i =0; i<hand.size(); i++)
			System.out.printf("%-19s%s", hand.get(i),((i+1)%4==0)?"\n":"");
	}
	public Card getCard(int i)
	{
		return deck[i];	
	}
}
