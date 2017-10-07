package test;

import static org.junit.Assert.*;
import org.junit.Test;
import models.*;
import war.*;

public class War1Test {
	
	
	@Test
	public void Variation1Player1Won(){
		System.out.println("\nVariation 1 with Player 1 as Winner Test!!");
		Deck deck = new Deck();
		deck.createEmptyDeck();
		deck.cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		deck.cards.add(new Card(Suits.DIAMONDS, Ranks.TWO));
		WarVariation1 war1 = new WarVariation1(deck);		
		assertEquals("Berto", war1.winningPlayer.name);
	}
	
	@Test
	public void Variation1Player2Won(){
		System.out.println("\nVariation 1 with Player 2 as Winner Test!!");
		Deck deck = new Deck();
		deck.createEmptyDeck();
		deck.cards.add(new Card(Suits.DIAMONDS, Ranks.TWO));
		deck.cards.add(new Card(Suits.DIAMONDS, Ranks.THREE));
		WarVariation1 war1 = new WarVariation1(deck);	
		System.out.println(war1.winningPlayer.name);
		assertEquals("Barf", war1.winningPlayer.name);
	}
	
	@Test
	public void Variation1Tie(){
		System.out.println("\n\n\nVariation 1 with tie");
		Deck deck = new Deck();
		deck.createEmptyDeck();
		deck.cards.add(new Card(Suits.HEARTS, Ranks.TWO));
		deck.cards.add(new Card(Suits.HEARTS, Ranks.TEN));
		deck.cards.add(new Card(Suits.HEARTS, Ranks.FIVE));
		deck.cards.add(new Card(Suits.HEARTS, Ranks.FOUR));
		WarVariation1 war1 = new WarVariation1(deck);	
		assertEquals(null, war1.winningPlayer);
	}
	

}
