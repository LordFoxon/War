package war;

import models.Deck;

public class Launcher {

	public static void main(String[] args) {
		Deck mainDeck = new Deck();	
		System.out.println("Bridget is Aswsome");
		mainDeck.createDeck();
		WarVariation2 war1 = new WarVariation2(mainDeck);
	}

}
