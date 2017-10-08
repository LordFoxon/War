package test;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Card;
import models.Deck;
import models.Ranks;
import models.Suits;
import war.WarVariation2;

public class War2Test {

	
	
	@Test
	public void Variation2WithWarWith1Cardleft(){
		Deck deck = new Deck();
		deck.createEmptyDeck();
		deck.cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		deck.cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		deck.cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		deck.cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		WarVariation2 war2 = new WarVariation2(deck);		
		assertEquals(null, war2.winningPlayer);
	}
	
	@Test
	public void Variation2WithNoCards(){
		System.out.println("\nNo cards no game");
		Deck deck = new Deck();
		deck.createEmptyDeck();
		WarVariation2 war2 = new WarVariation2(deck);
		assertEquals(null, war2.winningPlayer);
	}
	
	@Test
	public void Variaion2WithPlayer1Winning(){
		Deck deck = new Deck();
		deck.createEmptyDeck();
		deck.cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		deck.cards.add(new Card(Suits.DIAMONDS, Ranks.TWO));
		WarVariation2 war2 = new WarVariation2(deck);
		assertEquals("Berto", war2.winningPlayer.name);
	}

}
