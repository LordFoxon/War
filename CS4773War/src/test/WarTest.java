package test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

import models.*;
import war.*;

public class WarTest {

	
	@Test
	public void firstWar1TestWithBertoAsWinner() throws Exception {
		ArrayList<Card> cards =  new ArrayList<Card>();
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));

		Deck deck = new Deck();
		deck.cards = cards;
		WarVariation3 war1 = new WarVariation3(deck);		
		assertEquals(null, war1.getWinner());

	}
	@Test
	public void Variation2WithWarWith1Cardleft(){
		ArrayList<Card> cards =  new ArrayList<Card>();
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		cards.add(new Card(Suits.DIAMONDS, Ranks.ACE));
		Deck deck = new Deck();
		deck.cards = cards;
		WarVariation2 war1 = new WarVariation2(deck);		
		assertEquals(null, war1.getWinner());
	}
	
	@Test
	public void Variation1WithWarWith1Cardleft(){
		
	}
	@Test
	public void Variation2WithNoCards(){
		
	}
	
	

}
