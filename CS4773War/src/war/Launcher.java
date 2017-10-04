package war;

import models.Deck;

public class Launcher {

	public static void main(String[] args) {
		Deck mainDeck = new Deck();	
		mainDeck.createDeck();
		WarVariation2 war1 = new WarVariation2(mainDeck);
	}

}
