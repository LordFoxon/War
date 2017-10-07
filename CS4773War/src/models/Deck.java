package models;
import java.util.*;

/**
 * A deck of cards. A complete deck or individual cards can be added.
 * Can shuffle, print, and remove a card.
 */
public class Deck extends Pile{
	
	
	/**
	 * Allocates memory for the card list in the deck constructed.
	 */
	public Deck() {
		super();
	}
	
	/**
	 * Creates a full deck of 52 cards and then shuffles
	 */
	public void createDeck() {
		for(Suits suit: Suits.values())
			for(Ranks rank: Ranks.values())
				cards.add(new Card(suit, rank));
		shuffleDeck();
	}
	
	public void createEmptyDeck() {
		
	}
	/**
	 * Using collections library, it shifts the cards in the deck around 
	 */
	private void shuffleDeck() {
		Collections.shuffle(cards);
	}
	

	/**
	 * Prints all cards in the deck
	 */
	public void printDeck(){
		for(Card card: cards){
			System.out.print(card.suit+" " +card.rank+"\n");
		}
	}
	
}
