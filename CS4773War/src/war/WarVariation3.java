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
	/*
	 * TODO create empty constructor for card
	 */
	Card player3Card = new Card(null, null);
	Pile player3WonPile;
	int biggest;

	/**
	 * The constructor creates the deck, players, and contains the winners' Piles
	 */
	public WarVariation3(){
		super();
		logger = new Logger("War Variation 3");
		player1WonPile = new Pile();
		player2WonPile = new Pile();
		/*
		 * TODO rather than adding 52 cards, 51 should be added
		 */
		mainDeck.createDeck();
		/*
		 * TODO change "HALF OF DECK"
		 * TODO change deck initialization
		 * could do where start and stop indexes are passed in
		 * int size = mainDeck.cards.size;
		 * i.e new Player("Berto", mainDeck, 0, size/3);
		 * new Player("Bridget", mainDeck, size/3, size*2/3);
		 * new Player("Pablo", mainDeck, size*2/3, size);
		 */
		player1 =  new Player("Berto", mainDeck);
		player2 =  new Player("Bridget", mainDeck);
		player3 =  new Player("Pablo", mainDeck);
		
		while(player1.score+player2.score+player3.score != 51 && 
				player1.hand.cards.size() > 0 && player2.hand.cards.size() > 0 && player3.hand.cards.size() > 0){
			upPile = new Pile();
			drawCards(false);
			checkForTurnResult();
		}
	
		biggest = Math.max(player1.score, Math.max(player2.score, player3.score));
		if (biggest == player1.score)
			createWinningMessage(player1, player2, player3);
		else if (biggest == player2.score)
			createWinningMessage(player2, player1, player3);
		else
			createWinningMessage(player3, player1, player2);
	}
	
	public void createWinningMessage(Player currentPlayer, Player opponent1, Player opponent2){
		String winningMessage;
		if (biggest == opponent1.score)
			winningMessage = "Tie game between " + currentPlayer.name + " and " + opponent1.name + "!";
		else if (biggest == opponent2.score)
			winningMessage = "Tie game between " + currentPlayer.name + " and " + opponent2.name + "!";
		else if (biggest == opponent1.score && biggest == opponent2.score)
			winningMessage = "Tie game!";
		else
			winningMessage = currentPlayer.name + " wins!";
		logger.logMessage(winningMessage);
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
		
		if (warHappened == true)
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
	 * Declares the winner by adding the piles' cards to their hands, winner's score is incremented, winning message logged
	 * @param winner			The winning player
	 */
	@Override
	public void declareWinner(Player winner){
		super.declareWinner(winner);
		logger.logFormattedMessage(", %s %d\n", player3.name, player3.score);
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