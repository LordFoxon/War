package war;
import logger.Logger;
import models.*;
public abstract class War {

	Deck mainDeck = new Deck();	 
	Player player1;
	Player player2;
	Card player1Card = new Card(null, null);
	Card player2Card = new Card(null, null);
	Pile upPile;
	Logger logger;
	
	
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
			upPile.addCard(player1.hand.removeCard());
			upPile.addCard(player2.hand.removeCard());
		}
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

	public void addUpPileCardsToWinner(Player winner) {
		// TODO Auto-generated method stub
		
	}

}
