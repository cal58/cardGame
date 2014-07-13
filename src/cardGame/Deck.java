package cardGame;

import java.util.ArrayList;
import cardGame.Card;
import cardGame.Suit;

public class Deck {
	Deck() {
		// Initialised with cards in order (H,D,C,S ace->King)
		for (Suit s : Suit.values()) {
			for (Value v : Value.values()) {
				Card newCard = new Card(v,s);
				deck.add(newCard);
			}
		}
		
	}
	private
		ArrayList<Card> deck = new ArrayList<Card>();

	public void printAllCards() {
		for (Card c : deck) {
			System.out.println(c.getNumber()+" of "+c.getSuit());
		}
	}
	
	public void shuffleCards() {
		
	}
}
