package war;

import logger.Logger;
import models.*;

/**
 * This variation of war features three players trying to obtain the most cards in their winning pile.
 * When a player wins, they put add the cards that are in the up pile (faced up or down) to the 
 * won pile.
*/
public class WarVariation3 extends War {

	Deck mainDeck = new Deck();	 
	Player player1;
	Player player2;
	Player player3;
	Card player1Card = new Card(null, null);
	Card player2Card = new Card(null, null);
	Card player3Card = new Card(null, null);
	Pile upPile;
	Pile player1WonPile;
	Pile player2WonPile;
	Pile player3WonPile;
	Logger logger = new Logger("War Variation 3");

	/**
	 * The constructor creates the deck, players, and contains the winners' Piles
	 */
	public WarVariation3(){
		player1WonPile = new Pile();
		player2WonPile = new Pile();
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
		String winningMessage = "";
		
		while(player1.score+player2.score+player3.score != 51 && 
				player1.hand.cards.size() > 0 && player2.hand.cards.size() > 0 && player3.hand.cards.size() > 0){
			upPile = new Pile();
			drawCards(false);
			checkForTurnResult();
		}
		/*
		 * TODO make this all nested ternary operators lol
		 */
		int biggest = Math.max(player1WonPile.cards.size(), Math.max(player2WonPile.cards.size(), player3WonPile.cards.size()));
		if (biggest == player1WonPile.cards.size())
		{
			if (biggest == player2WonPile.cards.size())
				winningMessage = "Tie game between " + player1.name + " and " + player2.name + "!";
			else if (biggest == player3WonPile.cards.size())
				winningMessage = "Tie game between " + player1.name + " and " + player3.name + "!";
			else if (biggest == player2WonPile.cards.size() && biggest == player3WonPile.cards.size())
				winningMessage = "Tie game!";
			else
				winningMessage = player1.name + " wins!";
			
		}
		else if (biggest == player2WonPile.cards.size())
		{
			if (biggest == player1WonPile.cards.size())
				winningMessage = "Tie game between " + player1.name + " and " + player2.name + "!";
			else if (biggest == player3WonPile.cards.size())
				winningMessage = "Tie game between " + player2.name + " and " + player3.name + "!";
			else if (biggest == player1WonPile.cards.size() && biggest == player3WonPile.cards.size())
				winningMessage = "Tie game!";
			else
				winningMessage = player2.name + " wins!";
		}
		else
		{
			if (biggest == player3WonPile.cards.size())
				winningMessage = "Tie game between " + player1.name + " and " + player3.name + "!";
			else if (biggest == player2WonPile.cards.size())
				winningMessage = "Tie game between " + player2.name + " and " + player3.name + "!";
			else if (biggest == player2WonPile.cards.size() && biggest == player1WonPile.cards.size())
				winningMessage = "Tie game!";
			else
				winningMessage = player3.name + " wins!";
			
		}
//		winningMessage = player1WonPile.cards.size() < player2WonPile.cards.size() ? 
//				(player1WonPile.cards.size() == player2WonPile.cards.size() ? "Tie game!" : player2.name + " wins!") : 
//				(player1WonPile.cards.size() == player2WonPile.cards.size() ? "Tie game!" : player1.name + " wins!");
		logger.logMessage(winningMessage);
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
		upPile.addCard(player3Card = player3.hand.removeCard());
		logger.logFormattedMessage("%s plays %s\n%s plays %s\n%s plays %s", 
				player1.name, player1Card, player2.name, player2Card, player3.name, player3Card);
		
		if (warHappened == true)
		{
			upPile.addCard(player1.hand.removeCard());
			upPile.addCard(player2.hand.removeCard());
			upPile.addCard(player3.hand.removeCard());
		}
	}
	
	/**
	 * Declares either a winning player or war. If a player wins, the cards in the up pile are added to their hands
	 * and their score is increased as well. Also logs winner/war.
	 */
	public void checkForTurnResult(){
		/*
		 * TODO change logic to 3 way 
		 */
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
		logger.logFormattedMessage("%s wins the round\nScore is %s %d, %s %d, %s %d", 
									winner.name, 
									player1.name, player1.score, 
									player2.name, player2.score, 
									player3.name, player3.score);
	}
	
	/**
	 * Adds all the cards in the game pile to the given player
	 * @param winner			The winning player
	 */
	public void addUpPileCardsToWinner(Player winner)
	{
		Pile winnersPile;
		/*
		 * TODO change to 3 way logic
		 */
		winnersPile = winner.name.equals(player1.name) ? player1WonPile : player2WonPile;
		for(Card card: upPile.cards)
				winnersPile.addCard(card);
			
	}
}
