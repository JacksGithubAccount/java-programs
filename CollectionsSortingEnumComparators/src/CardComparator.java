import java.util.Comparator;
public class CardComparator implements Comparator<Card>{
	
	public int compare(Card card1, Card card2)
	{
	if(card1.getSuitValue() < card2.getSuitValue())
	{
		return -1;
	}
	else if(card1.getSuitValue() > card2.getSuitValue())
	{
		return +1;
	}
	else if(card1.getFaceValue() < card2.getFaceValue())
	{
		return -1;
	}
	else if(card1.getFaceValue() > card2.getFaceValue())
	{
		return +1;
	}
	else
	{
		return 0;
	}
	}

}