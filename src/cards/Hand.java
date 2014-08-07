package cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author camilla
 *
 */
public class Hand {
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Hand() {
	}
	
	public Hand(Card firstCard) {
		addCard(firstCard);
	}
	
	public Hand(ArrayList<Card> cards) {
		for (Card c : cards) {
			addCard(c);
		}
	}
	
	public void printAllCards() {
		for (Card c : cards) {
			c.printInfo();
		}
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	/**
	 * removeCard(s) need to have errors if card is not present 
	 */
	public void removeCard(Card card) {
		cards.remove(card);
	}
	
	public void removeCards(ArrayList<Card> all) {
		for (Card c : all) {
			cards.remove(c);
		}
	}
	
	public int size() {
		return cards.size();
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card getCard(int n) {
		return cards.get(n);
	}
	
	public Card removeTopCard() {
		Card topCard = getCard(0);
		cards.remove(0);
		return topCard;
	}
	
	public boolean isEmpty() {
		return cards.isEmpty();
	}

	public void addCards(ArrayList<Card> cards) {
		for (Card c : cards) {
			addCard(c);
		}
	}
}