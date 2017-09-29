package war;

import logger.Logger;
import models.*;

/**
 * This variation of war features two players trying to obtain the most cards in their hands.
 * When a player wins, they put all the cards that are in the up pile (faced up or down) at the 
 * bottom of their hand.
*/
public class WarVariation1 {

	public static final int MAX_TURNS = 10; 
	Deck mainDeck = new Deck();	 
	Player player1;
	Player player2;
	Card player1Card = new Card(null, null);
	Card player2Card = new Card(null, null);
	Pile upPile;
	Logger logger = new Logger("War Variation 1");

	/**
	 * The constructor creates the deck, players, and contains the counter of the game.
	 * For the desire of keeping testing rapid, we decided there would be ten turns total 
	 */
	public WarVariation1(){
		mainDeck.createDeck();
		player1 =  new Player("Berto", mainDeck);
		player2 =  new Player("Barfget", mainDeck);
		String winningPlayer;
		int turns = 0;
		
		while(turns < MAX_TURNS && player1.hand.cards.size() > 0 && player2.hand.cards.size() > 0){
			upPile = new Pile();
			drawCards(false);
			checkForTurnResult();
			turns++;
		}
		winningPlayer = (player1.hand.cards.size() < player2.hand.cards.size()) ? player2.name:player1.name;
		logger.logFormattedMessage("%s wins!", winningPlayer);
	}
	
	/**
	 * This function adds two "face-down" cards to the up pile, draws two face-up cards and then checks for a winner
	 */
	public void initiateWar(){
		logger.logMessage("War!");
		drawCards(true);
		checkForTurnResult();
	}
	
	/**
	 * Draw one card from players' hands and log cards drawn and if there was war, two more cards are drawn
	 * @param warHappened			boolean indicating whether there war was declared or not			
	 */
	public void drawCards(boolean warHappened){
		upPile.addCard(player1Card = player1.hand.removeCard());
		upPile.addCard(player2Card = player2.hand.removeCard());
		logger.logFormattedMessage("%s plays %s\n%s plays %s", player1.name, player1Card, player2.name, player2Card);
		if (warHappened == true)
		{
			upPile.addCard(player1Card = player1.hand.removeCard());
			upPile.addCard(player2Card = player2.hand.removeCard());
		}
	}
	
	/**
	 * Declares either a winning player or war. If a player wins, the cards in the up pile are added to their hands
	 * and their score is increased as well. Also logs winner/war.
	 */
	public void checkForTurnResult(){
		if(player1Card.compareTo(player2Card) > 0)
			declareWinner(player1);
		else if(player1Card.compareTo(player2Card) < 0)
			declareWinner(player2);
		else
			initiateWar();
	}
	
	/**
	 * Declares the winner by adding the piles' cards to their hands, winner's score is incremented, winning message logged
	 * @param winner			The winning player
	 */
	public void declareWinner(Player winner)
	{
		addUpPileCardsToWinner(winner);
		winner.score += upPile.cards.size();
		logger.logFormattedMessage("%s wins the round\nScore is %s %d, %s %d", 
									winner.name, player1.name, player1.score, player2.name, player2.score);
	}
	
	/**
	 * Adds all the cards in the game pile to the given player
	 * @param winner			The winning player
	 */
	public void addUpPileCardsToWinner(Player winner)
	{
		for(Card card: upPile.cards)
			winner.hand.addCard(card);
	}
}
