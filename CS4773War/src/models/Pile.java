package models;

import java.util.*;

public class Pile {
	public static final int HALFOFDECK = 26;
	
	ArrayList<Card> cards;
	public Pile(Deck deck) {
		cards = new ArrayList<>();
		for (int i=0; i < HALFOFDECK ; i++)
			cards.add(deck.cards.remove(i));
	}

	public Pile(){
		cards = new ArrayList<>();		
	}
	
	public void addCard(Card card){
		cards.add(card);
	}
	
	public Card removeCard(){
		return cards.remove(cards.size());
	}
}
