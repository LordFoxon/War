package war;

import models.Deck;

public class Launcher {

	public static void main(String[] args) {
		Deck mainDeck = new Deck();	
		mainDeck.createDeck();
		new WarVariation2(mainDeck);
	}

}
