package models;

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
	 */
	public Player(String name, Deck deck) {
		this.name = name;
		hand = new Pile(deck);
	}

}
