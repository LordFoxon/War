package models;

import java.util.*;

/**
 * A heap of cards that can either represent the up pile or a player's hand
 */
public class Pile {
	public ArrayList<Card> cards;
	
	/**
	 * Creates a pile object having a list of cards and splits 52 cards evenly between the 2 players 
	 * @param deck			The deck of main cards		
	 * @param numberOfCards The number of cards to be taken out of the deck for each pile	
	 */	
	public Pile(ArrayList<Card> cards, int numberOfCards) {
		this.cards = new ArrayList<>();
		for (int i=0; i < numberOfCards ; i = i+1)
			this.cards.add(cards.remove(0));
	}

	
	/**
	 * Creates a pile object without the full deck 
	 */
	public Pile(){
		cards = new ArrayList<>();		
	}
	
	/**
	 * Adds a card to the list
	 * @param card			The card needing to be added
	 */
	public void addCard(Card card){
		cards.add(card);
	}
	
	
	/**
	 * Removes a single card from the pile's list
	 * @return			The card that was removed
	 */
	public Card removeCard(){
		return cards.remove(0);
	}
}
