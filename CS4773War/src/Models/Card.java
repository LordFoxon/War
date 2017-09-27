package Models;


public class Card implements Comparable<Card>{

	Suits suit;
	Ranks rank;

	public Card(Suits suit, Ranks rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public boolean equals(Card compare) {
		if(compare.rank == rank)
			return true;
		return false;
	}
	@Override
	public int compareTo(Card compare) {
		return rank.compareTo(compare.rank);
	}

}
