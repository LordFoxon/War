package models;
import java.util.*;

public class Deck {
	
	
	ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();
//		createDeck();
//		shuffleDeck();
//		printDeck();
	}
	
	public void createDeck() {
		for(Suits suit: Suits.values()){
			for(Ranks rank: Ranks.values()){
				cards.add(new Card(suit, rank));
			}
		}
		shuffleDeck();
	}
	
	private void shuffleDeck() {
		Collections.shuffle(cards);
	}
	
	public void addCard(Card card)
	{
		cards.add(card);
	}

//	private void printDeck(){
//		for(Card card: cards){
//			System.out.print(card.suit+" " +card.rank+"\n");
//		}
//	}
	
}
