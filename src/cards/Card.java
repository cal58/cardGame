package cards;

import cards.Suit;
import cards.Value;

/**
 * Base class for a card from a standard deck. Card has a number and a suit which cannot be changed, but can be queried.
 * @author camilla
 *
 */
public class Card {
	Card(Value number, Suit suit) {
		this.number = number;
		this.suit = suit;
		
	}
	// Each card has a number and a suit.
	// The number is between 1 and 13 (inclusive).
	// The suit is an enum with 0 1 2 3 mapping to Hearts Diamonds Clubs Spades.
	
	private
		Value number;
		Suit suit;
	
	//public static void main(String[] args) {
	//	System.out.println(Suit.HEARTS);
	//}
		
	public Value getNumber() {
		return number;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public void printInfo() {
		System.out.println(number+" of "+suit);
	}
}
