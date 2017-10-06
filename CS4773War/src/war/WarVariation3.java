package war;

import logger.Logger;
import models.*;

/**
 * This variation of war features three players trying to obtain the most cards in their winning pile.
 * When a player wins, they put add the cards that are in the up pile (faced up or down) to the 
 * won pile.
*/
public class WarVariation3 extends War {
	Player player3;
	Card player3Card = new Card();
	Pile player3WonPile;

	/**
	 * The constructor creates the deck, players, and contains the winners' Piles
	 * @param deck		The Deck to be used for this instance of War
	 */
	public WarVariation3(Deck deck){
		super();
		logger = new Logger("War Variation 3");
		mainDeck = deck;
		player1WonPile = new Pile();
		player2WonPile = new Pile();
		player3WonPile =  new Pile();
		int numberOfPlayers = 3;
		int numberOfCardsPerPile = getNumberOfCardsPerPlayer(mainDeck.cards.size(), numberOfPlayers);
	
		player1 =  new Player("Berto", mainDeck, numberOfCardsPerPile);
		player2 =  new Player("Bridget", mainDeck, numberOfCardsPerPile);
		player3 =  new Player("Pablo", mainDeck, numberOfCardsPerPile);
		
		players.add(player1);
		players.add(player2);
		players.add(player3);
		
		while(player1.score+player2.score+player3.score != 51 && 
				player1.hand.cards.size() > 0 && player2.hand.cards.size() > 0 && player3.hand.cards.size() > 0){
			upPile = new Pile();
			drawCards(false);
			checkForTurnResult();
		}
		calculateWinner(players);
	}
	
	/**
	 * Draw one card from players' hands and log cards drawn and if there was war, two more cards are drawn
	 * @param warHappened			boolean indicating whether there war was declared or not			
	 */
	@Override
	public void drawCards(boolean warHappened){
		super.drawCards(warHappened);
		upPile.addCard(player3Card = player3.hand.removeCard());
		logger.logFormattedMessage("\n%s plays %s\n", player3.name, player3Card);
		if(player3.hand.cards.size() == 0 && warHappened)
			upPile.cards.clear();
		else if (warHappened == true)
			upPile.addCard(player3.hand.removeCard());
	}
	
	/**
	 * Declares either a winning player or war. If a player wins, the cards in the up pile are added to their hands
	 * and their score is increased as well. Also logs winner/war.
	 */
	public void checkForTurnResult(){
		if(player1Card.compareTo(player2Card) > 0 && player1Card.compareTo(player3Card) > 0 )
			declareWinner(player1);
		else if(player2Card.compareTo(player1Card) > 0 && player2Card.compareTo(player3Card) > 0 )
			declareWinner(player2);
		else if (player3Card.compareTo(player1Card) > 0 && player3Card.compareTo(player2Card) > 0 )
			declareWinner(player3);
		else
			initiateWar();
	}
	
	/**
	 * Adds all the cards in the game pile to the given player
	 * @param winner			The winning player
	 */
	public void addUpPileCardsToWinner(Player winner){
		Pile winnersPile = player1WonPile;
		if (winner.name.equals(player2.name))
			winnersPile = player2WonPile;
		else if (winner.name.equals(player3.name))
			winnersPile = player3WonPile;
		for(Card card: upPile.cards)
				winnersPile.addCard(card);
	}
}