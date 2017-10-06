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
	 * @param deck		The Deck to be used for this instance of War
	 */
	public WarVariation1(Deck deck){
		super();
		logger = new Logger("War Variation 1");
		mainDeck = deck;
		int numberOfPlayers = 2;
		int numberOfCards = getNumberOfCardsPerPlayer(mainDeck.cards.size(), numberOfPlayers);
		player1 =  new Player("Berto", mainDeck, numberOfCards);
		player2 =  new Player("Barf", mainDeck, numberOfCards);
		players.add(player1);
		players.add(player2);
		
		int turns = 0;
		
		while(turns < MAX_TURNS && player1.hand.cards.size() > 0 && player2.hand.cards.size() > 0){
			upPile = new Pile();
			drawCards(false);
			checkForTurnResult();
			turns++;
		}
		calculateWinner();

		if(winningPlayer != null)
			logger.logMessage(winningPlayer.name + " wins!");
		else
			logger.logMessage("Tie!");
	}
	
	
	/**
	 * Adds all the cards in the game pile to the given player
	 * @param winner			The winning player
	 */
	@Override
	public void addUpPileCardsToWinner(Player winner) {
		for(Card card: upPile.cards)
			winner.hand.addCard(card);
	}

	@Override
	public void drawCards(boolean warHappened){
		super.drawCards(warHappened);
		logger.logMessage("\n");
	}
}
