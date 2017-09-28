package war;

import logger.Logger;
import models.*;

public class WarVariation1 {

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
		player2 =  new Player("Barfget", mainDeck);
		String winningPlayer;
		int count = 0;
		
		while(count < 10){
			upPile = new Pile();
			drawCards();
			checkForTurnResult();
			count++;
		}
		winningPlayer = (player1.hand.cards.size() < player2.hand.cards.size()) ? player2.name:player1.name;
		logger.logFormattedMessage("%s wins!", winningPlayer);
	}
	
	public void war(){
		upPile.addCard(player1Card = player1.hand.removeCard());
		upPile.addCard(player2Card = player2.hand.removeCard());
		drawCards();
		checkForTurnResult();
		
	}
	
	public void drawCards(){
		upPile.addCard(player1Card = player1.hand.removeCard());
		upPile.addCard(player2Card = player2.hand.removeCard());
		logger.logFormattedMessage("%s plays %s\n%s plays %s", player1.name, player1Card, player2.name, player2Card);
	}
	
	public void checkForTurnResult(){
		if(player1Card.compareTo(player2Card) > 0){
			for(Card card: upPile.cards)
				player1.hand.addCard(card);
			player1.score += upPile.cards.size();
			logger.logFormattedMessage("%s wins the round\nScore is %s %d, %s %d", 
										player1.name, player1.name, player1.score, player2.name, player2.score);
		}
		else if(player1Card.compareTo(player2Card) < 0){
			for(Card card: upPile.cards)
				player2.hand.addCard(card);
			player2.score += upPile.cards.size();
			logger.logFormattedMessage("%s wins the round\nScore is %s %d, %s %d", 
					player2.name, player1.name, player1.score, player2.name, player2.score);
		}
		else
		{
			logger.logMessage("War!");
			war();
		}
	}
	
}
