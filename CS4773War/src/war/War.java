package war;
import java.util.ArrayList;

import logger.Logger;
import models.*;
public abstract class War {

	Deck mainDeck = new Deck();	 
	Player player1;
	Player player2;
	Card player1Card = new Card();
	Card player2Card = new Card();
	Pile upPile;
	Pile player1WonPile;
	Pile player2WonPile;
	Logger logger;
	ArrayList<Player> players = new ArrayList<Player>();

	Player winningPlayer;
	/**
	 * Draw one card from players' hands and log cards drawn and if there was war, two more cards are drawn
	 * @param warHappened			boolean indicating whether there war was declared or not			
	 */
	public void drawCards(boolean warHappened){
		upPile.addCard(player1Card = player1.hand.removeCard());
		upPile.addCard(player2Card = player2.hand.removeCard());
		logger.logFormattedMessage("%s plays %s\n%s plays %s", player1.name, player1Card, player2.name, player2Card);
		if(player1.hand.cards.size() == 0 && warHappened == true){
			upPile.cards.clear();
		}
		else if (warHappened == true){
			upPile.addCard(player1.hand.removeCard());
			upPile.addCard(player2.hand.removeCard());
		}
	}
	public void printScore()
	{
		logger.logFormattedMessage("Score is %s %d", player1.name, player1.score);
		for (int i = 1; i < players.size(); i++)
			logger.logFormattedMessage(", %s %d", players.get(i).name, players.get(i).score);
		logger.logMessage("\n");
	}
	
	/**
	 * This function adds two "face-down" cards to the up pile, draws two face-up cards and then checks for a winner
	 */
	public void initiateWar(){
		logger.logMessage("War!\n");
		printScore();
		
		if(player1.hand.cards.size() > 0){
			drawCards(true);
			checkForTurnResult();
		}
		else{
			logger.logFormattedMessage("No more cards. Tie round!!!\n");
			printScore();
		}
	}
	
	
	/**
	 * Declares either a winning player or war. If a player wins, the cards in the up pile are added to their hands
	 * and their score is increased as well. Also logs winner/war.
	 */
	public void checkForTurnResult(){
		if(player1Card.compareTo(player2Card) > 0)
			if (upPile.cards.size() > 0)
				declareWinner(player1);
			else
			{
				logger.logFormattedMessage("No more cards. Tie round\n");
				printScore();
			}
		else if(player1Card.compareTo(player2Card) < 0)
			if (upPile.cards.size() > 0)
				declareWinner(player2);
			else
			{
				logger.logFormattedMessage("No more cards. Tie round.\n");
				printScore();
			}
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
		logger.logFormattedMessage("%s wins the round\n", winner.name);
		printScore();
	}
	

	/**
	 * Returns the number of cards that each player will be given based on the card in the deck
	 * and number of players in the game.
	 * 
	 * @param cardsInDeck 		The number of cards in the deck
	 * @param numberOfPlayers	Number of players in the game
	 * @return
	 */
	public int getNumberOfCardsPerPlayer(int cardsInDeck, int numberOfPlayers){
		return (cardsInDeck - (cardsInDeck % numberOfPlayers)) / numberOfPlayers;
	}
	
	public void calculateWinner(ArrayList<Player> players){
		int highestScore = -1;
		Player winningPlayer = null;
		for(Player player: players){
			if(player.getNumberOfCards(this) > highestScore){
				highestScore = player.getNumberOfCards(this);
				winningPlayer = player;
				
			}else if(player.getNumberOfCards(this) == highestScore){
				highestScore = player.getNumberOfCards(this);
				winningPlayer = null;
			}
		}
		setWinningPLayer(winningPlayer);
	}

	public Player getWinner(){
		if(this.winningPlayer == null)
			return null;
		else
			return this.winningPlayer;
	}
	
	public void setWinningPLayer(Player winner){
		this.winningPlayer = winner;
	}

	
	public abstract void addUpPileCardsToWinner(Player winner);

}
