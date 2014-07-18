package cards;

import java.util.ArrayList;
import java.util.Collections;

import cards.Card;
import cards.Suit;

/**
 * Class for a deck of cards. Has a card of every suit with every value (where suits and values are defined in the eponymous enums).
 * Cards can be shuffled, a list of cards printed, or the nth card returned.
 * @author camilla
 *
 */
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
