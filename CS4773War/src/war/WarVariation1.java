package war;

import models.*;

public class WarVariation1 {

	Deck mainDeck = new Deck();
	Pile upPile = new Pile();
	
	
	Player player1 =  new Player("Berto", mainDeck);
	Player player2 = new Player("Bridget", mainDeck);
	
	public WarVariation1(){
		Card player1Card = new Card(null, null);
		Card player2Card = new Card(null, null);

		int count = 0;
		while(count < 10){
			upPile.addCard(player1Card = player1.pile.removeCard());
			upPile.addCard(player2Card = player2.pile.removeCard());

			player1Card.
		}
	}
	
	
	
	
}
