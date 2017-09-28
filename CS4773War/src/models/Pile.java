package models;

import java.util.*;

public class Pile {
	public static final int HALFOFDECK = 26;
	
	public ArrayList<Card> cards;
	public Pile(Deck deck) {
		cards = new ArrayList<>();
		System.out.println(deck.cards.size());
		int i = 0;
		for (i=0; i < HALFOFDECK ; i = i+1)
			cards.add(deck.removeCard());
	}

	public Pile(){
		cards = new ArrayList<>();		
	}
	
	public void addCard(Card card){
		cards.add(card);
	}
	
	public Card removeCard(){
		return cards.remove(0);
	}
}
