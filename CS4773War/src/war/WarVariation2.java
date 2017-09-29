package war;

import logger.Logger;
import models.*;

/**
 * This variation of war features two players trying to obtain the most cards in their winning pile.
 * When a player wins, they put add the cards that are in the up pile (faced up or down) to the 
 * won pile.
*/
public class WarVariation2 extends War {

	
	Pile player1WonPile;
	Pile player2WonPile;
	Logger logger = new Logger("War Variation 2");

	/**
	 * The constructor creates the deck, players, and contains the winners' Piles
	 */
	public WarVariation2(){
		super();
		player1WonPile = new Pile();
		player2WonPile = new Pile();
		mainDeck.createDeck();
		player1 =  new Player("Berto", mainDeck);
		player2 =  new Player("Bridget", mainDeck);
		String winningMessage;
		
		while(player1.score+player2.score != 52 && player1.hand.cards.size() > 0 && player2.hand.cards.size() > 0){
			upPile = new Pile();
			drawCards(false);
			checkForTurnResult();
		}
		winningMessage = player1WonPile.cards.size() < player2WonPile.cards.size() ? 
				(player1WonPile.cards.size() == player2WonPile.cards.size() ? "Tie game!" : player2.name + " wins!") : 
				(player1WonPile.cards.size() == player2WonPile.cards.size() ? "Tie game!" : player1.name + " wins!");
		logger.logMessage(winningMessage);
	}
	
	
	/**
	 * Adds all the cards in the game pile to the given player
	 * @param winner			The winning player
	 */
	@Override
	public void addUpPileCardsToWinner(Player winner)
	{
		Pile winnersPile;
		winnersPile = winner.name.equals(player1.name) ? player1WonPile : player2WonPile;
		for(Card card: upPile.cards)
				winnersPile.addCard(card);
			
	}
}
