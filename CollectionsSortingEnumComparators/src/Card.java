
public class Card {
	private Face face;
	private Suit suit;
	
	public Card(Face face, Suit suit)
	{
	this.face = face;
	this.suit = suit;
	}
	public int getSuitValue()
	{
		return suit.getSuit();
	}
	public int getFaceValue()
	{
		return face.getFace();
	}
	public String toString()
	{
		return String.format(face + " of " + suit);
	}
	public void getFace()
	{
		
	}
}
