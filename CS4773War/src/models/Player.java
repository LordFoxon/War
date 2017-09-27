package models;

public class Player {
	
	String name;
	public Pile pile;
	public Player(String name, Deck deck) {
		this.name = name;
		pile = new Pile(deck);
	}

}
