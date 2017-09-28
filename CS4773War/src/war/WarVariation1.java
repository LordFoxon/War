package war;

import logger.Logger;
import models.*;

public class WarVariation1 {

	public static final int PLAYER1VICTORY = 1;
	public static final int PLAYER2VICTORY = 2;
	public static final int WAR = 0;

	Deck mainDeck = new Deck();	 
	Player player1;
	Player player2;
	Card player1Card = new Card(null, null);
	Card player2Card = new Card(null, null);
	Pile upPile;
	Logger logger = new Logger("War Variation 1");

	public WarVariation1(){
		mainDeck.createDeck();
		player1 =  new Player("Berto", mainDeck);
		mainDeck.printDeck();
		player2 =  new Player("Barfget", mainDeck);
		mainDeck.printDeck();
		int count = 0;
		
		while(count < 10){
			upPile = new Pile();
			drawCards();
			checkForTurnResult();
			count++;
		}
	}
	
	public void war(){
		drawCards();
		checkForTurnResult();
		
	}
	
	public void drawCards(){
		upPile.addCard(player1Card = player1.pile.removeCard());
		upPile.addCard(player2Card = player2.pile.removeCard());
	}
	
	public void checkForTurnResult(){
		if(player1Card.compareTo(player2Card) > 0){
			for(Card card: upPile.cards)
				player1.pile.addCard(card);
			logger.logMessage("Player 1 wins the round");
		}
		else if(player1Card.compareTo(player2Card) < 0){
			for(Card card: upPile.cards)
				player2.pile.addCard(card);
			logger.logMessage("Player 2 wins the round");

		}
		else
		{
			logger.logMessage("WAR!");
			war();
		}
	}
	
}
