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

	/**
	 * The constructor creates the deck, players, and contains the winners' Piles
	 *  @param deck		The Deck to be used for this instance of War
	 */
	public WarVariation2(Deck deck){
		super();
		logger = new Logger("War Variation 2");
		int numberOfPlayers = 2;
		player1WonPile = new Pile();
		player2WonPile = new Pile();
		mainDeck = deck;
		int numberOfCardsPerPlayer = getNumberOfCardsPerPlayer(mainDeck.cards.size(), numberOfPlayers);
		player1 =  new Player("Berto", mainDeck, numberOfCardsPerPlayer);
		player2 =  new Player("Bridget", mainDeck, numberOfCardsPerPlayer);
		players.add(player1);
		players.add(player2);
		
		while(player1.score+player2.score != 52 && player1.hand.cards.size() > 0 && player2.hand.cards.size() > 0){
			upPile = new Pile();
			drawCards(false);
			checkForTurnResult();
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
	public void addUpPileCardsToWinner(Player winner)
	{
		Pile winnersPile;
		winnersPile = winner.name.equals(player1.name) ? player1WonPile : player2WonPile;
		for(Card card: upPile.cards)
				winnersPile.addCard(card);
	}
	
	@Override
	public void drawCards(boolean warHappened){
		super.drawCards(warHappened);
		logger.logMessage("\n");
	}
}
