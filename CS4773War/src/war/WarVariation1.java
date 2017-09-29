package war;

import logger.Logger;
import models.*;

/**
 * This variation of war features two players trying to obtain the most cards in their hands.
 * When a player wins, they put all the cards that are in the up pile (faced up or down) at the 
 * bottom of their hand.
*/
public class WarVariation1 extends War {

	public static final int MAX_TURNS = 10; 
	

	/**
	 * The constructor creates the deck, players, and contains the counter of the game.
	 * For the desire of keeping testing rapid, we decided there would be ten turns total 
	 */
	public WarVariation1(){
		super();
		logger = new Logger("War Variation 1");
		mainDeck.createDeck();
		player1 =  new Player("Berto", mainDeck);
		player2 =  new Player("Barf", mainDeck);
		String winningMessage;
		int turns = 0;
		
		while(turns < MAX_TURNS && player1.hand.cards.size() > 0 && player2.hand.cards.size() > 0){
			upPile = new Pile();
			drawCards(false);
			checkForTurnResult();
			turns++;
		}
		winningMessage = player1.hand.cards.size() < player2.hand.cards.size() ? 
				(player1.hand.cards.size() == player2.hand.cards.size() ? "Tie game!" : player2.name + " wins!") : 
				(player1.hand.cards.size() == player2.hand.cards.size() ? "Tie game!" : player1.name + " wins!");
		logger.logMessage(winningMessage);
	}
	

	
	/**
	 * Adds all the cards in the game pile to the given player
	 * @param winner			The winning player
	 */
	@Override
	public void addUpPileCardsToWinner(Player winner)
	{
		for(Card card: upPile.cards)
			winner.hand.addCard(card);
	}
}
