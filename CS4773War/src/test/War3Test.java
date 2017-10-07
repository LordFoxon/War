package test;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Card;
import models.Deck;
import models.Ranks;
import models.Suits;
import war.WarVariation3;

public class War3Test {

	@Test
	public void War3TestWithTie() throws Exception {
		Deck deck = new Deck();
		deck.createEmptyDeck();
		for(int i = 0 ; i < 10; i++) {
			deck.cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		}
		WarVariation3 war3 = new WarVariation3(deck);		
		assertEquals(null, war3.winningPlayer);
	}
	
	@Test
	public void War3WithPlayer2AsWinner() {
		Deck deck = new Deck();
		deck.createEmptyDeck();
		for(int i = 0 ; i < 10; i++) {
			deck.cards.add(new Card(Suits.DIAMONDS, Ranks.TWO));
			deck.cards.add(new Card(Suits.DIAMONDS, Ranks.TEN));
			deck.cards.add(new Card(Suits.DIAMONDS, Ranks.FIVE));

		}
		WarVariation3 war3 = new WarVariation3(deck);		
		assertEquals("Bridget", war3.winningPlayer.name);
	}
	
	@Test
	public void War3WithPlayer3AsWinner() {
		Deck deck = new Deck();
		deck.createEmptyDeck();
		for(int i = 0 ; i < 10; i++) {
			deck.cards.add(new Card(Suits.DIAMONDS, Ranks.TWO));
			deck.cards.add(new Card(Suits.DIAMONDS, Ranks.TEN));
			deck.cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		}
		WarVariation3 war3 = new WarVariation3(deck);		
		assertEquals("Pablo", war3.winningPlayer.name);
	}

}
