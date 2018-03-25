
public enum Suit {
	Club(0),
	Diamond(1),
	Heart(2),
	Spade(3);
	
	private int suit;
	
	Suit(int suit)
	{
		this.suit = suit;
	}
	public int getSuit()
	{
		return suit;
	}
}
