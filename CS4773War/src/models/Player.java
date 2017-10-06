package models;

import war.War;
import war.WarVariation1;

/**
 * Someone who engages in the game.
 * Keeps track of hand and score of each player.
 */
public class Player {

	public String name;
	public Pile hand;
	public int score = 0;
	/**
	 * Creates a player and initializes their name and hand
	 * @param name			The first name of the player
	 * @param deck			The main deck split in half
	 * @param numberOdCards The number of cards to be designated to each player
	 */
	public Player(String name, Deck deck, int numberOfCards ) {
		this.name = name;
		hand = new Pile(deck.cards, numberOfCards);
	}
	
	public int getNumberOfCards(War variation){
		if (variation instanceof WarVariation1)
			return this.hand.cards.size();
		return this.score;
	}
}
