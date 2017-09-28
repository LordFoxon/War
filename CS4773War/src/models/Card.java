package models;


public class Card implements Comparable<Card>{

	Suits suit;
	Ranks rank;

	public Card(Suits suit, Ranks rank) {
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public int compareTo(Card card){
		return rank.compareTo(card.rank);
	}

}
