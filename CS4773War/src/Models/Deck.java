package Models;
import java.util.*;

public class Deck {
	
	
	ArrayList<Card> cards = new ArrayList<>();
	
	public Deck() {
		createDeck();
		shuffleDeck();
		printDeck();
	}
	
	private void createDeck() {
		for(Suits suit: Suits.values()){
			for(Ranks rank: Ranks.values()){
				cards.add(new Card(suit, rank));
			}
		}
		
	}
	
	private void shuffleDeck() {
		// TODO Auto-generated method stub
		Collections.shuffle(cards);
	}

	private void printDeck(){
		for(Card card: cards){
			System.out.print(card.suit+" " +card.rank+"\n");
		}
	}
	
}
