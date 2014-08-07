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

	// Why is an arrayList best for this?!
	private ArrayList<Card> deck = new ArrayList<Card>();

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
	
	public Card removeTopCard() {
		Card topCard = getCard(0);
		deck.remove(0);
		return topCard;
	}
	
	public int size() {
		return deck.size();
	}
	
	public boolean isLowerLikely(int n) {
		int tot = 0;
		int deckSize = deck.size();
		//System.out.println(n);
		
		for (Card c : deck) {
			int cardVal = c.getNumber().getInt();
			if (cardVal < n) {
				//c.printInfo();
				tot++;
			}
		}
		//System.out.println(tot);
		//System.out.println();
		
		if (tot*2 > deckSize) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * Splits deck into n Hands with i cards, returned as an ArrayList. Deck will then contain all other cards.
	 */
	public ArrayList<Hand> dealCards(int cardsPerHand, int numHands) {
		ArrayList<Hand> hands = new ArrayList<Hand>();
		
		//int numHands = (int) Math.ceil(52/cardsPerHand);
		
		for (int ii=0; ii<numHands; ii++) {
			Card firstCard = removeTopCard();
			Hand newEmptyHand = new Hand(firstCard);
			hands.add(newEmptyHand);
		}

		while (hands.get(numHands-1).size() < cardsPerHand ) {
			int numCards = deck.size();
			int handNum = numCards%numHands;
			
			// Add top card to a hand.
			hands.get(handNum).addCard(removeTopCard());
			
			//System.out.println(hands.get(deckNum).size());
		}
		
		return hands;
	}
}
