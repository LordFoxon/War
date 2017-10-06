package war;

import models.Deck;

public class Launcher {

	public static void main(String[] args) {
		Deck mainDeck = new Deck();	
		mainDeck.createDeck();
		WarVariation3 war1 = new WarVariation3(mainDeck);
	}

}
