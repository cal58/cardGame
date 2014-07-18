package cards;

import java.util.ArrayList;
import java.util.Collections;

import cards.Card;
import cards.Suit;

public class Deck {
	public Deck() {
		// Initialised with cards in order (H,D,C,S ace->King)
		for (Suit s : Suit.values()) {
			for (Value v : Value.values()) {
				Card newCard = new Card(v,s);
				deck.add(newCard);
			}
		}
		
	}
	private
		// Why is an arrayList best for this?!
		ArrayList<Card> deck = new ArrayList<Card>();

	public void printAllCards() {
		for (Card c : deck) {
			System.out.println(c.getNumber()+" of "+c.getSuit());
		}
	}
	
	public Card getCard(int n) {
		return deck.get(n);
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
	public void shuffleCards() {
		Collections.shuffle(deck);
	}
}