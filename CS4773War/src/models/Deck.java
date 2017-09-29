package models;
import java.util.*;

/**
 * A deck of cards. A complete deck or individual cards can be added.
 * Can shuffle, print, and remove a card.
 */
public class Deck {
	
	
	ArrayList<Card> cards;
	
	/**
	 * Allocates memory for the card list in the deck constructed.
	 */
	public Deck() {
		cards = new ArrayList<>();
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
	
	/**
	 * Using collections library, it shifts the cards in the deck around 
	 */
	private void shuffleDeck() {
		Collections.shuffle(cards);
	}
	
	
	/**
	 * Rather than creating a complete deck of 52 cards, it adds a single card.
	 * This is mostly for testing outcomes in JUnit.
	 * @param card			The card being added to the deck
	 */
	public void addCard(Card card)
	{
		cards.add(card);
	}

	/**
	 * Prints all cards in the deck
	 */
	public void printDeck(){
		for(Card card: cards){
			System.out.print(card.suit+" " +card.rank+"\n");
		}
	}

	/**
	 * Removes a single card from the deck
	 * @return			The card removed from the list of cards
	 */
	public Card removeCard() {
		return cards.remove(0);
	}
	
}
