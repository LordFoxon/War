package models;

import java.util.*;

/**
 * A heap of cards that can either represent the up pile or a player's hand
 */
public class Pile {
	public static final int HALFOFDECK = 26;
	
	public ArrayList<Card> cards;
	
	/**
	 * Creates a pile object having a list of cards and splits 52 cards evenly between the 2 players 
	 * @param deck			The deck of main cards			
	 */
	public Pile(Deck deck) {
		cards = new ArrayList<>();
		for (int i=0; i < HALFOFDECK ; i = i+1)
			cards.add(deck.removeCard());
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
