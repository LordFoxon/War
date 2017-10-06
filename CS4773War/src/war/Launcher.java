package war;

import models.Deck;
import models.Player;

public class Launcher {

	public static void main(String[] args) {
		Deck mainDeck = new Deck();	
		mainDeck.createDeck();
		WarVariation3 war1 = new WarVariation3(mainDeck);
		System.out.println(war1.getWinner());
	}

}
