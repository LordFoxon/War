package models;


/**
 * An object representing a traditional card structure with rank and suit.
 * Allows comparing and printing
 */
public class Card implements Comparable<Card>{

	Suits suit;
	Ranks rank;

	/**
	 * Creates a card and sets the suit and rank of the card
	 * @param suit		Suit based on the Suits enum
	 * @param rank		Rank based on Ranks enum
	 */
	public Card(Suits suit, Ranks rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Card card){
		return rank.compareTo(card.rank);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return rank + " of " + suit + " as up card";
	}
}
