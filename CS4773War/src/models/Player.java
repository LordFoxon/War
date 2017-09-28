package models;

public class Player {
	
	public String name;
	public Pile hand;
	public int score = 0;
	public Player(String name, Deck deck) {
		this.name = name;
		hand = new Pile(deck);
	}

}
